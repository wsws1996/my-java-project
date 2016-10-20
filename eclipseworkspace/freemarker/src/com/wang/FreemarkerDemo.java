package com.wang;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 测试Freemarker Freemarker环境
 * 
 * @author wang
 *
 */
public class FreemarkerDemo {

	// 搭建Freemarker
	public static void main(String[] args) throws IOException, TemplateException {
		// 配置对象
		Configuration conf = new Configuration();
		// 模板路径
		String dir = "/E/myproject/my-java-project/eclipseworkspace/freemarker/ftl/";
		// 导入模板目录
		conf.setDirectoryForTemplateLoading(new File(dir));

		Template template = conf.getTemplate("freemarker.html");

		// 数据
		Map root = new HashMap();
		root.put("world",null);
		Person p = new Person();
		p.setId(1);
		p.setName("王小二");
		root.put("p", p);

		// List
		List<String> persons = new ArrayList();
		persons.add("测试二");
		persons.add("测试一");
		persons.add("王二小");
		root.put("persons", persons);

		// Map
		Map mx = new HashMap();
		mx.put("cs3", "测试三");
		mx.put("cs4", "测试四");
		mx.put("cs5", "测试五");
		root.put("mx", mx);

		// List<Map>
		List<Map> maps = new ArrayList<Map>();
		Map pms1 = new HashMap();
		pms1.put("id1", "测试六");
		pms1.put("id2", "测试七");
		Map pms2 = new HashMap();
		pms2.put("id1", "测试八");
		pms2.put("id2", "测试九");
		maps.add(pms1);
		maps.add(pms2);
		root.put("maps", maps);
		
		root.put("cur_time", new Date());
		// 输出流
		Writer out = new FileWriter(new File(dir + "hello.html"));

		// 生成开始
		template.process(root, out);

		out.close();

		System.out.println("生成完毕！");
	}
}
