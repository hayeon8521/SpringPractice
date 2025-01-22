package com.example.demo.posts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.posts.domain.Posts;
import com.example.demo.posts.domain.PostsRepository;
import com.example.demo.posts.web.dto.PostsListResponseDto;
import com.example.demo.posts.web.dto.PostsResponseDto;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;
import com.example.demo.posts.web.dto.PostsUpdateRequestDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
	
    private final PostsRepository postsRepository;

    //등록
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    
    //수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    
    //단건조회
    @Transactional
    public PostsResponseDto findById(Long id) {
    	Optional<Posts> post = postsRepository.findById(id);
    	return new PostsResponseDto(post.get());
    }

    
    //삭제
    public int delete(Long id){
    	postsRepository.deleteById(id);;
    	return 0;
    }
    
    //전체조회
    @Transactional
    public List<PostsListResponseDto> findAll(){
    	//전체 데이터 가져옴
    	List<Posts> list =  postsRepository.findAll();
    	
    	// 단순포문 돌려서 객체에 담아도 되고
    	
    	//전체 데이터를 넣을 빈공간 (이렇게 객체 선언해서 포이치 해도 되고)
//    	List<PostsListResponseDto> dtoList = new ArrayList<>();
//    	list.forEach(post -> dtoList.add( new PostsListResponseDto(post) ) );
//    	return dtoList;
    	
    	//이렇게 스트림 맵 콜랙트 함수 사용해서 한줄로 처리해도되고 [ 병렬 처리 되기때문에 가장 빠르고 효율적임 ]
    	return list.stream().map( post -> new PostsListResponseDto(post) )
    						.collect( Collectors.toList() );
    }
    
}