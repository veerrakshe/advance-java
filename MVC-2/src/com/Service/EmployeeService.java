package com.Service;

import java.util.List;

import com.Model.Employee;

public interface EmployeeService {

	public List<Employee> getEmployeeDetails(String un, String ps);
	
	public void insertEmploye(Employee emp);

}
