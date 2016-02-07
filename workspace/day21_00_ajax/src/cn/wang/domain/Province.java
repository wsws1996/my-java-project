package cn.wang.domain;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("province")
public class Province {
	@XStreamAsAttribute
	private int code;
	@XStreamAsAttribute
	private String name;
	
	public Province() {
		super();
	}

	public Province(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	@XStreamImplicit()
	private List<City> cities=new ArrayList<City>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
}
