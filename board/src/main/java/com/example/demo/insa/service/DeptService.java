package com.example.demo.insa.service;

import java.util.List;

public interface DeptService {
	public DeptDTO read(Long deptId);

	public List<DeptDTO> getList(DeptSearchDTO searchDTO);
}
