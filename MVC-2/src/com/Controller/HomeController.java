package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Model.Employee;
import com.Service.EmployeeService;

@Controller
public class HomeController {

	@Autowired
	private EmployeeService e;

	@RequestMapping("/log")
	public String getDetails(@RequestParam("uname") String un, @RequestParam("password") String ps, Model model) {
		System.out.println("Login Request");

		List<Employee> allEmp = e.getEmployeeDetails(un, ps);

		System.out.println(allEmp);

		if (allEmp != null) {
			System.out.println("Controller Layer");

			model.addAttribute("msg", allEmp);

			return "success";
		} else {

			return "error";
		}

	}

	@RequestMapping("/reg")
	public String getRegister(@ModelAttribute Employee emp, Model model) {

		System.out.println("Register Request!!!!  ");

		System.out.println(emp);

		e.insertEmploye(emp);

		return "signin";
	}
}
