package com.kh.finalGudok.item.model.service;

import java.util.ArrayList;

import com.kh.finalGudok.item.model.vo.AdminItem;
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




}
