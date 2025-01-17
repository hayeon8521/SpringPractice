package com.example.demo.board.service;

import java.util.List;

import com.example.demo.common.Paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 서비스 impl에서 생성됨
// DB리플정보 여러건 담을 VO 인데 
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyPageDTO {
	
	private int replyCnt;	//총 뎃글수
	//기존에 만들어놓은 공용클래스 사용함
	Paging paging;
	private List<ReplyDTO> list;	//댓글들의 집합
	

}
