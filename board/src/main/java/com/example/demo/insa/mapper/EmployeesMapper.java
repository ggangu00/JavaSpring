package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.dto.EmployeesDTO;
import com.example.demo.insa.dto.EmployeesSearchDTO;
import com.example.demo.insa.dto.JobsDTO;

public interface EmployeesMapper {

	int insert(EmployeesDTO employeesDTO);
	int update(EmployeesDTO employeesDTO);
	int delete(Long employeeId);
	EmployeesDTO read(Long employeeId);	
	List<EmployeesDTO> getList(EmployeesSearchDTO searchDTO);	
	int getCount(EmployeesSearchDTO searchDTO);
	List<JobsDTO> getListByJob();	
}
