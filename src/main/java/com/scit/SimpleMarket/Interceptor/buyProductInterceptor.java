package com.scit.SimpleMarket.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.scit.SimpleMarket.DAO.ProductDAO;

public class buyProductInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	ProductDAO dao;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String buyProductSeq = request.getParameter("productSeq");
		int seq=Integer.parseInt(buyProductSeq);
		int quantity = Integer.parseInt(request.getParameter("quantity")); // 구입하려는 수량
		int recentQuantity = dao.checkQuantity(buyProductSeq); // 현재 재고
		if(recentQuantity - quantity < 0) {
			response.sendRedirect(request.getContextPath()+"/selectProductDetail?productSeq="+seq);
			return false;
		}
		return super.preHandle(request, response, handler);
	}
	
}
