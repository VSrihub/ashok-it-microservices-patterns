/**
 * 
 */
package com.medilab.order.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilab.order.bean.OrderBean;
import com.medilab.order.service.OrderService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author nsanda
 *
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class OrderResource {

	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/customer-orders")
	public ResponseEntity<OrderBean> placeOrder(@RequestBody OrderBean orderData){
		log.info("Customer Order Details are:\t"+orderData.toString());
		orderData = orderService.placeOrder(orderData);
		if(orderData.getOrderId() > 0) {
			return ResponseEntity.ok(orderData);
		}
		return ResponseEntity.badRequest().build();
	}
}
