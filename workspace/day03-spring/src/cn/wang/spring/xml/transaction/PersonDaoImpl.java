package cn.wang.spring.xml.transaction;

import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	public String savePerson() {
		System.out.println("save person");
		return "success";
	}

}
