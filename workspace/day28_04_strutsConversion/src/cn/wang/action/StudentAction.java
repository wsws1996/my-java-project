package cn.wang.action;

import cn.wang.domain.Student;
import cn.wang.service.BussinessService;
import cn.wang.service.impl.BussinessServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements
		ModelDriven<Student> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2002661838483611402L;
	private Student student = new Student();
	private BussinessService service = new BussinessServiceImpl();
	private String[] hobbies;

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String register() {
		try {
			if (hobbies != null && hobbies.length > 0) {
				StringBuffer stringBuffer = new StringBuffer();
				for (int i = 0; i < hobbies.length; i++) {
					if (i > 0) {
						stringBuffer.append(",");
					}
					stringBuffer.append(hobbies[i]);
				}
				student.setHobby(stringBuffer.toString());
			}
			service.registerStudent(student);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}

}