package com.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Config.HibernateUtil;
import com.Entity.Employee;

public class Main {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();

		//		emp.setEid(103);
		Employee e = s.get(Employee.class, 101);
		e.setEname("aditya");
		System.out.println(e);

		s.beginTransaction().commit();

		Employee e1 = s.get(Employee.class, 101);
		e.setEname("aditya");
		System.out.println(e1);

//		s.save(emp);

		System.out.println("Data Saved!!!");
	}

}
