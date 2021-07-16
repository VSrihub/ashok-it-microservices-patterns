package com.medilab.order.config;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.medilab.order.aggregate.OrderAggregate;
import com.medilab.order.event.OrderEvent;
import com.medilab.order.repo.OrderRepo;

@Component
public class OrderEntityManager {

	@Autowired
	private OrderRepo orderRepo;
	

	
	@Autowired
	@Qualifier("medilabOrderEventSourcingRepository")
	private EventSourcingRepository<OrderAggregate> eventSourceRepo;
	
	@EventSourcingHandler
	public void placeOrderEventHandler(OrderEvent orderEvent) {
		
		OrderAggregate orderAgg = (OrderAggregate) eventSourceRepo
		.load(orderEvent.getOrderEventId())
		.getWrappedAggregate()
		.getAggregateRoot();
		
		orderEvent = orderAgg.getOrderEvent();
		
		orderRepo.save(orderEvent);
		
	}
	
	/*@EventSourcingHandler
	public void placeOrderEventToQueue(OrderEvent orderEvent) {
		System.out.println("i am in placeOrderEventToQueue");
		mqSender.sendOrderEventToQueue(orderEvent);
		
	}*/
}
