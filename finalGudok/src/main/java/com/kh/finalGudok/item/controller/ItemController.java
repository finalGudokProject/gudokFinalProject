package com.kh.finalGudok.item.controller;

import static com.kh.finalGudok.common.pagination.getPageInfo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalGudok.item.model.exception.ItemException;
import com.kh.finalGudok.item.model.service.ItemService;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.PageInfo;

@Controller
public class ItemController {

	@Autowired
	ItemService iService;
	
	@RequestMapping("itemFood.do")
	public ModelAndView itemList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page){
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int listCount = iService.getItemCount();
//		System.out.println("listCount : " + listCount);
		
		PageInfo pi = getPageInfo(currentPage, listCount);
		ArrayList<Item> list = iService.selectList(pi);
		System.out.println("ArrayList : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("items/itemFood");
		}else {
			throw new ItemException("아이템 조회 실패");
		}
		return mv;
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
		return "items/itemLiving";
	}
	
	@RequestMapping("itemReview.do")
	public String reviewPage() {
		return "items/itemReview";
	}
	
	
}
