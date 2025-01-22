package com.example.demo.posts.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
//상속받는 자식 클래스에 자동으로 아래꺼 칼럼 추가해라
@MappedSuperclass
//등록과 수정이 발생할때 해당리스너가 작동함
@EntityListeners(AuditingEntityListener.class)	
public class BaseTimeEntity {
	
	//등록될때 시간정보를 자동으로 집어넣어줌
	@CreatedDate
	private LocalDateTime createdDate;
	
	//수정할때 자동으로 시간정보를 집어넣어줌
	@LastModifiedDate
	private LocalDateTime modifyDate;

}
