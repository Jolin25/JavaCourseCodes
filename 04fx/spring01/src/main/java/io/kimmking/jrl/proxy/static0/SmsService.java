package io.kimmking.jrl.proxy.static0;

/**
 * 接口
 *
 * @author jrl
 * @date Create in 17:02 2022/4/7
 */
public interface SmsService {
    /**
     * 将指定的信息进行处理后发送出去
     *
     * @param message 指定的信息
     * @return 发送的信息
     * @date 2022/4/7
     */
    String send(String message);
}
