package com.fleetmanagement.platform.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateInvoiceCommand{

    @TargetAggregateIdentifier
    public final String paymentId;

    public final String orderId;

    public CreateInvoiceCommand(String paymentId, String orderId) {
        this.paymentId = paymentId;
        this.orderId = orderId;
    }
}
