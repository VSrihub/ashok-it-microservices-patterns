package com.fleetmanagemnt.platform.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmanagemnt.platform.dto.commands.OrderCreateDTO;
import com.fleetmanagemnt.platform.services.commands.OrderCommandService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/orders")
@Api(value = "Order Commands")
public class OrderCommandController {

    private OrderCommandService orderCommandService;

    public OrderCommandController(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createOrder(@RequestBody OrderCreateDTO orderCreateDTO){
        return orderCommandService.createOrder(orderCreateDTO);
    }
}
