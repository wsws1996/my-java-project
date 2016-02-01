package cn.wang.domain;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private String id;
	private String name;
	private String description;
	private Set<Privilege> privilages = new HashSet<Privilege>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Privilege> getPrivilages() {
		return privilages;
	}
	public void setPrivilages(Set<Privilege> privilages) {
		this.privilages = privilages;
	}
	
}
