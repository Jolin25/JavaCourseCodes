package io.github.kimmking.gateway.inbound;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * HttpInboundServer 其实就是gateway对io请求进来的处理
 * 1.就是用Netty实现的
 * 2.reactor主从模型
 * 3.作用:维护io连接，将io事件处理好后交给业务程序
 *
 * @author jrl
 * @date 2021-9-28
 */
@Data
public class HttpInboundServer {
    /**
     * 端口号（自己的端口号，请求直接设置成发给这个端口撒）
     *
     * @author jrl
     * @date 2021-9-28
     */
    private int port;
    /**
     * 代理的服务器（比如业务服务器）
     *
     * @author jrl
     * @date 2021-9-28
     */
    private List<String> proxyServers;

    public HttpInboundServer(int port, List<String> proxyServers) {
        this.port = port;
        this.proxyServers = proxyServers;
    }

    /**
     * 这是被执行的主体方法
     * Netty实现了Reactor的主从模型
     *
     * @param
     * @return
     * @date 2021-9-28
     */
    public void run() throws Exception {

        /** knowledge point: mainReactor 负责对io的连接维护 */
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        /** knowledge point:  subReactor 负责对事件的分发*/
        EventLoopGroup workerGroup = new NioEventLoopGroup(16);

        try {
            // knowledge use: netty写的server的启动入口点
            ServerBootstrap b = new ServerBootstrap();
            // knowledge use:用于设置正在建立连接的网络连接数最大可以是多少
            b.option(ChannelOption.SO_BACKLOG, 128)
                    /* knowledge use:  TCP发送网络包的时候的优化策略:TCP会把同一个程序的数据合在一起来统一发送.
                     *                 设置TCP_NODELAY就能屏蔽Nagle算法.
                     */
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.SO_REUSEADDR, true)
                    // knowledge use:接受数据和发送数据的缓冲区,这样就可以不满就发送出去，就快一点
                    .childOption(ChannelOption.SO_RCVBUF, 32 * 1024)
                    .childOption(ChannelOption.SO_SNDBUF, 32 * 1024)
                    .childOption(EpollChannelOption.SO_REUSEPORT, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            // 绑定EventLoopGroup 和 Handler
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(new HttpInboundInitializer(this.proxyServers));
            // 启动服务器（绑定端口）
            Channel ch = b.bind(port).sync().channel();
            System.out.println("开启netty http服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');
            /** todo doubt:  这在干嘛*/
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
