package shangbai.com.dao;

import shangbai.com.po.User;

public interface UserMapper {

	User userLogin(User user);

	void register(User user);
	
}
