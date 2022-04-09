package io.kimmking.jrl.proxy.dynamic1;

/**
 * @author jrl
 * @date Create in 23:11 2022/4/7
 */
public class AliService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
