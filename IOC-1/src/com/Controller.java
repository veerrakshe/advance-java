package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Controller {

	public static void main(String[] args) {

//		Resource resource = new ClassPathResource("beans.xml");
//
//		BeanFactory bf = new XmlBeanFactory(resource);
//
//		Student st = bf.getBean("stu", Student.class);

		System.out.println("-----------------------------------------------");

		ApplicationContext apc = new ClassPathXmlApplicationContext("beans.xml");
		Student st = apc.getBean("stu", Student.class);

	}
}
