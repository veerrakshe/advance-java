package com.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Config.HibernateUtil;
import com.Model.Student;
import com.Model.Subject;

public class StudentServiceImpl implements StudentService {

	SessionFactory sf = HibernateUtil.getConnection();
	Session s = sf.openSession();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentWithSubject() {

		Student st = new Student();

		System.out.println("Enter the Name of Student :- ");
		st.setsName(sc.next());
		List<Subject> ls = new ArrayList<Subject>();
		System.out.println("Enter the number of Subjects to be entered :- ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Subject sub = new Subject();
			System.out.println("Enter the name of Subject :- ");
			sub.setSubName(sc.next());

			ls.add(sub);
		}
		st.setListOfSubject(ls);
		Serializable id = s.save(st);
		s.beginTransaction().commit();
		System.out.println("Id number " + id + " is inserted. ");
	}

	@Override
	public void displaySubjects() {
		System.out.println("Enter the Student Id :- ");
		Student st = s.get(Student.class, sc.nextInt());

		if (st != null) {
			List<Subject> listOfSubject = st.getListOfSubject();
			for (Subject subject : listOfSubject) {
				System.out.println(subject.getsID() + " " + subject.getSubName());
			}
		} else {
			System.out.println("Invalid Subject Id :- ");
		}

	}

	@Override
	public void displayStudent() {
		System.out.println("Enter the Student Id:- ");
		Student st = s.get(Student.class, sc.nextInt());
		if (st != null) {
			System.out.println(st.getsId() + " " + st.getsName());
		} else {
			System.out.println("Invalid Student ID!!");
		}
	}

	@Override
	public void updateSubjectUsingStudentID() {
		System.out.println("Enter the Student ID :- ");
		Student st = s.get(Student.class, sc.nextInt());
		if (st != null) {
			List<Subject> listOfSubject = st.getListOfSubject();
			System.out.println("Enter the Subject Id to be Updated :- ");
			int id = sc.nextInt();
			for (Subject subject : listOfSubject) {
				if (subject != null && subject.getsID() == id) {
					System.out.println("Enter the new subject name :- ");
					subject.setSubName(sc.next());

					s.update(subject);
					s.beginTransaction().commit();
					System.out.println("Subject Updated!!!!!");
					break;
				}
			}
		}
	}

	@Override
	public void updateStudentUsingStudentID() {
		System.out.println("Enter the Student Id to be Updated :- ");
		Student stu = s.get(Student.class, sc.nextInt());

		if (stu != null) {
			System.out.println("Enter the Updated Name :- ");
			{
				stu.setsName(sc.next());
				s.save(stu);
				s.beginTransaction().commit();
				System.out.println("Student Updated Succesfully!!");
			}
		}

	}

	@Override
	public void deleteStudentOnlyUsingStudentID() {
		System.out.println("Enter the Student Id to be Deleted :- ");
		Student stu = s.get(Student.class, sc.nextInt());
		if (stu != null) {
			stu.setListOfSubject(null);
			s.delete(stu);
			s.beginTransaction().commit();
			System.out.println("Student Deleted Succesfully !!");
		}

	}

	@Override
	public void deleteSubjectOnlyUsingStudentID() {
		System.out.println("Enter the Student ID :- ");
		Student stu = s.get(Student.class, sc.nextInt());
		Subject subToDelete = null;
		if (stu != null) {
			System.out.println("Enter the Subject ID :- ");
			int id = sc.nextInt();
			List<Subject> ls = stu.getListOfSubject();
			for (Subject sub : ls) {
				if (sub != null && sub.getsID() == id) {
					subToDelete = sub;
					break;
				}
			}
			if (subToDelete != null) {
				ls.remove(subToDelete);
				s.delete(subToDelete);
				s.beginTransaction().commit();
				System.out.println("Subject Deleted Succesfully!!");
			}
		}

	}

}
