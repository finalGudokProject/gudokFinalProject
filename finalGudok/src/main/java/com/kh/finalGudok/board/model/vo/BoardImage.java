package com.kh.finalGudok.board.model.vo;

import java.io.Serializable;

public class BoardImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8065379195380922835L;

	private int biBoardImage_no;	// 게시물 이미지 번호
	private int biBoard_no;			// 게시물 번호
	private String biB_image_no;	// 이미지 번호
	
	public BoardImage() {
	}

	public BoardImage(int biBoardImage_no, int biBoard_no, String biB_image_no) {
		this.biBoardImage_no = biBoardImage_no;
		this.biBoard_no = biBoard_no;
		this.biB_image_no = biB_image_no;
	}

	public int getBiBoardImage_no() {
		return biBoardImage_no;
	}

	public void setBiBoardImage_no(int biBoardImage_no) {
		this.biBoardImage_no = biBoardImage_no;
	}

	public int getBiBoard_no() {
		return biBoard_no;
	}

	public void setBiBoard_no(int biBoard_no) {
		this.biBoard_no = biBoard_no;
	}

	public String getBiB_image_no() {
		return biB_image_no;
	}

	public void setBiB_image_no(String biB_image_no) {
		this.biB_image_no = biB_image_no;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BoardImage [biBoardImage_no=" + biBoardImage_no + ", biBoard_no=" + biBoard_no + ", biB_image_no="
				+ biB_image_no + "]";
	}
	
	
}
