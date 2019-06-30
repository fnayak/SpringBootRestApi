package com.rbs.service;

import java.util.Date;
import java.util.List;

import com.rbs.model.Employee;

public interface EmployeeService {
	
    public List<Employee> findAll();
    public List<Employee> findByName(String name);
    public List<Employee> findBySalary(Double salary);
    public List<Employee> findByHiredate(Date hiredate);
    public Employee findOne(Long id) ;

}
