package hwa.jong.lee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AuthInterceptor extends  HandlerInterceptorAdapter{
	private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle() 호출");

		// 로그인 여부를 확인하기 위해서 Session 객체를 구함
		HttpSession session = request.getSession();
		Object id = session.getAttribute("member");

		if (id != null) { // 로그인 되어 있는 경우
			log.info("로그인 아이디: {}", id);

			return true;
		} else { // 로그인 안된 경우
			log.info("로그인 안됨");
			String url = getRedirectUrl(request);
			response.sendRedirect(url);
			return false;
		}

	} // end preHandle()
	
	private String getRedirectUrl(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		log.info("url: {}", url);
		
		String queryString = request.getQueryString();
		log.info("queryString1 : {}", queryString);
		
		if(queryString == null) {
			queryString = "target=" + url;
		} else {
			queryString += "&target=" + url;
		}
		
		log.info("queryString: {}", queryString);
		
		return "/signin?" + queryString;
	} // end getRedirectUrl
	

}
