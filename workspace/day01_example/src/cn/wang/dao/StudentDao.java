package cn.wang.dao;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.wang.domain.Student;
import cn.wang.utils.XmlUtils;

public class StudentDao {
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
		
	}
	public Student find(String examid) {
		return null;
	}
}
