package com.example.demo.insa.service;

import java.util.List;

import com.example.demo.insa.dto.DeptDTO;
import com.example.demo.insa.dto.EmployeesDTO;
import com.example.demo.insa.dto.EmployeesSearchDTO;
import com.example.demo.insa.dto.JobsDTO;

public interface EmployeesService {
	
	public void register(EmployeesDTO employees);
	public boolean modify(EmployeesDTO employee);	
	public boolean remove(Long employeeId);

	public EmployeesDTO get(Long employeeId);
	public List<EmployeesDTO> getList(EmployeesSearchDTO searchDTO);
	
	public int getCount(EmployeesSearchDTO searchDTO);
	public List<JobsDTO> getListByJob();
	public List<DeptDTO> getListByDept();
	
}
