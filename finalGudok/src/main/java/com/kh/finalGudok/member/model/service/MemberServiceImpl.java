package com.kh.finalGudok.member.model.service;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.member.model.dao.MemberDao;

import com.kh.finalGudok.member.model.vo.Cart;
import com.kh.finalGudok.member.model.vo.DeleteHeart;
import com.kh.finalGudok.member.model.vo.Delivery;
import com.kh.finalGudok.member.model.vo.Exchange;
import com.kh.finalGudok.member.model.vo.Heart;
import com.kh.finalGudok.member.model.vo.Inquiry;

import com.kh.finalGudok.member.model.vo.Member;

import com.kh.finalGudok.member.model.vo.Point;
import com.kh.finalGudok.member.model.vo.Reply;
import com.kh.finalGudok.member.model.vo.Review;
import com.kh.finalGudok.member.model.vo.Withdrawal;

@Service("mService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao mDao;

	@Override
	public Member loginMember(Member m) {
		return mDao.loginMember(m);
	}

	// 마이페이지
	@Override
	public Member confirmMember(Member m) {
		return mDao.confirmMember(m);
	}

	@Override
	public ArrayList<Point> selectPointList(Integer memberNo) {
		return mDao.selectPointList(memberNo);
	}

	@Override
	public ArrayList<Review> selectReviewList(Integer memberNo) {
		return mDao.selectReviewList(memberNo);
	}

	@Override
	public ArrayList<Exchange> selectExchangeList(Integer memberNo) {
		return mDao.selectExchangeList(memberNo);
	}
//
//	@Override
//	public ArrayList<Delivery> selectDeliveryList(Integer memberNo) {
//		return mDao.selectDeliveryList(memberNo);
//	}
//
//	@Override
//	public ArrayList<Cart> selectCartList(Integer memberNo) {
//		return mDao.selectCartList(memberNo);
//	}
//
//	@Override
//	public int insertExchange(Exchange e) {
//		return mDao.insertExchange(e);
//	}

	@Override
	public int checkIdDup(String memberId) {
		return mDao.checkIdDup(memberId);
	}

	@Override
	public int insertMember(Member m) {
		return mDao.insertMember(m);
	}

	@Override
	public int emailDupCheck(String email) {
		
		return mDao.emailDupCheck(email);
	}

	@Override
	public ArrayList<Delivery> selectDeliveryList(Integer memberNo) {
		return mDao.selectDeliveryList(memberNo);
	}

	@Override
	public ArrayList<Cart> selectCartList(Integer memberNo) {
		return mDao.selectCartList(memberNo);
	}

	@Override
	public int insertExchange(Exchange e) {
		return mDao.insertExchange(e);
	}

	@Override
	public int updateSubscribe(int subscribeNo) {
		return mDao.updateSubscribe(subscribeNo);
	}

	@Override
	public Review selectReview(Integer reviewNo) {
		return mDao.selectReview(reviewNo);
	}

	@Override
	public int deleteReview(Integer reviewNo) {
		return mDao.deleteReview(reviewNo);
	}

	@Override
	public int updateMember(Member m) {
		return mDao.updateMember(m);
	}

	@Override
	public int updateMemberStatus(int memberNo) {
		return mDao.updateMemberStatus(memberNo);
	}

	@Override
	public int insertSecession(Withdrawal w) {
		return mDao.insertSecession(w);
	}

	@Override
	public ArrayList<Inquiry> selectInquiryList(Integer memberNo) {
		return mDao.selectInquiryList(memberNo);
	}

	@Override
	public ArrayList<Heart> selectHeartList(Integer memberNo) {
		return mDao.selectHeartList(memberNo);
	}

	@Override
	public int deleteHeart(DeleteHeart dh) {
		return mDao.deleteHeart(dh);
	}

	@Override
	public Item selectItem(int itemNo) {
		return mDao.selectItem(itemNo);
	}

	@Override
	public int addCart(HashMap map) {
		return mDao.addCart(map);
	}

	@Override
	public Reply selectReply(Integer boardNo) {
		return mDao.selectReply(boardNo);
	}

	@Override
	public int deleteCart(HashMap map) {
		return mDao.deleteCart(map);
	}



}
