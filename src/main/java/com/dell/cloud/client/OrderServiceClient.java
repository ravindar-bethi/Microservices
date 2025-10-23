package com.dell.cloud.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceClient {
	private final DiscoveryClient discoveryClient;
	private final RestTemplate restTemplate;

	@Autowired
	public OrderServiceClient(DiscoveryClient discoveryClient, RestTemplate restTemplate) {
		this.discoveryClient = discoveryClient;
		this.restTemplate = restTemplate;
	}

	public String fetchOrdersForUser(Long userId) {
		// get all instances of Order servics
		/*List<ServiceInstance> instances = discoveryClient.getInstances("orderservice");
		if (instances.isEmpty()) {
			return "Order Service is unavailable";
		}
		// Get the first available instance
		ServiceInstance serviceInstance = instances.get(0);
		String orderServiceUrl = serviceInstance.getUri().toString();*/
		
		String orderServiceUrl = "http://orderservice/orders/users/"+ userId;
		
		// Make API call Dynamically
		return restTemplate.getForObject(orderServiceUrl, String.class);
	}

}
