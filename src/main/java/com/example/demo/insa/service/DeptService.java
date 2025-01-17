package com.example.demo.insa.service;

import java.util.List;

import com.example.demo.insa.dto.DeptDTO;
import com.example.demo.insa.dto.DeptSearchDTO;

public interface DeptService {
	public DeptDTO read(Long deptId);

	public List<DeptDTO> getList(DeptSearchDTO searchDTO);
}
