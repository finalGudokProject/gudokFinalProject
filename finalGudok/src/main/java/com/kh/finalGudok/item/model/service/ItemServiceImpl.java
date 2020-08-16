package com.kh.finalGudok.item.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalGudok.item.model.dao.ItemDao;
import com.kh.finalGudok.item.model.vo.Board;
import com.kh.finalGudok.item.model.vo.Cart;
import com.kh.finalGudok.item.model.vo.Heart;
import com.kh.finalGudok.item.model.vo.Image;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;
import com.kh.finalGudok.item.model.vo.ReviewImage;
import com.kh.finalGudok.item.model.vo.ReviewView;
import com.kh.finalGudok.member.model.vo.Member;

@Service("iService")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDao iDao;

	@Override
	public int getItemCount() {
		return iDao.getItemCount();
	}
	
	@Override
	public int getNewCount() {
		return iDao.getNewCount();
	}
	
	@Override
	public ArrayList<Item> selectList(PageInfo pi) {
		return iDao.selectList(pi);
	}

	@Override
	public int detailCount(int itemNo) {
		return iDao.detailCount(itemNo);
	}

	@Override
	public ItemListView selectItem(int itemNo) {
		return iDao.selectItem(itemNo);
	}

	@Override
	public ArrayList<Review> selectReview(int itemNo) {
		return iDao.selectReview(itemNo);
	}

	@Override
	public ArrayList<Review> selectAllReview(int itemNo) {
		return iDao.selectAllReview(itemNo);
	}

	@Override
	public int insertChoice(Heart h) {
		return iDao.insertChoice(h);
	}

	@Override
	public int deleteChoice(Heart h) {
		return iDao.deleteChoice(h);
	}

	@Override
	public int getItemLivingCount() {
		return iDao.getItemLivingCount();
	}

	@Override
	public ArrayList<Item> selectLivingList(PageInfo pi) {
		return iDao.selectLivingList(pi);
	}

	@Override
	public int getItemEventCount() {
		return iDao.getItemEventCount();
	}

	@Override
	public ArrayList<Item> selectEventList(PageInfo pi) {
		return iDao.selectEventList(pi);
	}

	@Override
	public int insertInquired(Board b) {
		return iDao.insertInquired(b);
	}

	@Override
	public int insertReview(Review r) {
		return iDao.insertReview(r);
	}

	@Override
	public ArrayList<Item> selectNewList(PageInfo pi) {
		return iDao.selectNewList(pi);
	}

	@Override
	public int insertCart(Cart c) {
		return iDao.insertCart(c);
	}

	@Override
	public Heart detailHeart(int itemNo) {
		return iDao.detailHeart(itemNo);
	}

	@Override
	public ArrayList<Cart> selectBasket(int memberNo) {
		return iDao.selectBasket(memberNo);
	}

	@Override
	public int updatePChoice(int itemNo) {
		return iDao.updatePChoice(itemNo);
	}

	@Override
	public int updateMChoice(int itemNo) {
		return iDao.updateMChoice(itemNo);
	}

	@Override
	public void deleteCart(Cart c) {
		iDao.deleteCart(c);
	}

	@Override
	public int updateReviewRate(int itemNo) {
		return iDao.updateReviewRate(itemNo);
	}

	@Override
	public int mListCount() {
		return iDao.mListCount();
	}

	@Override
	public ArrayList<ItemListView> selectMList(PageInfo pi) {
		return iDao.selectMList(pi);
	}

	@Override
	public int dListCount() {
		return iDao.dListCount();
	}

	@Override
	public ArrayList<ItemListView> selectDList(PageInfo pi) {
		return iDao.selectDList(pi);
	}

	@Override
	public int bListCount() {
		return iDao.selectBListCount();
	}

	@Override
	public int sListCount() {
		return iDao.selectSListCount();
	}

	@Override
	public int hListCount() {
		return iDao.selectHListCount();
	}

	@Override
	public int diListCount() {
		return iDao.selectDiListCount();
	}

	@Override
	public ArrayList<ItemListView> selectBList(PageInfo pi) {
		return iDao.selectBList(pi);
	}

	@Override
	public ArrayList<ItemListView> selectSList(PageInfo pi) {
		return iDao.selectSList(pi);
	}

	@Override
	public ArrayList<ItemListView> selectHList(PageInfo pi) {
		return iDao.selectHList(pi);
	}

	@Override
	public ArrayList<ItemListView> selectDiList(PageInfo pi) {
		return iDao.selectDiList(pi);
	}

	@Override
	public ArrayList<ItemListView> selectDLists(PageInfo pi,String sortNo) {
		return iDao.selectDLists(pi,sortNo);
	}

	@Override
	public ArrayList<ItemListView> selectMLists(PageInfo pi, String sortNo) {
		return iDao.selectMLists(pi, sortNo);
	}

	@Override
	public ArrayList<ItemListView> selectBLists(PageInfo pi, String sortNo) {
		return iDao.selectBLists(pi, sortNo);
	}

	@Override
	public ArrayList<ItemListView> selectSLists(PageInfo pi, String sortNo) {
		return iDao.selectSLists(pi, sortNo);
	}

	@Override
	public ArrayList<ItemListView> selectHLists(PageInfo pi, String sortNo) {
		return iDao.selectHLists(pi, sortNo);
	}

	@Override
	public ArrayList<ItemListView> selectDiLists(PageInfo pi, String sortNo) {
		return iDao.selectDiLists(pi, sortNo);
	}

	@Override
	public int insertReviewImage1(Image i) {
		return iDao.insertReviewImage1(i);
	}

	@Override
	public int insertReviewImage2(Image i) {
		return iDao.insertReviewImage2(i);
	}
	
	@Override
	public int insertRI(ReviewImage ri) {
		return iDao.insertRI(ri);
	}

	@Override
	public int livingCateCount(String categoryNo) {
		return iDao.livingCateCount(categoryNo);
	}

	@Override
	public ArrayList<ItemListView> livingCateList(PageInfo pi, String categoryNo) {
		return iDao.livingCateList(pi, categoryNo);
	}

	@Override
	public ArrayList<Item> selectNewList(PageInfo pi, String sortNo) {
		return iDao.selectNewList(pi, sortNo);
	}

//	@Override
//	public int l1Count() {
//		return iDao.l1Count();
//	}
//
//	@Override
//	public int l2Count() {
//		return iDao.l2Count();
//	}
//
//	@Override
//	public int l3Count() {
//		return iDao.l3Count();
//	}
//
//	@Override
//	public ArrayList<ItemListView> l1List(PageInfo pi, String sortNo) {
//		return iDao.l1List(pi, sortNo);
//	}
//
//	@Override
//	public ArrayList<ItemListView> l2List(PageInfo pi, String sortNo) {
//		return iDao.l2List(pi, sortNo);
//	}
//
//	@Override
//	public ArrayList<ItemListView> l3List(PageInfo pi, String sortNo) {
//		return iDao.l3List(pi, sortNo);
//	}


}
