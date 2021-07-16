package com.medilab.order.command;

import java.io.Serializable;
import java.util.List;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class OrderCommand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@TargetAggregateIdentifier
	private int orderId;
	private List<OrderMenuCommand> menu;
	

}
