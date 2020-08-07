package com.kh.finalGudok.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.finalGudok.member.model.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService mService;
}
