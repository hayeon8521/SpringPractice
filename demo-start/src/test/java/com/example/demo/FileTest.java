package com.example.demo;

import org.junit.jupiter.api.Test;
import java.io.*;

public class FileTest {
	
	@Test
	public void contextLoads() {
//		File file = new File("c:/Temp/a.text");
//		//System.out.println(file.length());
//		//파일 삭제
//		file.delete();
//		
//		//폴더생성
//		File folder = new File("c:/Temp/txt");
//		folder.mkdir();
		
		//폴더 목록
		File file = new File("C:/Users");
		String[] list = file.list();
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
		
	}

}
