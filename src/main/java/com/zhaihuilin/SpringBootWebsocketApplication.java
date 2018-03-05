package com.zhaihuilin;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@SpringBootApplication
@Log4j
@EnableWebSocketMessageBroker   //开启WebSocket
@EnableWebSecurity
public class SpringBootWebsocketApplication extends AbstractWebSocketMessageBrokerConfigurer {

	public static void main(String[] args) {
		log.info("我问: 什么是WebSocket？");
		log.info("他说: WebSocket为浏览器和服务端提供了双工异步通信的功能，即浏览器可以向服务端发送消息，服务端也可以向浏览器发送消息！");
		SpringApplication.run(SpringBootWebsocketApplication.class, args);
	}

	/**
	 * 注册STOMP协议的节点（endpoint），并映射的指定的URL
	 * @param stompEndpointRegistry
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		//注册一个STOMP的endpoint，并指定使用SockJS协议
		stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();
	}


	/**
	 * 配置消息代理
	 * @param registry
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//广播式应配置一个/topic消息代理
		registry.enableSimpleBroker("/topic");
	}
}
