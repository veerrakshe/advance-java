package com.Service;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.Config.HibernateUtil;
import com.Entity.AdhharBi;
import com.Entity.PersonBi;

public class PersonServiceIMPL implements PersonService {
	SessionFactory sf = HibernateUtil.getConnection();
	Scanner sc = new Scanner(System.in);
	Session s = sf.openSession();

	@Override
	public void addPersonWithAdhar() {
		System.out.println("Enter the number of persons to add :- ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			PersonBi p = new PersonBi();
			System.out.println("Enter the Name :- ");
			p.setpName(sc.nextLine());
			System.out.println("Enter the Address :- ");
			p.setpAddress(sc.nextLine());

			AdhharBi ad = new AdhharBi();

			System.out.println("Enter the Adhhar number :- ");
			ad.setaNumber(sc.nextLine());

			p.setAd(ad);
			ad.setP(p);
			Serializable id = s.save(p);
			s.beginTransaction().commit();

			System.out.println("ID no. " + id + "  " + "is Inserted");
		}

	}

	@Override
	public void getPersonOnly() {
		System.out.println("Enter the Id :- ");
		PersonBi p = s.get(PersonBi.class, sc.nextInt());

		if (p != null) {
			System.out.println("                        ");
			System.out.println("Person Name :- " + p.getpName() + "\n" + "Person Address :- " + p.getpAddress());
			System.out.println("                        ");
		} else {
			System.out.println("Id Does'nt Exist");
		}

	}

	@Override
	public void getAdharOnly() {
		System.out.println("Enter Adhhar Id :- ");
		AdhharBi a = s.get(AdhharBi.class, sc.nextInt());

		if (a != null) {
			System.out.println("    ");
			System.out.println("Adhhar Number = " + a.getaNumber());
			System.out.println("    ");
		} else {
			System.out.println("Invalid Adhhar Id");
		}

	}

	@Override
	public void updatePersonOnly() {
		System.out.println("Enter the ID to be Updated :- ");
		PersonBi p = s.get(PersonBi.class, sc.nextInt());
		sc.nextLine();

		boolean flag = true;
		do {

			if (p != null) {

				System.out.println("                       ");
				System.out.println(" ------------UPDATE BY----------");
				System.out.println("|   1. Name                     |");
				System.out.println("|   2. Address                  |");
				System.out.println("|   3. Adhaar Number            |");
				System.out.println("|   4. ALL Fields               |");
				System.out.println("|   5. Exit                     |");
				System.out.println(" ------------------------------- ");
				System.out.println("                       ");

				System.out.println("Enter Your Choice:- ");

				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter the Updated Name :- ");
					p.setpName(sc.nextLine());
					break;
				case 2:
					System.out.println("Enter the Update Address :- ");
					p.setpAddress(sc.nextLine());
					break;
				case 3:
					AdhharBi ad = p.getAd();
					System.out.println("Enter the Updated Adhhar Number :- ");
					ad.setaNumber(sc.nextLine());
//					ad.setP(p);
					p.setAd(ad);
					break;
				case 4:
					System.out.println("Enter the Updated Name :- ");
					p.setpName(sc.nextLine());
					System.out.println("Enter the Update Address :- ");
					p.setpAddress(sc.nextLine());
					AdhharBi ad1 = p.getAd();
					System.out.println("Enter the Updated Adhhar Number :- ");
					ad1.setaNumber(sc.nextLine());
//					ad1.setP(p);
					p.setAd(ad1);
					break;
				case 5:
					flag = false;
					s.saveOrUpdate(p);
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
				updatePersonOnly();
			}

		} while (flag);
	}

	@Override
	public void deletePersonOnly() {
		System.out.println("Enter the Id to be Deleted");
		PersonBi p = s.get(PersonBi.class, sc.nextInt());
		sc.nextLine();

		if (p != null) {
//			s.beginTransaction();
			AdhharBi ad = p.getAd();
			ad.setP(null);
			p.setAd(null);
			s.update(p);
			s.delete(p);
			s.beginTransaction().commit();
			System.out.println("Id Deleted");

		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void addPersonByAdhhar() {
		System.out.println("Enter the Adhhar ID :- ");
		AdhharBi ad = s.get(AdhharBi.class, sc.nextInt());
		sc.nextLine();

		if (ad != null) {
			PersonBi p = new PersonBi();

			System.out.println("Enter Name :- ");
			p.setpName(sc.nextLine());
			System.out.println("Enter Address:- ");
			p.setpAddress(sc.nextLine());

			ad.setP(p);
			p.setAd(ad);

			s.save(p);

			s.beginTransaction().commit();
			System.out.println("Person Added");

		}

	}

}
