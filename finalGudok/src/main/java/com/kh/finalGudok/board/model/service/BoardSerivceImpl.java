package com.kh.finalGudok.board.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalGudok.board.model.dao.BoardDao;
import com.kh.finalGudok.board.model.vo.Board;
import com.kh.finalGudok.board.model.vo.bPageInfo;

@Service("bService")
public class BoardSerivceImpl implements BoardService {
	@Autowired
	BoardDao bDao;

	// 리스트 불러오기
	@Override
	public int getListCountNotice() {
		return bDao.getListCountNotice();
	}

	@Override
	public ArrayList<Board> selectListNotice(bPageInfo pi) {
		return bDao.selectListNotice(pi);
	}

	@Override
	public int getListCountFAQ() {
		return bDao.getListCountFAQ();
	}

	@Override
	public ArrayList<Board> selectListFAQ(bPageInfo pi) {
		return bDao.selectListFAQ(pi);
	}

	@Override
	public int getListCountProductProposal() {
		return bDao.getListCountProductProposal();
	}

	@Override
	public ArrayList<Board> selectListProductProposal(bPageInfo pi) {
		return bDao.selectListProductProposal(pi);
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

	// Detail 세부내용
	@Override
	public Board selectDetail(int bBoard_no) {
		return bDao.selectDetail(bBoard_no);
	}

	@Override
	public Board selectIDetail(int bBoard_no) {
		return bDao.selectIDetail(bBoard_no);
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
	
	

}
