package com.qsp.springboot_employee.service;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_employee.dao.EmployeeDao;
import com.qsp.springboot_employee.dto.Employee;
import com.qsp.springboot_employee.util.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
	ResponseStructure<List<Employee>> responseStructureList = new ResponseStructure<>();

	public ResponseStructure<Employee> saveEmployee(Employee employee) {
		

		if (employee.getSalary() > 0 && employee.getSalary() <= 10000) {
			employee.setGrade('D');

		} else if (employee.getSalary() > 10000 && employee.getSalary() <= 20000) {
			employee.setGrade('C');
		} else if (employee.getSalary() > 20000 && employee.getSalary() <= 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}
		responseStructure.setMessage("SAVED SUCCESSFULLY ");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));

		return responseStructure;
	}

	public ResponseStructure<Employee> getEmployee(int id) {
		if (employeeDao.getEmployee(id) != null) {

			responseStructure.setMessage("FETCHED SUCCESSFULLY");
			responseStructure.setData(employeeDao.getEmployee(id));
			responseStructure.setStatus(HttpStatus.OK.value());
		} else {
			responseStructure.setMessage("ID NOT FOUND");
			responseStructure.setData(employeeDao.getEmployee(id));
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return responseStructure;
	}

	public ResponseStructure<List<Employee>> getAllEmployee() {
		responseStructureList.setMessage("ALL EMPLOYEE FETCHED SUCCESSFULLY");
		responseStructureList.setStatus(HttpStatus.OK.value());
		responseStructureList.setData(employeeDao.getAllEmployee());
		return responseStructureList;
	}

	public ResponseStructure<Employee> deleteEmployee(int id) {
		if (employeeDao.getEmployee(id)!=null) {
			
			responseStructure.setMessage("DELETED SUCCESSFULLY");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(employeeDao.deleteEmployee(id));
			
		} else {
			responseStructure.setMessage("ID NOT FOUND");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(employeeDao.deleteEmployee(id));

		}
		return responseStructure;
	}

	public ResponseStructure<Employee> getEmployeeByEmail(String email) {
		responseStructure.setMessage("FETCHED EMPLOYEE BASED ON EMAIL");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.getEmployeeByEmail(email));
		return responseStructure;
	}

	public ResponseStructure<Employee> getEmployeeByPhone(long phone) {
		responseStructure.setMessage("FETCHED EMPLOYEE BASED ON PHONE");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.getEmployeeByPhone(phone));
		return responseStructure;
	}

	public ResponseStructure<Employee> updateeEmployee(int id, Employee employee) {

		if (employee.getSalary() > 0 && employee.getSalary() <= 10000) {
			employee.setGrade('D');

		} else if (employee.getSalary() > 10000 && employee.getSalary() <= 20000) {
			employee.setGrade('C');
		} else if (employee.getSalary() > 20000 && employee.getSalary() <= 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}

		responseStructure.setMessage("UPDATED SUCCESSFULLY");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.updateeEmployee(id, employee));
		return responseStructure;
	}

	public ResponseStructure<List<Employee>> findEmployeeBySalary(double salary) {
		
		responseStructureList.setMessage("ALL EMPLOYEE FETCHED SUCCESSFULLY");
		responseStructureList.setStatus(HttpStatus.OK.value());
		responseStructureList.setData(employeeDao.findEmployeeBySalary(salary));
		return responseStructureList;

	}

	public ResponseStructure<Employee> updateSalary(int id, double salary ) {
		
	
		responseStructure.setMessage("UPDATED BASED ON SALARY");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.updateSalary(id, salary));
		return responseStructure;
	}

}
