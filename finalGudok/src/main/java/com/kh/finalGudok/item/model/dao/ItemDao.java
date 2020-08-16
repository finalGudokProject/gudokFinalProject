package com.kh.finalGudok.item.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalGudok.item.model.vo.Board;
import com.kh.finalGudok.item.model.vo.Cart;
import com.kh.finalGudok.item.model.vo.Heart;
import com.kh.finalGudok.item.model.vo.Image;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;
import com.kh.finalGudok.item.model.vo.ReviewImage;

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
		int offsetL = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBoundsL = new RowBounds(offsetL, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.getItemLivingList", null, rowBoundsL);
	}

	public int getItemEventCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.getItemEventCount");
	}
	
	public ArrayList<Item> selectEventList(PageInfo pi) {
		int offsetE = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBoundsE = new RowBounds(offsetE, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.getItemEventList", null, rowBoundsE);
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
		int offsetN = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBoundsN = new RowBounds(offsetN, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectNewList", null, rowBoundsN);
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

	public void deleteCart(Cart c) {
		sqlSessionTemplate.delete("cartMapper.deleteCart", c);
	}

	public int updateReviewRate(int itemNo) {
		return sqlSessionTemplate.update("reviewMapper.updateReviewRate", itemNo);
	}

	public int mListCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.mListCount");
	}

	public ArrayList<ItemListView> selectMList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectMList",null,rowBounds);
	}

	public int dListCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.dListCount");
	}

	public ArrayList<ItemListView> selectDList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectDList",null,rowBounds);
	}

	public int selectBListCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.bListCount");
	}

	public ArrayList<ItemListView> selectBList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectBList",null,rowBounds);
	}
	
	public int selectSListCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.sListCount");
	}
	
	public ArrayList<ItemListView> selectSList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectSList",null,rowBounds);
	}

	public int selectHListCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.hListCount");
	}

	public ArrayList<ItemListView> selectHList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectHList",null,rowBounds);
	}

	public int selectDiListCount() {
		return sqlSessionTemplate.selectOne("itemListMapper.diListCount");
	}

	public ArrayList<ItemListView> selectDiList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectDiList",null,rowBounds);
	}

	public ArrayList<ItemListView> selectDLists(PageInfo pi, String sortNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		HashMap<String, String> map = new HashMap<>();
		map.put("test",sortNo);
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectDLists",map,rowBounds);
	}

	public ArrayList<ItemListView> selectMLists(PageInfo pi, String sortNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		HashMap<String, String> map = new HashMap<>();
		map.put("test",sortNo);
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectMLists",map,rowBounds);
	}

	public ArrayList<ItemListView> selectBLists(PageInfo pi, String sortNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		HashMap<String, String> map = new HashMap<>();
		map.put("test",sortNo);
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectBLists",map,rowBounds);
	}

	public ArrayList<ItemListView> selectSLists(PageInfo pi, String sortNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		HashMap<String, String> map = new HashMap<>();
		map.put("test",sortNo);
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectSLists",map,rowBounds);
	}

	public ArrayList<ItemListView> selectHLists(PageInfo pi, String sortNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		HashMap<String, String> map = new HashMap<>();
		map.put("test",sortNo);
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectHLists",map,rowBounds);
	}

	public ArrayList<ItemListView> selectDiLists(PageInfo pi, String sortNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		HashMap<String, String> map = new HashMap<>();
		map.put("test",sortNo);
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectDiLists",map,rowBounds);
	}

	public int insertReviewImage1(Image i) {
		return sqlSessionTemplate.insert("reviewMapper.insertReviewImage1",i);
	}

	public int insertReviewImage2(Image i) {
		return sqlSessionTemplate.insert("reviewMapper.insertReviewImage2",i);
	}
	
	public int insertRI(ReviewImage ri) {
		return sqlSessionTemplate.insert("reviewMapper.insertRI",ri);
	}

	public int livingCateCount(String categoryNo) {
		return sqlSessionTemplate.selectOne("itemListMapper.livingCount", categoryNo);
	}

	public ArrayList<ItemListView> livingCateList(PageInfo pi, String categoryNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		HashMap<String, String> map = new HashMap<>();
		map.put("living", categoryNo);
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.livingCateList",map,rowBounds);
	}

	public ArrayList<Item> selectNewList(PageInfo pi, String sortNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		HashMap<String, String> map = new HashMap<>();
		map.put("sortNo", sortNo);
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectSortNewList", map, rowBounds);
	}

	public ArrayList<Item> selectEventList(PageInfo pi, String sortNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		HashMap<String, String> map = new HashMap<>();
		map.put("sortNo", sortNo);
		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectSortEventList", map, rowBounds);
	}


//	public int l1Count() {
//		return sqlSessionTemplate.selectOne("itemListMapper.l1Count");
//	}
//
//	public int l2Count() {
//		return sqlSessionTemplate.selectOne("itemListMapper.l2Count");
//	}
//
//	public int l3Count() {
//		return sqlSessionTemplate.selectOne("itemListMapper.l3Count");
//	}
//
//	public ArrayList<ItemListView> l1List(PageInfo pi, String sortNo) {
//		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
//		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
//		HashMap<String, String> map = new HashMap<>();
//		map.put("test",sortNo);
//		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectDiLists",map,rowBounds);
//	}
//
//	public ArrayList<ItemListView> l2List(PageInfo pi, String sortNo) {
//		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
//		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
//		HashMap<String, String> map = new HashMap<>();
//		map.put("test",sortNo);
//		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectDiLists",map,rowBounds);
//	}
//
//	public ArrayList<ItemListView> l3List(PageInfo pi, String sortNo) {
//		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
//		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
//		HashMap<String, String> map = new HashMap<>();
//		map.put("test",sortNo);
//		return (ArrayList)sqlSessionTemplate.selectList("itemListMapper.selectDiLists",map,rowBounds);
//	}


}
