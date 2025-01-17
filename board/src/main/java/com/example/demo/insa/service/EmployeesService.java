package com.example.demo.insa.service;

import java.util.List;

import com.example.demo.insa.dto.EmployeesDTO;
import com.example.demo.insa.dto.EmployeesSearchDTO;
import com.example.demo.insa.dto.JobsDTO;

public interface EmployeesService {
	
	public void register(EmployeesDTO employees);

	public EmployeesDTO get(Long bno);

	public List<EmployeesDTO> getList(EmployeesSearchDTO searchDTO);
	public List<JobsDTO> getListByJob();
	
}
