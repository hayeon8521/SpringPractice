package com.example.demo.customer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//1대 1관계로 조인 걸어놨음
public interface AddressRepository extends JpaRepository<Address, Long> {

}
