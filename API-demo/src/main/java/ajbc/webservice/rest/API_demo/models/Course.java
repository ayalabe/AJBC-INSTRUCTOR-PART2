package ajbc.webservice.rest.API_demo.models;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private final long number;
	private String name;
	List<Student> students;
	private static long counter = 10;
	
	public Course() {
		this.number = generateNumber();
	}
	private synchronized long generateNumber() {
		return counter++;
	}
	
	
	
	public Course(String name) {
		this.number = generateNumber();
		this.students = new ArrayList<Student>();
		setName(name);
		setStudents(students);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public long getNumber() {
		return number;
	}
	
	
}
