package com.kh.finalGudok.item.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalGudok.item.model.vo.AdminItem;
import com.kh.finalGudok.item.model.vo.BannerItem;
import com.kh.finalGudok.item.model.vo.Event;

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

	public ArrayList<BannerItem> selectEventListA(PageInfo pi) {
		int offset=(pi.getCurrentPage()-1)*pi.getBoardLimit();
		RowBounds rowBounds=new RowBounds(offset,pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("adminItemMapper.selectEventList",null,rowBounds);
	}

	public ArrayList selectEventListCount(PageInfo pi) {
		int offset=(pi.getCurrentPage()-1)*pi.getBoardLimit();
		RowBounds rowBounds=new RowBounds(offset,pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("adminItemMapper.selectEventListCount",null,rowBounds);
	}

	public int deleteEvent(int dEventArr) {
		return sqlSessionTemplate.delete("adminItemMapper.deleteEvent",dEventArr);
		
	}

	public int deleteEventItem(int i) {
		return sqlSessionTemplate.delete("adminItemMapper.deleteEventItem",i);
	}

	public int deleteEventImg(int i) {
		return sqlSessionTemplate.delete("adminItemMapper.deleteEventImg",i);
	}

	public int deleteEventBannerImg(int i) {
		return sqlSessionTemplate.delete("adminItemMapper.deleteEventBannerImg",i);
	}

	public Event selectDeleteEvent(int i) {
		return sqlSessionTemplate.selectOne("adminItemMapper.selectDeleteEvent",i);
	}

	public int updateEventStatusY(ArrayList<Event> dEventArr) {
		return sqlSessionTemplate.update("adminItemMapper.updateEventStatusY",dEventArr);
	}

	public int updateEventStatusN(ArrayList<Event> dEventArr) {
		return sqlSessionTemplate.update("adminItemMapper.updateEventStatusN",dEventArr);
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

	public int selectBannerItemCount(int bi) {
		return sqlSessionTemplate.selectOne("adminItemMapper.selectBannerItemCount",bi);
	}

	public ArrayList<BannerItem> selectBannerItem(int bi, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSessionTemplate.selectList("adminItemMapper.selectBannerList",bi,rowBounds);
	}

	public ArrayList<BannerItem> selectItemListA(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("adminItemMapper.selectItemListA",null,rowBounds);
	}

	public int deleteBannerItem(int[] itemArr) {
		
		return sqlSessionTemplate.delete("adminItemMapper.deleteBannerItem",itemArr);
	}

	public int updateItemStatusY(ArrayList<BannerItem> iArr) {
		
		return sqlSessionTemplate.update("adminItemMapper.updateItemStatusY",iArr);
	}
	
public int updateItemStatusN(ArrayList<BannerItem> iArr) {
		
		return sqlSessionTemplate.update("adminItemMapper.updateItemStatusN",iArr);
	}

public BannerItem selectAdminItem(int itemNo) {
	
	return sqlSessionTemplate.selectOne("adminItemMapper.selectAdminItem",itemNo);
	}

public int updateitem(BannerItem i) {
	
	return sqlSessionTemplate.update("adminItemMapper.updateItem",i);
	}

public int deleteEventItem(BannerItem i) {
	
	return sqlSessionTemplate.delete("adminItemMapper.deleteBannerItem",i);
}

public int updateItemImg(BannerItem i) {
	
	return sqlSessionTemplate.update("adminItemMapper.updateItemImg",i);
}

public int selectImageNo(BannerItem i) {
	
	return sqlSessionTemplate.selectOne("adminItemMapper.selectImageNo",i);

}

public int selectItemCountA() {
	
	return sqlSessionTemplate.selectOne("adminItemMapper.selectItemCountA");
}

public BannerItem selectDeleteItem(int i) {
	return sqlSessionTemplate.selectOne("adminItemMapper.selectDeleteItem",i);
}

public int deleteItemA(int i) {
	return sqlSessionTemplate.delete("adminItemMapper.deleteItemA",i);
}

public int deleteImgA(int i) {
	return sqlSessionTemplate.delete("adminItemMapper.deleteImgA",i);
}

public int deleteItemImgA(int i) {
	return sqlSessionTemplate.delete("adminItemMapper.deleteItemImgA",i);
}

public int deleteItemEvent(int i) {
	return sqlSessionTemplate.delete("adminItemMapper.deleteItemEvent",i);
}

public ArrayList<BannerItem> selectEventOption() {
	
	return (ArrayList)sqlSessionTemplate.selectList("adminItemMapper.selectEventOption");
}

public ArrayList<BannerItem> selectItems(PageInfo pi) {
	int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
	RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
	return (ArrayList)sqlSessionTemplate.selectList("adminItemMapper.selectItems",null,rowBounds);
}

public int selectNonEventItemCnt() {
	
	return sqlSessionTemplate.selectOne("adminItemMapper.selectNonEventItemCnt");
}

public int updateItemEventStatus(int i) {
	
	return sqlSessionTemplate.update("adminItemMapper.updateItemEventStatus",i);
}

public int insertEventItem(BannerItem i) {
	
	return sqlSessionTemplate.insert("adminItemMapper.insertEventItem",i);
}

public int deleteEventItemBefor(BannerItem i) {
	
	return sqlSessionTemplate.delete("adminItemMapper.deleteEventItemBefore",i);
}
}
