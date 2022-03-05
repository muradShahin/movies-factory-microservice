package com.moviesmms.moviesfactory;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesFactoryApplication  implements CommandLineRunner{
//	
//	@Autowired
//	JpaEntity repository;

	public static void main(String[] args) {
		SpringApplication.run(MoviesFactoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		long count = repository.count();
//
//		if (count == 0) {
//			repository.save(new Movie(1001,"Spider Man 2002","http://image","the Begining of spider",BigDecimal.valueOf(7)));
//			
//		}
	}

}
