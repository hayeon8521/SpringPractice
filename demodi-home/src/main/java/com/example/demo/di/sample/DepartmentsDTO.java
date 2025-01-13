package com.example.demo.di.sample;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentsDTO {
	String departmentId;
	String departmentName;
	String managerId;
	String locationId;
}
