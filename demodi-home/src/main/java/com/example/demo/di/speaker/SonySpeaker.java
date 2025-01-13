package com.example.demo.di.speaker;

import org.springframework.stereotype.Component;

//@Component
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("소니 스피커 객채 생성");
	}
	@Override
	public void volumeUp(){
		System.out.println("Sony Speaker 소리 올림");
	}
	@Override
	public void volumeDown(){
		System.out.println("Sony Speaker 소리 내림");
	}
} 