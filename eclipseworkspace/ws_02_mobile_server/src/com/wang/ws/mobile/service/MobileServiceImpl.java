package com.wang.ws.mobile.service;

import cn.com.webxml.MobileCodeWSSoap;

/**
 * 手机号查询
 * 
 * @author wang
 *
 */
public class MobileServiceImpl implements MobileService {

	private MobileCodeWSSoap mobileClient;

	public MobileCodeWSSoap getMobileClient() {
		return mobileClient;
	}

	public void setMobileClient(MobileCodeWSSoap mobileClient) {
		this.mobileClient = mobileClient;
	}

	@Override
	public String queryMobile(String code) {
		return mobileClient.getMobileCodeInfo(code, "");
	}

}
