package com.example.demo.di.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.di.speaker.SonySpeaker;
import com.example.demo.di.speaker.Speaker;
import com.example.demo.di.tv.LgTV;
import com.example.demo.di.tv.TV;

@Configuration
public class Javaconfig {
	@Bean
	public Speaker speaker() {
		return new SonySpeaker(); 
	}
	@Bean
	public TV tv() {
		return new LgTV(speaker());
	}
}
