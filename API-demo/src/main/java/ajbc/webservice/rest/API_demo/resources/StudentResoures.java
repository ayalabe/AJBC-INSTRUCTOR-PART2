package ajbc.webservice.rest.API_demo.resources;

import java.util.List;


import ajbc.webservice.rest.API_demo.DBService.StudentDBService;
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

@Path("students")
public class StudentResoures {
	
	StudentDBService studentDB = new StudentDBService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {
		return studentDB.getAllStudents();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentId(@PathParam("id") long id) {
		return studentDB.getStudentById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student addStudent(Student student) {
		return studentDB.addStudent(student);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student updateStudent(@PathParam("id") long id, Student student) {
		return studentDB.updateStudent(id, student);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("id") long id) {
		return studentDB.deleteStudent(id);
	}
}
