package com.alibaba.edas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringcloudProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudProviderApplication.class, args);
	}

    @RestController
    class EchoController {

        @RequestMapping("/echo")
        public String echo() {
            return "hello world";
        }

    }

}
