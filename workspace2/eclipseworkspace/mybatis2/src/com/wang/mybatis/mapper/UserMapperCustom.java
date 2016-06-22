package com.wang.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.wang.mybatis.po.Orders;
import com.wang.mybatis.po.QueryVo;
import com.wang.mybatis.po.User;

public interface UserMapperCustom {
	public List<User> findUserList(QueryVo queryVo) throws Exception;

	public int findUserCount(QueryVo queryVo) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map findUserListReturnMap(QueryVo queryVo) throws Exception;

	public List<User> findUserListResultMap(QueryVo queryVo) throws Exception;

}
