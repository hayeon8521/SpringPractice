package com.example.demo.emp.service;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
	private Long employeeId;
	@NotBlank(message = "성을 입력 해주세요")
	private String firstName;
	@NotBlank(message = "이름을 입력 해주세요")
	private String lastName;
	@NotBlank(message = "메일을 입력 해주세요")
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private Long salary;
	private Double commissionPct;
	private String managerId;
	private String departmentId;
}
