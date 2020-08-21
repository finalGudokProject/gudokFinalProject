package com.kh.finalGudok.board.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalGudok.board.model.dao.BoardDao;
import com.kh.finalGudok.board.model.vo.Board;
import com.kh.finalGudok.board.model.vo.Inquiry;
import com.kh.finalGudok.board.model.vo.bPageInfo;
import com.kh.finalGudok.board.model.vo.secret;

@Service("bService")
public class BoardSerivceImpl implements BoardService {
	@Autowired
	BoardDao bDao;

	// 리스트 불러오기
	// notice
	@Override
	public int getListCountNotice() {
		return bDao.getListCountNotice();
	}

	@Override
	public ArrayList<Board> selectListNotice(bPageInfo pi) {
		return bDao.selectListNotice(pi);
	}

	// FAQ
	@Override
	public int getListCountFAQ() {
		return bDao.getListCountFAQ();
	}

	@Override
	public ArrayList<Board> selectListFAQ(bPageInfo pi) {
		return bDao.selectListFAQ(pi);
	}

	// ProductProposal
	@Override
	public int getListCountProductProposal() {
		return bDao.getListCountProductProposal();
	}

	@Override
	public ArrayList<Board> selectListProductProposal(bPageInfo pi) {
		return bDao.selectListProductProposal(pi);
	}

	// inquiry
	@Override
	public int getListCountInquiry() {
		return bDao.getListCountInquiry();
	}

	@Override
	public ArrayList<Board> selectListInquiry1(bPageInfo pi) {
		return bDao.selectListInquiry1(pi);
	}

	@Override
	public ArrayList<secret> selectListInquiry2(bPageInfo pi) {
		return bDao.selectListInquiry2(pi);
	}

	@Override
	public ArrayList<Inquiry> selectListInquiry3(bPageInfo pi) {
		return bDao.selectListInquiry3(pi);
	}
	
	
	// Count
	@Override
	public int addReadCount(int bBoard_no) {
		return bDao.addReadCount(bBoard_no);
	}

	// Insert 글 등록
	@Override
	public int insertImage(Board b) {
		return bDao.insertImage(b);
	}

	@Override
	public int insertNotice(Board b) {
		return bDao.insertNotice(b);
	}

	@Override
	public int insertFAQ(Board b) {
		return bDao.insertFAQ(b);
	}

	@Override
	public int insertProductProposal(Board b) {
		return bDao.insertProductProposal(b);
	}

	@Override
	public int insertInquiry1(Board b) {
		return bDao.insertInquiry1(b);
	}
	
	@Override
	public int insertInquiry2(secret s) {
		return bDao.insertInquiry2(s);
	}
	
	@Override
	public int insertInquiry3(Inquiry i) {
		return bDao.insertInquiry3(i);
	}
	
	// Detail 세부내용
	@Override
	public Board selectDetail(int bBoard_no) {
		return bDao.selectDetail(bBoard_no);
	}

	@Override
	public Board selectIDetail(int bBoard_no) {
		return bDao.selectIDetail(bBoard_no);
	}

	@Override
	public Board selectOIDetail1(int bBoard_no) {
		return bDao.selectOIDetail1(bBoard_no);
	}
	
	@Override
	public secret selectOIDetail2(int bBoard_no) {
		return bDao.selectOIDetail2(bBoard_no);
	}

	@Override
	public Inquiry selectOIDetail3(int bBoard_no) {
		return bDao.selectOIDetail3(bBoard_no);
	}

	
	// Update 수정
	@Override
	public int updateImage(Board b) {
		return bDao.updateImage(b);
	}

	@Override
	public int updateBoard(Board b) {
		return bDao.updateBoard(b);
	}
	
	@Override
	public int updateOneInquiry(secret s) {
		return bDao.updateOneInquiry(s);
	}

	@Override
	public int updateInquiry(Inquiry i) {
		return bDao.updateInquiry(i);
	}

	// Delete 삭제
	@Override
	public int deleteImage(Integer bBoard_no) {
		return bDao.deleteImage(bBoard_no);
	}

	@Override
	public int deleteBoardImage(Integer bBoard_no) {
		return bDao.deleteBoardImage(bBoard_no);
	}

	@Override
	public int deleteBoard(Integer bBoard_no) {
		return bDao.deleteBoard(bBoard_no);
	}

	@Override
	public int deleteOneInquiryBoard(Integer bBoard_no) {
		return bDao.deleteOneInquiryBoard(bBoard_no);
	}

	@Override
	public int deleteInquiryBoard(Integer bBoard_no) {
		return bDao.deleteInquiryBoard(bBoard_no);
	}

	

	

	

	
	
	
	

}
