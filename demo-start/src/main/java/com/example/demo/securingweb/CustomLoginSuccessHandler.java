package com.example.demo.securingweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.securing.service.CustomerUser;
import com.example.demo.securing.service.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
										HttpServletResponse response,
										Authentication auth) throws IOException, ServletException {
		
		//단건조회
		UserDTO dto = ((CustomerUser)auth.getPrincipal()).getUserDTO();
		//세션으로 값담아서 하기
		request.getSession().setAttribute("userid", dto.getId());
		request.getSession().setAttribute("deptName", dto.getDeptName());
		
		
		//로그인한 정보 다 받을수 있음 // 권한에 따라 원하는 페이지로 보낼수 있음
		List<String> roleNames = new ArrayList<>();
		
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		System.out.println("roleName:" + roleNames);
		
		if( roleNames.contains("ROLE_ADMIN") ) {
			response.sendRedirect("/emp/list");
			return;
		} else if ( roleNames.contains("ROLE_USER") ) {
			response.sendRedirect("/board/list");
			return;
		} else {
			response.sendRedirect("/main");
			return;
		}
		
	}

}
