package com.kh.finalGudok.Board.model.vo;

import java.io.Serializable;

public class BoardCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 371112303266896464L;

	private String Board_code;	// 게시물 코드
	private String Board_name; // 게시물 이름
	
	public BoardCode() {
	}

	public BoardCode(String bBoard_code, String bBoard_name) {
		this.Board_code = bBoard_code;
		this.Board_name = bBoard_name;
	}

	public String getbBoard_code() {
		return Board_code;
	}

	public void setbBoard_code(String bBoard_code) {
		this.Board_code = bBoard_code;
	}

	public String getbBoard_name() {
		return Board_name;
	}

	public void setbBoard_name(String bBoard_name) {
		this.Board_name = bBoard_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BoardCode [Board_code=" + Board_code + ", Board_name=" + Board_name + "]";
	}
	
	
		
}
