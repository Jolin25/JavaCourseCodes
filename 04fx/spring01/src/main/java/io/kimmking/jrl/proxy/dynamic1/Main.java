package io.kimmking.jrl.proxy.dynamic1;

/**
 * @author jrl
 * @date Create in 23:20 2022/4/7
 */
public class Main {
    public static void main(String[] args) {
        AliService aliService = (AliService) CglibProxyFactory.getProxy(AliService.class);
        aliService.send("msg");
    }
}
