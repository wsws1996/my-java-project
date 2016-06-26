package com.wang.ssm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.ssm.po.Xsb;
import com.wang.ssm.service.StudentInfoService;

@Controller
public class StudentInfoAction {
	@Autowired
	private StudentInfoService studentInfoService;

	@RequestMapping("/queryStudentUI")
	public String queryStudentUI() throws Exception {
		return "queryStudent";
	}

	@RequestMapping("queryStudent")
	public @ResponseBody List<Xsb> queryStudent(Xsb xsb, Date startDate, Date endDate, String zxf1, String zxf2)
			throws Exception {
		List<Xsb> xsbs = studentInfoService.findStudent(xsb, startDate, endDate, zxf1, zxf2);
		return xsbs;
	}

	@RequestMapping("editStudent")
	public void editStudent(Xsb xsb) throws Exception {
		studentInfoService.updateStudent(xsb);
	}

	@RequestMapping("delStudent")
	public void delStudent(String xh) throws Exception {
		studentInfoService.deleteStudent(xh);
	}

	@RequestMapping("addStudent")
	public void addStudent(Xsb xsb) throws Exception {
		studentInfoService.insertStudent(xsb);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
