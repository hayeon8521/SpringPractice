package com.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputStreamTest {
	
	//@Test
	@DisplayName("파일생성")
	public void test1() throws IOException{
		//반드시 예외처리가 필요
		//키보드 입력을 파일로 읽는다
		FileOutputStream fo = new FileOutputStream("c:/Temp/data.txt");
		int readByte;
		//더이상 읽을값이 없을땐 -1 그게아니면 읽는값을 읽어드린다
		while( (readByte = System.in.read()) != -1 ) { //컨트롤 z 누르면 빠져나옴
			fo.write(readByte);
		}
		//fw.write("happy");
		fo.close();
	}
	
	//@Test
	@DisplayName("파일출력")
	public void test2() throws IOException {
		FileInputStream fi = new FileInputStream("c:/Temp/data.txt");
		int readByte;
		while ( (readByte = fi.read()) != -1 ) {
			System.out.print((char)readByte);
		}
		fi.close();
	}
	
	@Test
	@DisplayName("파일복사")
	public void test3() throws IOException {
		FileInputStream fi = new FileInputStream("c:/Temp/data.txt");
		FileOutputStream fo = new FileOutputStream("c:/Temp/data2.txt");
		int readByte;
		while ( (readByte = fi.read()) != -1 ) {
			fo.write(readByte);
		}
		fi.close();
		fo.close();
	}

}

//writer, reader - 스트링 바이트 (텍스트 파일 )
//stream - 바이너리(실행파일, 이미지파일)