package com.dell.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dell.cloud.client.OrderClient;

@SpringBootTest(properties = {
		  "eureka.client.enabled=false",
		  "spring.cloud.discovery.enabled=false",
		  "feign.hystrix.enabled=false"
		})
@MockBean(OrderClient.class)
class SpringcloudApplicationTests {

	@Test
	void contextLoads() {
	}


}
