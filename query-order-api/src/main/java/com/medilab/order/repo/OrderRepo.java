package com.medilab.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medilab.order.event.OrderEvent;

public interface OrderRepo extends JpaRepository<OrderEvent, Integer> {

	@Query("from OrderEvent oe where oe.orderEventId=:orderEventId")
	public OrderEvent findByEventId(@Param("orderEventId") String orderEventId);
}
