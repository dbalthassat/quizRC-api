package com.dbalthassat.quizrc.config;

import com.dbalthassat.quizrc.config.properties.FrontProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	@Autowired
	private FrontProperties frontProperties;

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/");
		config.setApplicationDestinationPrefixes(UrlConstants.WEB_SOCKET_ROOT);
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint(UrlConstants.WEB_SOCKET_ROOT).setAllowedOrigins(frontProperties.getUrl()).withSockJS();
	}
}