package cn.wang.proxy;

public class PersonDaoProxy implements PersonDao {
	private PersonDao personDao;

	private Transaction transaction;

	public PersonDaoProxy(PersonDao personDao, Transaction transaction) {
		this.personDao = personDao;
		this.transaction = transaction;
	}

	@Override
	public void updatePerson() {
		System.out.println("update person");
	}

	@Override
	public void savePerson() {
		System.out.println("save person");
	}

}
