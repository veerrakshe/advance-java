package com.Config;

import java.util.jar.Attributes.Name;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.Entity.Dept;
import com.Entity.Employee;

@Configuration
public class AppConfiguration {

	@Bean(name = "emp")
	@Scope(value = "singleton")
	public Employee employee() {

		Employee emp = new Employee();
		emp.setEid(101);
		emp.seteName("Vishu");

		return emp;

	}

	@Bean(name = "dept")
	@Scope(value = "prototype")
	public Dept department() {
		Dept d = new Dept();
		d.setDid(201);
		d.setdName("Dev");
		return d;

	}

}
