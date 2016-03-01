package cn.wang.hibernate.dao;

import com.mysql.jdbc.StringUtils;


public class ClassesQuery extends BaseQuery {

	private String name;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void buildWhere() {
		if (!com.mysql.jdbc.StringUtils.isNullOrEmpty(name)) {
			this.getKeyValues().put("name", name);
		}
		if (!StringUtils.isNullOrEmpty(description)) {
			this.getKeyValues().put("description", description);
		}
	}
}
