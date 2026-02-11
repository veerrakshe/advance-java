package com.Service;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Config.HibernateUtil;
import com.Entity.Company;
import com.Entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	SessionFactory sf = HibernateUtil.getConnection();
	Session s = sf.openSession();

	Scanner sc = new Scanner(System.in);

	@Override
	public void addPersonWithCompany() {

		Employee e = new Employee();
		System.out.println("Enter the Name Of Employee :-");
		e.seteName(sc.next());
		System.out.println("Enter the Age of Employee :- ");
		e.seteAge(sc.nextInt());
		System.out.println("Enter the employee Address :- ");
		e.seteAddress(sc.next());
		System.out.println("Enter the employee Salary :- ");
		e.seteSalary(sc.nextInt());
		System.out.println("Enter Role of Employee :- ");
		e.seteRole(sc.next());

		Company c = new Company();

		System.out.println("Enter Company Name :- ");
		c.setCmpName(sc.next());
		System.out.println("Enter Company Address :- ");
		c.setCmpAddress(sc.next());
		System.out.println("Enter Comapny Type :- ");
		c.setCmpType(sc.next());
		System.out.println("Enter Company Pincode :- ");
		c.setCmpPincode(sc.nextInt());

		e.setC(c);

		Serializable id = s.save(e);
		s.beginTransaction().commit();

		System.out.println("The Employee of Id :- " + id + " is saved. ");

	}

	@Override
	public void displayPerson() {
//		Employee e = new Employee();
		System.out.println("Enter the ID to be Displayed :- ");
		Employee emp = s.get(Employee.class, sc.nextInt());
		if (emp != null) {
			System.out.println(emp);
		} else {
			System.out.println("Invalid ID!!!!");
		}

	}

	@Override
	public void upadtePerson() {
		System.out.println("Enter the Id to be Updated :- ");
		Employee emp = s.get(Employee.class, sc.nextInt());
		boolean condition = true;
		if (emp != null) {
			while (condition) {
				System.out.println("1. Update Name");
				System.out.println("2. Update Age");
				System.out.println("3. Update Address");
				System.out.println("4. Update Salary");
				System.out.println("5. Update Role");
				System.out.println("6. Exit");
				System.out.println("Enter the Field to be Updated :- ");

				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter the New Name :- ");
					emp.seteName(sc.next());
					break;
				case 2:
					System.out.println("Enter the Update Age :- ");
					emp.seteAge(sc.nextInt());
					break;
				case 3:
					System.out.println("Enter the Updated Address :- ");
					emp.seteAddress(sc.next());
					break;
				case 4:
					System.out.println("Enter the Upadte Salary :- ");
					emp.seteSalary(sc.nextInt());
					break;
				case 5:
					System.out.println("Enter the Updated Role :- ");
					emp.seteRole(sc.next());
					break;
				case 6:
					System.out.println("Fields Updated Succesfully");
					s.update(emp);
					s.beginTransaction().commit();
					condition = false;
					break;

				default:
					System.out.println("Field Not Found!!!");
					break;
				}
			}
		} else {
			System.out.println("Id not Found!!");
		}

	}

	@Override
	public void deletePersonOnly() {
		System.out.println("Enter the Employee ID to be Deleted :- ");
		Employee e = s.get(Employee.class, sc.nextInt());
		if (e != null) {
			e.setC(null);
			s.delete(e);
			s.beginTransaction().commit();
			System.out.println("Employee Deleted Succesfully!!");
		} else {
			System.out.println("Invalid ID!!");
		}
	}

}
