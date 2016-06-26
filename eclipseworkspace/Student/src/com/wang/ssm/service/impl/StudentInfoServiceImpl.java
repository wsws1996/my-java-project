package com.wang.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.wang.ssm.dao.mapper.XsbMapper;
import com.wang.ssm.po.Xsb;
import com.wang.ssm.po.XsbExample;
import com.wang.ssm.service.StudentInfoService;

public class StudentInfoServiceImpl implements StudentInfoService {

	@Autowired
	XsbMapper xsbMapper;

	@Override
	public List<Xsb> findStudent(Xsb student, Date startDate, Date endDate, String zxf1, String zxf2) throws Exception {
		XsbExample xsbExample = new XsbExample();
		XsbExample.Criteria criteria = xsbExample.createCriteria();
		if (StringUtils.isNotBlank(student.getXh())) {
			criteria.andXhEqualTo(student.getXh());
		}
		if (StringUtils.isNotBlank(student.getXm())) {
			criteria.andXmLike(student.getXm());
		}
		if (student.getXb() != null) {
			criteria.andXbEqualTo(student.getXb());
		}
		if (startDate != null && endDate != null) {
			criteria.andCssjBetween(startDate, endDate);
		}
		if (startDate == null && endDate != null) {
			criteria.andCssjLessThanOrEqualTo(endDate);
		}
		if (startDate != null && endDate == null) {
			criteria.andCssjGreaterThanOrEqualTo(startDate);
		}
		if (StringUtils.isNotBlank(student.getZy())) {
			criteria.andZyEqualTo(student.getZy());
		}
		int nzxf1 = -1, nzxf2 = -1;
		if (StringUtils.isNotBlank(zxf1)) {
			nzxf1 = Integer.parseInt(zxf1);
		}
		if (StringUtils.isNotBlank(zxf2)) {
			nzxf2 = Integer.parseInt(zxf2);
		}

		if (nzxf1 != -1 && nzxf2 != -1) {
			criteria.andZxfBetween(nzxf1, nzxf2);
		}
		if (nzxf1 == -1 && nzxf2 != -1) {

			criteria.andZxfLessThanOrEqualTo(nzxf2);
		}

		if (nzxf1 != -1 && nzxf2 == -1) {

			criteria.andZxfGreaterThanOrEqualTo(nzxf1);
		}
		List<Xsb> xsbs = xsbMapper.selectByExample(xsbExample);
		for (Xsb xsb : xsbs) {
		}
		return xsbs;
	}

	@Override
	public void insertStudent(Xsb student) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStudent(Xsb student) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(String xh) throws Exception {
		// TODO Auto-generated method stub

	}

}
