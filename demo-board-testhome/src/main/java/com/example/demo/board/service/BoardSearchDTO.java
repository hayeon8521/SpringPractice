package com.example.demo.board.service;

import lombok.Data;

@Data
public class BoardSearchDTO {
	int start;
	int end;
	
	int pageUnit;
	
	String keyword;
	
	String type;
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
