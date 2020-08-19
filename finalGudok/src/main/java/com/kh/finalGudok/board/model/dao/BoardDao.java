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
	
	public int getListCountNotice() {
		return sqlSessionTemplate.selectOne("boardMapper.getListCountNotice");
	}

	public ArrayList<Board> selectListNotice(bPageInfo pi) {
		int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSessionTemplate.selectList("boardMapper.getBoardListNotice", null, rowBounds);
	}

	// FAQ
	
		public int getListCountFAQ() {
			return sqlSessionTemplate.selectOne("boardMapper.getListCountFAQ");
		}

		public ArrayList<Board> selectListFAQ(bPageInfo pi) {
			int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
			
			return (ArrayList)sqlSessionTemplate.selectList("boardMapper.getBoardListFAQ", null, rowBounds);
		}
		
		
	// ProductProposal
		public int getListCountProductProposal() {
			return sqlSessionTemplate.selectOne("boardMapper.getListCountProductProposal");
		}

		public ArrayList<Board> selectListProductProposal(bPageInfo pi) {
			int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
			
			return (ArrayList)sqlSessionTemplate.selectList("boardMapper.getBoardListProductProposal", null, rowBounds);
		}
		
		
	// Count
	public int addReadCount(int bBoard_no) {
		return sqlSessionTemplate.update("boardMapper.updateCount", bBoard_no);
	}

	// Insert
	public int insertImage(Board b) {
		return sqlSessionTemplate.insert("boardMapper.insertImage", b);
	}

	public int insertNotice(Board b) {
		return sqlSessionTemplate.insert("boardMapper.insertNotice", b);
	}

	public int insertFAQ(Board b) {
		return sqlSessionTemplate.insert("boardMapper.insertFAQ",b);
	}

	public int insertProductProposal(Board b) {
		return sqlSessionTemplate.insert("boardMapper.insertProductProposal", b);
	}
	
	
	// Detail 세부내용
	public Board selectDetail(int bBoard_no) {
		return sqlSessionTemplate.selectOne("boardMapper.selectDetail", bBoard_no);
	}

	public Board selectIDetail(int bBoard_no) {
		return sqlSessionTemplate.selectOne("boardMapper.selectIDetail", bBoard_no);
	}

	// Update 수정

	public int updateImage(Board b) {
		return sqlSessionTemplate.update("boardMapper.updateImage", b);
	}

	public int updateBoard(Board b) {
		return sqlSessionTemplate.update("boardMapper.updateBoard", b);
	}

	// Delete 삭제
	public int deleteImage(Integer bBoard_no) {
		return sqlSessionTemplate.delete("boardMapper.deleteImage",bBoard_no);
	}
	
	public int deleteBoardImage(Integer bBoard_no) {
		return sqlSessionTemplate.delete("boardMapper.deleteBoardImage",bBoard_no);
	}
	
	public int deleteBoard(Integer bBoard_no) {
		return sqlSessionTemplate.delete("boardMapper.deleteBoard",bBoard_no);
	}
	


}
