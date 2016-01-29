package cn.wang.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import cn.wang.domain.Student;
import cn.wang.utils.XmlUtils;

public class StudentDaoByJaxp {
	public void add(Student student) {
		try {
			Document document = XmlUtils.getDocument();
			Element student_node = document.createElement("student");
			student_node.setAttribute("examid",student.getExamid());
			student_node.setAttribute("idcard",student.getIdcard());
			Element name=document.createElement("name");
			name.setTextContent(student.getName());
			Element location=document.createElement("location");
			location.setTextContent(student.getLocation());
			Element grade=document.createElement("grade");
			grade.setTextContent(student.getGrade()+"");
			student_node.appendChild(name);
			student_node.appendChild(location);
			student_node.appendChild(grade);
			document.getElementsByTagName("exam").item(0).appendChild(student_node);
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public void delete(String name) {
		try {
			Document document =XmlUtils.getDocument();
			NodeList list=document.getElementsByTagName("name");
			for (int i = 0; i < list.getLength(); i++) {
				Node node=list.item(i);
				if (node.getTextContent().equals(name)) {
					node.getParentNode().getParentNode().removeChild(node.getParentNode());
					XmlUtils.write2Xml(document);
					return;
				}
			}
			throw new RuntimeException("对不起，您要删除的学生不存在！！！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public Student find(String examid) {
		
		try {
			Document document =XmlUtils.getDocument();
			NodeList list =document.getElementsByTagName("student");
			for (int i = 0; i < list.getLength(); i++) {
				Element student=(Element)list.item(i);
				String s_examid= student.getAttribute("examid");
				if(s_examid.equals(examid)){
					Student s=new Student();
					s.setExamid(student.getAttribute("examid"));
					s.setIdcard(student.getAttribute("idcard"));
					s.setGrade(Double.parseDouble(student.getElementsByTagName("grade").item(0).getTextContent()));
					s.setName(student.getElementsByTagName("name").item(0).getTextContent());
					s.setLocation(student.getElementsByTagName("location").item(0).getTextContent());
					return s;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		return null;
	}
}
