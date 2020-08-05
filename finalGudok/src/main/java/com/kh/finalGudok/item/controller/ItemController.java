package com.kh.finalGudok.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.finalGudok.item.model.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService iService;
	
	@RequestMapping(value="itemFood.do")
	public String itemPage() {
		return "items/itemFood";
	}
	
	@RequestMapping("itemDetail.do")
	public String itemDetailPage() {
		return "items/itemDetail";
	}
	
	@RequestMapping("basket.do")
	public String BasketPage() {
		return "order/basket";
	}

	@RequestMapping("itemLiving.do")
	public String livingPage() {
		return "items/exam";
	}
	
	@RequestMapping("itemReview.do")
	public String reviewPage() {
		return "items/itemReview";
	}
	
	
}
