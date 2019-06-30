package com.rbs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbs.model.Employee;
import com.rbs.repo.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	List<Employee> emps = new ArrayList<>();
	

	@Override
	public List<Employee> findAll() {
		emps = (List<Employee>)employeeRepository.findAll();
		return emps;
	}

	@Override
	public List<Employee> findByName(String name) {
		emps = employeeRepository.findByName(name);
		return emps;
	}

	@Override
	public List<Employee> findBySalary(Double salary) {
		emps = employeeRepository.findBySalary(salary);
		return emps;
	}

	@Override
	public List<Employee> findByHiredate(Date hiredate) {
		emps = employeeRepository.findByHiredate(hiredate);
		return emps;
	}

	@Override
	public Employee findOne(Long id) {
		Employee emp = employeeRepository.findOne(id);
		return emp;
	}

}
