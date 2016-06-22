package com.wang.ws.area.server.service;

import java.util.List;

import javax.jws.WebService;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.wang.ws.area.server.dao.AreaDao;
import com.wang.ws.area.server.dao.AreaDaoImpl;
import com.wang.ws.area.server.po.Area;

/**
 * 区域查询
 * 
 * @author wang
 *
 */
@WebService
public class AreaServiceInterfaceImpl implements AreaServiceInterface {

	private AreaDao areaDao = new AreaDaoImpl();

	@Override
	public String queryArea(String areaInfo) {
		String responseString = "";
		try {
			Area area = this.parseXml(areaInfo);
			int start = area.getStart() - 1;
			int pageSize = area.getEnd() - start;
			List<Area> list = areaDao.queryAreaList(area.getParentid(), start, pageSize);

			responseString = parseXmlFromAreaList(list);
			return responseString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseString;
	}

	private Area parseXml(String areaInfo) throws DocumentException {
		Area area = new Area();
		Document document = DocumentHelper.parseText(areaInfo);

		String parentId = document.selectSingleNode("/queryarea/parentid").getText();

		String start = document.selectSingleNode("/queryarea/start").getText();
		String end = document.selectSingleNode("/queryarea/end").getText();

		area.setParentid(parentId);
		area.setStart(Integer.parseInt(start));
		area.setEnd(Integer.parseInt(end));
		return area;
	}

	private String parseXmlFromAreaList(List<Area> list) {
		Document document = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("areas");
		document.add(root);

		for (Area area : list) {
			String areaid = area.getAreaid();
			String areaname = area.getAreaname();
			String arealevel = area.getArealevel();
			String parentid = area.getParentid();

			Element area_element = DocumentHelper.createElement("area");

			area_element.addElement("areaid").addText(areaid);
			area_element.addElement("areaname").addText(areaname);
			area_element.addElement("arealevel").addText(arealevel);
			area_element.addElement("parentid").addText(parentid);

			root.add(area_element);
		}
		return document.asXML();
	}
}
