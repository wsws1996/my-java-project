package com.wang.purchasing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wang.purchasing.dao.mapper.PurSysUserMapper;
import com.wang.purchasing.po.PurSysUser;
import com.wang.purchasing.po.PurSysUserExample;
import com.wang.purchasing.service.UserService;
import com.wang.purchasing.util.MD5;
import com.wang.purchasing.vo.ActiveUser;

public class UserServiceImpl implements UserService {

	@Autowired
	private PurSysUserMapper purSysUserMapper;
	
	
	@Override
	public PurSysUser findUserByUserId(String userId) throws Exception {
		PurSysUserExample purSysUserExample = new PurSysUserExample();
		PurSysUserExample.Criteria criteria = purSysUserExample.createCriteria();
		criteria.andUseridEqualTo(userId);
//		List<PurSysUser> list  = purSysUserMapper.selectByExample(purSysUserExample);
		List<PurSysUser> list  = purSysUserMapper.selectByExample(purSysUserExample);
		if(list!=null && list.size() == 1){
			return list.get(0);
		}
		return null;
	}
	@Override
	public ActiveUser checkUser(String userId, String pwd) throws Exception {
		
		//校验用户账号及密码
		PurSysUser purSysUser = this.findUserByUserId(userId);
		if(purSysUser == null){
			//账号不存在
			return null;
		}
		String pwd_md5 = new MD5().getMD5ofStr(pwd);
		if(!pwd_md5.equalsIgnoreCase(purSysUser.getPwd())){
			//密码不匹配
			return null;
		}
		
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(purSysUser.getId());
		activeUser.setUsername(purSysUser.getUsername());
		return activeUser;
	}

}
