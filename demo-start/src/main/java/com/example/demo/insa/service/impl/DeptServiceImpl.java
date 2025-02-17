package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.DeptMapper;
import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptSearchDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor 
public class DeptServiceImpl implements DeptService{

	private final DeptMapper deptMapper;
	
	@Override
	public DeptDTO get(Long departmentId) {
		return deptMapper.read(departmentId);
	}

	@Override
	public List<DeptDTO> getList() {
		return deptMapper.getList();
	}

}
