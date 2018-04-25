package shangbai.com.service.user.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import shangbai.com.dao.UserMapper;
import shangbai.com.po.User;
import shangbai.com.service.user.UserService;
import shangbai.com.utils.KeyWords;
import shangbai.com.utils.MD5Util;
import shangbai.com.utils.StatusEnum;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	public JSONObject userLogin(User user, HttpServletRequest request) {

		log.info("用户:" + user.getUserName() + "登录");

		user.setUserPassWord(MD5Util.getMD5(user.getUserPassWord()));
		JSONObject obj = new JSONObject();
		User u = userMapper.userLogin(user);

		if (u != null) {

			obj.put("userId", u.getUserId());
			obj.put("userName", u.getUserName());
			obj.put("realName", u.getRealName());
			obj.put(KeyWords.TIPSTATUS, StatusEnum.SSUCCESS.getNum());
			obj.put(KeyWords.TIPSTATUSCONTENT, StatusEnum.SSUCCESS.getValue());
			request.getSession().setAttribute(KeyWords.USERSESSION, obj);
			log.info("用户登录成功:" + obj);

		} else {

			obj.put("userName", user.getUserName());
			obj.put(KeyWords.TIPSTATUS, StatusEnum.FAIL.getNum());
			obj.put(KeyWords.TIPSTATUSCONTENT, StatusEnum.FAIL.getValue());
			log.info("用户登录失败:" + obj);

		}

		return obj;
	}

	public void register(User user) {

		user.setUserPassWord(MD5Util.getMD5(user.getUserPassWord()));
		userMapper.register(user);

	}

}
