package com.example.demo.common.aop;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect //이거 막으면 로그 안찍힘
@Component // 빈등록
public class LogAdvice {

	@Pointcut("execution(* com.example..*Impl.*(..))")
	public void allpointcut() {
	}
	
	@Pointcut("execution(* com.example..*Impl.get*(..))")
	public void getpointcut() {
	}
	

	//비포 시점에 처리되는것들
	@Before("allpointcut()")
	public void log(JoinPoint jp) {
		// 메서드 이름
		String methodname = jp.getSignature().getName();
		log.info("★★★[before] " + methodname);

		Object[] obj = jp.getArgs();
		if (obj != null) {
			log.info("★★★parameter: ");
			Arrays.asList(obj).forEach( p -> log.info(p.toString()));
		}
	}
	
	//에프터 시접에 처리되는것들 (서비스가 겟으로 처리되는것들 )
	//처리된 결과를 반환 받을려면 리터닝 해야함
	@AfterReturning(value="getpointcut()", returning = "result")	//정상실행결과만 돌아옴
	public void after(JoinPoint jp, Object result) {
		// 메서드 이름
		String methodname = jp.getSignature().getName();
		log.info("●●●[after returning] " + methodname);
		
		//서비스 리턴 값 출력 (get으로 시작하는 서비스만)
		log.info("●●●return : " + result);
	}
}
