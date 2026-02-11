package com.Controller;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Configuration.HibernateUtil;
import com.Entity.Student;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getConnection();

		Session s = sf.openSession();
		Session s1 = sf.getCurrentSession();
		Session s2 = sf.getCurrentSession();
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

		// java application => Data Table (Record)

//		   Transient -> save -> Persist -> Detached

		Student st = new Student();
		st.setSid(1);
		st.setSname("Veer");
		st.setSaddress("Pune");

//		Serializable id = s.save(st);
//		System.out.println(id);

		s.persist(st);
//		s.update(st);
//		s.delete(st);

//		s.saveOrUpdate(st);
//		
		Student student = s.get(Student.class, 1005);
		System.out.println(student);

		Student st1 = s.load(Student.class, 1005);
		System.out.println(st1);

//		s1.beginTransaction().commit();
//		System.out.println("saved");

	}
}
