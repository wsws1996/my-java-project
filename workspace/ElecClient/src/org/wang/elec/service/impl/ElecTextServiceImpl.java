package org.wang.elec.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecTextDao;
import org.wang.elec.domain.ElecText;
import org.wang.elec.service.IElecTextService;

@Service(IElecTextService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecTextServiceImpl implements IElecTextService {

	@Resource(name = IElecTextDao.SERVICE_NAME)
	IElecTextDao elecTextDao;

	@Override
	@Transactional(readOnly = false)
	public void saveElecText(ElecText elecText) {
		elecTextDao.save(elecText);
	}

	@Override
	public List<ElecText> findCollectionByConditionNoPage(ElecText elecText) {

		String condition = "";
		List<Object> paramList = new ArrayList<Object>();
		if (StringUtils.isNotBlank(elecText.getTextName())) {
			condition += " and o.textName like ?";
			paramList.add("%" + elecText.getTextName() + "%");
		}

		if (StringUtils.isNotBlank(elecText.getTextRemark())) {
			condition += " and o.textName like ?";
			paramList.add("%" + elecText.getTextRemark() + "%");
		}

		Object[] params = paramList.toArray();

		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.textDate", "asc");
		orderby.put("o.textName", "desc");

		List<ElecText> list = elecTextDao.findCollectionByConditionNoPage(
				condition, params, orderby);

		return list;
	}

}
