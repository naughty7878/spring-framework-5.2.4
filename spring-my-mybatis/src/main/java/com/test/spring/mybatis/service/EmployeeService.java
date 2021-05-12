package com.test.spring.mybatis.service;

import com.test.spring.mybatis.entity.Employee;
import com.test.spring.mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface EmployeeService {


	@Transactional
	Employee getEmployeeById(Integer id);
}
