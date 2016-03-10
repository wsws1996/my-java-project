package org.wang.crm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.wang.crm.domain.Department;
import org.wang.crm.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements
		ModelDriven<Department> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 405159187105240473L;
	private DepartmentService departmentService;
	private Department model = new Department();

	@Override
	public Department getModel() {
		return this.model;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String showDepartment() {
		List<Department> departments = this.departmentService.findAllEntry();
		ActionContext.getContext().put("departments", departments);
		return "list";
	}

	public String map() {
		Department department = new Department();
		department.setName("aaa");
		department.setDescription("bbb");
		Map<String, Department> map = new HashMap<String, Department>();
		map.put("d1", department);
		ActionContext.getContext().put("map", map);
		return "list";
	}

	public String listMap() {
		List<Map<String, Department>> list = new ArrayList<>();

		Department department = new Department();
		department.setName("aaa");
		department.setDescription("bbb");
		Map<String, Department> map = new HashMap<String, Department>();
		map.put("d1", department);
		list.add(map);
		ActionContext.getContext().put("list", list);
		return "list";
	}

	public String mapList() {
		Map<String, List<Department>> map = new HashMap<>();
		Department department = new Department();
		department.setName("aaa");
		department.setDescription("bbb");
		List<Department> departments = new ArrayList<>();
		departments.add(department);

		Department department2 = department = new Department();
		department2.setName("ccc");
		department2.setDescription("ddd");
		departments.add(department);

		map.put("list", departments);

		ActionContext.getContext().put("map", map);
		return "list";
	}

	public String listMapList() {
		List<Map<String, List<Department>>> list = new ArrayList<>();
		Map<String, List<Department>> map = new HashMap<>();
		Department department = new Department();
		department.setName("aaa");
		department.setDescription("bbb");
		List<Department> departments = new ArrayList<>();
		departments.add(department);

		Department department2 = department = new Department();
		department2.setName("ccc");
		department2.setDescription("ddd");
		departments.add(department);

		map.put("list", departments);
		list.add(map);

		ActionContext.getContext().put("list", list);
		return "list";
	}

	public String addUI() {
		return "addUI";
	}
	public String add() {
		Department department=new Department();
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.saveEntry(department);
		return "action2action";
	}
	public String deleteByOrder() {
		this.departmentService.deleteByOrder();
		return "action2action";
	}
	public String updateUI() {
		Department department=this.departmentService.getEntryByID(this.getModel().getDid());
		ActionContext.getContext().getValueStack().push(department);
		return "updateUI";
	}
	public String update() {
		Department department= this.departmentService.getEntryByID(this.getModel().getDid());
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.updateEntry(department);
		return "action2action";
	}
}
