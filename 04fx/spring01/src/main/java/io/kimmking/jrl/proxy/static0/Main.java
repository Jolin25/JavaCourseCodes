package io.kimmking.jrl.proxy.static0;

/**
 * @author jrl
 * @date Create in 21:14 2022/4/7
 */
public class Main {
    public static void main(String[] args) {
        /*调用real Object 的时候就改成调用代理类对应的方法*/
        new SmsServiceProxy(new SmsServiceImpl()).send("msg");
    }
}
