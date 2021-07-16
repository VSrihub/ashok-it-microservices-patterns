package com.fleetmanagement.platform.events;

public class OrderUpdatedEvent {

    public final String orderId;

    public final String orderStatus;

    public OrderUpdatedEvent(String orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

	@Override
	public String toString() {
		return "OrderUpdatedEvent [orderId=" + orderId + ", orderStatus=" + orderStatus + "]";
	}
    
    
}
