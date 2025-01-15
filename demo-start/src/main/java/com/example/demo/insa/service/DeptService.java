package com.example.demo.insa.service;

import java.util.List;

public interface DeptService {
	//단건 조회
	public DeptDTO get(Long departmentId);
	//여러건 조회
	public List<DeptDTO> getList(DeptSearchDTO searchDTO);

}
