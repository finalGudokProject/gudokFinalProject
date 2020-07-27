package com.kh.finalGudok.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.finalGudok.item.model.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService iService;
}
