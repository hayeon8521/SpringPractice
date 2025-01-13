package com.example.demo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	//이렇게하면 이제 자바유틸이지만 슬러쉬아니고 빼기로 값받을수있음
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date dueDate;
}
