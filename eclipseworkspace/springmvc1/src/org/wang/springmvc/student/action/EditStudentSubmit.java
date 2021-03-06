package org.wang.springmvc.student.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.wang.springmvc.student.pojo.Student;

@SuppressWarnings("deprecation")
public class EditStudentSubmit extends AbstractCommandController {

	
	
	public EditStudentSubmit() {
		this.setCommandClass(Student.class);
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		
		Student student=(Student) command;
		System.out.println(student);
		
		modelAndView.setViewName("success");
		
		return modelAndView;
	}
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
