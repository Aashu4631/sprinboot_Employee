package com.qsp.springboot_employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_employee.dto.Employee;
import com.qsp.springboot_employee.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee)

	{

		return employeeRepo.save(employee);
	}

	public Employee getEmployee(int id) {

		Optional<Employee> optional = employeeRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}

	public List<Employee> getAllEmployee() {

		return employeeRepo.findAll();
	}

	public Employee deleteEmployee(int id) {

		Optional<Employee> optional = employeeRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		employeeRepo.deleteById(id);
		return optional.get();

	}

	public Employee updateeEmployee(int id, Employee employee) {
		Optional<Employee> optional = employeeRepo.findById(id);

		if (optional.isPresent()) {
			Employee employee2 = optional.get();
			employee.setId(id);
			return employeeRepo.save(employee);

		}
		return null;

	}

	public Employee updateSalary(int id, double salary) {
		Optional<Employee> optional = employeeRepo.findById(id);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			employee.setSalary(salary);
			return employeeRepo.save(employee);

		}
		return null;

	}

	public Employee getEmployeeByEmail(String email) {

		return employeeRepo.findByEmail(email);
	}

	public Employee getEmployeeByPhone(long phone) {

		return employeeRepo.employeeByPhone(phone);
	}

	public List<Employee> findEmployeeBySalary(double salary) {

		return employeeRepo.findBySalaryGreaterThan(salary);
	}
}
