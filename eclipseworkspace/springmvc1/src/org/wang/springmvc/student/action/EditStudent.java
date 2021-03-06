package org.wang.springmvc.student.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.wang.springmvc.student.pojo.Student;

@SuppressWarnings("deprecation")
public class EditStudent extends AbstractCommandController {

	public EditStudent() {
		this.setCommandClass(Student.class);
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		Student student = new Student();
		student.setName("张三");
		student.setAge(32);
		student.setBirthday(new Date());

		modelAndView.addObject("student", student);

		modelAndView.setViewName("student/editstudent");

		return modelAndView;
	}

}
