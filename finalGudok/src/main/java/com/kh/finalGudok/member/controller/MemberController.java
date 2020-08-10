package com.kh.finalGudok.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("moveToLogin.do")
	public String login1() {
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
	
}
