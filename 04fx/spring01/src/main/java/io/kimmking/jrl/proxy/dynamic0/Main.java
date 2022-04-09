package io.kimmking.jrl.proxy.dynamic0;

/**
 * @author jrl
 * @date Create in 22:37 2022/4/7
 */
public class Main {
    public static void main(String[] args) {
        /*......这前面肯定会做一系列匹配，然后确定要对被代理类的某个方法进行加强*/
        /*获取代理类*/
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        /*执行代理对象*/
        smsService.send("msg");
        /*......这个被代理类里的其他方法可以做别的加强，再创建一个代理类就好了，然后再执行代理对象*/
    }
}
