package cn.wang.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.wang.dao.UserDao;
import cn.wang.domain.User;
import cn.wang.utils.XmlUtils;

public class UserDaoXmlImpl implements UserDao {

	/* (non-Javadoc)
	 * @see cn.wang.dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username, String password) {

		try {
			Document document = XmlUtils.getDocument();
			Element element = (Element) document
					.selectSingleNode("//user[@username='" + username
							+ "' and @password='" + password + "']");
			if (element == null) {
				return null;
			}
			User user = new User();
			user.setId(element.attributeValue("id"));
			user.setEmail(element.attributeValue("email"));
			user.setPassword(element.attributeValue("password"));
			user.setUsername(element.attributeValue("username"));
			String birthday = element.attributeValue("birthday");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-mm-dd");
			user.setBirthday(simpleDateFormat.parse(birthday));
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see cn.wang.dao.impl.UserDao#add(cn.wang.domain.User)
	 */
	@Override
	public void add(User user) {
		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element user_node = root.addElement("user");
			user_node.setAttributeValue("id", user.getId());
			user_node.setAttributeValue("username", user.getUsername());
			user_node.setAttributeValue("password", user.getPassword());
			user_node.setAttributeValue("email", user.getEmail());
			user_node.setAttributeValue("birthday", user.getBirthday()
					.toLocaleString());
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/* (non-Javadoc)
	 * @see cn.wang.dao.impl.UserDao#find(java.lang.String)
	 */
	@Override
	public User find(String username) {
		try {
			Document document = XmlUtils.getDocument();
			Element element = (Element) document
					.selectSingleNode("//user[@username='" + username+"']");
			if (element == null) {
				return null;
			}
			User user = new User();
			user.setId(element.attributeValue("id"));
			user.setEmail(element.attributeValue("email"));
			user.setPassword(element.attributeValue("password"));
			user.setUsername(element.attributeValue("username"));
			String birthday = element.attributeValue("birthday");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-mm-dd");
			user.setBirthday(simpleDateFormat.parse(birthday));
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
