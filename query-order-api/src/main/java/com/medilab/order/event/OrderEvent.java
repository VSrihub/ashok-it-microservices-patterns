package com.medilab.order.event;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class OrderEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private String orderEventId;
	
	public OrderEvent() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<OrderMenuEvent> menu;
	

}
