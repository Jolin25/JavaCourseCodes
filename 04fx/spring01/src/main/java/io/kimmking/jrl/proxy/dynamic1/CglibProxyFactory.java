package io.kimmking.jrl.proxy.dynamic1;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author jrl
 * @date Create in 23:18 2022/4/7
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(target.getClassLoader());
        enhancer.setSuperclass(target);
        enhancer.setCallback(new DebugMethodInterceptor());
        return enhancer.create();
    }
}
