package com.kh.finalGudok.item.model.service;

import java.util.ArrayList;

import com.kh.finalGudok.item.model.vo.AdminItem;
import com.kh.finalGudok.item.model.vo.Event;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;

public interface ItemService {

	int getItemCount();

	ArrayList<Item> selectList(PageInfo pi);

	int detailCount(int itemNo);

	ItemListView selectItem(int itemNo);

	ArrayList<Review> selectReview(int itemNo);

	int insertItem(AdminItem i);

	int insertImage(AdminItem i);

	int insertEvent(Event e);

	int insertEventImg(Event e);

	int getEventCount();

	ArrayList<Event> selectEventList(PageInfo pi);

	ArrayList selectEventListCount(PageInfo pi);

	int deleteEvent(int dEventArr);

	int deleteEventItem(int i);

	int deleteEventImg(int i);

	int deleteEventBannerImg(int i);

	Event selectDeleteEvent(int i);

	int updateEventStatusY(int i);

	int updateEventStatusN(int i);








}
