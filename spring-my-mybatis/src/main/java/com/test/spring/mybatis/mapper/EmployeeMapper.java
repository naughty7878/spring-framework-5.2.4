package com.test.spring.mybatis.mapper;

import com.test.spring.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    
    public Employee getEmployeeById(@Param("id") Integer id);

}