package com.medilab.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medilab.order.event.OrderEvent;
import com.medilab.order.repo.OrderRepo;

@Service
public class QueryOrderServiceImpl implements QueryOrderService {

	/*@Autowired
	private QueryGateway queryGateway;*/
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public OrderEvent getOrderEvent(String orderId) {
		OrderEvent orderEvent = null;
		
		try {
			orderEvent = orderRepo.findByEventId(orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderEvent;
	}

}
