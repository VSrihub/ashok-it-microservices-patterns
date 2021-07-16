package com.medilab.order.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderMenuCommand {

	private int itemId;
	private String name;
	private int quantity;
}
