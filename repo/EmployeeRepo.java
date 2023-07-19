package com.qsp.springboot_employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.springboot_employee.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String email);

	@Query("select e from Employee e where e.phone=?1")
	Employee employeeByPhone(long phone);

	List<Employee> findBySalaryGreaterThan(double salary);
	
	

}