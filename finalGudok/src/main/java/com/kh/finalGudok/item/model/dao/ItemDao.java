package com.kh.finalGudok.item.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalGudok.item.model.vo.Board;
import com.kh.finalGudok.item.model.vo.Cart;
import com.kh.finalGudok.item.model.vo.Heart;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;
import com.kh.finalGudok.member.model.vo.Member;

@Repository("iDao")
public class ItemDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int getItemCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.getItemCount");
	}

	public ArrayList<Item> selectList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.getItemList", null, rowBounds);
	}

	public int detailCount(int itemNo) {
		return sqlSessionTemplate.update("itemMapper.getDetailCount", itemNo);
	}

	public ItemListView selectItem(int itemNo) {
		return sqlSessionTemplate.selectOne("itemListMapper.selectOne", itemNo);
	}

	public ArrayList<Review> selectReview(int itemNo) {
		return (ArrayList)sqlSessionTemplate.selectList("reviewMapper.selectReview", itemNo);
	}

	public ArrayList<Review> selectAllReview(int itemNo) {
		return (ArrayList)sqlSessionTemplate.selectList("reviewMapper.selectAllReview",itemNo);
	}


	public int insertChoice(Heart h) {
		return sqlSessionTemplate.insert("heartMapper.insertChoice", h);
	}

	public int deleteChoice(Heart h) {
		return sqlSessionTemplate.delete("heartMapper.deleteChoice", h);
	}

	public int getItemLivingCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.getItemLivingCount");
	}

	public ArrayList<Item> selectLivingList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.getItemLivingList", null, rowBounds);
	}

	public int getItemEventCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.getItemEventCount");
	}
	
	public ArrayList<Item> selectEventList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.getItemEventList", null, rowBounds);
	}

	public int insertInquired(Board b) {
		return sqlSessionTemplate.insert("itemMapper.insertInquired",b);
	}

	public int insertReview(Review r) {
		return sqlSessionTemplate.insert("reviewMapper.insertReview",r);
	}

	public int getNewCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.newCount");
	}

	public ArrayList<Item> selectNewList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectNewList", null, rowBounds);
	}

	public int insertCart(Cart c) {
		return sqlSessionTemplate.insert("cartMapper.insertCart",c);
	}

	public Heart detailHeart(int itemNo) {
		return sqlSessionTemplate.selectOne("heartMapper.selectHeart", itemNo);
	}

	public ArrayList<Cart> selectBasket(int memberNo) {
		return (ArrayList)sqlSessionTemplate.selectList("cartMapper.selectCart", memberNo);
	}

	public int updatePChoice(int itemNo) {
		return sqlSessionTemplate.update("itemMapper.updatePChoice",itemNo);
	}

	public int updateMChoice(int itemNo) {
		return sqlSessionTemplate.update("itemMapper.updateMChoice",itemNo);
	}


}
