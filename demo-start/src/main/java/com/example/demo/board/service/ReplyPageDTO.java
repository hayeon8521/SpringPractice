package com.example.demo.board.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyPageDTO {
	
	private int replyCnt;
	private List<ReplyDTO> list;

}
