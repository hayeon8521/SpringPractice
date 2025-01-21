package com.example.demo.customer.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Getter;

//Setter 안쓰기 위해서!!! 다 풀어서 사용함 @Data 금지!!
@Getter	//셋터 넣으면 안되고 겟터만 넣어야함!!
@Entity	//JPA 테이블 자동으로 생성하게 만듬
//@Table(name = "cust")	//테이블 이름을 cust로 생성한다 이거 없으면 클래스 명으로 테이블 만듬
public class Customer {
	@Id	//자카르타이고 ( 기본키 설정 )
	@GeneratedValue(strategy = GenerationType.AUTO)		//시퀀스 만드는 방법 GenerationType.SEQUENCE 오토로하면 알아서 잡아줌
	private Long id;
	
	//@Column(name = "username", length = 50, nullable = false)	//칼럼을 username 으로하고 길이는 50으로 notnull로 칼럼 추가함
	private String name;
	
	//@Column(nullable = false, columnDefinition = "clob")	//칼럼 속성을 varchar2에서 clob로 변경한다
	private String phone;
	
	
	//Address 클래스 조인 걸어서 (1대 1관계)
	//@OneToOne
	//@JoinColumn(name = "address_id")
	//Address address;
	
	
	//일대 다 관계  커스터머가주어  어드레스가 부어
	//이거 안됐음!!!!
//	@OneToMany(mappedBy = "customer")
//	List<Address> address;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Transient	// 이거 쓰면 반영 안됨!! 칼럼 생성 안됨
	private String addr;
	
	@Transient // 이거 쓰면 반영 안됨!! 칼럼 생성 안됨
	private String grade;

	//생성자
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	//기본생성자
	public Customer() {}

	//셋터 생성
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
} 