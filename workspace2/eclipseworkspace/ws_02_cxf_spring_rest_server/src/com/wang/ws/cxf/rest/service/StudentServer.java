package com.wang.ws.cxf.rest.service;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import com.wang.ws.cxf.rest.pojo.Student;

public class StudentServer {
	public static void main(String[] args) {
		JAXRSServerFactoryBean jaxrsServerFactoryBean = new JAXRSServerFactoryBean();
		jaxrsServerFactoryBean.setAddress("http://127.0.0.1:12345/rest");
		jaxrsServerFactoryBean.setServiceBean(new StudentServiceImpl());
		jaxrsServerFactoryBean.setResourceClasses(Student.class);
		jaxrsServerFactoryBean.create();
	}

}
