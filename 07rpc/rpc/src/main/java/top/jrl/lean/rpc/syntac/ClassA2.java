package top.jrl.lean.rpc.syntac;

/**
 * @author jrl
 * @date Create in 22:42 2022/6/23
 */
public class ClassA2 implements InterfaceA {
    @Override
    public String sayHello() {
        System.out.println("Hi2");
        return "hello2";
    }
}
