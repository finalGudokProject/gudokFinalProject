package com.kh.finalGudok.item.model.service;

import java.util.ArrayList;

import com.kh.finalGudok.item.model.vo.Board;
import com.kh.finalGudok.item.model.vo.Cart;
import com.kh.finalGudok.item.model.vo.Heart;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;
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






}
