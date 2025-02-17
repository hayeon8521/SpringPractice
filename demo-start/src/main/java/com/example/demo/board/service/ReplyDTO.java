package com.example.demo.board.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//리플 DB 정보 가져오는거
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
	
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replydate;
	private Date updatedate;

}
