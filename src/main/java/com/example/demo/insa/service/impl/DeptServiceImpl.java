package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.dto.DeptDTO;
import com.example.demo.insa.dto.DeptSearchDTO;
import com.example.demo.insa.mapper.DeptMapper;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;


@Service //서비스가 들어오면 무조건 선언해주기
@RequiredArgsConstructor //final 붙은것만 초기화
public class DeptServiceImpl implements DeptService{
		
	private final DeptMapper deptMapper;
	
	@Override
	public DeptDTO read(Long deptId) {
		return deptMapper.read(deptId);
	}

	@Override
	public List<DeptDTO> getList(DeptSearchDTO searchDTO) {
		return deptMapper.getList(searchDTO);
	}
}
