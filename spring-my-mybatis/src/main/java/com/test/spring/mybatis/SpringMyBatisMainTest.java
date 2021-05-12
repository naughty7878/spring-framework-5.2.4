package com.test.spring.mybatis;

import com.test.spring.mybatis.config.SpringMyBatisConfig;
import com.test.spring.mybatis.entity.Employee;
import com.test.spring.mybatis.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author h__d
 */
public class SpringMyBatisMainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SpringMyBatisConfig.class);

		EmployeeService employeeService = context.getBean(EmployeeService.class);

		Employee employee = employeeService.getEmployeeById(1);

		System.out.println(employee);

	}
}