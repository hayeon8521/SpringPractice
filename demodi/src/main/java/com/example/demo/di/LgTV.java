package com.example.demo.di;

import lombok.Data;

//빈등록하라는 옵션
@Data
//@RequiredArgsConstructor
//@NoArgsConstructor	// 파이널 빼고
//@AllArgsConstructor
//@Component
public class LgTV implements TV{
	
	// 롬복이용
//	@Setter(onMethod_ = {@Autowired})
//	Speaker speaker;
		
	// 롬복 2
	final Speaker speaker;	// 파이널 필드 초기화 해주는 생성자 (@RequiredArgsConstructor)
	int price;	// 모든 필드 초기화 해주는 생성자 ( @AllArgsConstructor )
	
	//1. 필드 주입 방법 (권장하지 않음)
	//@Autowired 
	//Speaker speaker;

	// 3. 제일 많이 쓰는 [생성자 주입 방법] {권장}
//	@Autowired
//	public LgTV(Speaker speaker) {
//		System.out.println("construction injection");
//		//super();
//		this.speaker = speaker;
//	}
	
	// 2. setter 방식
	//@Autowired
//	public void setSpeaker(Speaker speaker) {
//		System.out.println("setter injection");
//		this.speaker = speaker;
//	}
//	
	
	
	
	
	public void powerOn() {
		System.out.println("LG TV--전원 on");
	}

	public void powerOff() {
		System.out.println("LG TV--전원 off");
	}
	public void volumeUp() {
		//System.out.println("LG TV--볼륨 up");
		speaker.volumeUp();
	}
	public void volumeDown() {
		//System.out.println("LG TV--볼륨 down");
		speaker.volumeDown();
	}
}