package com.example.demo.posts.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//수정은 제목과 내용만 변경가능
@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
