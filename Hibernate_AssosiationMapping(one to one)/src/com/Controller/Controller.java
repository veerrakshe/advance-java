package com.Controller;

import java.util.Scanner;

import Service.PersonService;
import Service.PersonServiceIMPL;

public class Controller {

	public static void main(String[] args) {
		PersonService p = new PersonServiceIMPL();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		do {
			System.out.println(" ---------------------------------------");
			System.out.println(" -----------------MENU------------------");
			System.out.println(" ---------------------------------------");
			System.out.println("|   1. Add Person With Adhhar           |");
			System.out.println("|   2. Get Person Details               |");
			System.out.println("|   3. Get Adhhar Details               |");
			System.out.println("|   4. UPDATE                           |");
			System.out.println("|   5. Delete Person Only               |");
			System.out.println("|   6. Add By Adhhar                    |");
			System.out.println("|   7. EXIT                             |");
			System.out.println(" --------------------------------------- ");
			System.out.println("                                         ");
			System.out.println("Enter Your Choice:-");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				p.addPersonWithAdhar();
				break;
			case 2:
				p.getPersonOnly();
				break;
			case 3:
				p.getAdharOnly();
				break;
			case 4:
				p.update();
				break;
			case 5:
				p.deletePersonOnly();
				break;
			case 6:
				p.addPersonByAdhhar();
				break;
			case 7:
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
