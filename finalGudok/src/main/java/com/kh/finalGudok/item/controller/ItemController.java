package com.kh.finalGudok.item.controller;

import static com.kh.finalGudok.common.pagination.getPageInfo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
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
import com.kh.finalGudok.item.model.vo.Image;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;
import com.kh.finalGudok.item.model.vo.ReviewImage;
import com.kh.finalGudok.item.model.vo.ReviewView;
import com.kh.finalGudok.member.model.vo.Member;

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
		mv.addObject("list", list).addObject("pi", pi).setViewName("items/itemFood");
		
		return mv;
	}
	
	@RequestMapping("foodSort.do")
	public ModelAndView foodSort(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page, String categoryNo) {
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		if(categoryNo.equals("F1")) {
			int dListCount = iService.dListCount();
			System.out.println("음료 Count : " + dListCount);
			PageInfo pi = getPageInfo(currentPage, dListCount);
			ArrayList<ItemListView> dList = iService.selectDList(pi);
			mv.addObject("list", dList).addObject("pi", pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F2")) {
			int mListCount = iService.mListCount();
			System.out.println("유제품 Count : " + mListCount);
			PageInfo pi = getPageInfo(currentPage, mListCount);
			ArrayList<ItemListView> mList = iService.selectMList(pi);
			mv.addObject("list", mList).addObject("pi", pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F3")) {
			int bListCount = iService.bListCount();
			System.out.println("베이커리 Count : " + bListCount);
			PageInfo pi = getPageInfo(currentPage, bListCount);
			ArrayList<ItemListView> bList = iService.selectBList(pi);
			mv.addObject("list", bList).addObject("pi", pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F4")) {
			int sListCount = iService.sListCount();
			System.out.println("간편 Count : " + sListCount);
			PageInfo pi = getPageInfo(currentPage, sListCount);
			ArrayList<ItemListView> sList = iService.selectSList(pi);
			mv.addObject("list", sList).addObject("pi", pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F5")) {
			int hListCount = iService.hListCount();
			System.out.println("건강 Count : " + hListCount);
			PageInfo pi = getPageInfo(currentPage, hListCount);
			ArrayList<ItemListView> hList = iService.selectHList(pi);
			mv.addObject("list", hList).addObject("pi", pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F6")) {
			int diListCount = iService.diListCount();
			System.out.println("다이어트 Count : " + diListCount);
			PageInfo pi = getPageInfo(currentPage, diListCount);
			ArrayList<ItemListView> diList = iService.selectDiList(pi);
			mv.addObject("list", diList).addObject("pi", pi).setViewName("items/itemFood");
		}
		
//		if(categoryNo.equals("L1")) {
//			int l1Count= iService.l1Count();
//			System.out.println("다이어트 Count : " + l1Count);
//			PageInfo pi = getPageInfo(currentPage, l1Count);
//			ArrayList<ItemListView> l1List = iService.l1List(pi);
//			mv.addObject("list", l1List).addObject("pi", pi).setViewName("items/itemFood");
//		}else if(categoryNo.equals("L2")) {
//			int l2Count = iService.l2Count();
//			System.out.println("다이어트 Count : " + l2Count);
//			PageInfo pi = getPageInfo(currentPage, l2Count);
//			ArrayList<ItemListView> l2List = iService.l2List(pi);
//			mv.addObject("list", l2List).addObject("pi", pi).setViewName("items/itemFood");
//		}else if(categoryNo.equals("L3")) {
//			int l3Count = iService.l3Count();
//			System.out.println("다이어트 Count : " + l3Count);
//			PageInfo pi = getPageInfo(currentPage, l3Count);
//			ArrayList<ItemListView> l3List = iService.l3List(pi);
//			mv.addObject("list", l3List).addObject("pi", pi).setViewName("items/itemFood");
//		}
		return mv;
	}
	
	
	@RequestMapping("livingSort.do")
	public ModelAndView livingSort(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page, String categoryNo) {
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		if(categoryNo != null) {
			int livingCateCount = iService.livingCateCount(categoryNo);
			System.out.println("리빙 Count : " + livingCateCount);
			PageInfo pi = getPageInfo(currentPage, livingCateCount);
			ArrayList<ItemListView> livingCateList = iService.livingCateList(pi, categoryNo);
			mv.addObject("list", livingCateList).addObject("pi", pi).setViewName("items/itemFood");
		}
		return mv;
	}	
		
	@RequestMapping("fSort.do")
	public ModelAndView foodSort(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page, String categoryNo, @RequestParam("sortNo") String sortNo) {
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		System.out.println("sortNo : " + sortNo);
		if(categoryNo.equals("F1") && sortNo != null) {
			int dListCounts = iService.dListCount();
			PageInfo pi = getPageInfo(currentPage, dListCounts);
			ArrayList<ItemListView> dLists = iService.selectDLists(pi,sortNo);
			mv.addObject("list", dLists).addObject("pi", pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F2") && sortNo != null) {
			int mListCount = iService.mListCount();
			PageInfo pi = getPageInfo(currentPage, mListCount);
			ArrayList<ItemListView> mList = iService.selectMLists(pi, sortNo);
			mv.addObject("list", mList).addObject("pi", pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F3") && sortNo != null) {
			int bListCount = iService.bListCount();
			PageInfo pi = getPageInfo(currentPage, bListCount);
			ArrayList<ItemListView> bList = iService.selectBLists(pi, sortNo);
			mv.addObject("list", bList).addObject("pi", pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F4") && sortNo != null) {
			int sListCount = iService.sListCount();
			PageInfo pi = getPageInfo(currentPage, sListCount);
			ArrayList<ItemListView> sList = iService.selectSLists(pi, sortNo);
			mv.addObject("list", sList).addObject("pi", pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F5") && sortNo != null) {
			int hListCount = iService.hListCount();
			PageInfo pi = getPageInfo(currentPage, hListCount);
			ArrayList<ItemListView> hList = iService.selectHLists(pi, sortNo);
			mv.addObject("list", hList).addObject("pi", pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F6") && sortNo != null) {
			int diListCount = iService.diListCount();
			PageInfo pi = getPageInfo(currentPage, diListCount);
			ArrayList<ItemListView> diList = iService.selectDiLists(pi, sortNo);
			mv.addObject("list", diList).addObject("pi", pi).setViewName("items/itemFood");
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
	public String choiceInsert(HttpServletRequest request, Heart h, Integer itemNo) {
		int result = iService.insertChoice(h);
		System.out.println("찜 확인 : " + result);
		int result2 = iService.updatePChoice(itemNo);
		if(result > 0 && result2 > 0) {
			return "success";
		}else {
			throw new ItemException("찜 실패");
		}
	}
	
	@RequestMapping("choiceDel.do")
	@ResponseBody
	public String choiceDelete(HttpServletRequest request, Heart h, Integer itemNo) {
		int result = iService.deleteChoice(h);
		System.out.println("찜 삭제 확인 : " + result);
		int result2 = iService.updateMChoice(itemNo);
		if(result > 0 && result2 > 0) {
			return "success";
		}else {
			throw new ItemException("찜 삭제 실패");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="basketDel.do", method=RequestMethod.POST)
	public String cartDelete(HttpSession session, HttpServletRequest request, @RequestParam(value="checkboxArr[]") List<String> checkArr, Cart c) {
		Member member = (Member)session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		
		int cartNo = 0;
		
		if(member != null) {
			c.setMemberId(memberId);
			for(String i : checkArr) {
				cartNo = Integer.parseInt(i);
				c.setCartNo(cartNo);
				iService.deleteCart(c);
			}
		}
		return "success";
			
		
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
		return "items/reviewUpdate";
	}
	
	@RequestMapping(value="reviewInsert.do", method=RequestMethod.POST)
	public String reviewInsert(Review r, Image i, ReviewImage ri, HttpServletRequest request, @RequestParam(value = "page", required = false)Integer page
			, @RequestParam(value = "memberNo", required = false)int memberNo
			, @RequestParam(value = "itemNo", required = false)int itemNo
			, @RequestParam(value="uploadFile1", required=false)MultipartFile file1
			, @RequestParam(value="uploadFile2", required=false)MultipartFile file2) {
		int currentPage = page;
		
		int result = iService.insertReview(r);
		int updateResult = iService.updateReviewRate(itemNo);
		
		if(!file1.getOriginalFilename().equals("")) {
			String renameFileName1 = saveFile(file1, request);
			i.setImageOriginalName(file1.getOriginalFilename());
			i.setImageRename(renameFileName1);
			int imgResult1 = iService.insertReviewImage1(i);
		}
		
		if(!file2.getOriginalFilename().equals("")) {
			String renameFileName2 = saveFile(file2, request);
			i.setImageOriginalName(file2.getOriginalFilename());
			i.setImageRename(renameFileName2);
			int imgResult2 = iService.insertReviewImage2(i);
		}
		
		
		System.out.println("review result : " + result);
		if(result > 0 && updateResult > 0) {
			iService.insertRI(ri);
			return "redirect:idetail.do?itemNo=" + itemNo + "&page=" + currentPage + "&memberNo=" + memberNo + "#reviewPI";
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "." + 
		originFileName.substring(originFileName.lastIndexOf(".")+1);
		
		String filePath = folder + "\\" + renameFileName;
		
		try {
			file.transferTo(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return renameFileName;
	}
	
	
}
