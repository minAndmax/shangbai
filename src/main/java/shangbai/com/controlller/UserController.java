package shangbai.com.controlller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import shangbai.com.po.User;
import shangbai.com.service.user.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "login" , method = RequestMethod.POST)
	public JSONObject login(User user,HttpServletRequest request) {
		
		JSONObject obj = userService.userLogin(user, request);
		
		return obj;
	}
	
	@RequestMapping(value = "register" , method = RequestMethod.POST)
	public JSONObject register(User user) {
		
		userService.register(user);
		JSONObject obj = new JSONObject();
		obj.put("ss", "添加成功");
		return obj;
	}
	
	
}
