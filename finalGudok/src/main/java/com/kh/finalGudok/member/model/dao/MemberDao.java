package com.kh.finalGudok.member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalGudok.item.model.vo.Item;
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

@Repository("mDao")
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Member loginMember(Member m) {
		return sqlSessionTemplate.selectOne("memberMapper.selectOne", m);
	}

	// 마이페이지
	public Member confirmMember(Member m) {
		return sqlSessionTemplate.selectOne("memberMapper.memberConfirm", m);
	}

	public ArrayList<Point> selectPointList(Integer memberNo) {
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.pointList", memberNo);
	}

	public ArrayList<Review> selectReviewList(Integer memberNo) {
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.reviewList", memberNo);
	}

	public ArrayList<Exchange> selectExchangeList(Integer memberNo) {
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.exchangeList", memberNo);
	}

	public ArrayList<Delivery> selectDeliveryList(Integer memberNo) {
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.deliveryList", memberNo);
	}

	public ArrayList<Cart> selectCartList(Integer memberNo) {
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.cartList", memberNo);
	}

	public int insertExchange(Exchange e) {
		return sqlSessionTemplate.insert("memberMapper.insertExchange", e);
	}

	public int checkIdDup(String memberId) {
		return sqlSessionTemplate.selectOne("memberMapper.idCheck", memberId);
	}

	public int insertMember(Member m) {
		return sqlSessionTemplate.insert("memberMapper.insertMember", m);
	}

	public int emailDupCheck(String email) {
		return sqlSessionTemplate.selectOne("memberMapper.emailDupCheck",email);
	}

	public int updateSubscribe(int subscribeNo) {
		return sqlSessionTemplate.update("memberMapper.updateSubscribe", subscribeNo);
	}

	public Review selectReview(Integer reviewNo) {
		return sqlSessionTemplate.selectOne("memberMapper.selectReview", reviewNo);
	}

	public int deleteReview(Integer reviewNo) {
		return sqlSessionTemplate.delete("memberMapper.deleteReview", reviewNo);
	}

	public int updateMember(Member m) {
		return sqlSessionTemplate.update("memberMapper.updateMember", m);
	}

	public int insertSecession(Withdrawal w) {
		return sqlSessionTemplate.insert("memberMapper.insertSecession", w);
	}

	public int updateMemberStatus(int memberNo) {
		return sqlSessionTemplate.update("memberMapper.updateMemberStatus", memberNo);
	}

	public ArrayList<Inquiry> selectInquiryList(Integer memberNo) {
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.selectInquiryList", memberNo);
	}

	public ArrayList<Heart> selectHeartList(Integer memberNo) {
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.selectHeartList", memberNo);
	}

	public int deleteHeart(DeleteHeart dh) {
		return sqlSessionTemplate.delete("memberMapper.deleteHeart", dh);
	}

	public Item selectItem(int itemNo) {
		return sqlSessionTemplate.selectOne("memberMapper.selectItem", itemNo);
	}

	public int addCart(HashMap map) {
		return sqlSessionTemplate.insert("memberMapper.insertCart", map);
	}

	public Reply selectReply(Integer boardNo) {
		return sqlSessionTemplate.selectOne("memberMapper.selectReply", boardNo);
	}

	public int deleteCart(HashMap map) {
		return sqlSessionTemplate.delete("memberMapper.deleteCart", map);
	}

	public int updatePassword(Member m) {
		return sqlSessionTemplate.update("memberMapper.updatePassword", m);
	}
}
