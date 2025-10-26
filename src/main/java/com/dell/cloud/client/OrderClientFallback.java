package com.dell.cloud.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dell.cloud.entity.Order;

@Component
public class OrderClientFallback implements OrderClient {

	@Override
	public List<Order> getOrdersByUserId(Long userId) {
       //Returning default response when order service is down
		return Collections.singletonList(new Order(0L,0L,"0",0, "Service Unavilable"));
	}

}
