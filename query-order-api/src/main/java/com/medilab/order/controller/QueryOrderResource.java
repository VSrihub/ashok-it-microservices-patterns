package com.medilab.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilab.order.event.OrderEvent;
import com.medilab.order.service.QueryOrderService;

@RestController
@RequestMapping("/api")
public class QueryOrderResource {

	@Autowired
	private QueryOrderService orderService;
	
	@GetMapping("/query-order/{orderId}")
	public OrderEvent queryOrderEvent(@PathVariable("orderId") String orderId) {
		System.out.println("order id is:\t"+orderId);
		return orderService.getOrderEvent(orderId);
	}
}
