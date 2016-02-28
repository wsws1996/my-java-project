package cn.wang.hibernate.utils;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */

public class Person implements java.io.Serializable {

	// Fields

	private Long pid;
	private String name;
	private String description;

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** full constructor */
	public Person(String name, String description) {
		this.name = name;
		this.description = description;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}