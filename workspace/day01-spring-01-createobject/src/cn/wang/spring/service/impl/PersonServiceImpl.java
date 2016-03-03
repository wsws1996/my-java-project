package cn.wang.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wang.spring.dao.PersonDao;
import cn.wang.spring.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	@Resource
	private PersonDao personDao;
	

	@Override
	public void savePerson() {
		this.personDao.savePerson();
	}

}
