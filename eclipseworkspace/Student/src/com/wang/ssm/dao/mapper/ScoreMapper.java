package com.wang.ssm.dao.mapper;

import java.util.List;

import com.wang.ssm.po.Score;

public interface ScoreMapper {
	List<Score> selectByXh(String xh);
}
