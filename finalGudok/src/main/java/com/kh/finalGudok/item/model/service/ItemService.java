package com.kh.finalGudok.item.model.service;

import java.util.ArrayList;

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

public interface ItemService {

	int getItemCount();

	ArrayList<Item> selectList(PageInfo pi);

	int detailCount(int itemNo);

	ItemListView selectItem(int itemNo);

	ArrayList<Review> selectReview(int itemNo);

	ArrayList<Review> selectAllReview(int itemNo);


	int insertChoice(Heart h);

	int deleteChoice(Heart h);

	int getItemLivingCount();

	ArrayList<Item> selectLivingList(PageInfo pi);

	int getItemEventCount();

	ArrayList<Item> selectEventList(PageInfo pi);

	int insertInquired(Board b);

	int insertReview(Review r);

	int getNewCount();

	ArrayList<Item> selectNewList(PageInfo pi);

	int insertCart(Cart c);

	Heart detailHeart(int itemNo);

	ArrayList<Cart> selectBasket(int memberNo);

	int updatePChoice(int itemNo);

	int updateMChoice(int itemNo);

	public void deleteCart(Cart c);

	int updateReviewRate(int itemNo);

	int dListCount();
	
	ArrayList<ItemListView> selectDList(PageInfo pi);
	
	int mListCount();

	ArrayList<ItemListView> selectMList(PageInfo pi);

	int bListCount();
	
	ArrayList<ItemListView> selectBList(PageInfo pi);
	
	int sListCount();

	ArrayList<ItemListView> selectSList(PageInfo pi);
	
	int hListCount();

	ArrayList<ItemListView> selectHList(PageInfo pi);
	
	int diListCount();

	ArrayList<ItemListView> selectDiList(PageInfo pi);

	ArrayList<ItemListView> selectDLists(PageInfo pi,String sortNo);

	ArrayList<ItemListView> selectMLists(PageInfo pi, String sortNo);

	ArrayList<ItemListView> selectBLists(PageInfo pi, String sortNo);

	ArrayList<ItemListView> selectSLists(PageInfo pi, String sortNo);

	ArrayList<ItemListView> selectHLists(PageInfo pi, String sortNo);

	ArrayList<ItemListView> selectDiLists(PageInfo pi, String sortNo);

	int insertReviewImage1(Image i);

	int insertReviewImage2(Image i);

	int insertRI(ReviewImage ri);

	int livingCateCount(String catecoryNo);

	ArrayList<ItemListView> livingCateList(PageInfo pi, String categoryNo, String sortNo);

	ArrayList<Item> selectNewList(PageInfo pi, String sortNo);

	ArrayList<Item> selectEventList(PageInfo pi, String sortNo);

	ArrayList<ReviewView> selectReviewDetail(int reviewNo);

	ArrayList<Item> selectLivingList(PageInfo pi, String sortNo);

	ArrayList<Item> selectList(PageInfo pi, String sortNo);

	int reviewUpdate(Review r);

	ArrayList<ReviewView> selectAllReviewImg(int itemNo);

	int reviewDelete(int reviewNo);

	Item reviewItemName(int itemNo);

//	int l1Count();
//
//	int l2Count();
//
//	int l3Count();
//
//	ArrayList<ItemListView> l1List(PageInfo pi, String sortNo);
//
//	ArrayList<ItemListView> l2List(PageInfo pi, String sortNo);
//
//	ArrayList<ItemListView> l3List(PageInfo pi, String sortNo);
	
}
