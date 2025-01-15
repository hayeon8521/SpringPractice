package com.example.demo.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpDTO;
import com.example.demo.emp.service.EmpSearchDTO;
import com.example.demo.emp.service.EmpService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	
	private final EmpMapper empMapper;
	
	@Override
	public void register(EmpDTO empDTO) {
		empMapper.insert(empDTO);
	}

	@Override
	public EmpDTO get(Long employeeId) {
		return empMapper.read(employeeId);
	}

	@Override
	public boolean modify(EmpDTO empDTO) {
		return empMapper.update(empDTO) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long employeeId) {
		return empMapper.delete(employeeId) == 1 ? true : false;
	}

	@Override
	public List<EmpDTO> getList(EmpSearchDTO searchDTO) {
		return empMapper.getList(searchDTO);
	}

	@Override
	public int getCount(EmpSearchDTO searchDTO) {
		return empMapper.getCount(searchDTO);
	}
	
}
