package com.kh.finalGudok.board.model.vo;

import java.io.Serializable;

public class EventBoard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -649241899205567546L;

	private int eBoard_no;		// �Խù� ��ȣ
	private String eE_status; 	// �Խ� ����
	
	public EventBoard() {
	}

	public EventBoard(int eBoard_no, String eE_status) {
		this.eBoard_no = eBoard_no;
		this.eE_status = eE_status;
	}

	
	public EventBoard(int eBoard_no) {
		super();
		this.eBoard_no = eBoard_no;
	}

	public int geteBoard_no() {
		return eBoard_no;
	}

	public void seteBoard_no(int eBoard_no) {
		this.eBoard_no = eBoard_no;
	}

	public String geteE_status() {
		return eE_status;
	}

	public void seteE_status(String eE_status) {
		this.eE_status = eE_status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EventBoard [eBoard_no=" + eBoard_no + ", eE_status=" + eE_status + "]";
	}
	
	
}
