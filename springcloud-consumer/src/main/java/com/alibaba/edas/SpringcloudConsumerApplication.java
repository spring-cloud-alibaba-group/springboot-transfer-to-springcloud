package com.alibaba.edas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringcloudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConsumerApplication.class, args);
	}

    @Configuration
    class Config {
	    @LoadBalanced
        @Bean
        RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

    @RestController
    class Controller {

        private RestTemplate restTemplate;

        public Controller(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @RequestMapping("/hello")
        public String echo() {
            return restTemplate.getForObject("http://echo-service/echo", String.class);
        }

    }

}
