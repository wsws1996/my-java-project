package cn.wang.spring.di.xml.setter;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {
	@Resource(name = "student")
	private Student student;

	public Student getStudent() {
		return student;
	}

}
