package com.medilab.order.amqp;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medilab.order.event.OrderEvent;

@Component
public class MQSender {

	@Value("${order.rabbitmq.exchange}")
	private String exhange;
	
	@Value("${order.rabbitmq.routingKey}")
	private String routingKey;
	
	@Autowired
	private AmqpTemplate rabbitMqTemplate;
	
	public void sendOrderEventToQueue(OrderEvent orderEvent) {
		System.out.println("order event data in mq sender is:\t"+orderEvent.toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			rabbitMqTemplate.convertAndSend(exhange,routingKey,mapper.writeValueAsString(orderEvent));
		} catch (AmqpException | JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
