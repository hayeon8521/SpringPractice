package com.example.demo.emp.service;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobsDTO {
	
	private String jobId;
	private String jobTitle;
	private String minSalary;
	private String maxSalary;
}
