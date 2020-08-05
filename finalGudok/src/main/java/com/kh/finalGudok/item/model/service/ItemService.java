package com.kh.finalGudok.item.model.service;

import java.util.ArrayList;

import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.PageInfo;

public interface ItemService {

	int getItemCount();

	ArrayList<Item> selectList(PageInfo pi);

}
