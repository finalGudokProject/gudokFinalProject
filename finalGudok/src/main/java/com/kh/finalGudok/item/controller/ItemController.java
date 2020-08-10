package com.kh.finalGudok.item.controller;

import static com.kh.finalGudok.common.pagination.getPageInfo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalGudok.item.model.exception.ItemException;
import com.kh.finalGudok.item.model.service.ItemService;
import com.kh.finalGudok.item.model.vo.AdminItem;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;

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
	
	@RequestMapping("idetail.do")
	public ModelAndView itemDetailPage(ModelAndView mv, Integer itemNo, @RequestParam("page")Integer page) {
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
			ArrayList<Review> review = iService.selectReview(itemNo);
			System.out.println("review 확인 : " + review);
			mv.addObject("review",review).setViewName("items/itemDetail");
			
		}else {
			throw new ItemException("조회수 증가 실패");
		}
		return mv;
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
	
	
	@RequestMapping("iInsertView.do")
	public String itemRegisterPage() {
		return "admin/itemRegister";
	}
	
	@RequestMapping("eInsertView.do")
	public String eventPage() {
		return "admin/bannerRegister";
	}
	

	@RequestMapping("iInsert.do")
	public String itemInsert(HttpServletRequest request, AdminItem i, @RequestParam("uploadFile") MultipartFile file) {
		
		
		String renameFileName=saveFile(request,file);
		String root=request.getSession().getServletContext().getRealPath("resources");
		String savePath=root+"\\uploadFiles";
		
		i.setImageOriginalName(file.getOriginalFilename());
		i.setImageRename(renameFileName);
		i.setImagePath(savePath);
	
		
		int result1=iService.insertItem(i);
		int result2=iService.insertImage(i);
		
	
		if(result1>0 && result2>0) {
			
			return "redirect:iInsertView.do";
			
		}else {
			throw new ItemException("상품 등록 실패");
		}
		
		
		
		
	}

	private String saveFile(HttpServletRequest request, MultipartFile file) {
		
		String root=request.getSession().getServletContext().getRealPath("resources");
		String savePath=root+"\\uploadFiles";
		File folder=new File(savePath);
		
		if(!folder.exists()) {
			folder.mkdir();
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName=file.getOriginalFilename();
		String renameFileName=sdf.format(new java.sql.Date(System.currentTimeMillis()))+"."+originFileName.substring(originFileName.lastIndexOf(".")+1);
		String filePath=folder+"\\"+renameFileName;
		
		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return renameFileName;
	}
	

	
}
