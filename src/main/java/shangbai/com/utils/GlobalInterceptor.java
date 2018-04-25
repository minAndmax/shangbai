package shangbai.com.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * 对没有登录的用户进行拦截
 * 
 * @author hky004
 *
 */

public class GlobalInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 登录请求放行
		String path = request.getRequestURI();
		if ("/user/login".equals(path)) {
			return true;
		}
		// 注册请求放行
		if ("/user/regist".equals(path)) {
			return true;
		}

		// 对没有登录的请求进行拦截
		JSONObject obj = (JSONObject) request.getSession().getAttribute(KeyWords.USERSESSION);

		if (obj == null) {

			response.sendRedirect("/index.jsp");
			return false;

		} else {

			return true;

		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
