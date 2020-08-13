package com.kh.finalGudok.item.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalGudok.item.model.dao.ItemDao;
import com.kh.finalGudok.item.model.vo.AdminItem;
import com.kh.finalGudok.item.model.vo.Event;
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

	@Override
	public int insertEvent(Event e) {
		return iDao.insertEvent(e);
	}

	@Override
	public int insertEventImg(Event e) {
		return iDao.insertEventImg(e);
	}

	@Override
	public int getEventCount() {
		return iDao.getEventCount();
	}

	@Override
	public ArrayList<Event> selectEventList(PageInfo pi) {
		return iDao.selectEventListA(pi);
	}

	@Override
	public ArrayList selectEventListCount(PageInfo pi) {
		return iDao.selectEventListCount(pi);
	}


	@Override
	public int deleteEvent(int dEventArr) {
		return iDao.deleteEvent(dEventArr);
	}

	@Override
	public int deleteEventItem(int i) {
		return iDao.deleteEventItem(i);
	}

	@Override
	public int deleteEventImg(int i) {
		return iDao.deleteEventImg(i);
	}

	@Override
	public int deleteEventBannerImg(int i) {
		return iDao.deleteEventBannerImg(i);
	}

	@Override
	public Event selectDeleteEvent(int i) {
		return iDao.selectDeleteEvent(i);
	}

	@Override
	public int updateEventStatusY(int i) {
		return iDao.updateEventStatusY(i);
	}

	@Override
	public int updateEventStatusN(int i) {
		return iDao.updateEventStatusN(i);
	}






}
