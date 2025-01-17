package com.example.demo.emp.service;

import java.util.List;

public interface EmpService {
	//등록
		public void register(EmpDTO empDTO);
		//단건 조회
		public EmpDTO get(Long employeeId);
		//수정
		public boolean modify(EmpDTO empDTO);
		//삭제
		public boolean remove(Long employeeId);
		//여러건 조회
		public List<EmpDTO> getList(EmpSearchDTO searchDTO);
		//카운터
		public int getCount(EmpSearchDTO searchDTO);
		
		public List<JobsDTO> yourJob();
}
