package com.kh.finalGudok.Board.model.vo;

import java.io.Serializable;

public class OneOnOneInquiryBoard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -649241899205567546L;
	
	private int oBoard_no;			// 비공개 게시물 번호
	private String oSecret;			// 공개 여부
	private String oSercret_pwd;	// 비밀번호
	
	public OneOnOneInquiryBoard() {
	}

	public OneOnOneInquiryBoard(int oBoard_no, String oSecret, String oSercret_pwd) {
		this.oBoard_no = oBoard_no;
		this.oSecret = oSecret;
		this.oSercret_pwd = oSercret_pwd;
	}

	public int getoBoard_no() {
		return oBoard_no;
	}

	public void setoBoard_no(int oBoard_no) {
		this.oBoard_no = oBoard_no;
	}

	public String getoSecret() {
		return oSecret;
	}

	public void setoSecret(String oSecret) {
		this.oSecret = oSecret;
	}

	public String getoSercret_pwd() {
		return oSercret_pwd;
	}

	public void setoSercret_pwd(String oSercret_pwd) {
		this.oSercret_pwd = oSercret_pwd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OneOnOneInquiryBoard [oBoard_no=" + oBoard_no + ", oSecret=" + oSecret + ", oSercret_pwd="
				+ oSercret_pwd + "]";
	}
	
	
}
