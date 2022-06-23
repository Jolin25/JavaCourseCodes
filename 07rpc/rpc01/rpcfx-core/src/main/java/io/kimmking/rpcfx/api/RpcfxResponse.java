package io.kimmking.rpcfx.api;

import lombok.Data;
/**
 * 响应：封装了服务提供者的服务的响应信息
 * @author Joly
 * @date 2022/6/22
 */
@Data
public class RpcfxResponse {
    // 返回的结果数据
    private Object result;
    // 成功与否的状态
    private boolean status;
    // 异常
    private Exception exception;
}
