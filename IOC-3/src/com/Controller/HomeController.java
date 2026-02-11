package com.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Entity.Student;

public class HomeController {

	public static void main(String[] args) {

		ApplicationContext apc = new ClassPathXmlApplicationContext("beans.xml");

		Student st1 = apc.getBean("stu", Student.class);
		System.out.println(st1);

	}
}
