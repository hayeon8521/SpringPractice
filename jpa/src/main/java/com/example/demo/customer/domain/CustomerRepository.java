package com.example.demo.customer.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//이렇게하면 맵퍼가 자동으로 생김
//인터페이스끼리 상속은 extends								//클래스명,   기본키 타입
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	//이렇게하면 메소드 하나 추가된다 ★내가 원하는 쿼리 만들수있따
	public List<Customer> findByNameLike(String keyword);
	
	//like name , or , like phone, order by name desc 이런식으로 원하는 쿼리 만들수있다
	//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	public List<Customer> findByNameLikeOrPhoneLikeOrderByNameDesc(String keyword, String phone);
	
	//그것도 싫으면 쿼리 자체를 만들수있따
	// ?1 첫번쨰 값 ?2 두번째값
	@Query("select c from Customer c where id = :id and phone = :phone order by name desc")
	public Optional<Customer> abcd(@Param("id") Long id, @Param("phone") String phone);
	
	@Query("select c from Customer c where id = ?1")
	public Optional<Customer> ffff(Long id);
}
