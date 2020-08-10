package com.kh.finalGudok.Board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ServiceCenterBoard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5093762690289456321L;

	private int scMember_no;		// 게시한 회원 번호
	private String scMember_id;		// 게시한 회원 아이디
	private String scEmail;			// 게시한 회원 이메일
	private int scItem_no;			// 상품 번호
	private String scBoard_code;	// 게시물 코드
	private int scBoard_no;			// 게시물 번호
	private String scTitle;			// 제목
	private String scContent;		// 내용
	private Date scWrite_date;		// 작성일자
	private int scRead_num;			// 조회수
	
	public ServiceCenterBoard() {
	}

	public ServiceCenterBoard(int scMember_no, String scMember_id, String scEmail, int scItem_no, String scBoard_code,
			int scBoard_no, String scTitle, String scContent, Date scWrite_date, int scRead_num) {
		this.scMember_no = scMember_no;
		this.scMember_id = scMember_id;
		this.scEmail = scEmail;
		this.scItem_no = scItem_no;
		this.scBoard_code = scBoard_code;
		this.scBoard_no = scBoard_no;
		this.scTitle = scTitle;
		this.scContent = scContent;
		this.scWrite_date = scWrite_date;
		this.scRead_num = scRead_num;
	}

	public int getScMember_no() {
		return scMember_no;
	}

	public void setScMember_no(int scMember_no) {
		this.scMember_no = scMember_no;
	}

	public String getScMember_id() {
		return scMember_id;
	}

	public void setScMember_id(String scMember_id) {
		this.scMember_id = scMember_id;
	}

	public String getScEmail() {
		return scEmail;
	}

	public void setScEmail(String scEmail) {
		this.scEmail = scEmail;
	}

	public int getScItem_no() {
		return scItem_no;
	}

	public void setScItem_no(int scItem_no) {
		this.scItem_no = scItem_no;
	}

	public String getScBoard_code() {
		return scBoard_code;
	}

	public void setScBoard_code(String scBoard_code) {
		this.scBoard_code = scBoard_code;
	}

	public int getScBoard_no() {
		return scBoard_no;
	}

	public void setScBoard_no(int scBoard_no) {
		this.scBoard_no = scBoard_no;
	}

	public String getScTitle() {
		return scTitle;
	}

	public void setScTitle(String scTitle) {
		this.scTitle = scTitle;
	}

	public String getScContent() {
		return scContent;
	}

	public void setScContent(String scContent) {
		this.scContent = scContent;
	}

	public Date getScWrite_date() {
		return scWrite_date;
	}

	public void setScWrite_date(Date scWrite_date) {
		this.scWrite_date = scWrite_date;
	}

	public int getScRead_num() {
		return scRead_num;
	}

	public void setScRead_num(int scRead_num) {
		this.scRead_num = scRead_num;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ServiceCenter [scMember_no=" + scMember_no + ", scMember_id=" + scMember_id + ", scEmail=" + scEmail
				+ ", scItem_no=" + scItem_no + ", scBoard_code=" + scBoard_code + ", scBoard_no=" + scBoard_no
				+ ", scTitle=" + scTitle + ", scContent=" + scContent + ", scWrite_date=" + scWrite_date
				+ ", scRead_num=" + scRead_num + "]";
	}
	
	
	
}
