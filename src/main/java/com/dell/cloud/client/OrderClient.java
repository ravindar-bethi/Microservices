package com.dell.cloud.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*@FeignClient(name="order-service", url="${order.service.url}")
public interface OrderClient{
	@GetMapping("/user/{userId}")
	List<String> getOrdersByUserId(@PathVariable Long userId);
}*/