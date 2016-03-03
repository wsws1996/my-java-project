package cn.wang.demo;
//观察者设计模式
public class Demo2 {

	public static void main(String[] args) {
		Person person = new Person();
		person.registerListener(new PersonListener() {
			@Override
			public void doeat(Event e) {
				System.out.println(e.getPerson() + "吃不下");
			}

			@Override
			public void dorun(Event e) {
				System.out.println(e.getPerson() + "跑不动");
			}
		});
		person.eat();
		person.run();
	}
}

class Person {

	private PersonListener listener;

	public void eat() {
		if (listener != null) {
			this.listener.doeat(new Event(this));
		}
	}

	public void run() {
		if (listener != null) {
			this.listener.dorun(new Event(this));
		}
	}

	public void registerListener(PersonListener listener) {
		this.listener = listener;
	}
}

interface PersonListener {
	public void doeat(Event e);

	public void dorun(Event e);
}

class Event {
	private Person person;

	public Event() {
		super();
	}

	public Event(Person person) {
		super();
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}