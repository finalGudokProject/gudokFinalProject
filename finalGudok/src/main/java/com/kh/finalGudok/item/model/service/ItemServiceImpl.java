package com.kh.finalGudok.item.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalGudok.item.model.dao.ItemDao;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.PageInfo;

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
}
