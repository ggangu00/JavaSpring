package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.dto.DeptDTO;
import com.example.demo.insa.dto.DeptSearchDTO;

public interface DeptMapper {
	DeptDTO read(Long deptId);
	List<DeptDTO> getList(DeptSearchDTO searchDTO);
}
