package com.kh.finalGudok.board.model.service;

import java.util.ArrayList;

import com.kh.finalGudok.board.model.vo.Board;
import com.kh.finalGudok.board.model.vo.Inquiry;
import com.kh.finalGudok.board.model.vo.bPageInfo;
import com.kh.finalGudok.board.model.vo.secret;

public interface BoardService {

	// Notice 리스트
	int getListCountNotice();

	ArrayList<Board> selectListNotice(bPageInfo pi);
	
	// FAQ 리스트
	int getListCountFAQ();
	
	ArrayList<Board> selectListFAQ(bPageInfo pi);
	
	// productProposal 리스트
	int getListCountProductProposal();
	
	ArrayList<Board> selectListProductProposal(bPageInfo pi);
	
	// inquiry 리스트
	int getListCountInquiry();

	ArrayList<Board> selectListInquiry1(bPageInfo pi);
	ArrayList<secret> selectListInquiry2(bPageInfo pi);
	ArrayList<Inquiry> selectListInquiry3(bPageInfo pi);

	// Count 조회수 기능
	int addReadCount(int bBoard_no);

	// Insert 글 등록
	int insertImage(Board b);
	
	int insertNotice(Board b);

	int insertFAQ(Board b);
	
	int insertProductProposal(Board b);
	
	int insertInquiry1(Board b);

	int insertInquiry2(secret s);
	
	int insertInquiry3(Inquiry i);

	// Detail 글 세부
	Board selectDetail (int bBoard_no);	
	
	Board selectIDetail (int bBoard_no);
	
	Board selectOIDetail1(int bBoard_no);

	secret selectOIDetail2(int bBoard_no);
	
	Inquiry selectOIDetail3(int bBoard_no);
	
	// Update 글 수정
	int updateImage(Board b);

	int updateBoard(Board b);
	
	int updateOneInquiry(secret s);

	int updateInquiry(Inquiry i);
	// Delete글 삭제
	int deleteImage(Integer bBoard_no);

	int deleteBoardImage(Integer bBoard_no);

	int deleteBoard(Integer bBoard_no);

	int deleteOneInquiryBoard(Integer bBoard_no);

	int deleteInquiryBoard(Integer bBoard_no);

	

	
	

	

	

	


}
