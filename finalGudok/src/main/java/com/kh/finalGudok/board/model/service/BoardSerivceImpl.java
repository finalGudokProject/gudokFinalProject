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
	
	@Override
	public int getListCount() {
		return bDao.getListCount();
	}

	@Override
	public ArrayList<Board> selectList(bPageInfo pi) {
		return bDao.selectList(pi);
	}

	@Override
	public int addReadCount(int bBoard_no) {
		return bDao.addReadCount(bBoard_no);
	}

	@Override
	public int insertNotice(Board b) {
		return bDao.insertNotice(b);
	}

	@Override
	public int insertNoticeImg(Board b) {
		return bDao.insertNoticeImg(b);
	}

	@Override
	public Board selectNoticeDetail(int bBoard_no) {
		return bDao.selectNoticeDetail(bBoard_no);
	}

}
