package com.example.demo.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect	//이거 막으면 로그 안찍힘
@Component 
public class AroundAdvice {

	@Around("LogAdvice.allpointcut()")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		// 서비스 메서드 실행 전
		long start = System.currentTimeMillis();	//현재시간
		
		// 서비스 메서드 호출
		obj = pjp.proceed();
		
		// 서비스 메서드 실행 후
		long end = System.currentTimeMillis();	//현재시간
		log.info("◆◆◆TIME: " + (end-start));
		
		return obj;
	}
}
