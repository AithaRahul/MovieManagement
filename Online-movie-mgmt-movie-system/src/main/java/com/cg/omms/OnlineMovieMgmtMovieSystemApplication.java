package com.cg.omms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OnlineMovieMgmtMovieSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMovieMgmtMovieSystemApplication.class, args);
	}

}
