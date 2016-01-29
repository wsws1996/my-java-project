package cn.wang.dao;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import cn.wang.domain.Student;
import cn.wang.utils.XmlUtilsForDom4j;

public class StudentDaoByDom4j {
	public void add(Student student) {
		try {
			Document document = XmlUtilsForDom4j.getDocument();

			Element student_node = DocumentHelper.createElement("student");
			student_node.addAttribute("examid", student.getExamid());
			student_node.addAttribute("idcard", student.getIdcard());
			student_node.addElement("name").setText(student.getName());
			student_node.addElement("location").setText(student.getLocation());
			student_node.addElement("grade").setText(student.getGrade() + "");
			document.getRootElement().add(student_node);
			XmlUtilsForDom4j.write2Xml(document);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void delete(String name) {
		try {
			Document document = XmlUtilsForDom4j.getDocument();
			@SuppressWarnings("rawtypes")
			List list = document.selectNodes("//name");
			@SuppressWarnings("rawtypes")
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Element name_node = (Element) it.next();
				if (name_node.getText().equals(name)) {
					name_node.getParent().getParent().remove(name_node.getParent());
					XmlUtilsForDom4j.write2Xml(document);
					return;
				}
			}
			throw new RuntimeException("要删除的学生未找到！！！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public Student find(String examid) {
		try {
			Document document = XmlUtilsForDom4j.getDocument();
			Element element = (Element) document.selectSingleNode("//student[@examid='" + examid + "']");
			if (element != null) {
				Student s = new Student();
				s.setExamid(element.attributeValue("examid"));
				s.setIdcard(element.attributeValue("idcard"));
				s.setName(element.element("name").getText());
				s.setLocation(element.element("location").getText());
				s.setGrade(Double.parseDouble(element.element("grade").getText()));
				return s;
			}
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
