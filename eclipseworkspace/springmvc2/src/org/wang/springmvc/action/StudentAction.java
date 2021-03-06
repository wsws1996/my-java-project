package org.wang.springmvc.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wang.springmvc.student.pojo.Student;
import org.wang.springmvc.student.pojo.UserVo;

@Controller
@RequestMapping("/stu")
public class StudentAction {

	@RequestMapping("querystudent")
	public String querystudent(Model model,@RequestParam(value="groupid",required=true,defaultValue="g001")String group, UserVo userVo) throws Exception {
//		System.out.println("group:"+group);
		List<Student> list = new ArrayList<Student>();
		Student student = new Student();
		student.setId("s001");
		student.setName("张三");
		student.setAge(32);
		student.setBirthday(new Date());

		Student student2 = new Student();
		student2.setId("s002");
		student2.setName("李四");
		student2.setAge(32);
		student2.setBirthday(new Date());

		list.add(student);
		list.add(student2);

		model.addAttribute("list", list);

		return "student/querystudent";
	}

	@RequestMapping(value = "/editstudent/{id}", method = RequestMethod.GET)
	public String editstudent(HttpServletRequest request, Model model, @PathVariable String id) throws Exception {
		System.out.println("request:" + request.getParameter("id"));
		System.out.println("id:" + id);
		Student student = new Student();
		student.setId("s001");
		student.setName("张三");
		student.setAge(32);
		student.setBirthday(new Date());

		model.addAttribute("student", student);
		return "student/editstudent";
	}

	@RequestMapping("/deletestu")
	public String deletestu(String [] deleteid) throws Exception {
		
		System.out.println(deleteid.length);
		return "success";
	}

	@RequestMapping("/editstudentsubmit")
	public String editstudentsubmit(String id_, Student student, UserVo userVo) throws Exception {
		System.out.println(student);
//		return "success";
		return "forward:querystudent.action";
	}

	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {

		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
