package com.wang.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wang.dao.SqlHelper;
import com.wang.domain.News;

public class NewsService {
	/*
	 * @author 王爽
	 * @param keys : 表示用户输入的所有关键字
	 */
public ArrayList<News> searchNews(String keys) {
	ArrayList<News> al=null;
	String keyArr[]=keys.split(" ");
	String sql ="select newsid,newstitle,newsdate from news where";
	for (int i = 0; i < keyArr.length; i++) {
		if (i==keyArr.length-1) {
			sql+=" (newstitle like '%"+keyArr[i]+
					"%' or newscontent like '%"+keyArr[i]+"%')";
		} else {
			sql+=" (newstitle like '%"+keyArr[i]+
					"%' or newscontent like '%"+keyArr[i]+"%') and ";
		}
	}
	
	//完成查询
	try {
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		
		//将rs->Arrayist(News对象)[业务逻辑的二次封装]
		al=new ArrayList<News>();
		
		while (rs.next()) {
			News news =new News();
			news.setNewsid(rs.getInt(1));
			news.setNewsTitle(rs.getString(2));
			news.setNewsDate(rs.getDate(3));
//			news.setNewsContent(rs.getString(4));
			al.add(news);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		//关闭资源
		SqlHelper.close(SqlHelper.getRs(), SqlHelper.getPs(), SqlHelper.getCt());
	}
	
	return al;
	
}
}
