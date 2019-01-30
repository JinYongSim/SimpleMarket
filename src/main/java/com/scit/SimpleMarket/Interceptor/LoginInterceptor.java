package com.scit.SimpleMarket.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private void saveDest(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String query = req.getQueryString();
		
		if(query == null || query.equals("null")) {
			query="";
		}else {
			query = "?"+query;
		}
		if(req.getMethod().equals("GET")) {
			System.out.println("dest:"+(uri+query)+req.getSession().getAttribute("loginId"));
			req.getSession().setAttribute("dest", uri+query);
		}
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		if(loginId == null) {
			saveDest(request);
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		return super.preHandle(request, response, handler);
	}
	
}
