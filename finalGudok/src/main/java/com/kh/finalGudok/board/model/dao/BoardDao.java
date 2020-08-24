package com.kh.finalGudok.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalGudok.board.model.vo.Board;
import com.kh.finalGudok.board.model.vo.Inquiry;
import com.kh.finalGudok.board.model.vo.bPageInfo;
import com.kh.finalGudok.board.model.vo.secret;

@Repository("bDao")
public class BoardDao {

	// Notice
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
	
	// inquiry
		public int getListCountInquiry() {
			return sqlSessionTemplate.selectOne("boardMapper.getListCountInquiry");
		}

		public ArrayList<Board> selectListInquiry1(bPageInfo pi) {
			int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
			
			return (ArrayList)sqlSessionTemplate.selectList("boardMapper.getBoardListInquiry1", null, rowBounds);
		}
		
		public ArrayList<secret> selectListInquiry2(bPageInfo pi) {
			int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
			
			return (ArrayList)sqlSessionTemplate.selectList("boardMapper.getBoardListInquiry2", null, rowBounds);
		}
		
		public ArrayList<Inquiry> selectListInquiry3(bPageInfo pi) {
			int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
			
			return (ArrayList)sqlSessionTemplate.selectList("boardMapper.getBoardListInquiry3", null, rowBounds);
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
	
	public int insertInquiry1(Board b) {
		return sqlSessionTemplate.insert("boardMapper.insertInquiry1", b);
	}
	
	public int insertInquiry2(secret s) {
		return sqlSessionTemplate.insert("boardMapper.insertInquiry2", s);
	}
	
	public int insertInquiry3(Inquiry i) {
		return sqlSessionTemplate.insert("boardMapper.insertInquiry3", i);
	}
	
	
	// Detail 세부내용
	public Board selectDetail(int bBoard_no) {
		return sqlSessionTemplate.selectOne("boardMapper.selectDetail", bBoard_no);
	}

	public Board selectIDetail(int bBoard_no) {
		return sqlSessionTemplate.selectOne("boardMapper.selectIDetail", bBoard_no);
	}
	
	public Board selectOIDetail1(int bBoard_no) {
		return sqlSessionTemplate.selectOne("boardMapper.selectOIDetail1", bBoard_no);
	}

	public secret selectOIDetail2(int bBoard_no) {
		return sqlSessionTemplate.selectOne("boardMapper.selectOIDetail2", bBoard_no);
	}
	
	public Inquiry selectOIDetail3(int bBoard_no) {
		return sqlSessionTemplate.selectOne("boardMapper.selectOIDetail3", bBoard_no);
	}

	// Update 수정

	public int updateImage(Board b) {
		return sqlSessionTemplate.update("boardMapper.updateImage", b);
	}

	public int updateBoard(Board b) {
		return sqlSessionTemplate.update("boardMapper.updateBoard", b);
	}
	
	public int updateOneInquiry(secret s) {
		return sqlSessionTemplate.update("boardMapper.updateOneInquiry", s);
	}

	public int updateInquiry(Inquiry i) {
		return sqlSessionTemplate.update("boardMapper.updateInquiry", i);
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

	public int deleteOneInquiryBoard(Integer bBoard_no) {
		return sqlSessionTemplate.delete("boardMapper.deleteOneInquiryBoard",bBoard_no);
	}

	public int deleteInquiryBoard(Integer bBoard_no) {
		return sqlSessionTemplate.delete("boardMapper.deleteInquiryBoard",bBoard_no);
	}




}
