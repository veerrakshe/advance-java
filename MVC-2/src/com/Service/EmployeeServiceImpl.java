package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.DaoService;
import com.Model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private DaoService ds;

	@Override
	public List<Employee> getEmployeeDetails(String un, String ps) {

		ds.getEmployeeDetails(un, ps);

		if (un.equals("admin") && ps.equals("admin123")) {
			List<Employee> allEmp = ds.getEmployeeDetails(un, ps);
			System.out.println("Service Layer!!");
			System.out.println(allEmp);
			return allEmp;
		} else {
			return null;
		}
	}

	@Override
	public void insertEmploye(Employee emp) {

		System.out.println("employee in service");
		// TODO Auto-generated method stub

		ds.insertEmployee(emp);
		System.out.println("Service :: Layer");

	}

}
