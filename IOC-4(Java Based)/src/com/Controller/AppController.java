package com.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Entity.Employee;
import com.Config.*;

public class AppController {

	public static void main(String[] args) {

		ApplicationContext acp = new AnnotationConfigApplicationContext(AppConfiguration.class);
		Employee bean = acp.getBean("emp", Employee.class);
		System.out.println(bean);
	}

}
