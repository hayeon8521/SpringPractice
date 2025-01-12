package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository	extends JpaRepository<Customer,	Long>{
	//이걸로 모든 curd 가능함
	// 아무것도 없이 비워 놔도 됨
}
 