package com.example.demo.insa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor //Builder, All, No 세투세투
public class DeptDTO {
	private Long departmentId;	
	private String departmentName;
	private Long managerId;
}
