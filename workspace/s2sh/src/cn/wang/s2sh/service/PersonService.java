package cn.wang.s2sh.service;

import java.io.Serializable;

import cn.wang.s2sh.domain.Person;

public interface PersonService {
	public void savePerson(Person person);
	public Person getPersonById(Serializable iSerializable);
}
