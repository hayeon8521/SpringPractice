package com.example.demo.securing.mapper;

import java.util.List;

import com.example.demo.securing.service.RoleDTO;
import com.example.demo.securing.service.UserDTO;

public interface UserMapper {
	//단건조회
	public UserDTO getUser(String userId);
	//권한조회
	public List<RoleDTO> getRole(Long id);
}
