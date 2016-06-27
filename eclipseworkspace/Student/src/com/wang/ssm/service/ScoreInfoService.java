package com.wang.ssm.service;

import java.util.List;

import com.wang.ssm.po.Cjb;
import com.wang.ssm.po.Kcb;
import com.wang.ssm.po.Score;

public interface ScoreInfoService {
	public List<Score> findScoreInfoByXh(String xh) throws Exception;

	public void insertScoreInfo(Cjb cjb) throws Exception;

	public void updateScoreInfo(Cjb cjb) throws Exception;
	
	public List<Kcb> findCourse();
}