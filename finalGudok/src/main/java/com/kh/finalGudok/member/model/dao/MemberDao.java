package com.kh.finalGudok.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalGudok.member.model.vo.Member;

import java.util.ArrayList;

//import com.kh.finalGudok.member.model.vo.Cart;
//import com.kh.finalGudok.member.model.vo.Delivery;
//import com.kh.finalGudok.member.model.vo.Exchange;
//import com.kh.finalGudok.member.model.vo.Point;
//import com.kh.finalGudok.member.model.vo.Review;

@Repository("mDao")
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Member loginMember(Member m) {
		return sqlSessionTemplate.selectOne("memberMapper.selectOne", m);
	}

	// 마이페이지
	public int confirmMember(Member m) {
		return sqlSessionTemplate.selectOne("memberMapper.memberConfirm", m);
	}

//	public ArrayList<Point> selectPointList(Integer memberNo) {
//		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.pointList", memberNo);
//	}
//
//	public ArrayList<Review> selectReviewList(Integer memberNo) {
//		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.reviewList", memberNo);
//	}
//
//	public ArrayList<Exchange> selectExchangeList(Integer memberNo) {
//		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.exchangeList", memberNo);
//	}
//
//	public ArrayList<Delivery> selectDeliveryList(Integer memberNo) {
//		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.deliveryList", memberNo);
//	}
//
//	public ArrayList<Cart> selectCartList(Integer memberNo) {
//		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.cartList", memberNo);
//	}
//
//	public int insertExchange(Exchange e) {
//		return sqlSessionTemplate.insert("memberMapper.insertExchange", e);
//	}

	public int checkIdDup(String memberId) {
		return sqlSessionTemplate.selectOne("memberMapper.idCheck", memberId);
	}

	public int insertMember(Member m) {
		return sqlSessionTemplate.insert("memberMapper.insertMember", m);
	}

	public int emailDupCheck(String email) {
		return sqlSessionTemplate.selectOne("memberMapper.emailDupCheck",email);
	}

	public String findId(Member m) {
		return sqlSessionTemplate.selectOne("memberMapper.findId", m);
	}

	public int checkMember(Member m) {

		return sqlSessionTemplate.selectOne("memberMapper.checkMember",m);
	}

	public int changePwd(Member m) {
		
		return sqlSessionTemplate.update("memberMapper.changePwd",m);
	}
}