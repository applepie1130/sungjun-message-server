package com.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
public class SungjunStreamServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SungjunStreamServerApplication.class, args);
	}

}
