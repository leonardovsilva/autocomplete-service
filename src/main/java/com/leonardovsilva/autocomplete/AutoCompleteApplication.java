package com.leonardovsilva.autocomplete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableElasticsearchRepositories
@EnableHystrix
public class AutoCompleteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoCompleteApplication.class, args);
	}

}
