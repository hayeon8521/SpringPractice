package com.example.demo.board.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import groovy.util.logging.Slf4j;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ReportController {

	// db커넥션 풀
	@Autowired
	DataSource datasource;

	// 파일 다운로드
	@GetMapping("fileDown")
	public void fileDown(HttpServletResponse response) throws IOException {
		FileInputStream fi = new FileInputStream("c:/Temp/data.txt");
		int readByte;
		// 파일 다운로드 하게 해줌
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		// 파일명을 변경해줌
		response.setHeader("Content-Disposition", "attachment; filename=" + "data.txt");
		while ((readByte = fi.read()) != -1) {
			response.getOutputStream().write(readByte);
		}
		fi.close();
	}

	// PDF연결
	@GetMapping("report")
	public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//레포트파일 읽어드림
		InputStream jasperStream = getClass().getResourceAsStream("/reports/emp.jasper");
		
		//레포트 + 데이터(커넥션) => 레포트파일 환성
		Connection conn = datasource.getConnection();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, null, conn);
		conn.close();

		//pdf 출력
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	
	//common 패키지에 만들어놓고 호출해서  파일명만 넘겨주면 알아서 처리하게 할 수 도 있다.
	@GetMapping(value = "pdfView")
	public ModelAndView pdfview() throws Exception {
		return new ModelAndView("pdfView", "filename", "/reports/emp.jasper");
	}
	
	@GetMapping(value = "pdfViewDown")
	public ModelAndView pdfviewDown() throws Exception {
		return new ModelAndView("pdfViewDown", "filename", "/reports/emp.jasper");
	}

}
