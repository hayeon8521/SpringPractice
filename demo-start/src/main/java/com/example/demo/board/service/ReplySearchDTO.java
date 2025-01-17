package com.example.demo.board.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//리플 페이지 구하는거 인데...
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplySearchDTO {
	
	int page = 1;	// 몇 페이지 
	int amount = 3;	//몇건 출력?

	public int getStart() {
		return (page-1)*amount +1;
	}

	public int getEnd() {
		return page*amount;
	}
}
