package com.medilab.order.event;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
//@AllArgsConstructor
public class OrderMenuEvent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3788829706033800605L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int itemId;
	private String name;
	private int quantity;
	
	
	public OrderMenuEvent(int itemId, String name, int quantity) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.quantity = quantity;
	}
	
}
