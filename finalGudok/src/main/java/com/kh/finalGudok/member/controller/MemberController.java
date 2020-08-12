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

@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
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
			return "home";
		}
	}
	
	@RequestMapping(value="memberModify.do", method=RequestMethod.POST)
	public String memberModify(Member m, HttpSession session, Model model) {
		int result = mService.confirmMember(m);
		
		if(result > 0) {			
			return "mypage/memberInfoView";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value="pointList.do")
	public ModelAndView pointList(ModelAndView mv, Integer memberNo) {
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
	public ModelAndView reviewList(ModelAndView mv, Integer memberNo) {
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
	public ModelAndView exchangeList(ModelAndView mv, Integer memberNo) {
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
	public ModelAndView deliveryList(ModelAndView mv, Integer memberNo) {
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
	public ModelAndView cartList(ModelAndView mv, Integer memberNo) {
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
	public String exchangeInsert(HttpServletRequest request, Exchange e) {
		System.out.println("교환 내용 : " + e);
		
		if(e.getExchangeCategory() == 1) {
			e.setExchangeContent("");
		} else if(e.getExchangeCategory() == 2) {
			e.setExchangeContent("");
		} 
		
//		int result = mService.insertExchange(e);
//		
//		if(result > 0) {
//			return "redirect:exchangeList.do";
//		} else {
//			throw new MemberException("교환 신청 실패");
//		}
		
		return "home";
	}
	
}

