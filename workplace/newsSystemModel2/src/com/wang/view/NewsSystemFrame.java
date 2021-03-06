package com.wang.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.wang.domain.News;
import com.wang.service.NewsService;

public class NewsSystemFrame {
	//这是我们的新闻管理界面
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		System.out.println("**********欢迎登陆到系统**********");
		System.out.println("*****请输入用户编号*****");
		String userId=br.readLine();
		System.out.println("*****请输入密码*****");
		String pwd=br.readLine();
		
		//到数据库验证
		
		if (true) {
			while (true) {
				System.out.println("*****管理界面*****");
				System.out.println("请选择你要进行的操作");
				System.out.println("search \t 查询新闻");
				System.out.println("add \t 添加新闻");
				System.out.println("exit \t 退出系统");
				
				String operType =br.readLine();
				
				if(operType.equals("search")){
					//提示他输入关键字
					System.out.println("请输入关键字,用空格隔开");
					String keys=br.readLine();
					//调用service完成任务
					NewsService ns=new NewsService();
					ArrayList<News> al = ns.searchNews(keys);
					for (News news : al) {
						System.out.println
						(news.getNewsid()+"\t"+news.getNewsTitle()
						+"\t"+news.getNewsDate().toString());
					}
				}else if (operType.equals("add")) {
					System.out.println("请输入新闻的标题");
					String newsTitle=br.readLine();
					System.out.println("请输入新闻的内容");
					String newsContent=br.readLine();
				}else if (operType.equals("exit")) {
					System.exit(0);
				}
			}
		}
	}

}
