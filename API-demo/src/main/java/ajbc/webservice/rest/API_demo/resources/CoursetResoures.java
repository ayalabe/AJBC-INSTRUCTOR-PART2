package ajbc.webservice.rest.API_demo.resources;

import java.util.List;

import ajbc.webservice.rest.API_demo.DBService.CourseDBService;
import ajbc.webservice.rest.API_demo.DBService.StudentDBService;
import ajbc.webservice.rest.API_demo.models.Course;
import ajbc.webservice.rest.API_demo.models.Student;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("courses")
public class CoursetResoures {
	
	CourseDBService coursesDB = new CourseDBService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses() {
		return coursesDB.getAllCourses();
	}
	
	@GET
	@Path("/{number}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourseByNumber(@PathParam("number") long number) {
		return coursesDB.getCourseByNumber(number);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Course addCourse(Course course) {
		return coursesDB.addCourse(course);
	}
	
	@PUT
	@Path("/{number}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Course updateCourse(@PathParam("number") long number, Course course) {
		return coursesDB.updateCourse(number, course);
	}
	
	@DELETE
	@Path("/{number}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course deleteCourse(@PathParam("number") long number) {
		return coursesDB.deleteCourse(number);
	}
}
