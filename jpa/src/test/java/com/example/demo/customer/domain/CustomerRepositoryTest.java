package com.example.demo.customer.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//레포지토리 인터페이스 있는 패키지 위치랑 똑같이 해야함 그리고 해당 인터페이스 이름에 Test만 붙여야함

@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired CustomerRepository customerRepository;
	
	@Autowired AddressRepository addressRepository;
	
	//@Test
	@DisplayName("고객등록")
	public void insert() {
		//given
		Customer customer = new Customer( "표하연", "010-8521-6704");
		//when
		customerRepository.save(customer);	//save 함수는 등록도 될수 있고 수정도 될수 있따
		//then
		Optional<Customer> result = customerRepository.findById(1L);
		assertThat( result.get().getName() ).isEqualTo("표하연");
	}
	
	
	//@Test
	@DisplayName("고객수정")
	public void update() {
		//given
		Customer customer = new Customer( "표하연", "010-8521-6704");
		customerRepository.save(customer);	// 값 1개 넣고
		//when
		Optional<Customer> result = customerRepository.findById(1L);	//들어간 값이 맞는지 확인하고
		result.get().setPhone("2222-3333");	//새로운 값으로 바꾸고
		customerRepository.save(result.get());	// 바꾼값으로 업데이트
		//then
		assertThat( result.get().getPhone() ).isEqualTo("2222-3333");
	}
	
	//@Test
	@DisplayName("이름검색")
	public void findByName() {
		String name = "%c%";
		List<Customer> list =  customerRepository.findByNameLike(name);
		System.out.println(list);		
	}
	
	//@Test
	@DisplayName("이름 과 폰 검색")
	public void findByNameLikeOrPhoneLikeOrderByNameDesc() {
		String name = "%hayeon%";
		String phone = "%8521%";
		List<Customer> list =  customerRepository.findByNameLikeOrPhoneLikeOrderByNameDesc(name,phone);
		System.out.println(list);		
	}
	
	//@Test
	@DisplayName("아이디로 전체검색")
	public void abcd() {
		Long id = 1l;
		String phone = "010-1111-2222";
		Optional<Customer> customer =  customerRepository.abcd(id, phone);
		System.out.println(customer);		
	}
	
	//@Test
	@DisplayName("아이디로 전체검색")
	public void ffff() {
		Long id = 1l;
		Optional<Customer> customer =  customerRepository.ffff(id);
		System.out.println(customer);		
	}
	
	//@Test
	@DisplayName("1:1 관계로 어드레스가 주어")
	public void insert2() {
		//given
		Customer customer = new Customer( "표하연", "010-8521-6704");
		//when
		//커스터머 등록
		customerRepository.save(customer);
		//주소 등록
		addressRepository.save(
								Address.builder()
								.address("우리집 좋은곳")
								//.customer(customer)
								.build()
								);
		System.out.println("id: "+customer.getId());
		//then
		Optional<Customer> result = customerRepository.findById(7L);
		Optional<Address> address = addressRepository.findById(1L);
		System.out.println("★★★★address: " + address);
		assertThat( result.get().getName() ).isEqualTo("표하연");
	}

}
