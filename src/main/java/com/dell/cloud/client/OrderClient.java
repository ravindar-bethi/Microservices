package com.dell.cloud.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dell.cloud.entity.Order;

//@FeignClient(name="orderservice", url="${order.service.url}")
@FeignClient(name="orderservice")
public interface OrderClient{
	@GetMapping("/orders/user/{userId}")
	List<Order> getOrdersByUserId(@PathVariable("userId") Long userId);
}