package com.example.demo.insa.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class EmployeesDTO {	
	private Long employeeId;
	private Long departmentId;
	
	@NotBlank(message = "이름을 입력해주세요")
	private String firstName;
	
	@NotBlank(message = "성을 입력해주세요")
	private String lastName;
	
	@NotBlank(message = "이메일을 입력해주세요")
	private String email;
	
	private String hireDate;
	private String jobId;
}
