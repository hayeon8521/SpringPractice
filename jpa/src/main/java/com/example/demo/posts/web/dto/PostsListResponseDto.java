package com.example.demo.posts.web.dto;

import java.time.LocalDateTime;

import com.example.demo.posts.domain.Posts;

import lombok.Getter;

//전체조회
@Getter
public class PostsListResponseDto {
	private Long id;
	private String title;
	private String author;
	private LocalDateTime modifyDate;
	
	//그래서 조회한거를 Dto로 변환
	public PostsListResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		this.modifyDate = entity.getModifyDate();
	}
}
