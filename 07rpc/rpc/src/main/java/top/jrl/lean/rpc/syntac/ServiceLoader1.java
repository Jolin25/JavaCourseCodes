package top.jrl.lean.rpc.syntac;

import java.util.ServiceLoader;

/**
 * @author jrl
 * @date Create in 16:36 2022/6/24
 */
public class ServiceLoader1 {
    public static void main(String[] args) {
        ServiceLoader<InterfaceA> load = ServiceLoader.load(InterfaceA.class);
        for (InterfaceA a : load) {
            a.sayHello();
        }
    }
}
