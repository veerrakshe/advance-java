package com.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Model.Employee;

@Repository
public class DaoServieImpl implements DaoService {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Employee> getEmployeeDetails(String un, String ps) {

		Session s = sf.openSession();
		Query query = s.createQuery("from Employee");

		List<Employee> allEmp = query.getResultList();

		System.out.println(allEmp);
		return allEmp;
	}

	@Override
	public void insertEmployee(Employee emp) {
		System.out.println("in dao");
		System.out.println(emp);
		Session s = sf.openSession();

		s.save(emp);
		s.beginTransaction().commit();
		System.out.println("Employee Data Saved!!!!!!");
	}

}
