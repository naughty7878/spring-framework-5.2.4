package com.test.spring.mybatis.service.impl;

import com.test.spring.mybatis.entity.Employee;
import com.test.spring.mybatis.mapper.EmployeeMapper;
import com.test.spring.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	@Transactional
	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeMapper.getEmployeeById(id);
	}
}
