package com.kh.finalGudok.member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.member.model.vo.AdminMember;
import com.kh.finalGudok.member.model.vo.AdminPayment;
import com.kh.finalGudok.member.model.vo.AdminSecession;
import com.kh.finalGudok.member.model.vo.Cart;
import com.kh.finalGudok.member.model.vo.DeleteHeart;
import com.kh.finalGudok.member.model.vo.Delivery;
import com.kh.finalGudok.member.model.vo.Exchange;
import com.kh.finalGudok.member.model.vo.Grade;
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

	public String findId(Member m) {
		return sqlSessionTemplate.selectOne("memberMapper.findId", m);
	}

	public int checkMember(Member m) {

		return sqlSessionTemplate.selectOne("memberMapper.checkMember",m);
	}

	public int changePwd(Member m) {
		
		return sqlSessionTemplate.update("memberMapper.changePwd",m);
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

	public ArrayList<Grade> selectGradeList() {
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.selectGradeList");
	}

	public int selectMemberCnt() {
		return sqlSessionTemplate.selectOne("memberMapper.selectMemberCnt");
	}

	public Integer selectGradeCnt(int i) {
		return sqlSessionTemplate.selectOne("memberMapper.selectGradeCnt",i);
	}

	public ArrayList<AdminMember> selectMemberN(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.selectMemberN",null,rowBounds);
	}

	public int updateGradeRate(ArrayList<Grade> g) {
		return sqlSessionTemplate.update("memberMapper.updateGradeRate",g);
	}

	public int updateGradeMin(ArrayList<Grade> g) {
		return sqlSessionTemplate.update("memberMapper.updateGradeMin",g);
	}

	public AdminMember selectOneMember(int memberNo) {
		return sqlSessionTemplate.selectOne("memberMapper.selectOneMember",memberNo);
	}

	public ArrayList<AdminPayment> selectMemberPay(int memberNo, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.selectMemberPay",memberNo,rowBounds);
	}

	public int selectMemberPayCnt(int memberNo) {
		return sqlSessionTemplate.selectOne("memberMapper.selectMemberPayCnt",memberNo);
	}

	public Integer selectTotalPay(int i) {
		return sqlSessionTemplate.selectOne("memberMapper.selectTotalPay",i);
	}

	public int updateMemberA(AdminMember m) {
		return sqlSessionTemplate.update("memberMapper.updateMemberA",m);
	}

	public int deleteMemberA(Integer memberNo) {
		return sqlSessionTemplate.delete("memberMapper.deleteMemberA",memberNo);
	}

	public int deleteMemberSecession(Integer memberNo) {
		return sqlSessionTemplate.delete("memberMapper.deleteMemberSecession",memberNo);
	}

	public int deleteMemberBoard(Integer memberNo) {
		return sqlSessionTemplate.delete("memberMapper.deleteMemberBoard",memberNo);
	}

	public int deleteMemberHeart(Integer memberNo) {
		return sqlSessionTemplate.delete("memberMapper.deleteMemberHeart",memberNo);
	}

	public int deleteMemberCart(Integer memberNo) {
		return sqlSessionTemplate.delete("memberMapper.deleteMemberCart",memberNo);
	}
	
	public int deleteMemberReview(Integer memberNo) {
		return sqlSessionTemplate.delete("memberMapper.deleteMemberReview",memberNo);
	}

	public int deleteMemberPayment(Integer memberNo) {
		return sqlSessionTemplate.delete("memberMapper.deleteMemberPayment",memberNo);
	}

	public int deleteMemberSubscribe(Integer memberNo) {
		return sqlSessionTemplate.delete("memberMapper.deleteMemberSubscribe",memberNo);
	}

	public Integer selectSecessionCnt(AdminSecession s) {
		return sqlSessionTemplate.selectOne("memberMapper.selectSecessionCnt",s);
	}

	public Integer selectMemberSecessionCnt(AdminSecession s) {
		return sqlSessionTemplate.selectOne("memberMapper.selectMemberSecessionCnt",s);
	}

	public ArrayList<AdminSecession> selectMemberSecession(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.selectMemberSecession",null,rowBounds);
	}
}
