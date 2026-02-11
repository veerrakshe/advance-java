package com.ServiceImpl;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Configuration.HibernateUtil;
import com.Model.User;
import com.Service.UserService;

public class UserServiceImpl implements UserService {
	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getConnection();
	Session s = sf.openSession();

	@Override
	public void addUser() {

		System.out.println("Enter number of ID's to insert :- ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			User u = new User();

			System.out.println("Enter the id:- ");
			u.setuId(sc.nextInt());
			sc.nextLine();

			System.out.println("Enter the name :- ");
			u.setuName(sc.nextLine());

			System.out.println("Enter the Salary :- ");
			u.setuSalary(sc.nextInt());
			sc.nextLine();

			System.out.println("Enter the Age :-");
			u.setuAge(sc.nextInt());
			sc.nextLine();

			Serializable id = s.save(u);
			s.beginTransaction().commit();

			System.out.println("ID no. " + id + "  " + "is Inserted");
		}

	}

	@Override
	public void displayUser() {
		System.out.println("Enter the Id to be Displayed :- ");
		User user = s.get(User.class, sc.nextInt());
		sc.nextLine();
		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("----------------");
			System.out.println("ID Does'nt Exist");
			System.out.println("----------------");
		}

	}

	@Override
	public void updateUser() {
		boolean flag = true;

		System.out.println("Enter The ID to be Updated:- ");
		User user = s.get(User.class, sc.nextInt());
		sc.nextLine();

		do {

			if (user != null) {

				System.out.println("                       ");
				System.out.println(" ------UPDATE BY------");
				System.out.println("|   1. Name           |");
				System.out.println("|   2. Salary         |");
				System.out.println("|   3. Age            |");
				System.out.println("|   4. ALL Fields     |");
				System.out.println("|   5. Exit           |");
				System.out.println(" --------------------- ");
				System.out.println("                       ");

				System.out.println("Enter Your Choice:- ");

				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter the Updated Name :- ");
					user.setuName(sc.nextLine());
					break;
				case 2:
					System.out.println("Enter the Update Salary :- ");
					user.setuSalary(sc.nextInt());
					sc.nextLine();
					break;
				case 3:
					System.out.println("Enter the Updated Age :- ");
					user.setuAge(sc.nextInt());
					sc.nextLine();
					break;
				case 4:
					System.out.println("Enter the Updated Name :- ");
					user.setuName(sc.nextLine());
					System.out.println("Enter the Update Salary :- ");
					user.setuSalary(sc.nextInt());
					sc.nextLine();
					System.out.println("Enter the Updated Age :- ");
					user.setuAge(sc.nextInt());
					sc.nextLine();
					break;
				case 5:
					flag = false;
					s.beginTransaction().commit();
					System.out.println("Updated Succesfully!!!");
					break;
				default:
					System.out.println("---------------------------");
					System.out.println("Enter Choice betweeen 1-5!!");
					System.out.println("---------------------------");
					break;
				}
			} else {
				System.out.println("------------------");
				System.out.println("USER DOES'nt EXIST");
				System.out.println("------------------");

				flag = false;
				updateUser();
			}

		} while (flag);

	}

	@Override
	public void deleteUser() {
		System.out.println("-----------------------------");
		System.out.println("Enter the ID to be Deleted:- ");
		User u = s.get(User.class, sc.nextInt());
		sc.nextLine();

		if (u != null) {
			s.delete(u);
			s.beginTransaction().commit();
			System.out.println("--------------------------");
			System.out.println("Id Deleted Succesfully!!!!");
			System.out.println("--------------------------");
		} else {
			System.out.println("----------");
			System.out.println("Invalid Id");
			System.out.println("----------");
		}

	}

}
