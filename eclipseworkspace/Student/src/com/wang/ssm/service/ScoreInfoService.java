package com.wang.ssm.service;

import com.wang.ssm.po.Cjb;
import com.wang.ssm.po.Xsb;

public interface ScoreInfoService {
	public Xsb findScoreInfoById(String xh) throws Exception;

	public void insertScoreInfo(Cjb cjb) throws Exception;

	public void updateScoreInfo(Cjb cjb) throws Exception;
}