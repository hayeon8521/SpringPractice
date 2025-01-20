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
	@NotBlank(message = "타이틀을 입력 해주세요")
	private String title;
	@NotBlank(message = "내용을 입력 해주세요")
	private String content;
	@NotBlank(message = "글쓴이를 입력 해주세요")
	private String writer;
	private Date regdate;
	private Date updatedate;
	private String replycnt;
}
