package cn.wang.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.City;
import cn.wang.domain.Province;

import com.thoughtworks.xstream.XStream;

public class ServletDemo4 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7470600888677008345L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Province> provinces=new ArrayList<Province>();
		Province sd=new Province(37, "山东省");
		Province hb=new Province(42, "湖北省");
		Province hn=new Province(41, "河南省");
		
		sd.getCities().add(new City(01, "济南"));
		sd.getCities().add(new City(02, "青岛"));
		sd.getCities().add(new City(03, "淄博"));
		
		hb.getCities().add(new City(01, "武汉"));
		hb.getCities().add(new City(02, "黄冈"));
		hb.getCities().add(new City(03, "襄阳"));
		
		hn.getCities().add(new City(01, "郑州"));
		hn.getCities().add(new City(02, "开封"));
		hn.getCities().add(new City(03, "洛阳"));
		
		provinces.add(sd);
		provinces.add(hb);
		provinces.add(hn);
		
		XStream xs=new XStream();
		xs.autodetectAnnotations(true);
		xs.alias("provinces", List.class);
		String xml=xs.toXML(provinces);
		response.setContentType("text/xml;charset=UTF-8");
		response.getWriter().write(xml);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
