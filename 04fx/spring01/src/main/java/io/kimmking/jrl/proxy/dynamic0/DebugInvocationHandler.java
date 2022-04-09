package io.kimmking.jrl.proxy.dynamic0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 这是对所有符合条件的方法的某一种增强
 * （所以实现了InvocationHandler的类就是真的去实现具体加强内容的类）
 *
 * @author jrl
 * @date Create in 21:57 2022/4/7
 */
public class DebugInvocationHandler implements InvocationHandler {
    /**
     * 被代理类实例
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }
    /**
     * 当代理对象(方法)被调用时，实际调用的方法是invoke()
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //加强
        System.out.println("enhance before method send()");
        // 通过反射，调用被代理对象（精度是方法）
        method.invoke(target, args);
        //加强
        System.out.println("enhance after method send()");
        return null;
    }
}
