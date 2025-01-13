package com.example.demo.di.tv;

import org.springframework.stereotype.Component;

import com.example.demo.di.speaker.Speaker;

import lombok.Data;

@Data
//@Component
public class LgTV implements TV {
	
	// SETTER 주입방식 [디펜던시 인젝트 DI]
//	private Speaker speaker; 
//	@Autowired
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
	
	// 생성자 주입방식 [ 디펜던시 인젝트 DI ]
//	private Speaker speaker;
//	public LgTV(Speaker speaker) {
//		this.speaker = speaker;
//	}
	
	// 생성자 주입방식 진화 @Data 필수 [ 디펜던시 인젝트 DI ]
	private final Speaker speaker;
	
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