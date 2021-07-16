package com.medilab.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medilab.order.event.OrderEvent;

public interface OrderRepo extends JpaRepository<OrderEvent, Integer> {

}
