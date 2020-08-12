package com.kh.finalGudok.item.model.vo;

import java.io.Serializable;

public class Sort implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6102233108925222790L;
	
	private String F1;
	private String F2;
	private String F3;
	private String F4;
	private String F5;
	private String F6;
	
	public Sort() {
		// TODO Auto-generated constructor stub
	}

	public Sort(String f1, String f2, String f3, String f4, String f5, String f6) {
		super();
		F1 = f1;
		F2 = f2;
		F3 = f3;
		F4 = f4;
		F5 = f5;
		F6 = f6;
	}

	public String getF1() {
		return F1;
	}

	public void setF1(String f1) {
		F1 = f1;
	}

	public String getF2() {
		return F2;
	}

	public void setF2(String f2) {
		F2 = f2;
	}

	public String getF3() {
		return F3;
	}

	public void setF3(String f3) {
		F3 = f3;
	}

	public String getF4() {
		return F4;
	}

	public void setF4(String f4) {
		F4 = f4;
	}

	public String getF5() {
		return F5;
	}

	public void setF5(String f5) {
		F5 = f5;
	}

	public String getF6() {
		return F6;
	}

	public void setF6(String f6) {
		F6 = f6;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Sort [F1=" + F1 + ", F2=" + F2 + ", F3=" + F3 + ", F4=" + F4 + ", F5=" + F5 + ", F6=" + F6 + "]";
	}
	
}
