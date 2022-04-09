package io.kimmking.jrl.proxy.static0;

/**
 * 代理类：对被代理类的方法做了加强
 *
 * @author jrl
 * @date Create in 17:11 2022/4/7
 */
public class SmsServiceProxy implements SmsService {

    private final SmsService smsService;

    public SmsServiceProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        System.out.println("enhance before method send()");
        smsService.send(message);
        System.out.println("enhance after method send()");
        return null;
    }
}
