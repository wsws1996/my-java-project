package cn.wang.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cn.wang.dao.*;
import cn.wang.domain.Student;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("添加学生(a) 查找学生(b) 删除学生(c)");
		System.out.print("请输入操作类型");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String type= br.readLine();
		if (type.equalsIgnoreCase("a")) {
			try {
				System.out.print("请输入学生姓名");
				String name=br.readLine();
				System.out.print("请输入学生准考证号");
				String examid=br.readLine();
				System.out.print("请输入学生身份证号");
				String idcard=br.readLine();
				System.out.print("请输入学生所在地");
				String location=br.readLine();
				System.out.print("请输入学生成绩");
				String grade=br.readLine();
				Student student =new Student();
				student.setExamid(examid);
				student.setGrade(Double.parseDouble(grade));
				student.setIdcard(idcard);
				student.setLocation(location);
				student.setName(name);
				StudentDaoByDom4j dao=new StudentDaoByDom4j();
				dao.add(student);
				System.out.println("录入成功！！！");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("录入失败！！！");
			}
		}else if (type.equalsIgnoreCase("b")) {
			System.out.print("请输入学生的准考证号");
			String examid=br.readLine();
			
			StudentDaoByDom4j dao=new StudentDaoByDom4j();
			Student student =dao.find(examid);
			if (student==null) {
				System.out.println("对不起，您要查找的学生不存在！！！");
			} else {
				System.out.println("您要查找的信息如下：");
				System.out.println("姓名："+student.getName());
				System.out.println("身份证："+student.getIdcard());
				System.out.println("准考证："+student.getExamid());
				System.out.println("所在地："+student.getLocation());
				System.out.println("成绩："+student.getGrade());
			}
		}else if (type.equalsIgnoreCase("c")) {
			try {
				System.out.print("请输入要删除学生的姓名：");
				String name =br.readLine();
				StudentDaoByDom4j dao=new StudentDaoByDom4j();
				dao.delete(name);
				System.out.println("删除成功！！！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("不支持此类操作！！！");
		}
	}

}
