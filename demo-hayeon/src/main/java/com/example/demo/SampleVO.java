package com.example.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {
	
	//이그노어 사용하면 해당 객체는 없이 출력됨
	//@JsonIgnore
	private int mno;
	
	//갯터 셋터 이름 다른걸로할수있음
	//@JsonProperty("fname")
	private String firstName;	
	
	//기본값 설정
	//@JsonProperty(defaultValue = "hayeon")
	private String lastName;
	
	//날짜 포멧 바꿀수도 있음
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
	private Date regdate;

}
