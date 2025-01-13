package com.jroman5.api;

import com.jroman5.api.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@SpringBootApplication
public class ApiSpringBootApplication {

//	static ApplicationContext ctx;






	public static void main(String[] args) {
		SpringApplication.run(ApiSpringBootApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run() {
//		return args -> {
//
//			System.out.println("Executing command line runner...");
//
//
//			Customer c = new Customer();
//			System.out.println(ctx.getBean(Customer.class));
//			// Your command line logic here
//		};
//	}

}
