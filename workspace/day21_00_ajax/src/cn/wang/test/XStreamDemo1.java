package cn.wang.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import cn.wang.domain.City;
import cn.wang.domain.Province;
public class XStreamDemo1 {
	@Test
	public void test1(){
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
		System.out.println(xs.toXML(provinces));
	}
}
