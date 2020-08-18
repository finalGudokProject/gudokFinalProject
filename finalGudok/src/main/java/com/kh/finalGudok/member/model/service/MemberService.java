package com.kh.finalGudok.member.model.service;

import java.util.ArrayList;

import com.kh.finalGudok.member.model.vo.Member;

//import com.kh.finalGudok.member.model.vo.Cart;
//import com.kh.finalGudok.member.model.vo.Delivery;
//import com.kh.finalGudok.member.model.vo.Exchange;
//import com.kh.finalGudok.member.model.vo.Member;
//import com.kh.finalGudok.member.model.vo.Point;
//import com.kh.finalGudok.member.model.vo.Review;

public interface MemberService {

	Member loginMember(Member m);

	// 마이페이지
	int confirmMember(Member m);

//	ArrayList<Point> selectPointList(Integer memberNo);
//
//	ArrayList<Review> selectReviewList(Integer memberNo);
//
//	ArrayList<Exchange> selectExchangeList(Integer memberNo);
//
//	ArrayList<Delivery> selectDeliveryList(Integer memberNo);
//
//	ArrayList<Cart> selectCartList(Integer memberNo);
//
//	int insertExchange(Exchange e);

	int checkIdDup(String id);

	int insertMember(Member m);

	int emailDupCheck(String email);

}