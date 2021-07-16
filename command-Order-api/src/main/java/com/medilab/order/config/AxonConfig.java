package com.medilab.order.config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.medilab.order.aggregate.OrderAggregate;

@Configuration
public class AxonConfig {

	@Bean
	EventSourcingRepository<OrderAggregate>  medilabOrderEventSourcingRepository(EventStore eventStore){
		return EventSourcingRepository
				.builder(OrderAggregate.class)
				.eventStore(eventStore)
				.build();
	}
}
