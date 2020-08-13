package com.kh.finalGudok.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalGudok.member.model.dao.MemberDao;
import com.kh.finalGudok.member.model.vo.Cart;
import com.kh.finalGudok.member.model.vo.Delivery;
import com.kh.finalGudok.member.model.vo.Exchange;
import com.kh.finalGudok.member.model.vo.Member;
import com.kh.finalGudok.member.model.vo.Point;
import com.kh.finalGudok.member.model.vo.Review;

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
	public int confirmMember(Member m) {
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
}
