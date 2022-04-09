package io.kimmking.jrl.proxy.dynamic0;


/**
 * 被代理类
 *
 * @author jrl
 * @date Create in 17:09 2022/4/7
 */
public class SmsServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
