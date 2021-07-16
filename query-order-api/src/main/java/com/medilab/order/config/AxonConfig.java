package com.medilab.order.config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.medilab.order.aggregate.OrderAggregate;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class AxonConfig {

	@Bean
	public MessageConverter  messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public SimpleRabbitListenerContainerFactory  srlcFactory(ConnectionFactory conFactory,
			SimpleRabbitListenerContainerFactoryConfigurer factoryConfifurer) {
		
		SimpleRabbitListenerContainerFactory rabbitConFactory = new SimpleRabbitListenerContainerFactory();
		factoryConfifurer.configure(rabbitConFactory, conFactory);
		rabbitConFactory.setMessageConverter(messageConverter());
		return rabbitConFactory;
		
	}
	
	@Bean
	EventSourcingRepository<OrderAggregate>  medilabOrderEventSourcingRepository(EventStore eventStore){
		return EventSourcingRepository
				.builder(OrderAggregate.class)
				.eventStore(eventStore)
				.build();
	}
}
