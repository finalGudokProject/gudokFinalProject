package com.kh.finalGudok.member.model.vo;

import java.io.Serializable;

public class Heart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4631523059183129200L;
	
	private int heartNo;
	private int itemNo;
	private int memberNo;
	private int itemPrice;
	
	public Heart() {}

	public Heart(int heartNo, int itemNo, int memberNo) {
		this.heartNo = heartNo;
		this.itemNo = itemNo;
		this.memberNo = memberNo;
	}

	public int getHeartNo() {
		return heartNo;
	}

	public void setHeartNo(int heartNo) {
		this.heartNo = heartNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Heart [heartNo=" + heartNo + ", itemNo=" + itemNo + ", memberNo=" + memberNo + "]";
	}
}
