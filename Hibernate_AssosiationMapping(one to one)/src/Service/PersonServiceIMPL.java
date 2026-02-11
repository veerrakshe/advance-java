package Service;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Config.HibernateUtil;
import com.Entity.Adhhar;
import com.Entity.Person;

public class PersonServiceIMPL implements PersonService {
	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getConnection();
	Session s = sf.openSession();

	@Override
	public void addPersonWithAdhar() {
		System.out.println("Enter number of ID's to insert :- ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			Person p = new Person();
			Adhhar a = new Adhhar();

			System.out.println("Enter the Name :- ");
			p.setpName(sc.nextLine());

			System.out.println("Enter the Address :- ");
			p.setpAddress(sc.nextLine());

			System.out.println("Enter the Adhhar Number :- ");
			a.setaNumber(sc.nextLine());

			p.setAd(a);

			Serializable id = s.save(p);
			s.beginTransaction().commit();

			System.out.println("ID no. " + id + "  " + "is Inserted");
		}
	}

	@Override
	public void getPersonOnly() {
		System.out.println("Enter the Person Id :-");
		Person p = s.get(Person.class, sc.nextInt());
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
		System.out.println("Enter the Adhhar Id :- ");
		Adhhar a = s.get(Adhhar.class, sc.nextInt());
		System.out.println("    ");
		System.out.println("Adhhar Number :- " + a.getaNumber());
		System.out.println("    ");

	}

	@Override
	public void update() {
		boolean flag = true;

		System.out.println("Enter The ID to be Updated:- ");
		Person p = s.get(Person.class, sc.nextInt());
		sc.nextLine();

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
					Adhhar ad = new Adhhar();
					System.out.println("Enter the Updated Adhhar Number :- ");
					ad.setaNumber(sc.nextLine());
					p.setAd(ad);
					break;
				case 4:
					System.out.println("Enter the Updated Name :- ");
					p.setpName(sc.nextLine());
					System.out.println("Enter the Update Address :- ");
					p.setpAddress(sc.nextLine());
					Adhhar ad1 = new Adhhar();
					System.out.println("Enter the Updated Adhhar Number :- ");
					ad1.setaNumber(sc.nextLine());
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
				update();
			}

		} while (flag);
	}

	@Override
	public void deletePersonOnly() {
		System.out.println("Enter the ID to be Deleted :- ");
		Person p = s.get(Person.class, sc.nextInt());
		if (p != null) {
			s.beginTransaction();
			p.setAd(null); // unlink Adhhar

			s.delete(p); // now delete Person only
			s.getTransaction().commit();

			System.out.println("Person Deleted Succesfully!!!");
		} else {
			System.out.println("Invalid Id!!");
		}

	}

	@Override
	public void addPersonByAdhhar() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Adhhar Id :- ");
		Adhhar a = s.get(Adhhar.class, sc.nextInt());
		sc.nextLine();
		if (a != null) {

			Person p = new Person();
			System.out.println("Enter the Name :- ");
			p.setpName(sc.nextLine());

			System.out.println("Enter the Address :- ");
			p.setpAddress(sc.nextLine());

			p.setAd(a);

			s.beginTransaction();

			s.save(p);
			s.getTransaction().commit();

			System.out.println("Person added and linked to Aadhaar ID " + a.getaId());

		} else {
			System.out.println("Invalid Adhhar Id ");
		}

	}

}
