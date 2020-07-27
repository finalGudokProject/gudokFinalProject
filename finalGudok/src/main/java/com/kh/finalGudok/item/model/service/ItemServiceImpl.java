package com.kh.finalGudok.item.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalGudok.item.model.dao.ItemDao;

@Service("iService")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDao iDao;
}
