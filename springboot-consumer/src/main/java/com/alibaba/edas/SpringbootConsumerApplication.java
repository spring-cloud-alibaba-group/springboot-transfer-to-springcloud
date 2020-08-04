package com.alibaba.edas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConsumerApplication.class, args);
	}

    @Configuration
    class Config {
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
            // 基于 ip 的调用方式
            //return restTemplate.getForObject("http://localhost:8080/echo", String.class);
            // 基于域名的调用方式
            return restTemplate.getForObject("http://echo-service/echo", String.class);
        }

    }

}
