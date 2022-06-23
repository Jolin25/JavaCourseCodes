package io.kimmking.rpcfx.api;

import lombok.Data;
/**
 * 请求：封装了服务消费者要消费的服务消费者的服务的描述信息（类名、方法名、参数）
 * @author Joly
 * @date 2022/6/22
 */
@Data
public class RpcfxRequest {
  // 因为用的是 共享API的方式来 定义的服务描述信息，所以知道是哪个类
  private String serviceClass;
  private String method;
  private Object[] params;
}
