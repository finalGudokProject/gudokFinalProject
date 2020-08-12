package com.kh.finalGudok.item.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalGudok.item.model.vo.AdminItem;
import com.kh.finalGudok.item.model.vo.Event;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;

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

	public int insertItem(AdminItem i) {
		
		return sqlSessionTemplate.insert("adminItemMapper.insertItem",i);
	}

	public int insertImage(AdminItem i) {
		return sqlSessionTemplate.insert("adminItemMapper.insertItemImage",i);
	}

	public int insertEvent(Event e) {
		return sqlSessionTemplate.insert("adminItemMapper.insertEvent",e);
	}

	public int insertEventImg(Event e) {		
		return sqlSessionTemplate.insert("adminItemMapper.insertEventImg",e);
	}

	public int getEventCount() {
		return sqlSessionTemplate.selectOne("adminItemMapper.selectEventCount");
	}

	public ArrayList<Event> selectEventList(PageInfo pi) {
		int offset=(pi.getCurrentPage()-1)*pi.getBoardLimit();
		RowBounds rowBounds=new RowBounds(offset,pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("adminItemMapper.selectEventList",null,rowBounds);
	}

	public ArrayList selecctEventListCount(PageInfo pi) {
		int offset=(pi.getCurrentPage()-1)*pi.getBoardLimit();
		RowBounds rowBounds=new RowBounds(offset,pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("adminItemMapper.selectEventListCount",null,rowBounds);
	}
}
