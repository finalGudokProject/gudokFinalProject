package com.kh.finalGudok.Board.model.vo;

import java.io.Serializable;

public class Image implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8372894494864334773L;

	private String image_no;	// 이미지 번호
	private String image_path;	// 경로
	private String image_name;	// 파일명
	
	public Image() {
	}

	public Image(String image_no, String image_path, String image_name) {
		this.image_no = image_no;
		this.image_path = image_path;
		this.image_name = image_name;
	}

	public String getImage_no() {
		return image_no;
	}

	public void setImage_no(String image_no) {
		this.image_no = image_no;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Image [image_no=" + image_no + ", image_path=" + image_path + ", image_name=" + image_name + "]";
	}
	
	
}
