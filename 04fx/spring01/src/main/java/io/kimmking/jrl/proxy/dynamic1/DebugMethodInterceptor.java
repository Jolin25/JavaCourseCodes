package io.kimmking.jrl.proxy.dynamic1;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jrl
 * @date Create in 23:12 2022/4/7
 */
public class DebugMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //加强
        System.out.println("enhance before method send()");
        methodProxy.invokeSuper(o,objects);
        //加强
        System.out.println("enhance after method send()");
        return null;
    }
}
