package com.careerdevs.placeholderV1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PlaceholderV1Application {

	public static void main(String[] args) {
		SpringApplication.run(PlaceholderV1Application.class, args);
	}

	@Bean  //implements an instance of the RestTemplate Class
	public RestTemplate restTemplate (RestTemplateBuilder builder){
		return builder.build();
	}

}
