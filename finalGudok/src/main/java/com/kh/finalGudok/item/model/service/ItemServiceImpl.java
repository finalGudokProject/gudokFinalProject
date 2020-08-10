package com.kh.finalGudok.item.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalGudok.item.model.dao.ItemDao;
import com.kh.finalGudok.item.model.vo.Board;
import com.kh.finalGudok.item.model.vo.Cart;
import com.kh.finalGudok.item.model.vo.Heart;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;
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







}
