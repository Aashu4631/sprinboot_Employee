package com.qsp.springboot_employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_employee.dao.EmployeeDao;
import com.qsp.springboot_employee.dto.Employee;
import com.qsp.springboot_employee.service.EmployeeService;
import com.qsp.springboot_employee.util.ResponseStructure;

import java.util.List;

@RestController
public class MainController {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);

	}

	@GetMapping("/fetch")
	public ResponseStructure<Employee> getEmployee(@RequestParam int id) {
		return employeeService.getEmployee(id);
	}

	@GetMapping("fetchAll")
	public ResponseStructure<List<Employee>> getAllEmployee() {

		return employeeService.getAllEmployee();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseStructure<Employee> deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);

	}

	@PutMapping("/update/{id}")
	public ResponseStructure<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {

		return employeeService.updateeEmployee(id, employee);
	}

	@PatchMapping("/updatesalary")
	public ResponseStructure<Employee> updateSalary(@RequestParam int id, @RequestParam double salary ) {
		return employeeService.updateSalary(id, salary );
	}

	@GetMapping("/fetchemail")
	public ResponseStructure<Employee> getEmployeeByEmail(@RequestParam String email) {

		return employeeService.getEmployeeByEmail(email);
	}

	@GetMapping("/fetchphone/{phone}")
	public ResponseStructure<Employee> getEmployeeByPhone(@PathVariable long phone) {
		return employeeService.getEmployeeByPhone(phone);
	}

	@GetMapping("/findbysalary")
	public ResponseStructure<List<Employee>> findEmployeeBySalary(@RequestParam double salary) {

		return employeeService.findEmployeeBySalary(salary);

	}
}
