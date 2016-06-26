package com.wang.ssm.service;

import java.util.Date;
import java.util.List;

import com.wang.ssm.po.Xsb;

public interface StudentInfoService {
	public List<Xsb> findStudent(Xsb student, Date startDate, Date endDate, String zxf1, String zxf2) throws Exception;

	public void insertStudent(Xsb student) throws Exception;

	public void updateStudent(Xsb student) throws Exception;

	public void deleteStudent(String xh) throws Exception;
}
