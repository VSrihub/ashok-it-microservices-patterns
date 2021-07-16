package com.medilab.order.amqp;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medilab.order.event.OrderEvent;

@Component
public class MQConsumer {

	@Autowired
	private CommandGateway commandGateway;
	
	@RabbitListener(queues="${order.rabbitmq.queue}",containerFactory="srlcFactory")
	public void recieveMessageFromQueue(String orderEvent) {
		System.out.println("order event data received from queue si:\t"+orderEvent.toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			OrderEvent event = mapper.readValue(orderEvent, OrderEvent.class);
			commandGateway.send(event);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//commandGateway.send(orderEvent);
	}
}
