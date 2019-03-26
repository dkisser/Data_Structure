package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void run (){
        /**
         * 1.创建两个NIO线程组，一个专门用于接收来自客户端的连接，另一个则用于处理已经被接收的连接。
         * 2.创建一个ServerBootstrap对象，配置Netty的一系列参数，例如接受传出数据的缓存大小等。
         * 3.创建一个用于实际处理数据的类ChannelInitializer，进行初始化的准备工作，比如设置接受传出数据的字符集、格式以及实际处理数据的接口。
         * 4.绑定端口，执行同步阻塞方法等待服务器端启动即可。
         */
        EventLoopGroup boosGroup =  new NioEventLoopGroup();
        EventLoopGroup workerGroup =  new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boosGroup,workerGroup)
                .channel(NioServerSocketChannel.class)//这里告诉Channel如何接收新的连接
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        //将自定义处理类放到最后处理
                        socketChannel.pipeline().addLast(new ServerHandler());
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        try {
            // 绑定端口，开始接收进来的连接
            ChannelFuture channelFuture =  serverBootstrap.bind(port).sync();
            // 等待服务器socket关闭
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            workerGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
            e.printStackTrace();
        }

    }

    public static void main (String[] args){
        new Server(6660).run();
    }
}
