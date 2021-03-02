package com.egorbarinov.demoapp;


import com.egorbarinov.demoapp.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PersonRepository.initDataBase();
	}
}
