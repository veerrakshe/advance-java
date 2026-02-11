package com.DAO;

import java.util.List;

import com.Model.Employee;

public interface DaoService {

	public List<Employee> getEmployeeDetails(String un, String ps);

	public void insertEmployee(Employee emp);
}
