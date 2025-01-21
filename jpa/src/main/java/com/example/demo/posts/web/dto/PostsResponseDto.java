package com.example.demo.posts.web.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Getter;

//단건조회 조회한거를 다시 Dto에 넣어줘야함
@Getter	
public class PostsResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;
	
	//그래서 조회한거를 Dto로 변환
	public PostsResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getAuthor();
	}
}
