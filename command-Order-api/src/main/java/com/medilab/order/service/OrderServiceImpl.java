package com.medilab.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medilab.order.bean.OrderBean;
import com.medilab.order.command.OrderCommand;
import com.medilab.order.command.OrderMenuCommand;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CommandGateway commandBus;
	
	@Override
	public OrderBean placeOrder(OrderBean orderBean) {
		
		OrderCommand orderCommand = new OrderCommand();
		BeanUtils.copyProperties(orderBean, orderCommand);
		
		List<OrderMenuCommand> menuCommandList = new ArrayList();
		orderBean.getMenu().stream().forEach(menuBean->{
			OrderMenuCommand menuCommand = new OrderMenuCommand(menuBean.getItemId(),menuBean.getName(),menuBean.getQuantity());
			menuCommandList.add(menuCommand);
		});
		orderCommand.setMenu(menuCommandList);
		
		CompletableFuture<OrderCommand> future = commandBus.send(orderCommand);
		System.out.println("is future done:\t"+future.isDone());
		System.out.println("is future isCompletedExceptionally:\t"+future.isCompletedExceptionally());
		if(future.isDone() && !future.isCompletedExceptionally()) {
			try {
				OrderCommand orderComm = (OrderCommand) future.get();
				System.out.println("fure resposne is:\t"+orderComm.getOrderId());
				BeanUtils.copyProperties(orderComm, orderBean);
			} catch (BeansException | InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		return orderBean;
	}

}
