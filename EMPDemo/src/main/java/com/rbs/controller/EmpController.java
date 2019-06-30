package com.rbs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbs.model.Employee;
import com.rbs.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	@Autowired
	EmployeeService employeeService;
	
		
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> emps = employeeService.findAll();
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	
	@GetMapping("/employees/name/{sortByName}")
	public ResponseEntity<List<Employee>> getAllEmployeeByName(@PathVariable("sortByName") String sortByName) {
		List<Employee> emps = employeeService.findByName(sortByName);
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	
	@GetMapping("/employees/salary/{sortBySalary}")
	public ResponseEntity<List<Employee>> getAllEmployeeBySalary(@PathVariable("sortBySalary") String sortBySalary) {
		Double salInDouble = Double.valueOf(sortBySalary);
		List<Employee> emps = employeeService.findBySalary(salInDouble);
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	
	@GetMapping("/employees/hiredate/{sortByHiredate}")
	public ResponseEntity<List<Employee>> getAllEmployeeBy(@PathVariable("sortByHiredate") String sortByHiredate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse(sortByHiredate);
		List<Employee> emps = employeeService.findByHiredate(date);
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") String id) {
		Long idLong = Long.valueOf(id);
		Employee emp = employeeService.findOne(idLong);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	
}
