package io.github.kimmking.gateway;


import io.github.kimmking.gateway.inbound.HttpInboundServer;

import java.util.Arrays;

/**
 * knowledge point:
 * 个人认为：用netty实现gateway需要实现的功能点是：
 * 1.设置好gateway的端口和要代理的服务的端口
 * 2.把客户端的请求准确的传递到被代理的服务中
 * 3.做一些过滤器和路由的附加操作
 */
public class NettyServerApplication {

    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "3.0.0";

    public static void main(String[] args) {

        String proxyPort = System.getProperty("proxyPort", "8888");

        // 这是之前的单个后端url的例子
//        String proxyServer = System.getProperty("proxyServer","http://localhost:8088");
//          //  http://localhost:8888/api/hello  ==> gateway API
//          //  http://localhost:8088/api/hello  ==> backend service
        // java -Xmx512m gateway-server-0.0.1-SNAPSHOT.jar  #作为后端服务

        // knowledge use:网关就是用来代理业务服务的
        // 这是多个后端url走随机路由的例子
        String proxyServers = System.getProperty("proxyServers", "http://localhost:8801,http://localhost:8802");
        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION + " starting...");
        // done HttpInboundServer是什么 ---> 是用来处理输出的模块
        // done 不应该是用netty写的什么server吗，那么这个httpInboundServer就是用netty框架写的nio的服务是吗 ---> 是的
        HttpInboundServer server = new HttpInboundServer(port, Arrays.asList(proxyServers.split(",")));
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION + " started at http://localhost:" + port + " for server:" + server.toString());
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
