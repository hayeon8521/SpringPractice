package com.example.demo.service;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

	private Long bookNo;
	@NotBlank(message = "도서명을 입력해주세요")
	private String bookName;
	
	private String bookCoverimg;

	private Date bookDate;
	
	private Integer bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	private Integer rentPrice;
	private Integer rentStatus;
}
