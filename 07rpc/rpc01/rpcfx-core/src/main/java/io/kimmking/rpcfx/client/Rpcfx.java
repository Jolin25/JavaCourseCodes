package io.kimmking.rpcfx.client;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import io.kimmking.rpcfx.api.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户端会调用的代码
 *
 * @author Joly
 * @date 2022/6/22
 */
public final class Rpcfx {

    static {
        ParserConfig.getGlobalInstance().addAccept("io.kimmking");
    }

    /**
     * 有了注册中心的代理，会在基础RPC之上添加一些功能
     *
     * @param
     * @return
     * @date 2022/6/23
     */
    public static <T, filters> T createFromRegistry(final Class<T> serviceClass, final String zkUrl, Router router, LoadBalancer loadBalance, Filter filter) {

        // 加filte之一

        // curator Provider list from zk
        List<String> invokers = new ArrayList<>();
        // 1. 简单：从zk拿到服务提供的列表
        // 2. 挑战：监听zk的临时节点，根据事件更新这个list（注意，需要做个全局map保持每个服务的提供者List）

        List<String> urls = router.route(invokers);

        String url = loadBalance.select(urls); // router, loadbalance

        return (T) create(serviceClass, url, filter);

    }

    /**
     * 单纯的代理，简单的实现RPC
     *
     * @param
     * @return
     * @date 2022/6/23
     */
    public static <T> T create(final Class<T> serviceClass, final String url, Filter... filters) {

        // 0. 替换动态代理 -> 字节码生成
        return (T) Proxy.newProxyInstance(Rpcfx.class.getClassLoader(), new Class[]{serviceClass}, new RpcfxInvocationHandler(serviceClass, url, filters));

    }

    /**
     * 实现服务消费者对服务提供者某个服务的调用
     *
     * @author Joly
     * @date 2022/6/22
     */
    public static class RpcfxInvocationHandler implements InvocationHandler {

        public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

        private final Class<?> serviceClass;
        private final String url;
        private final Filter[] filters;

        public <T> RpcfxInvocationHandler(Class<T> serviceClass, String url, Filter... filters) {
            this.serviceClass = serviceClass;
            this.url = url;
            this.filters = filters;
        }

        // 可以尝试，自己去写对象序列化，二进制还是文本的，，，rpcfx是xml自定义序列化、反序列化，json: code.google.com/p/rpcfx
        // int byte char float double long bool
        // [], data class

        /**
         * 代理后，会替换原方法的执行
         *
         * @param
         * @return
         * @date 2022/6/22
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {

            // 加filter地方之二
            // mock == true, new Student("hubao");

            RpcfxRequest request = new RpcfxRequest();
            // 因为服务描述就是这么定义的服务提供者和服务消费者如何确认要消费的服务，所以就要传输这些信息
            // 如果换了别的服务描述方式,那么这里的参数可能就会不同.但本质上还是确定类&&方法&&参数
            // 只是在不同的地方确认这个区别而已
            request.setServiceClass(this.serviceClass.getName());
            request.setMethod(method.getName());
            request.setParams(params);

            if (null != filters) {
                for (Filter filter : filters) {
                    if (!filter.filter(request)) {
                        return null;
                    }
                }
            }
            // 远程调用
            RpcfxResponse response = post(request, url);

            // 加filter地方之三
            // Student.setTeacher("cuijing");

            // 这里判断response.status，处理异常
            // 考虑封装一个全局的RpcfxException
            // 对服务提供者的服务结果进行反序列化处理
            return JSON.parse(response.getResult().toString());
        }

        /**
         * 进行远程调用
         *
         * @param
         * @return
         * @date 2022/6/22
         */
        private RpcfxResponse post(RpcfxRequest req, String url) throws IOException {
            /*1. 序列化*/
            String reqJson = JSON.toJSONString(req);
            System.out.println("req json: " + reqJson);
            /*2. 选择网络通信协议并进行网络传输，这里用的HTTP*/
            // 1.可以复用client
            // 2.尝试使用httpclient或者netty client
            OkHttpClient client = new OkHttpClient();
            final Request request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(JSONTYPE, reqJson))
                    .build();
            // DONE_JOLY：同步还是异步的---> OKHttp都提供了支持，这里用的是同步的
            String respJson = client.newCall(request).execute().body().string();
            System.out.println("resp json: " + respJson);
            /*3. 反序列化服务结果，并返回结果*/
            return JSON.parseObject(respJson, RpcfxResponse.class);
        }
    }
}
