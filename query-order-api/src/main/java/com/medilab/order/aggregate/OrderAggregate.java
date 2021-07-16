package com.medilab.order.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.medilab.order.event.OrderEvent;

import lombok.Data;

@Aggregate
@Data

public class OrderAggregate {

	@AggregateIdentifier
	private String orderEventId;
	
	
	private OrderEvent orderEvent;
	
	public OrderAggregate() {
		// TODO Auto-generated constructor stub
	}
	
	@CommandHandler
	
	public OrderAggregate(OrderEvent orderEvent) {
		
		AggregateLifecycle.apply(orderEvent);
	}
	
	@EventSourcingHandler
	public void on(OrderEvent orderEvent) {
		this.orderEvent = orderEvent;
		this.orderEventId = orderEvent.getOrderEventId();
	}
}
