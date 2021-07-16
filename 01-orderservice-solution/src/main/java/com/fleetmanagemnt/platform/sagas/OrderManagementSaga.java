package com.fleetmanagemnt.platform.sagas;

import com.fleetmanagement.platform.commands.CreateInvoiceCommand;
import com.fleetmanagement.platform.commands.CreateShippingCommand;
import com.fleetmanagement.platform.commands.UpdateOrderStatusCommand;
import com.fleetmanagement.platform.events.*;
import com.fleetmanagemnt.platform.aggregates.OrderStatus;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import javax.inject.Inject;
import java.util.UUID;

@Saga
public class OrderManagementSaga {

    @Inject
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent){
        String paymentId = UUID.randomUUID().toString();
        System.out.println("Saga invoked ...order created....");

        //associate Saga
        SagaLifecycle.associateWith("paymentId", paymentId);

        System.out.println("order id" + orderCreatedEvent.orderId);

        //send the commands
        commandGateway.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.orderId));
        
        System.out.println("Dispathed  CreateInvoiceCommand");
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(InvoiceCreatedEvent invoiceCreatedEvent){
        String shippingId = UUID.randomUUID().toString();

        System.out.println("Saga continued ..... InvoiceCreatedEvent");

        //associate Saga with shipping
        SagaLifecycle.associateWith("shippingId", shippingId);

        //send the create shipping command
        commandGateway.send(new CreateShippingCommand(shippingId, invoiceCreatedEvent.orderId, invoiceCreatedEvent.paymentId));
        System.out.println("Dispathed  CreateShippingCommand");
    }
   

    @SagaEventHandler(associationProperty = "shippingId")
    public void handle(OrderShippedEvent orderShippedEvent){
    	 System.out.println("Saga continued ..... OrderShippedEvent");
    	 
    	 SagaLifecycle.associateWith("orderId", orderShippedEvent.orderId);
        commandGateway.send(new UpdateOrderStatusCommand(orderShippedEvent.orderId, String.valueOf(OrderStatus.SHIPPED)));
        
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderUpdatedEvent orderUpdatedEvent){
    	System.out.println("Saga Ended....");
        SagaLifecycle.end();
    }
}
