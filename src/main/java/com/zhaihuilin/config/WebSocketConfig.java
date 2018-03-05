package com.zhaihuilin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * WebSocket 配置
 * Created by zhaihuilin on 2018/2/8  13:45.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
       // 注册STOMP协议的节点（endpoint），并映射的指定的URL
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();
       //注册STOMP协议的节点（endpoint），并映射的指定的URL
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //点对点式增加消息代理
        registry.enableSimpleBroker("/queue","/topic");
    }
}
