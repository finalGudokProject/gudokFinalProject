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

	int deleteAdminNoticeBoard(Integer bBoard_no);

	int deleteAdminNoticeImage(Integer bBoard_no);

	int deleteAdminNoticeBoardImg(Integer bBoard_no);

	int updateAdminNoticeUpdate(Board b);

	Board selectAdminNoticeDetail(int bBoard_no);

	int updateAdminNoticeUpdateImg(Board b);


}
