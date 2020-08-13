package com.kh.finalGudok.board.model.vo;

import java.io.Serializable;

public class InquiryType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5671494292551683273L;

	private String Board_Type;	// 문의 유형
	private String Inquiry_name;	// 문의명
	
	public InquiryType() {
	}

	public InquiryType(String itBoard_Type, String itInquiry_name) {
		this.Board_Type = itBoard_Type;
		this.Inquiry_name = itInquiry_name;
	}

	public String getItBoard_Type() {
		return Board_Type;
	}

	public void setItBoard_Type(String itBoard_Type) {
		this.Board_Type = itBoard_Type;
	}

	public String getItInquiry_name() {
		return Inquiry_name;
	}

	public void setItInquiry_name(String itInquiry_name) {
		this.Inquiry_name = itInquiry_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "InquiryType [Board_Type=" + Board_Type + ", Inquiry_name=" + Inquiry_name + "]";
	}
	
	
}
