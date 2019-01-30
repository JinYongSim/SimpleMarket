package com.scit.SimpleMarket;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.SimpleMarket.DAO.ProductDAO;
import com.scit.SimpleMarket.VO.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO dao;
	
	// 관리자 메인 페이지
	@RequestMapping(value="/adminMain", method=RequestMethod.GET)
	public String adminMain(Model model) {
		productListAll(model);
		return "admin/adminMain";
	}
	// 상품목록 출력 메소드
	public void productListAll(Model model) {
		ArrayList<Product> list = null;
		list = dao.selectProductListAll();
		model.addAttribute("list",list);
	}
	// 상품등록페이지로 이동
	@RequestMapping(value="/productMgr", method=RequestMethod.GET)
	public String productMgr() {
		return "admin/insertProduct";
	}
	
	// 상품 등록
	@RequestMapping(value="/insertProduct", method=RequestMethod.POST)
	public String insertProduct(Product product) {
		int result = 0;
		result = dao.insertProduct(product);
		if(result==0) {
			return "admin/insertProduct";
		}
		return "redirect:/adminMain";
	}
	
	// 상품 수정을 위해서 정보 가져오기
	@RequestMapping(value="/updateProduct", method=RequestMethod.GET)
	public String updateProduct(String productSeq, Model model) {
		Product product = null;
		product = dao.selectProductDetail(productSeq);
		model.addAttribute("product", product);
		return "admin/insertProduct";
	}
	// 상품 수정
	@RequestMapping(value="/updateContent", method=RequestMethod.POST)
	public String updateContent(Product product) {
		dao.updateProduct(product);
		return "redirect:/adminMain";
	}
	// 회원이 보는 상품목록
	@RequestMapping(value="/productList", method=RequestMethod.GET)
	public String productList(Model model,HttpSession session) {
		productListAll(model);
		return "member/product";
	}
	// 상품 자세히 보기 메소드
	public void productDetail(String productSeq, Model model) {
		Product product = null;
		product = dao.selectProductDetail(productSeq);
		model.addAttribute("product", product);
	}
	// 상품 자세히 보기
	@RequestMapping(value="/selectProductDetail", method=RequestMethod.GET)
	public String selectProductDetail(String productSeq, Model model) {
		productDetail(productSeq,model);
		return "member/productDetail";
	}
	// 물품 구매
	@RequestMapping(value="/buyProduct", method=RequestMethod.GET)
	public String buyProduct(Product product) {
		dao.insertSold(product);
		dao.updateProductQuantity(product);
		return "redirect:/productList";
	}
	@RequestMapping(value="/purchaseList", method=RequestMethod.GET)
	public String purchaseList(Model model, HttpSession session) {
		ArrayList<HashMap<String,Object>> hMap = null;		
		hMap = dao.selectPurchaseList((String)session.getAttribute("loginId"));
		model.addAttribute("hMap", hMap);
		return "member/purchaseList";
	}
}
