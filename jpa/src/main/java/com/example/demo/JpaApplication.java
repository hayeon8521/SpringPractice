package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.domain.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	// 여기에 집어넣으면 프로젝트가 시작될때 샘플데이터가 자동으로 삽입되어있따
	//@Bean
	public CommandLineRunner	demo(CustomerRepository	repository)	{
		return (args)	->	{
			//		save	a	few	customers
			repository.save(new	Customer("Jack",	"010-1111-2222"));
			repository.save(new Customer("Chloe",	"111-3333-4444"));
			repository.save(new Customer("Kim",	"222-4444-6666"));
			repository.save(new Customer("David",	"333-1234-6547"));
			repository.save(new Customer("Michelle",	"444-9874-7854"));
			repository.save(new Customer("hayeon",	"010-8521-6704"));
			//		fetch	all	customers
			log.info("Customers	found	with	findAll():");
			log.info("-------------------------------");
			for (Customer	customer :	repository.findAll())	{
				log.info(customer.toString());
			}
			log.info("");
		};
	}
	
	

}
