package cn.wang.spring.xml.transaction;

public class PersonDaoImpl implements PersonDao {

	@Override
	public String savePerson() {
//		int i = 1 / 0;
		System.out.println("save person");
		return "success";
	}

}
