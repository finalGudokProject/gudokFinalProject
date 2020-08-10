package com.kh.finalGudok.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.finalGudok.member.model.service.MemberService;
import com.kh.finalGudok.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	MemberService mService;
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String memberLogin(Member m, HttpSession session, Model model) {
		
//		System.out.println("id : " + m.getId());
//		System.out.println("pwd : " + m.getPwd());
		
		Member loginUser = mService.loginMember(m);
		
		System.out.println(loginUser);
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return "home";
		}else {	
			model.addAttribute("msg","로그인 실패");
			return "common/errorPage";
		}
	}
	
//	마이페이지
	@RequestMapping("mypage.do")
	public String mypageView() {
		return "mypage/subscribe";
	}
	
	@RequestMapping("myInfo.do")
	public String myInfoView() {
		return "mypage/memberConfirm";
	}
	
	@RequestMapping(value="memberConfirm.do", method=RequestMethod.POST)
	public String memberConfirm(Member m, HttpSession session, Model model) {
		int result = mService.confirmMember(m);
		
		if(result > 0) {			
			return "mypage/memberInfoView";
		} else {
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="memberModify.do", method=RequestMethod.POST)
	public String memberModify(Member m, HttpSession session, Model model) {
		int result = mService.confirmMember(m);
		
		if(result > 0) {			
			return "mypage/memberInfoView";
		} else {
			return "common/errorPage";
		}
	}
	
	
}
