package com.kh.finalGudok.board.model.service;

import java.util.ArrayList;

import com.kh.finalGudok.board.model.vo.Board;
import com.kh.finalGudok.board.model.vo.bPageInfo;

public interface BoardService {

	int getListCount();

	ArrayList<Board> selectList(bPageInfo pi);

	int addReadCount(int bBoard_no);

	int insertNotice(Board b);

	int insertNoticeImg(Board b);

	Board selectNoticeDetail(int bBoard_no);

}
