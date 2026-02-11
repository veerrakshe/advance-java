package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {

	private int studentId;

	private String studentName;

	private List<String> listOfCourses = new ArrayList<>();

	private Set<Integer> listOfNumbers = new HashSet<>();

	private Map<String, Integer> listOfStudentMarks = new HashMap<String, Integer>();

//	public int getStudentId() {
//		return studentId;
//	}
//
//	public void setStudentId(int studentId) {
//		this.studentId = studentId;
//	}
//
//	public String getStudentName() {
//		return studentName;
//	}
//
//	public void setStudentName(String studentName) {
//		this.studentName = studentName;
//	}
//
//	public List<String> getListOfCourses() {
//		return listOfCourses;
//	}
//
//	public void setListOfCourses(List<String> listOfCourses) {
//		this.listOfCourses = listOfCourses;
//	}
//
//	public Set<Integer> getListOfNumbers() {
//		return listOfNumbers;
//	}
//
//	public void setListOfNumbers(Set<Integer> listOfNumbers) {
//		this.listOfNumbers = listOfNumbers;
//	}
//
//	public Map<String, Integer> getListOfStudentMarks() {
//		return listOfStudentMarks;
//	}
//
//	public void setListOfStudentMarks(Map<String, Integer> listOfStudentMarks) {
//		this.listOfStudentMarks = listOfStudentMarks;
//	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", listOfCourses=" + listOfCourses
				+ ", listOfNumbers=" + listOfNumbers + ", listOfStudentMarks=" + listOfStudentMarks + "]";
	}

	public Student(int studentId, String studentName, List<String> listOfCourses, Set<Integer> listOfNumbers,
			Map<String, Integer> listOfStudentMarks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.listOfCourses = listOfCourses;
		this.listOfNumbers = listOfNumbers;
		this.listOfStudentMarks = listOfStudentMarks;
	}

}
