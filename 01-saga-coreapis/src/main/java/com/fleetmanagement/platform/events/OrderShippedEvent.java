package com.fleetmanagement.platform.events;

public class OrderShippedEvent {

    public final String shippingId;

    public final String orderId;

    public final String paymentId;

    public OrderShippedEvent(String shippingId, String orderId, String paymentId) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

	@Override
	public String toString() {
		return "OrderShippedEvent [shippingId=" + shippingId + ", orderId=" + orderId + ", paymentId=" + paymentId
				+ "]";
	}
    
    
}
