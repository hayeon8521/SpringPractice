package com.example.demo.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Setter 안쓰기 위해서!!! 다 풀어서 사용함 @Data 금지!!
@Getter @Builder @NoArgsConstructor @AllArgsConstructor
@ToString
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String zipcode;
	private String address;
	private String detailAddress;
	
	//1대 1관계 어드레스가 주어 커스터머가 부어
//	@OneToOne
//	@JoinColumn(name = "customer_id")
//	Customer customer;

}
