package com.example.demo.insa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
