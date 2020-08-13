package com.kh.finalGudok.member.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.kh.finalGudok.member.model.exception.MemberException;
import com.kh.finalGudok.member.model.service.MemberService;
import com.kh.finalGudok.member.model.vo.Cart;
import com.kh.finalGudok.member.model.vo.Delivery;
import com.kh.finalGudok.member.model.vo.Exchange;
import com.kh.finalGudok.member.model.vo.Member;
import com.kh.finalGudok.member.model.vo.Point;
import com.kh.finalGudok.member.model.vo.Review;


import com.kh.finalGudok.member.model.service.MemberService;
import com.kh.finalGudok.member.model.vo.Member;

@Controller
public class MemberController {

//	@Autowired
//	MemberService mService;

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

	
//	마이페이지

	@RequestMapping("mypage.do") 
	public String mypageView() { // 민지
		return "mypage/subscribe";
	}
	
	@RequestMapping("myInfo.do") 
	public String myInfoView() { // 민지
		return "mypage/memberConfirm";
	}
	
	@RequestMapping(value="memberConfirm.do", method=RequestMethod.POST)
	public String memberConfirm(Member m, HttpSession session, Model model) { // 민지
		int result = mService.confirmMember(m);
		
		if(result > 0) {			
			return "mypage/memberInfoView";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value="memberModify.do", method=RequestMethod.POST)
	public String memberModify(Member m, HttpSession session, Model model) { // 민지
		int result = mService.confirmMember(m);
		
		if(result > 0) {			
			return "mypage/memberInfoView";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value="pointList.do")
	public ModelAndView pointList(ModelAndView mv, Integer memberNo) { // 민지
		ArrayList<Point> list = mService.selectPointList(memberNo);
		
		System.out.println("적립금 내역  : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/pointList");
		} else {
			throw new MemberException("적립금내역 리스트 불러오기 실패");
		}
		
		return mv;
	}
	
	@RequestMapping(value="reviewList.do")
	public ModelAndView reviewList(ModelAndView mv, Integer memberNo) { // 민지
		ArrayList<Review> list = mService.selectReviewList(memberNo);
		
		System.out.println("리뷰 내역  : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/review");
		} else {
			throw new MemberException("리뷰 리스트 불러오기 실패");
		}
		
		return mv;
	}
	
//	@RequestMapping(value="inquiryList.do")
//	public ModelAndView inquiryList(ModelAndView mv, Integer memberNo) {
//		ArrayList<>
//	}
	
	@RequestMapping(value="exchangeList.do")
	public ModelAndView exchangeList(ModelAndView mv, Integer memberNo) { // 민지
		ArrayList<Exchange> list = mService.selectExchangeList(memberNo);
		
		System.out.println("교환 내역 : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/exchange");
		} else {
			throw new MemberException("교환 리스트 불러오기 실패");
		}
		
		return mv;
	}
	
	@RequestMapping(value="deliveryList.do")
	public ModelAndView deliveryList(ModelAndView mv, Integer memberNo) { // 민지
		ArrayList<Delivery> list = mService.selectDeliveryList(memberNo);
		
		System.out.println("배송 내역 : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/delivery");
		} else {
			throw new MemberException("배송 리스트 불러오기 실패");
		}
		
		return mv;
	}

	@RequestMapping(value="cartList.do")
	public ModelAndView cartList(ModelAndView mv, Integer memberNo) { // 민지
		ArrayList<Cart> list = mService.selectCartList(memberNo);
		
		System.out.println("장바구니 내역 : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/cart");
		} else {
			throw new MemberException("장바구니 리스트 불러오기 실패");
		}
		
		return mv;
	}
	
	@RequestMapping("exchangeInsert.do")
	public String exchangeInsert(HttpServletRequest request, Exchange e) { // 민지
		
		if(e.getExchangeCategory() == 1) {
			e.setExchangeContent("품질불량");
		} else if(e.getExchangeCategory() == 2) {
			e.setExchangeContent("오배송");
		} 
		
		System.out.println("교환 내용 : " + e);
		
		int result = mService.insertExchange(e);
		int result2 = mService.updateSubscribe(e.getSubscribeNo());
		
		if(result > 0 && result2 > 0) {
			return "redirect:exchangeList.do";
		} else {
			throw new MemberException("교환 신청 실패");
		}
	}
	
	@RequestMapping("reviewDelete.do")
	public String reviewDelete(HttpServletRequest request, Integer reviewNo) {// 민지
//		Review review = mService.selectReview(reviewNo); 
		
		int result = mService.deleteReview(reviewNo);
		
		if(result > 0) {
			return "redirect:reviewList.do";
		} else {
			throw new MemberException("리뷰 삭제 실패");
		}
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
