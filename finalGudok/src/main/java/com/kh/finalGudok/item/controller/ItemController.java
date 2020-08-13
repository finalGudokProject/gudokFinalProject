package com.kh.finalGudok.item.controller;

import static com.kh.finalGudok.common.pagination.getPageInfo;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.kh.finalGudok.item.model.vo.AdminItem;
import com.kh.finalGudok.item.model.vo.Event;

import com.kh.finalGudok.item.model.vo.Board;
import com.kh.finalGudok.item.model.vo.Cart;
import com.kh.finalGudok.item.model.vo.Heart;

import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;
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
			mv.addObject("list", dList).addObject("pi",pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F2")) {
			int mListCount = iService.mListCount();
			System.out.println("유제품 Count : " + mListCount);
			PageInfo pi = getPageInfo(currentPage, mListCount);
			ArrayList<ItemListView> mList = iService.selectMList(pi);
			mv.addObject("list", mList).addObject("pi",pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F3")) {
			int bListCount = iService.bListCount();
			System.out.println("베이커리 Count : " + bListCount);
			PageInfo pi = getPageInfo(currentPage, bListCount);
			ArrayList<ItemListView> bList = iService.selectBList(pi);
			mv.addObject("list", bList).addObject("pi",pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F4")) {
			int sListCount = iService.sListCount();
			System.out.println("간편 Count : " + sListCount);
			PageInfo pi = getPageInfo(currentPage, sListCount);
			ArrayList<ItemListView> sList = iService.selectSList(pi);
			mv.addObject("list", sList).addObject("pi",pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F5")) {
			int hListCount = iService.hListCount();
			System.out.println("건강 Count : " + hListCount);
			PageInfo pi = getPageInfo(currentPage, hListCount);
			ArrayList<ItemListView> hList = iService.selectHList(pi);
			mv.addObject("list", hList).addObject("pi",pi).setViewName("items/itemFood");
		}else if(categoryNo.equals("F6")) {
			int diListCount = iService.diListCount();
			System.out.println("다이어트 Count : " + diListCount);
			PageInfo pi = getPageInfo(currentPage, diListCount);
			ArrayList<ItemListView> diList = iService.selectDiList(pi);
			mv.addObject("list", diList).addObject("pi",pi).setViewName("items/itemFood");
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
	
	
	@RequestMapping("iInsertView.do")
	public String itemRegisterPage() {
		return "admin/itemRegister";
	}
	
	@RequestMapping("eInsertView.do")
	public String eventPage() {
		return "admin/bannerRegister";
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

	//상품등록
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

	@RequestMapping("reviewUpdate.do")
	public String reviewUpdate(@RequestParam("reviewNo") Integer reviewNo) {
		return null;
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
	
	
	//배너 이벤트 등록
	@RequestMapping("eInsert.do")
	public String insertEvent(HttpServletRequest request, Event e, @RequestParam("uploadFile") MultipartFile file) {

		System.out.println("이벤트 등록 도착");
		String renameFileName=saveFile(request,file);
		String root=request.getSession().getServletContext().getRealPath("resources");
		String savePath=root+"\\uploadFiles";
		
		e.setImageOriginalName(file.getOriginalFilename());
		e.setImageRename(renameFileName);
		e.setImagePath(savePath);
			
		int result1=iService.insertEvent(e);
		int result2=iService.insertEventImg(e);
		
		if(result1>0&&result2>0) {
			return "redirect:eList.do";
		}else {
			throw new ItemException("배너 등록 실패!");
		}
		
		
	}
	
	//이벤트 등록 페이지 가기
	@RequestMapping("eRegisterView.do")
	public String eventRegisterView() {
		return "admin/bannerRegister";
	}

	//이벤트 리스트 보기
	@RequestMapping("eList.do")
	public ModelAndView selectEvent(ModelAndView mv, Integer page) {
	
		System.out.println("도착했낭");
		int currentPage=1;
		
		if(page!=null) {
			currentPage=page;
		}
		
		int listCount=iService.getEventCount();
		
		PageInfo pi=getPageInfo(currentPage,listCount);
		pi.setPageLimit(10); //보여질 페이지 총 갯수
		pi.setBoardLimit(5); //게시판 한 페이지에 뿌려질 게시글 수
		
		ArrayList<Event> list=iService.selectEventListA(pi); //이벤트 리스트
		ArrayList eCountList=iService.selectEventListCount(pi); //이벤트당 상품갯수
		

		
		if(list!=null&&eCountList!=null) {
			mv.addObject("list",list);
			mv.addObject("eCountList",eCountList);
			mv.addObject("pi",pi);
			mv.setViewName("admin/bannerList");
			
		}else {
			throw new ItemException("이벤트 전체 조회 실패!");
		}
		return mv;
	}
	
	
	//이벤트 삭제
	@RequestMapping("eDelete.do")
	public String deleteEvent(HttpServletRequest request, String sendArr) {
		

		String dEvent=request.getParameter("sendArr");
		String[] strArr=dEvent.split(",");
		
		int[] dEventArr=new int[strArr.length];
		
		
		for(int i=0;i<strArr.length;i++) {
			dEventArr[i]=Integer.valueOf(strArr[i]);
			System.out.println("선택된 값:"+strArr[i]);
		}

		
		int result1=0; //이벤트 삭제
		int result2=0; //연결된 상품 삭제
		int result3=0; //배너 이미지 삭제
		int result4=0; //이미지 삭제
		
		
		
		for(int k=0;k<dEventArr.length;k++) {
			
			Event e=iService.selectDeleteEvent(dEventArr[k]);
			System.out.println(e.toString());
			if(e.getImageOriginalName()!=null) {
				deleteFile(e.getImageRename(),request);
			}
			
			result1=iService.deleteEvent(dEventArr[k]);
			result2=iService.deleteEventItem(dEventArr[k]);
			result3=iService.deleteEventImg(dEventArr[k]);
			result4=iService.deleteEventBannerImg(dEventArr[k]);
		}
		
		
		
		
		if(result1>0&&result3>0&&result4>0) {
			
			return "redirect:eList.do";
			
		}else {
			throw new ItemException("이벤트 삭제 실패!");
		}
		
		
	}

	private void deleteFile(String imageRename, HttpServletRequest request) {
		String root=request.getSession().getServletContext().getRealPath("resources");
		String savePath=root+"\\uploadFiles";
		File f=new File(savePath+"\\"+imageRename);
		
		if(f.exists()) { 
			f.delete();
		}
		
	}
	
		//이벤트 게시
		@RequestMapping("eChangeY.do")
		public String updateEventStatusY(HttpServletRequest request, String sendArr) {
			
			String dEvent=request.getParameter("sendArr");
			String[] strArr=dEvent.split(",");
			
			int[] dEventArr=new int[strArr.length];
			
			
			for(int i=0;i<strArr.length;i++) {
				dEventArr[i]=Integer.valueOf(strArr[i]);
			}
			
			int result=0;
			
			for(int k=0;k<dEventArr.length;k++) {
				result=iService.updateEventStatusY(dEventArr[k]);
			}
			
			
			if(result>0) {
				
				return "redirect:eList.do";
				
			}else {
				throw new ItemException("이벤트 게시 변경 실패!");
			}
		}
		
		
		//이벤트 게시
		@RequestMapping("eChangeN.do")
		public String updateEventStatusN(HttpServletRequest request, String sendArr) {
			
			String dEvent=request.getParameter("sendArr");
			String[] strArr=dEvent.split(",");
			
			int[] dEventArr=new int[strArr.length];
			
			
			for(int i=0;i<strArr.length;i++) {
				dEventArr[i]=Integer.valueOf(strArr[i]);
			}
			
			int result=0;
			
			for(int k=0;k<dEventArr.length;k++) {
				result=iService.updateEventStatusN(dEventArr[k]);
			}
			
			
			if(result>0) {
				
				return "redirect:eList.do";
				
			}else {
				throw new ItemException("이벤트 게시 변경 실패!");
			}
		}

	@RequestMapping(value="reviewInsert.do", method=RequestMethod.POST)
	public String reviewInsert(Review r, HttpServletRequest request, @RequestParam(value = "page", required = false)Integer page
			, @RequestParam(value = "memberNo", required = false)int memberNo
			, @RequestParam(value = "itemNo", required = false)int itemNo
			, @RequestParam(value="uploadFile1", required=false)MultipartFile file1
			, @RequestParam(value="uploadFile2", required=false)MultipartFile file2) {
		int currentPage = page;
		if(!file1.getOriginalFilename().equals("")) {
			String savePath1 = saveFile(file1, request);
			if(savePath1 != null) {
				r.setReviewImg1(file1.getOriginalFilename());
			}
		}
		
		if(!file2.getOriginalFilename().contentEquals("")) {
			String savePath2 = saveFile(file2, request);
			r.setReviewImg2(file2.getOriginalFilename());
			if(savePath2 != null) {
				r.setReviewImg1(file1.getOriginalFilename());
			}
		}
		
		int result = iService.insertReview(r);
		System.out.println("review result : " + result);
		int updateResult = iService.updateReviewRate(itemNo);
		if(result > 0 && updateResult > 0) {
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
		
		String filePath = folder + "\\" + file.getOriginalFilename();
		
		try {
			file.transferTo(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
}
