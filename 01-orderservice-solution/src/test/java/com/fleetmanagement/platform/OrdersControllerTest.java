package com.fleetmanagement.platform;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.fleetmanagemnt.platform.controllers.OrderCommandController;
import com.fleetmanagemnt.platform.dto.commands.OrderCreateDTO;
import com.fleetmanagemnt.platform.services.commands.OrderCommandService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class OrdersControllerTest {

	@Mock
	private OrderCommandService orderService;
	
	@InjectMocks
	private OrderCommandController controller;
	
	OrderCreateDTO dto = null;
	CompletableFuture<String> future = new CompletableFuture<>();
	
	@BeforeEach
	public void setMockResponse() {
		dto = new OrderCreateDTO();
		dto.setCurrency("INR");
		dto.setItemType("SMARTPHONE");
		dto.setPrice(new BigDecimal(2000));
		//CompletableFuture<String> future = new CompletableFuture<>();
		future.complete("12345678");
		future.completedFuture("completed");
		when(orderService.createOrder(dto)).thenReturn(future);
	}
	
	@Test
	public void testCreateOrder() throws InterruptedException, ExecutionException {
		when(controller.createOrder(dto)).thenReturn(future);
		assertEquals("12345678", future.get());
		assertTrue(future.isDone());
		assertFalse(future.isCompletedExceptionally());
	}
}
