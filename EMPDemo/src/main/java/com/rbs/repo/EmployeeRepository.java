package com.rbs.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rbs.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long>{
	
	public Page<Employee> findAll(Pageable pageable);
    public List<Employee> findByName(String name);
    public List<Employee> findBySalary(Double salary);
    public List<Employee> findByHiredate(Date hiredate);
    public Employee findOne(Long id);

}
