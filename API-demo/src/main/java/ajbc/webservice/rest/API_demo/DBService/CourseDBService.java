package ajbc.webservice.rest.API_demo.DBService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ajbc.webservice.rest.API_demo.demoDB.MyDB;
import ajbc.webservice.rest.API_demo.models.Course;
import ajbc.webservice.rest.API_demo.models.Student;

public class CourseDBService {

	private MyDB db;
	private Map<Long, Course> courses;
	
	
	
	public CourseDBService() {
		super();
		db = MyDB.getInstance();
		courses = db.getCourses();
	}



	// return the all students from the list
	
	public List<Course> getAllCourses(){
		return new ArrayList<Course>(courses.values());
	}
	
	//return student by id
	
	public Course getCourseByNumber(long number) {
		return courses.get(number);
	}
	
	//add student to DB
	
	public Course addCourse(Course course) {
		courses.put(course.getNumber(), course);
		return course;
	}
	
	//update student to DB
	
		public Course updateCourse(long number,Course course) {
			if(courses.containsKey(number)) {
				Course currCourse = courses.get(number); 
				currCourse.setName(course.getName());
				currCourse.setStudents(course.getStudents());
				
				courses.put(number, currCourse);
				return currCourse;
			}
			

			return null;
		}
		
		//delete a student from DB
		
		public Course deleteCourse(long number) {
			return courses.remove(number);
		}
}
