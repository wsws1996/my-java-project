package com.wang.ssm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.wang.ssm.dao.mapper.CjbMapper;
import com.wang.ssm.dao.mapper.KcbMapper;
import com.wang.ssm.dao.mapper.ScoreMapper;
import com.wang.ssm.po.Cjb;
import com.wang.ssm.po.CjbExample;
import com.wang.ssm.po.Kcb;
import com.wang.ssm.po.Score;
import com.wang.ssm.service.ScoreInfoService;

public class ScoreInfoServiceImpl implements ScoreInfoService {

	@Autowired
	ScoreMapper scoreMapper;

	@Autowired
	KcbMapper kcbMapper;

	@Autowired
	CjbMapper cjbMapper;

	@Override
	public List<Score> findScoreInfoByXh(String xh) throws Exception {
		return scoreMapper.selectByXh(xh);
	}

	@Override
	public void insertScoreInfo(Cjb cjb) throws Exception {
		if (StringUtils.isNotBlank(cjb.getXh()) && StringUtils.isNotBlank(cjb.getKch())) {
			CjbExample cjbExample = new CjbExample();
			CjbExample.Criteria criteria = cjbExample.createCriteria();
			criteria.andXhEqualTo(cjb.getXh());
			criteria.andKchEqualTo(cjb.getKch());
			if (cjbMapper.countByExample(cjbExample) == 0) {
				cjb.setCj(cjb.getCj() == null ? 0 : cjb.getCj());
				cjbMapper.insert(cjb);
			}
		}
	}

	@Override
	public void updateScoreInfo(Cjb cjb) throws Exception {
		CjbExample cjbExample = new CjbExample();
		CjbExample.Criteria criteria = cjbExample.createCriteria();
		criteria.andXhEqualTo(cjb.getXh());
		criteria.andKchEqualTo(cjb.getKch());
		cjbMapper.updateByExampleSelective(cjb, cjbExample);
	}

	@Override
	public List<Kcb> findCourse() {
		return kcbMapper.selectByExample(null);
	}

}
