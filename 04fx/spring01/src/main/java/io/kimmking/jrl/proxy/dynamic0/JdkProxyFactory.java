package io.kimmking.jrl.proxy.dynamic0;

import java.lang.reflect.Proxy;

/**
 * @author jrl
 * @date Create in 22:33 2022/4/7
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        /*利用JDK提供的Proxy，生成代理对象*/
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target));
    }
}
