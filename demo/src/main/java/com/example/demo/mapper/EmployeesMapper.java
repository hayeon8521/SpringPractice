package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface EmployeesMapper {
	//전체조회
	List<EmployeesDto> findAll();
	//단건조회
	EmployeesDto findById(long id);
	//여러건 조회 (파라메터가 여러개이면 이름을 지정해줘야함)
	List<EmployeesDto> findBydeptAndName(@Param("departmentId") Long id,
												@Param("firstName") String name);
	//직업 조회
	List<DepartmentsDto> findAllDept();
}
