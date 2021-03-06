package com.github.byference.tinyim.core.client.handler;

import com.github.byference.tinyim.core.protocol.response.LoginResponsePacket;
import com.github.byference.tinyim.core.util.SessionHolder;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * LoginResponseHandler
 *
 * @author byference
 * @since 2020-01-01
 */
@ChannelHandler.Sharable
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    public static LoginResponseHandler INSTANCE = new LoginResponseHandler();

    private LoginResponseHandler() {}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket packet) throws Exception {

        System.out.println("登陆成功...");
        final String username = packet.getUsername();
        SessionHolder.bind(username, ctx.channel());
    }
}
