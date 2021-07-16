package com.fleetmanagement.platform.aggregates;

import com.fleetmanagement.platform.commands.CreateShippingCommand;
import com.fleetmanagement.platform.events.OrderShippedEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ShippingAggregate {

    @AggregateIdentifier
    private String shippingId;

    private String orderId;

    private String paymentId;

    public ShippingAggregate() {
    }

    @CommandHandler
    public ShippingAggregate(CreateShippingCommand createShippingCommand){
    	
    	System.out.println("Executing CreateShippingCommand"  );
        AggregateLifecycle.apply(new OrderShippedEvent(createShippingCommand.shippingId, createShippingCommand.orderId, createShippingCommand.paymentId));
        System.out.println("Dispatched  OrderShippedEvent"  );
    }

    @EventSourcingHandler
    protected void on(OrderShippedEvent orderShippedEvent){
        this.shippingId = orderShippedEvent.shippingId;
        this.orderId = orderShippedEvent.orderId;
    }
}
