package com.medilab.order.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class OrderBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int orderId;
	private List<OrderMenuBean> menu;
	

}
