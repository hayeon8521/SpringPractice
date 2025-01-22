package com.example.demo.posts.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.posts.service.PostsService;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;
import com.example.demo.posts.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostsAPIController {
	
	final PostsService postsService;

	//등록처리
	@PostMapping("/api/v1/posts")
	public PostsSaveRequestDto save(@RequestBody PostsSaveRequestDto dto) {
		postsService.save(dto);
		return dto;
	}
	
	//수정처리
	@PutMapping("/api/v1/posts/{id}")
	public PostsUpdateRequestDto update(@PathVariable(name="id") Long id,
						@RequestBody PostsUpdateRequestDto dto) {
		log.info("★★"+id);
		log.info("★★★"+dto);
		postsService.update(id, dto);
		return dto;
	}
	
	//삭제처리
	//@DeleteMapping("/api/v1/posts/{id}")

}
