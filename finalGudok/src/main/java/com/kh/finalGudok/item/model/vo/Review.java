package com.kh.finalGudok.item.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3087143130105098134L;
	private int reviewNo;
	private int itemNo;
	private String reviewContent;
	private String reviewRate;
	private String reviewImg1;
	private String reviewImg2;
	private Date reviewDate;
	private Date reviewModify;
	private int memberNo;
	private String memberId;
	private String email;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewNo, int itemNo, String reviewContent, String reviewRate, String reviewImg1,
			String reviewImg2, Date reviewDate, Date reviewModify, int memberNo, String memberId, String email) {
		super();
		this.reviewNo = reviewNo;
		this.itemNo = itemNo;
		this.reviewContent = reviewContent;
		this.reviewRate = reviewRate;
		this.reviewImg1 = reviewImg1;
		this.reviewImg2 = reviewImg2;
		this.reviewDate = reviewDate;
		this.reviewModify = reviewModify;
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.email = email;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewRate() {
		return reviewRate;
	}

	public void setReviewRate(String reviewRate) {
		this.reviewRate = reviewRate;
	}

	public String getReviewImg1() {
		return reviewImg1;
	}

	public void setReviewImg1(String reviewImg1) {
		this.reviewImg1 = reviewImg1;
	}

	public String getReviewImg2() {
		return reviewImg2;
	}

	public void setReviewImg2(String reviewImg2) {
		this.reviewImg2 = reviewImg2;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Date getReviewModify() {
		return reviewModify;
	}

	public void setReviewModify(Date reviewModify) {
		this.reviewModify = reviewModify;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", itemNo=" + itemNo + ", reviewContent=" + reviewContent
				+ ", reviewRate=" + reviewRate + ", reviewImg1=" + reviewImg1 + ", reviewImg2=" + reviewImg2
				+ ", reviewDate=" + reviewDate + ", reviewModify=" + reviewModify + ", memberNo=" + memberNo
				+ ", memberId=" + memberId + ", email=" + email + "]";
	}

	

	
	

}
