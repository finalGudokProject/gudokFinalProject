package com.kh.finalGudok.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalGudok.board.model.vo.Board;
import com.kh.finalGudok.board.model.vo.bPageInfo;

@Repository("bDao")
public class BoardDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int getListCount() {
		return sqlSessionTemplate.selectOne("boardMapper.getListCount");
	}

	public ArrayList<Board> selectList(bPageInfo pi) {
		int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSessionTemplate.selectList("boardMapper.getBoardList", null, rowBounds);
	}

	public int addReadCount(int bBoard_no) {
		return sqlSessionTemplate.update("boardMapper.updateCount", bBoard_no);
	}

	public int insertNotice(Board b) {
		return sqlSessionTemplate.insert("boardMapper.insertNotice", b);
	}

	public int insertNoticeImg(Board b) {
		return sqlSessionTemplate.insert("boardMapper.insertNoticeImg", b);
	}

	public Board selectNoticeDetail(int bBoard_no) {
		return sqlSessionTemplate.selectOne("boardMapper.selectNoticeDetail", bBoard_no);
	}
}
