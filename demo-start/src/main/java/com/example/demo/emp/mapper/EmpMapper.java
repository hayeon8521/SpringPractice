package com.example.demo.emp.mapper;

import java.util.List;

import com.example.demo.emp.service.EmpDTO;
import com.example.demo.emp.service.EmpSearchDTO;
import com.example.demo.emp.service.JobsDTO;

public interface EmpMapper {
	
	//삽입 (건수를 받아와야해서)
		int insert(EmpDTO empDTO);
		
		//업데이트
		int update(EmpDTO empDTO);
		
		//삭제
		int delete(Long employeeId);
		
		//단건조회
		EmpDTO read(Long employeeId);
		
		//전체조회
		List<EmpDTO> getList(EmpSearchDTO searchDTO);
		
		//카운터
		int getCount(EmpSearchDTO searchDTO);
		
		//직업 가져오기
		public List<JobsDTO> yourJob();

}
