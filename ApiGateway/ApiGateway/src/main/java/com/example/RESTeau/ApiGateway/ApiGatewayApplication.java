package com.example.RESTeau.ApiGateway;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.net.http.HttpClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {


	public static void main(String[] args) {



		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
