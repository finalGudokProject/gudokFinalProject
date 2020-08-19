package com.kh.finalGudok.board.model.service;

import java.util.ArrayList;

import com.kh.finalGudok.board.model.vo.Board;
import com.kh.finalGudok.board.model.vo.bPageInfo;

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

	// Count 조회수 기능
	int addReadCount(int bBoard_no);

	// Insert 글 등록
	int insertImage(Board b);
	
	int insertNotice(Board b);

	int insertFAQ(Board b);
	
	int insertProductProposal(Board b);

	// Detail 글 세부
	Board selectDetail (int bBoard_no);	
	
	Board selectIDetail (int bBoard_no);	
	// Update 글 수정
	int updateImage(Board b);

	int updateBoard(Board b);
	// Delete글 삭제
	int deleteImage(Integer bBoard_no);

	int deleteBoardImage(Integer bBoard_no);

	int deleteBoard(Integer bBoard_no);


}
