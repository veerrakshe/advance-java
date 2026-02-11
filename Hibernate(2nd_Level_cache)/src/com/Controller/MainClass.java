package com.Controller;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Config.HibernateUtil;
import com.Entity.Student;

public class MainClass {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();

////		Student S = new Student();
////		S.setSname("Aditya");
////		S.setSaddress("Pune");
//
//		s.save(S);
		s.beginTransaction().commit();

		Student stu = s.get(Student.class, 1);
		System.out.println(stu);

		Student stu1 = s.get(Student.class, 1);
		System.out.println(stu1);

		stu.setSname("VEER");
		System.out.println(stu);

		Cache c = sf.getCache();
		c.evict(Student.class, stu);

		System.out.println("Data Saved");
	}

}
