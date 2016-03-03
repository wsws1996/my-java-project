package cn.wang.spring.xml.transaction;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson() {
		System.out.println("save person");
	}

}
