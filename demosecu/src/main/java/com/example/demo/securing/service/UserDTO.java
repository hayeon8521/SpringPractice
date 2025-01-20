package com.example.demo.securing.service;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
	private Long id;
	private String loginId;
	private String password;
	private String fullName;
	private String deptName;
	
	//쿼리한번에 권한도 가지고 오고싶은거
	private List<RoleDTO> roles;
	
}
