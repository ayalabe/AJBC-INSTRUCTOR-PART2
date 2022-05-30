package ajbc.webservice.rest.API_demo.DBService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ajbc.webservice.rest.API_demo.demoDB.MyDB;
import ajbc.webservice.rest.API_demo.models.Student;

public class StudentDBService {

	private MyDB db;
	private Map<Long, Student> students;
	
	
	
	public StudentDBService() {
		super();
		db = MyDB.getInstance();
		students = db.getStudents();
	}



	// return the all students from the list
	
	public List<Student> getAllStudents(){
		return new ArrayList<Student>(students.values());
	}
	
	//return student by id
	
	public Student getStudentById(long id) {
		return students.get(id);
	}
	
	//add student to DB
	
	public Student addStudent(Student student) {
		students.put(student.getID(), student);
		return student;
	}
	
	//update student to DB
	
		public Student updateStudent(long id,Student student) {
			if(students.containsKey(id)) {
				Student currStudent = students.get(id); 
				currStudent.setAverage(student.getAverage());
				currStudent.setFirstName(student.getFirstName());
				currStudent.setLastName(student.getLastName());
				
				students.put(id, currStudent);
				return currStudent;
			}
			

			return null;
		}
		
		//delete a student from DB
		
		public Student deleteStudent(long id) {
			return students.remove(id);
		}
}
