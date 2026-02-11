package com.Controller;

import java.util.Scanner;

import com.Service.EmployeeService;
import com.Service.EmployeeServiceImpl;

public class Controller {

	public static void main(String[] args) {

		EmployeeService e = new EmployeeServiceImpl();
		Scanner sc = new Scanner(System.in);

		boolean condition = true;

		while (condition) {
			System.out.println("1. Add Person With Company");
			System.out.println("2. Display Person");
			System.out.println("3. Update Person Details");
			System.out.println("4. Delete Person only");
			System.out.println("5. Exit");
			System.out.println("           ");
			System.out.println("           ");
			System.out.println("Enter Your Choice :- ");

			switch (sc.nextInt()) {
			case 1:
				e.addPersonWithCompany();
				break;
			case 2:
				e.displayPerson();
				break;
			case 3:
				e.upadtePerson();
				break;
			case 4:
				e.deletePersonOnly();
				break;
			case 5:
				condition = false;
				sc.close();
				break;

			default:
				System.out.println("Invalid Choice!!");
				break;
			}
		}
	}
}
