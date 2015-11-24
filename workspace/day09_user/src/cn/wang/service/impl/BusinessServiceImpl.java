package cn.wang.service.impl;

import cn.wang.dao.UserDao;
import cn.wang.dao.impl.UserDaoXmlImpl;
import cn.wang.domain.User;
import cn.wang.exception.UserExistException;
import cn.wang.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	UserDao dao = new UserDaoXmlImpl();

	/* (non-Javadoc)
	 * @see cn.wang.service.impl.BusinessService#registerUser(cn.wang.domain.User)
	 */
	@Override
	public void registerUser(User user) throws UserExistException {

		if (dao.find(user.getUsername()) != null) {
			throw new UserExistException("注册的用户名已存在！！！");
		}
		dao.add(user);
	}

	/* (non-Javadoc)
	 * @see cn.wang.service.impl.BusinessService#loginUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User loginUser(String username, String password) {
		return dao.find(username, password);
	}
}
