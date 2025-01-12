package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmployeesMapper {
	// 전체 조회
	List<EmployeesDto> findAll();
	// 단건 조회
	EmployeesDto findById(long employeeId);
	// 여러조건 검색
	List<EmployeesDto> findByDeptAndName( 
			@Param("departmentId") Long id, @Param("firstName") String name);
}
