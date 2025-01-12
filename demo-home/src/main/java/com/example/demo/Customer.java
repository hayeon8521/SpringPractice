package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer	{
				@Id
@GeneratedValue(strategy	=	GenerationType.AUTO)
				private Long	id;
				@Column(length	=	20,	nullable	=	false)
				private String	name;
				@Column(length	=	20,	nullable	=	false,	unique	=	true)
				private String	phone;
				public Long getId() {
					return id;
				}
				public void setId(Long id) {
					this.id = id;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public String getPhone() {
					return phone;
				}
				public void setPhone(String phone) {
					this.phone = phone;
				}	
}
