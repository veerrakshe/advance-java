package com.Controller;

import com.Service.StudentService;
import com.Service.StudentServiceImpl;

public class Controller {

	public static void main(String[] args) {
		StudentService s = new StudentServiceImpl();

//		s.addStudentWithSubject();
//		s.displaySubjects();
//		s.displayStudent();
//		s.updateSubjectUsingStudentID();
//		s.updateStudentUsingStudentID();
//		s.deleteSubjectOnlyUsingStudentID();
		s.deleteStudentOnlyUsingStudentID();
	}

}
