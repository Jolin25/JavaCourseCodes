package top.jrl.lean.rpc.syntac;

/**
 * @author jrl
 * @date Create in 22:42 2022/6/23
 */
public class ClassA implements InterfaceA {
    @Override
    public String sayHello() {
        System.out.println("Hi");
        return "hello";
    }
}
