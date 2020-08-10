package com.kh.finalGudok.item.controller;

import static com.kh.finalGudok.common.pagination.getPageInfo;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalGudok.item.model.exception.ItemException;
import com.kh.finalGudok.item.model.service.ItemService;
import com.kh.finalGudok.item.model.vo.Board;
import com.kh.finalGudok.item.model.vo.Cart;
import com.kh.finalGudok.item.model.vo.Heart;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;

@Controller
public class ItemController {

	@Autowired
	ItemService iService;
	
	@RequestMapping("itemNew.do")
	private ModelAndView itemNew(ModelAndView mv, @RequestParam(value="page",required=false)Integer page) {
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int listCount = iService.getNewCount();
		System.out.println("newListCount : " + listCount);
		PageInfo pi = getPageInfo(currentPage, listCount);
		ArrayList<Item> list = iService.selectNewList(pi);
		System.out.println("itemNew list : " + list);
		mv.addObject("list",list).addObject("pi", pi).setViewName("items/itemNew");
		return mv;
	}
	
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
//		System.out.println("ArrayList : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("items/itemFood");
		}else {
			throw new ItemException("아이템 조회 실패");
		}
		return mv;
	}
	
	@RequestMapping("itemLiving.do")
	public ModelAndView itemLivingList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page){
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int listCount = iService.getItemLivingCount();
//		System.out.println("listCount : " + listCount);
		
		PageInfo pi = getPageInfo(currentPage, listCount);
		ArrayList<Item> list = iService.selectLivingList(pi);
//		System.out.println("ArrayList : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("items/itemLiving");
		}else {
			throw new ItemException("아이템 조회 실패");
		}
		return mv;
	}
	
	@RequestMapping("itemEvent.do")
	public ModelAndView itemEventList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page){
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int listCount = iService.getItemEventCount();
//		System.out.println("listCount : " + listCount);
		
		PageInfo pi = getPageInfo(currentPage, listCount);
		ArrayList<Item> list = iService.selectEventList(pi);
//		System.out.println("ArrayList : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("items/itemEvent");
		}else {
			throw new ItemException("아이템 조회 실패");
		}
		return mv;
	}
	
	@RequestMapping("idetail.do")
	public ModelAndView itemDetailPage(ModelAndView mv, Integer itemNo, @RequestParam("page")Integer page, Integer memberNo) {
//		System.out.println("itemNo : " + itemNo + ", page : " + page);
		int currentPage = page;
		int result = iService.detailCount(itemNo);
//		System.out.println("증가함? : " + result);
		if(result > 0) {
			ItemListView ilv = iService.selectItem(itemNo);
			if(ilv != null) {
				mv.addObject("ilv", ilv).addObject("currentPage", currentPage).setViewName("items/itemDetail");
			}else {
				throw new ItemException("조회 실패");
			}
			
			// 해당 상품 리뷰 조회
			ArrayList<Review> review = iService.selectReview(itemNo);
			System.out.println("review 확인 : " + review);
			mv.addObject("review",review).setViewName("items/itemDetail");
			
			
			// Integer 형변환 오류 해결해야 됨
			Heart hResult = iService.detailHeart(itemNo);
			System.out.println("hResult : " +  hResult);
			mv.addObject("hResult", hResult).setViewName("items/itemDetail");
			
			
		}else {
			throw new ItemException("조회수 증가 실패");
		}
		return mv;
	}
	
	

	@RequestMapping("itemReview.do")
	public ModelAndView reviewPage(ModelAndView mv, int itemNo) {
		ArrayList<Review> review = iService.selectAllReview(itemNo);
		mv.addObject("review",review).setViewName("items/itemReview");
		return mv;
	}
	
	
	
	@RequestMapping("choice.do")
	@ResponseBody
	public String choiceInsert(HttpServletRequest request, Heart h) {
		int result = iService.insertChoice(h);
		System.out.println("찜 확인 : " + result);
		if(result > 0) {
			return "success";
		}else {
			throw new ItemException("찜 실패");
		}
	}
	
	@RequestMapping("choiceDel.do")
	@ResponseBody
	public String choiceDelete(HttpServletRequest request, Heart h) {
		int result = iService.deleteChoice(h);
		System.out.println("찜 삭제 확인 : " + result);
		if(result > 0) {
			return "success";
		}else {
			throw new ItemException("찜 삭제 실패");
		}
	}
	
	@RequestMapping("basket.do")
	@ResponseBody
	public String insertCart(HttpServletRequest request, Cart c) {
		int result = iService.insertCart(c);
		if(result > 0) {
			return "success";
		}else {
			throw new ItemException("추가 실패");
		}
	}
	
	@RequestMapping("basketPage.do")
	public ModelAndView basketPage(ModelAndView mv, Integer memberNo) {
		ArrayList<Cart> list = iService.selectBasket(memberNo);
		mv.addObject("list", list).setViewName("order/basket");
		System.out.println("basketList : " + list);
		return mv;
	}
	
	@RequestMapping("inquire.do")
	@ResponseBody
	public String itemInquire(HttpServletRequest request, Board b) {
		int result = iService.insertInquired(b);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}

	@RequestMapping("reviewUpdate.do")
	public String reviewUpdate(@RequestParam("reviewNo") Integer reviewNo) {
		return null;
	}
	
	@RequestMapping(value="reviewInsert.do", method=RequestMethod.POST)
	public String reviewInsert(Review r, HttpServletRequest request, @RequestParam(name="uploadFile1", required=false)MultipartFile file1, @RequestParam(name="uploadFile2", required=false)MultipartFile file2) {
		if(!file1.getOriginalFilename().equals("")) {
			String savePath1 = saveFile(file1, request);
			r.setReviewImg1(file1.getOriginalFilename());
			if(!file2.getOriginalFilename().contentEquals("")) {
				String savePath2 = saveFile(file2, request);
				r.setReviewImg2(file2.getOriginalFilename());
			}
		}
		int result = iService.insertReview(r);
		
		if(result > 0) {
			return "redirect:itemDetail.do";
		}else {
			throw new ItemException("리뷰 등록 실패");
		}
	}
	
	private String saveFile(MultipartFile file, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\iuploadFiles";
		File folder = new File(savePath);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		String filePath = folder + "\\" + file.getOriginalFilename();
		
		try {
			file.transferTo(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
	
}
