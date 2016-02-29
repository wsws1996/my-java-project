package cn.wang.service;

import java.util.List;

import cn.wang.dao.StudentDao;
import cn.wang.domain.Page;
import cn.wang.domain.Student;

public class BusinessService {
	
	StudentDao studentDao=new StudentDao();
	
	public Page getStudentPageData(String pagenum,String url) {
		
		int totalrecord=studentDao.getTotalrecord();
		if (pagenum==null) {
			Page page=new Page(totalrecord, 1);
			List<Student> list=studentDao.getPageData(page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}else {
			Page page=new Page(totalrecord, Integer.parseInt(pagenum));
			List<Student> list=studentDao.getPageData(page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}
}
