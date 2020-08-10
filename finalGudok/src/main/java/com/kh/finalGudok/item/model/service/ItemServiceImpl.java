package com.kh.finalGudok.item.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalGudok.item.model.dao.ItemDao;
import com.kh.finalGudok.item.model.vo.AdminItem;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;

@Service("iService")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDao iDao;

	@Override
	public int getItemCount() {
		return iDao.getItemCount();
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
	public int insertItem(AdminItem i) {
		return iDao.insertItem(i);
	}

	@Override
	public int insertImage(AdminItem i) {
		return iDao.insertImage(i);
	}




}
