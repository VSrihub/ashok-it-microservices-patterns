package com.medilab.order.service;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medilab.order.event.OrderEvent;
import com.medilab.order.repo.OrderRepo;

@Service
public class QueryOrderServiceImpl implements QueryOrderService {

	@Autowired
	private QueryGateway queryGateway;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public OrderEvent getOrderEvent(String orderId) {
		OrderEvent orderEvent = null;
		
		try {
			orderEvent = queryGateway.query(new OrderEvent(0, orderId, null), OrderEvent.class).get();
			//orderEvent = orderRepo.findByEventId(orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderEvent;
	}
	
	@QueryHandler
	public OrderEvent getCustomerOrderHandler(OrderEvent orderEvent) {
		return orderRepo.findByEventId(orderEvent.getOrderEventId());
	}

}
