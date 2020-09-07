package com.kh.finalGudok.board.model.vo;

import java.io.Serializable;

public class secret implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -649241899205567546L;
	
	private int oBoard_no;			// ����� �Խù� ��ȣ
	private String oSecret;			// ���� ����
	private String oSecret_pwd;	    // ��й�ȣ
	
	public secret() {
	}

	public secret(int oBoard_no, String oSecret, String oSecret_pwd) {
		this.oBoard_no = oBoard_no;
		this.oSecret = oSecret;
		this.oSecret_pwd = oSecret_pwd;
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

	public String getoSecret_pwd() {
		return oSecret_pwd;
	}

	public void setoSecret_pwd(String oSecret_pwd) {
		this.oSecret_pwd = oSecret_pwd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "secret [oBoard_no=" + oBoard_no + ", oSecret=" + oSecret + ", oSecret_pwd=" + oSecret_pwd + "]";
	}

	
}
