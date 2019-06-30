package com.rbs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rbs.model.Employee;
import com.rbs.repo.EmployeeRepository;

@SpringBootApplication
public class EmpDemoApplication  implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository empRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmpDemoApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		empRepository.save(new Employee("fakir",15000.00, new Date()));
		empRepository.save(new Employee("fakir",25000.00,new Date()));
		empRepository.save(new Employee("nayak",15000.00,new Date()));
		
		
		System.out.println("\nfindByName");
		empRepository.findByName("fakir").forEach(x -> System.out.println(x));
		
		System.out.println("\nfindBySalary");
		empRepository.findBySalary(25000.00).forEach(x -> System.out.println(x));
		
		System.out.println("\nfindByHiredate");
		/*String dateStr = "30-06-2019";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse(dateStr);*/
		Date date = new Date();
		empRepository.findByHiredate(date).forEach(x -> System.out.println(x));
		
		System.out.println("\nfindById");
		Employee emp = empRepository.findOne(1L);
		System.out.println(emp.toString());
		
	}
}
