package com.HomeController;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Entity.Employee;

public class Controller {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session s = sf.openSession();

		Employee emp = new Employee();
		emp.setEid(104);
		emp.setEname("Ravi");
		emp.setEaddress("Akurdi");

		s.save(emp);
		s.beginTransaction().commit();
		System.out.println("Employee Save");

	}
}
