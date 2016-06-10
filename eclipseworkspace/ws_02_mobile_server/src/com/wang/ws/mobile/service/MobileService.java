package com.wang.ws.mobile.service;

import javax.jws.WebService;

/**
 * 手机号查询service
 * 
 * @author wang
 *
 */
@WebService
public interface MobileService {
	public String queryMobile(String code);
}
