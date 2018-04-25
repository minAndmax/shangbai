package shangbai.com.service.user;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

import shangbai.com.po.User;

public interface UserService {

	JSONObject userLogin(User user,HttpServletRequest request);

	void register(User user);
	
	
	
}
