package com.example.demo.board.service;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	private Long bno;
	
	//공백도 허용안할때는 notblank // 공백허용은 notnull
	@NotBlank(message = "타이틀을 입력 해주세요")
	private String title;
	@NotBlank(message = "내용을 입력 해주세요")
	private String content;
	@NotBlank(message = "글쓴이를 입력 해주세요")
	private String writer;
	
	private Date regdate;
	private Date updatedate;
}
// Long = 기본타입들을 하나의 객체로 만들어준다 (초기값 null)
// long = 값만 저장할수있는 기본형  (초기값 0)