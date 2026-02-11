package com.Controller;

import java.util.Scanner;

import com.Service.UserService;
import com.ServiceImpl.UserServiceImpl;

public class Controller {

	public static void main(String[] args) {
		UserService us = new UserServiceImpl();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		do {
			System.out.println(" -------------------------");
			System.out.println(" ----------MENU-----------");
			System.out.println(" -------------------------");
			System.out.println("|   1. Add USER           |");
			System.out.println("|   2. Display USER       |");
			System.out.println("|   3. Update USER        |");
			System.out.println("|   4. Delete USER        |");
			System.out.println("|   5. EXIT               |");
			System.out.println(" ------------------------- ");
			System.out.println("                           ");
			System.out.println("Enter Your Choice:-");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				us.addUser();
				break;
			case 2:
				us.displayUser();
				break;
			case 3:
				us.updateUser();
				break;
			case 4:
				us.deleteUser();
				break;
			case 5:
				flag = false;
				sc.close();
				break;

			default:
				System.out.println("Enter Choice Between 1-5");
				break;
			}

		} while (flag);

	}

}
