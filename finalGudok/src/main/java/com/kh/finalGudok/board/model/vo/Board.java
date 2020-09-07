package com.kh.finalGudok.board.model.vo;

import java.io.Serializable;
import java.sql.Date;


public class Board implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5093762690289456321L;

	private int bMember_no;		// �Խ��� ȸ�� ��ȣ
	private String bMember_id;		// �Խ��� ȸ�� ���̵�
	private String bEmail;			// �Խ��� ȸ�� �̸���
	private String bBoard_code;		// �Խù� �ڵ�
	private int bBoard_no;			// �Խù� ��ȣ
	private String bTitle;			// ����
	private String bContent;		// ����
	private int bRead_num;			// ��ȸ��
	private String originalFileName;// �̹��� �����̸�
	private String renameFileName;	// �̹��� �����̸�
	private String imagePath;		// �̹��� ���
	private int bItem_no;			// ��ǰ��ȣ
	private int rownum;				// �Խù� ��ȣ ������ ���� rownum
	
	private Date bWrite_date;		// �ۼ�����

	public Board() {
	}

	public Board(int bMember_no, String bMember_id, String bEmail, String bBoard_code, int bBoard_no, String bTitle,
			String bContent, Date bWrite_date, int bRead_num, String originalFileName, String renameFileName,
			String imagePath, int bItem_no, int rownum) {
		this.bMember_no = bMember_no;
		this.bMember_id = bMember_id;
		this.bEmail = bEmail;
		this.bBoard_code = bBoard_code;
		this.bBoard_no = bBoard_no;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWrite_date = bWrite_date;
		this.bRead_num = bRead_num;
		this.originalFileName = originalFileName;
		this.renameFileName = renameFileName;
		this.imagePath = imagePath;
		this.bItem_no = bItem_no;
		this.rownum = rownum;
	}

	public int getbMember_no() {
		return bMember_no;
	}

	public void setbMember_no(int bMember_no) {
		this.bMember_no = bMember_no;
	}

	public String getbMember_id() {
		return bMember_id;
	}

	public void setbMember_id(String bMember_id) {
		this.bMember_id = bMember_id;
	}

	public String getbEmail() {
		return bEmail;
	}

	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}

	public String getbBoard_code() {
		return bBoard_code;
	}

	public void setbBoard_code(String bBoard_code) {
		this.bBoard_code = bBoard_code;
	}

	public int getbBoard_no() {
		return bBoard_no;
	}

	public void setbBoard_no(int bBoard_no) {
		this.bBoard_no = bBoard_no;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Date getbWrite_date() {
		return bWrite_date;
	}

	public void setbWrite_date(Date bWrite_date) {
		this.bWrite_date = bWrite_date;
	}

	public int getbRead_num() {
		return bRead_num;
	}

	public void setbRead_num(int bRead_num) {
		this.bRead_num = bRead_num;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getRenameFileName() {
		return renameFileName;
	}

	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getbItem_no() {
		return bItem_no;
	}

	public void setbItem_no(int bItem_no) {
		this.bItem_no = bItem_no;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Board [bMember_no=" + bMember_no + ", bMember_id=" + bMember_id + ", bEmail=" + bEmail
				+ ", bBoard_code=" + bBoard_code + ", bBoard_no=" + bBoard_no + ", bTitle=" + bTitle + ", bContent="
				+ bContent + ", bWrite_date=" + bWrite_date + ", bRead_num=" + bRead_num + ", originalFileName="
				+ originalFileName + ", renameFileName=" + renameFileName + ", imagePath=" + imagePath + ", bItem_no="
				+ bItem_no + ", rownum=" + rownum + "]";
	}
	
	
	
}