package com.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Entity.Student;

public class Controller {

	public static void main(String[] args) {

		ApplicationContext apc = new ClassPathXmlApplicationContext("beans.xml");

		Student st1 = apc.getBean("stu", Student.class);
		st1.setRollno(5555);
		System.out.println(st1);
		Student st2 = apc.getBean("stu", Student.class);
		System.out.println(st2.hashCode());

	}
}
