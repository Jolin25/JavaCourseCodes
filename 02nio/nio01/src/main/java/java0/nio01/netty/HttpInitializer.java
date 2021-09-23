package java0.nio01.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 流水线
 *
 * @author jrl
 * @date 2021-9-23
 */
public class HttpInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    public void initChannel(SocketChannel ch) {
        // 在这次IO中需要我们自己控制流水线部分
        ChannelPipeline p = ch.pipeline();
        // 添加了HTTPServer编码器
        p.addLast(new HttpServerCodec());
        //p.addLast(new HttpServerExpectContinueHandler());
        // 添加了聚合器
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        // 添加了适配器
        p.addLast(new HttpHandler());
    }
}
