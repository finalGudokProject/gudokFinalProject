package com.kh.finalGudok.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.finalGudok.member.model.exception.MemberException;
import com.kh.finalGudok.member.model.service.MemberService;
import com.kh.finalGudok.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;

	@RequestMapping("moveToLogin.do")
	public String moveTologin() {
		return "member/login";
	}
	
	@RequestMapping("signUp.do")
	public String signUp() {
		return "member/signUp";
	}
	
	@RequestMapping("find.do")
	public String findId() {
		return "member/find";
	}
	
	@RequestMapping("payment.do")
	public String payment() {
		return "items/payment";
	}

//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(HttpServletRequest request){
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		
//		return "home";
//	}
	
//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(@RequestParam("id") String id, @RequestParam("pwd") String pwd){
//
//		System.out.println(id);
//		System.out.println(pwd);
//		return "home";
//	}
	
//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(@RequestParam(value="id", required=false, defaultValue="1") String id, @RequestParam("pwd") String pwd){
//
//		System.out.println(id);
//		System.out.println(pwd);
//		return "home";
//	} 
	
//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(String id, String pwd) {
//		System.out.println(id);
//		System.out.println(pwd);
//		return "home";
//	}
	
//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(@ModelAttribute Member m) {
//		System.out.println(m.getMemberId());
//		System.out.println(m.getMemberPwd());
//		return "home";
//	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String memberLogin(Member m, HttpSession session, Model model) {
		
//		System.out.println(m.getMemberId());
//		System.out.println(m.getMemberPwd());
		
		Member loginUser = mService.loginMember(m);
		
		
		if(loginUser != null) {
//			System.out.println(loginUser);
			session.setAttribute("loginUser", loginUser);
			return "home";
		}else {
			model.addAttribute("msg","로그인 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
		public String logout(HttpSession session) {
			session.invalidate();
			return "home";
		}
	}
	
