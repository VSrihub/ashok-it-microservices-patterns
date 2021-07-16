package com.medilab.order.service;

import com.medilab.order.event.OrderEvent;

public interface QueryOrderService {

	public OrderEvent getOrderEvent(String orderId);
}
