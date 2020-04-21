package com.abhinav.coronatracker;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableAsync
@EnableScheduling
@EnableCaching
@SpringBootApplication
public class CoronatrackerApplication {

	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
		SpringApplication.run(CoronatrackerApplication.class, args);
	}

}
