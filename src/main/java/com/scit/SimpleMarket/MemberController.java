package com.scit.SimpleMarket;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.SimpleMarket.DAO.MemberDAO;
import com.scit.SimpleMarket.VO.Member;

@Controller
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value="/goLoginAdmin", method=RequestMethod.GET)
	public String goLoginAdmin() {
		return "admin/adminLogin";
	}
	
	
	@RequestMapping(value="/loginAdmin", method=RequestMethod.GET)
	public String loginAdmin(Member member) {
		Member lMember = null;
		lMember = dao.loginAdmin(member);
		if(lMember == null) {
			return "redirect:/goLoginAdmin";
		}
		return "redirect:/adminMain";
	}
	@RequestMapping(value="/memberMain", method=RequestMethod.GET)
	public String memberMain() {
		return "member/memberMain";
	}
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String signUp() {
		return "member/signUp";
	}
	@RequestMapping(value="/insertMember", method=RequestMethod.POST)
	public String insertMember(Member member) {
		int result = 0;
		result = dao.insertMember(member);
		if(result == 0) {
			return "redirect:/signUp";
		}
		return "redirect:/memberMain";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	@RequestMapping(value="/loginMember", method=RequestMethod.GET)
	public String loginMember(Member member, HttpSession session) {
		Member lMember = null;
		lMember = dao.loginMember(member);
		String dest = (String)session.getAttribute("dest");
		if(dest == null) {
			session.setAttribute("loginId", lMember.getCustomerId());
			return "member/memberMain";
		}
		String[] arr = dest.split("/");
		String str = arr[arr.length-1];
		if(lMember == null) {
			return "redirect:/login";
		}
		//TODO 구매내역과 같이 파라미터를 받는거면 다른게 처리해야한다.
		session.setAttribute("loginId", lMember.getCustomerId());
		System.out.println(str);
		return "redirect:/"+str;
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("loginId", null);
		return "member/memberMain";
	}
	@RequestMapping(value="/memberMgr", method=RequestMethod.GET)
	public String memberMgr(Model model) {
		ArrayList<Member> list = null;
		list = dao.selectCustomerList();
		model.addAttribute("list", list);
		return "admin/customerList";
	}
}
