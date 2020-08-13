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
import com.kh.finalGudok.item.model.vo.Event;
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
		
		ArrayList<Event> list=iService.selectEventList(pi); //이벤트 리스트
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
				
	
	
	
}
