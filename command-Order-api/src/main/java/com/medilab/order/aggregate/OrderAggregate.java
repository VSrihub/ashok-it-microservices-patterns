package com.medilab.order.aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.medilab.order.command.OrderCommand;
import com.medilab.order.event.OrderEvent;
import com.medilab.order.event.OrderMenuEvent;

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
	public OrderAggregate(OrderCommand orderComand) {
		String orderEventId = UUID.randomUUID().toString();
		List<OrderMenuEvent> menuList = new ArrayList<>();
		orderComand.getMenu().stream().forEach(menuCommand->{
			OrderMenuEvent menuEvent = new OrderMenuEvent(menuCommand.getItemId(), 
					menuCommand.getName(), menuCommand.getQuantity());
			menuList.add(menuEvent);
		});
		
		OrderEvent orderEvent = new OrderEvent(orderComand.getOrderId(),orderEventId, menuList);
		AggregateLifecycle.apply(orderEvent);
	}
	
	@EventSourcingHandler
	public void on(OrderEvent orderEvent) {
		this.orderEvent = orderEvent;
		this.orderEventId = orderEvent.getOrderEventId();
	}
}
