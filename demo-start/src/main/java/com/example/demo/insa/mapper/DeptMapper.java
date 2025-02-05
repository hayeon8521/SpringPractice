package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptSearchDTO;

public interface DeptMapper {
	
	//단건조회
	DeptDTO read(Long departmentId);
	
	//전체조회
	List<DeptDTO> getList();

}
