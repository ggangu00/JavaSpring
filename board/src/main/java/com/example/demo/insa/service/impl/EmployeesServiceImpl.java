package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.dto.DeptDTO;
import com.example.demo.insa.dto.EmployeesDTO;
import com.example.demo.insa.dto.EmployeesSearchDTO;
import com.example.demo.insa.dto.JobsDTO;
import com.example.demo.insa.mapper.EmployeesMapper;
import com.example.demo.insa.service.EmployeesService;

import lombok.RequiredArgsConstructor;

@Service //서비스가 들어오면 무조건 선언해주기
@RequiredArgsConstructor //final 붙은것만 초기화
public class EmployeesServiceImpl implements EmployeesService{
	private final EmployeesMapper employeesMapper;
	
	@Override
	public void register(EmployeesDTO employees) {
		employeesMapper.insert(employees);		
	}
	
	@Override
	public boolean modify(EmployeesDTO employee) {
		return employeesMapper.update(employee) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long employeeId) {
		return employeesMapper.delete(employeeId) == 1 ? true : false;
	}
	
	@Override
	public EmployeesDTO get(Long employeeId) {
		return employeesMapper.read(employeeId);
	}

	@Override
	public List<EmployeesDTO> getList(EmployeesSearchDTO searchDTO) {
		return employeesMapper.getList(searchDTO);
	}

	@Override
	public List<JobsDTO> getListByJob() {
		return employeesMapper.getListByJob();
	}
	
	@Override
	public int getCount(EmployeesSearchDTO searchDTO) {
		return employeesMapper.getCount(searchDTO);
	}

	@Override
	public List<DeptDTO> getListByDept() {
		return employeesMapper.getListByDept();
	}
}
