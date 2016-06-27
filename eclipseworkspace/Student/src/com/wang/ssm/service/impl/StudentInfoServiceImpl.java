package com.wang.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.wang.ssm.dao.mapper.CjbMapper;
import com.wang.ssm.dao.mapper.XsbMapper;
import com.wang.ssm.po.CjbExample;
import com.wang.ssm.po.Xsb;
import com.wang.ssm.po.XsbExample;
import com.wang.ssm.service.StudentInfoService;

public class StudentInfoServiceImpl implements StudentInfoService {

	@Autowired
	XsbMapper xsbMapper;
	@Autowired
	CjbMapper cjbMapper;

	@Override
	public List<Xsb> findStudent(Xsb student, Date startDate, Date endDate, String zxf1, String zxf2) throws Exception {
		XsbExample xsbExample = new XsbExample();
		XsbExample.Criteria criteria = xsbExample.createCriteria();
		if (StringUtils.isNotBlank(student.getXh())) {
			criteria.andXhEqualTo(student.getXh());
		}
		if (StringUtils.isNotBlank(student.getXm())) {
			criteria.andXmLike("%"+student.getXm()+"%");
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
		xsbExample.setOrderByClause("xh");
		List<Xsb> xsbs = xsbMapper.selectByExample(xsbExample);

		return xsbs;
	}

	@Override
	public void insertStudent(Xsb student) throws Exception {
		if (StringUtils.isNoneBlank(student.getXh())) {
			XsbExample xsbExample = new XsbExample();
			XsbExample.Criteria criteria = xsbExample.createCriteria();
			criteria.andXhEqualTo(student.getXh());
			if (xsbMapper.countByExample(xsbExample) == 0) {
				xsbMapper.insert(student);
			}
		}
	}

	@Override
	public void updateStudent(Xsb student) throws Exception {
		if (StringUtils.isNotBlank(student.getXh())) {
			XsbExample xsbExample = new XsbExample();
			XsbExample.Criteria criteria = xsbExample.createCriteria();
			criteria.andXhEqualTo(student.getXh());
			xsbMapper.updateByExampleSelective(student, xsbExample);
		}
	}

	@Override
	public void deleteStudent(String xh) throws Exception {
		XsbExample xsbExample = new XsbExample();
		XsbExample.Criteria criteria = xsbExample.createCriteria();
		criteria.andXhEqualTo(xh);
		xsbMapper.deleteByExample(xsbExample);
		CjbExample cjbExample = new CjbExample();
		CjbExample.Criteria criteria2 = cjbExample.createCriteria();
		criteria2.andXhEqualTo(xh);
		cjbMapper.deleteByExample(cjbExample);
	}

}
