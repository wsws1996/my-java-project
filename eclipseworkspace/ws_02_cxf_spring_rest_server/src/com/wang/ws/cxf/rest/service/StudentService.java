package com.wang.ws.cxf.rest.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wang.ws.cxf.rest.pojo.Student;

/**
 * rest的SEI
 * 
 * @author wang
 *
 */

@WebService
@Path("/student")
public interface StudentService {
	@GET
	@Path("/query/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Student queryStudent(@PathParam("id") long id);

	@GET
	@Path("/querylist/{type}")
	@Produces({ "application/json;charset=utf-8", MediaType.APPLICATION_XML })
	public List<Student> queryStudentList(@PathParam("type") String type);
}
