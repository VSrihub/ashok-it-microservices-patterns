package com.fleetmanagemnt.platform.services.commands;

import java.util.concurrent.CompletableFuture;

import com.fleetmanagemnt.platform.dto.commands.OrderCreateDTO;

public interface OrderCommandService {

    public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO);

}
