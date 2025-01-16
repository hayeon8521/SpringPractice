package com.example.demo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data	
public class CompVo {

	private List<Ticket> list;
	
	private SampleVO sample;
	
	private int cnt;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date regdate;
		
}
