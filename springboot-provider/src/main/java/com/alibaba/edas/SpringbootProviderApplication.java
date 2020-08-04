package com.alibaba.edas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProviderApplication.class, args);
	}

    @RestController
    class EchoController {

        @RequestMapping("/echo")
        public String echo() {
            return "hello world";
        }

    }

}
