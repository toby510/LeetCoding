package cn.itcast.server.handler;

import cn.itcast.message.LoginRequestMessage;
import cn.itcast.message.LoginResponseMessage;
import cn.itcast.server.service.UserServiceFactory;
import cn.itcast.server.session.SessionFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@ChannelHandler.Sharable
public class ServerActiveHandler extends SimpleChannelInboundHandler<LoginRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestMessage msg) throws Exception {
        String username = msg.getUsername();
        String password = msg.getPassword();
        System.out.println("绑定成功！！！channel=" + username + "，name=" + password);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();
        String name = ctx.name();
        ChannelHandler handler = ctx.handler();

        System.out.println("绑定成功！！！channel=" + channel + "，name=" + name + ",handler=" + handler);
        super.channelActive(ctx);
    }
}
