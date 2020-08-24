package com.kh.finalGudok.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.member.model.vo.Cart;
import com.kh.finalGudok.member.model.vo.DeleteHeart;
import com.kh.finalGudok.member.model.vo.Delivery;
import com.kh.finalGudok.member.model.vo.Exchange;
import com.kh.finalGudok.member.model.vo.Grade;
import com.kh.finalGudok.member.model.vo.Heart;
import com.kh.finalGudok.member.model.vo.Member;
import com.kh.finalGudok.member.model.vo.Point;
import com.kh.finalGudok.member.model.vo.Reply;
import com.kh.finalGudok.member.model.vo.Review;
import com.kh.finalGudok.member.model.vo.Withdrawal;
import com.kh.finalGudok.member.model.vo.AdminMember;
import com.kh.finalGudok.member.model.vo.AdminPayment;
import com.kh.finalGudok.member.model.vo.AdminSecession;
import com.kh.finalGudok.member.model.vo.Inquiry;

public interface MemberService {

	Member loginMember(Member m);

	// 마이페이지
	Member confirmMember(Member m);

	ArrayList<Point> selectPointList(Integer memberNo);

	ArrayList<Review> selectReviewList(Integer memberNo);

	ArrayList<Exchange> selectExchangeList(Integer memberNo);

	ArrayList<Delivery> selectDeliveryList(Integer memberNo);

	ArrayList<Cart> selectCartList(Integer memberNo);

	int insertExchange(Exchange e);

	int checkIdDup(String id);

	int insertMember(Member m);

	int emailDupCheck(String email);

	int updateSubscribe(int subscribeNo);

	Review selectReview(Integer reviewNo);

	int deleteReview(Integer reviewNo);

	int updateMember(Member m);

	int insertSecession(Withdrawal w);

	int updateMemberStatus(int memberNo);

	ArrayList<Inquiry> selectInquiryList(Integer memberNo);

	ArrayList<Heart> selectHeartList(Integer memberNo);
	
	int deleteHeart(DeleteHeart dh);

	Item selectItem(int itemNo);

	int addCart(HashMap map);

	Reply selectReply(Integer boardNo);

	int deleteCart(HashMap map);

	int updatePassword(Member m);
	
	ArrayList<Grade> selectGradeList();

	int getMemberCnt();

	Integer selectGradeCnt(int i);

	ArrayList<AdminMember> selectMemberN(PageInfo pi);

	int updateGradeRate(ArrayList<Grade> g);

	int updateGradeMin(ArrayList<Grade> g);

	AdminMember selectOneMember(int memberNo);

	ArrayList<AdminPayment> selectMemberPay(int memberNo, PageInfo pi);

	int getMemberPayCnt(int memberNo);

	Integer selectTotalPay(int i);

	int updateMemberA(AdminMember m);

	int deleteMemberA(Integer memberNo);

	int deleteMemberSecession(Integer memberNo);

	int deleteMemberBoard(Integer memberNo);

	int deleteMemberHeart(Integer memberNo);

	int deleteMemberCart(Integer memberNo);

	int deleteMemberReview(Integer memberNo);

	int deleteMemberPayment(Integer memberNo);

	int deleteMemberSubscribe(Integer memberNo);

	Integer selectSecessionCnt(AdminSecession s);

	Integer selectMemberSecessionCnt(AdminSecession s);

	ArrayList<AdminSecession> selectMemberSecession(PageInfo pi);

	String findId(Member m);

	int checkMember(Member m);

	int changePwd(Member m);

}