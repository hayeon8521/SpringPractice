package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LambdaTest {
	
	@Test
	public void sort() {
		//기본 타입은 그냥 소트 됨
		List<Integer> list2 = Arrays.asList(4,5,6,10,1);
		Collections.sort(list2);
		System.out.println(list2);
		
		
		//객체나 등등은 어느기준인지 해줘야함
		List<SampleVO> list = Arrays.asList(
				new SampleVO("홍길동", 10),
				new SampleVO("김유신", 20),
				new SampleVO("최기자", 15)
		);
		//Collections.sort(list, new SampleCompare());
		//익명클래스로 해보기 // 생성과 선언을 한꺼번에 하겠다
//		Collections.sort(list, new Comparator<SampleVO>() {
//				@Override
//				public int compare(SampleVO o1, SampleVO o2) {
//					return o1.getName().compareTo(o2.getName());
//				}
//			} 
//		);
		// 람다식이라는게 익명클래스로 만드는거
		//람다식으로 바꿔보기 ( 인터페이스의 메소드가 딱1개 일때만 가능하다 )
		Collections.sort(list, (SampleVO o1, SampleVO o2) -> {
				return o1.getName().compareTo(o2.getName());
			} 
		);
		
		System.out.println(list);
		
	}

}

class SampleCompare implements Comparator<SampleVO>{
	@Override
	public int compare(SampleVO o1, SampleVO o2) {
		return o1.getName().compareTo(o2.getName());
	}
}