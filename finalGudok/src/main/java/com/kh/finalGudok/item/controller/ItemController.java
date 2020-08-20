package com.kh.finalGudok.item.controller;

import static com.kh.finalGudok.common.pagination.getPageInfo;
import static com.kh.finalGudok.common.pagination2.getPageInfo2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.kh.finalGudok.item.model.vo.BannerItem;
import com.kh.finalGudok.item.model.vo.Board;
import com.kh.finalGudok.item.model.vo.Cart;
import com.kh.finalGudok.item.model.vo.Event;
import com.kh.finalGudok.item.model.vo.Heart;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;
import com.kh.finalGudok.member.model.vo.Member;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


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
		
		System.out.println(i.getItemRecommend());
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
		
		PageInfo pi=new PageInfo();
		
		int pageLimit=10; //보여질 페이지 총 갯수
		int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
		pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
		
		ArrayList<BannerItem> list=iService.selectEventListA(pi); //이벤트 리스트
		
		ArrayList eCountList=iService.selectEventListCount(pi); //이벤트당 상품갯수
		
	
		System.out.println(list);
		System.out.println(eCountList);
		
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
	public String deleteEvent(HttpServletRequest request,String sendArr) {
		

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
		@ResponseBody
		public String updateEventStatusY(String sendArr) {
			
		
			System.out.println("y컨트롤러옴");
			System.out.println(sendArr);
			
			
			String[] strArr=sendArr.split(",");
			System.out.println(strArr[0].toString());
			System.out.println(strArr.length);
			
			ArrayList<Event> dEventArr=new ArrayList<>();
			Event e=new Event();
			
			for(int i=0;i<strArr.length;i++) {
				e=new Event(Integer.valueOf(strArr[i]));
				dEventArr.add(e);
			
				System.out.println(dEventArr.get(i).getEventNo());
			}
			
			System.out.println("dEventArr길이"+dEventArr.size());
			System.out.println("확인할것"+dEventArr.toString());

			
			int result=0;
			
				result=iService.updateEventStatusY(dEventArr);
			
			System.out.println("변경된 갯수"+result);
			
			if(result>0) {
				
				return "success";
				
			}else {
				throw new ItemException("이벤트 게시 변경 실패!");
			}
		}
		
		
		//이벤트 중지
		@RequestMapping("eChangeN.do")
		@ResponseBody
		public String updateEventStatusN(String sendArr) {
			
		
			System.out.println("y컨트롤러옴");
			System.out.println(sendArr);
			
			
			String[] strArr=sendArr.split(",");
			System.out.println(strArr[0].toString());
			System.out.println(strArr.length);
			
			ArrayList<Event> dEventArr=new ArrayList<>();
			Event e=new Event();
			
			for(int i=0;i<strArr.length;i++) {
				e=new Event(Integer.valueOf(strArr[i]));
				dEventArr.add(e);
			
				System.out.println(dEventArr.get(i).getEventNo());
			}
			
			System.out.println("dEventArr길이"+dEventArr.size());
			System.out.println("확인할것"+dEventArr.toString());

			
			int result=0;
			
				result=iService.updateEventStatusN(dEventArr);
			
			System.out.println("변경된 갯수"+result);
			
			if(result>0) {
				
				return "success";
				
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
	
	
	
	//이벤트 리스트 보기
		@RequestMapping("eListChange.do")
		public void selectEventChange(HttpServletResponse response, Integer page) throws IOException {
		
		
			int currentPage=1;
			
			if(page!=null) {
				currentPage=page;
			}
			
			int listCount=iService.getEventCount();
			
			PageInfo pi=new PageInfo();
			
			int pageLimit=10; //보여질 페이지 총 갯수
			int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
			pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
			
			ArrayList<BannerItem> list=iService.selectEventListA(pi); //이벤트 리스트
			ArrayList eCountList=iService.selectEventListCount(pi); //이벤트당 상품갯수
			
			
			response.setContentType("application/json;charset=utf-8");

		
			if(list!=null&&eCountList!=null) {
				
				System.out.println(list);
				System.out.println(eCountList);
				JSONArray jarr=new JSONArray();
				
				for(int i=0;i<list.size();i++) {
					JSONObject jList=new JSONObject();
					
					jList.put("eventNo",list.get(i).getEventNo());
					jList.put("eventName",list.get(i).getEventName());
					jList.put("eventCnt",eCountList.get(i));
					jList.put("eventStatus",list.get(i).getEventStatus());
					
					jarr.add(jList);
				}
				
				JSONObject sendJson=new JSONObject();
				sendJson.put("bannerList",jarr);
				
				PrintWriter out=response.getWriter();
				out.print(sendJson);
				out.flush();
				out.close();
				
				
				
			}else {
				throw new ItemException("이벤트 전체 조회 실패!");
			}
		
		}
		
	
		//이벤트 검색
		@RequestMapping("searchEventA.do")
		public String searchEventA(String keyword) {
			
			
			
			Event e=new Event();
			e.setEventName(keyword);
			System.out.println("도착?"+keyword);
			
			
			return null;
			
		}
	

	
	
	//판매 상품 전체 보기
	@RequestMapping("itemListA.do")
	public ModelAndView selectItemListA(ModelAndView mv, Integer page) throws IOException {
		
		
		int currentPage=1;
		
		if(page!=null) {
			currentPage=page;
		}
		
		int listCount=iService.getItemCountA();
		
		PageInfo pi=new PageInfo();
		
		int pageLimit=10; //보여질 페이지 총 갯수
		int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
		pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
		
		ArrayList<BannerItem> list=iService.selectItemListA(pi); 


			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("admin/itemList");
			
	
		return mv;

	
	}
	
	
	//같은 이벤트 번호를 지닌 아이템들 리스트 보기
		@RequestMapping("bannerDetail.do")
		public ModelAndView bannerDetail(ModelAndView mv, int eventNo, Integer page  ) throws IOException {
			
			int currentPage=1;
			
			if(page!=null) {
				currentPage=page;
			}
			
			
			Event ev=new Event();
			ev.setEventNo(eventNo);
			
			
			int listCount=iService.getbannerItemCount(eventNo);
			
			PageInfo pi=new PageInfo();
			int pageLimit=10; //보여질 페이지 총 갯수
			int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
			
			pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
		
			ArrayList<BannerItem> biList=iService.selectBannerItem(eventNo,pi);
				mv.addObject("list",biList);
				mv.addObject("pi",pi);
				mv.addObject("ev",ev);
				mv.setViewName("admin/bannerDetail");
			return mv;
		}
		
		
		//이벤트 상품 제외
		@RequestMapping("bannerItemDelete.do")
		@ResponseBody
		public String deleteBannerItem(HttpServletRequest request,String sendArr) {
			

			System.out.println(sendArr);
			String dEvent=request.getParameter("sendArr");
			String[] strArr=dEvent.split(",");
			
			
			
			int[] dEventArr=new int[strArr.length];
			
			
			for(int i=0;i<strArr.length;i++) {
				dEventArr[i]=Integer.valueOf(strArr[i]);
				System.out.println(dEventArr[i]);
				
			}
				
			int result=iService.deleteBannerItem(dEventArr);
				
			System.out.println("1이 아님?"+result);
			
			if(result>0) {
				System.out.println("삭제 컨트롤러까진 옴");
				return "success";
				
			}else {
				throw new ItemException("이벤트 삭제 실패!");
			}
			
			
		}
	
	
		//배너 상품 제외 ajax용 
		@RequestMapping("biChange.do")
		
		public void biChange(int eventNo, HttpServletResponse response, Integer page) throws IOException {
			
			int currentPage=1;
			
			if(page!=null) {
				currentPage=page;
			}
			
			
			Event ev=new Event();
			ev.setEventNo(eventNo);
			
			
			int listCount=iService.getbannerItemCount(eventNo);
			
			PageInfo pi=new PageInfo();
			int pageLimit=10; //보여질 페이지 총 갯수
			int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
			
			pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
		
			ArrayList<BannerItem> biList=iService.selectBannerItem(eventNo,pi);
			

			response.setContentType("application/json;charset=utf-8");

		
			if(biList!=null) {
				
				System.out.println(biList);
				JSONArray jarr=new JSONArray();
				
				for(int i=0;i<biList.size();i++) {
					JSONObject jList=new JSONObject();
					
					jList.put("eventNo",biList.get(i).getEventNo());
					jList.put("itemNo",biList.get(i).getItemNo());
					jList.put("itemName",biList.get(i).getItemName());
					jList.put("itemPrice",biList.get(i).getItemPrice());
					jList.put("itemDpStatus",biList.get(i).getItemDpStatus());
					
					jarr.add(jList);
				}
				
				JSONObject sendJson=new JSONObject();
				sendJson.put("list",jarr);
				
				PrintWriter out=response.getWriter();
				out.print(sendJson);
				out.flush();
				out.close();
				
				
				
			}else {
				throw new ItemException("이벤트별 상품 조회 실패!");
			}
		
		}
		
		
		
		
		//아이템 게시
		@RequestMapping("iChangeY.do")
		@ResponseBody
		public String updateItemStatusY(String sendArr) {
			

			System.out.println("중지 컨트롤러");
			System.out.println(sendArr);
			
			
			String[] strArr=sendArr.split(",");
			System.out.println(strArr[0].toString());
			System.out.println(strArr.length);
			
			ArrayList<BannerItem> iArr=new ArrayList<>();
			
			for(int i=0;i<strArr.length;i++) {
				
				BannerItem item=new BannerItem();
				item.setItemNo(Integer.valueOf(strArr[i]));
				iArr.add(item);
			
				System.out.println(iArr.get(i).getItemNo());
			}
			
			System.out.println("iArr길이"+iArr.size());
			System.out.println("확인할것"+iArr.toString());

			
			int result=0;
			
				result=iService.updateItemStatusY(iArr);
			
			System.out.println("변경된 갯수"+result);
			
			if(result>0) {
				
				return "success";
				
			}else {
				throw new ItemException("이벤트 게시 변경 실패!");
			}
		}
		
		
		//아이템 게시 중지
		@RequestMapping("iChangeN.do")
		@ResponseBody
		public String updateItemStatusN(String sendArr) {
			
	
			System.out.println("중지 컨트롤러");
			System.out.println(sendArr);
			
			
			String[] strArr=sendArr.split(",");
			System.out.println(strArr[0].toString());
			System.out.println(strArr.length);
			
			ArrayList<BannerItem> iArr=new ArrayList<>();
			
			for(int i=0;i<strArr.length;i++) {
				
				BannerItem item=new BannerItem();
				item.setItemNo(Integer.valueOf(strArr[i]));
				iArr.add(item);
			
				System.out.println(iArr.get(i).getItemNo());
			}
			
			System.out.println("iArr길이"+iArr.size());
			System.out.println("확인할것"+iArr.toString());

			
			int result=0;
			
				result=iService.updateItemStatusN(iArr);
			
			System.out.println("변경된 갯수"+result);
			
			if(result>0) {
				
				return "success";
				
			}else {
				throw new ItemException("이벤트 게시 변경 실패!");
			}
		}

		//상태 변경 후 상품 리스트 보기
				@RequestMapping("iListChange.do")
				public void selectItemChange(HttpServletResponse response, Integer page) throws IOException {
				
				
					int currentPage=1;
					
					if(page!=null) {
						currentPage=page;
					}
					
					int listCount=iService.getEventCount();
					
					PageInfo pi=new PageInfo();
					
					int pageLimit=10; //보여질 페이지 총 갯수
					int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
					pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
					
					ArrayList<BannerItem> list=iService.selectItemListA(pi); 
				
					
					response.setContentType("application/json;charset=utf-8");

				
					if(list!=null) {
						
						System.out.println(list);
				
						JSONArray jarr=new JSONArray();
						
						for(int i=0;i<list.size();i++) {
							JSONObject jList=new JSONObject();
							
							jList.put("itemNo",list.get(i).getItemNo());
							jList.put("itemName",list.get(i).getItemName());
							jList.put("itemPrice",list.get(i).getItemPrice());
							jList.put("itemDpStatus",list.get(i).getItemDpStatus());
							
							jarr.add(jList);
						}
						
						JSONObject sendJson=new JSONObject();
						sendJson.put("list",jarr);
						
						PrintWriter out=response.getWriter();
						out.print(sendJson);
						out.flush();
						out.close();
						
						
						
					}else {
						throw new ItemException("이벤트 전체 조회 실패!");
					}
				
				}
	

		@RequestMapping("itemDetail.do")
		public ModelAndView selectItemDetail(ModelAndView mv, int itemNo, Integer page) {
			int currentPage=1;
		
			
			if(page!=null) {
				currentPage=page;
			}
			
			BannerItem i=iService.selectAdminItem(itemNo);
			
			mv.addObject("i",i);
			mv.addObject("page", currentPage);
			mv.setViewName("admin/itemModify");
			
			
			return mv;
		}
		
		//상품 정보 수정
		@RequestMapping("itemUpdate.do")
		public ModelAndView updateItem(ModelAndView mv, HttpServletRequest request, BannerItem i, @RequestParam("page") Integer page, @RequestParam("uploadFile") MultipartFile file) {
			
			int imgNo=iService.selectImageNo(i); //이미지 번호 가져오기 
			
			System.out.println(imgNo);
			String renameFileName="";
			int result1=0;
			//기존 이미지 파일 삭제
			if(!file.getOriginalFilename().equals("")) {
				if(i.getImageOriginalName()!=null) {
					deleteFile(i.getImageRename(),request);
				}
				renameFileName=saveFile(request,file);
			
			
			String root=request.getSession().getServletContext().getRealPath("resources");
			String savePath=root+"\\uploadFiles";
			
			i.setImageOriginalName(file.getOriginalFilename());
			i.setImageRename(renameFileName);
			i.setImagePath(savePath);
			i.setItemNo(imgNo);
		
			result1=iService.updateItemImg(i); //이미지 파일명 DB정보 변경 
			
			System.out.println("성공?"+result1);
			System.out.println(i.getItemNo());
			
			}
			
		
			
			
			int result2=iService.updateItem(i); //item테이블 정보 수정
//			int result3=iService.deleteEventItem(i); //이벤트 등록 테이블에서 상품 삭제
			
			if(result1>0||result2>0) {
				mv.addObject("page",page).setViewName("redirect:itemListA.do");
			}else {
				throw new ItemException("상품 정보 수정 실패!");
			}
			
			return mv;
			
		}
		
		//상품 삭제
		@RequestMapping("iDelete.do")
		public ModelAndView deleteItemA(ModelAndView mv, HttpServletRequest request,String sendArr, Integer page) {
			

			String dEvent=request.getParameter("sendArr");
			String[] strArr=dEvent.split(",");
			
			int[] dEventArr=new int[strArr.length];
			
			
			for(int i=0;i<strArr.length;i++) {
				dEventArr[i]=Integer.valueOf(strArr[i]);
				System.out.println("선택된 값:"+strArr[i]);
			}

			
			int result1=0; //상품 삭제
			int result2=0; //상품 이미지 삭제
			int result3=0; //상품 이미지 삭제
			int result4=0; //상품 이미지 삭제
		
			
			
			//선택한 상품의 정보를 객체에 담아 각각의 테이블에 있는 값을 삭제
			for(int k=0;k<dEventArr.length;k++) {
				
				BannerItem b=iService.selectDeleteItem(dEventArr[k]);
				System.out.println(b.toString());
				
				if(b.getImageOriginalName()!=null) {
					deleteFile(b.getImageRename(),request);
				}
				System.out.println("나와랏"+dEventArr[k]);
				
				result1=iService.deleteImgA(dEventArr[k]);
				result2=iService.deleteItemImgA(dEventArr[k]);
				result3=iService.deleteItemEvent(dEventArr[k]);
				result4=iService.deleteItemA(dEventArr[k]);
				
		
			}
			
			System.out.println("시작"+result1);
			System.out.println(result2);
			System.out.println(result3);
			System.out.println(result4);
			
			
			if(result1>0&&result2>0&&result4>0) {
				
				mv.addObject("page",page).setViewName("redirect:itemListA.do");
				return mv;
				
				
			}else {
				throw new ItemException("이벤트 삭제 실패!");
			}
			
			
		}

		
		@RequestMapping("iEventInsertView.do")
		public ModelAndView itemEventInsertView(ModelAndView mv, Integer page) {
			
			
			
			int currentPage=1;
			
			if(page!=null) {
				currentPage=page;
			}
			
			int listCount=iService.getNonEventItemCnt();
			
			PageInfo pi=new PageInfo();
			
			int pageLimit=10; //보여질 페이지 총 갯수
			int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
			pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
			
			
			//이벤트 목록
			ArrayList<BannerItem> eArr=iService.selectEventOption();
			
			//이벤트 등록이 안된 상품 목록
			ArrayList<BannerItem> list=iService.selectItems(pi);
		
		
			if(eArr!=null&&list!=null) {
				
				mv.addObject("eArr",eArr);
				mv.addObject("list",list);
				mv.addObject("pi",pi);
				mv.setViewName("admin/itemEvent");
				return mv;
				
			}else {
				throw new ItemException("이벤트 삭제 실패!");
			}
			
		}
		
		
		@RequestMapping("eventItemInsert.do")
		@ResponseBody
		public String eventItemInsert(HttpServletRequest request, int eventNo, int itemDiscount, String sendArr, Integer page) {
			
		
			
			String[] strArr=sendArr.split(",");
			System.out.println("받아온 길이"+strArr.length);
			int[] iArr=new int[strArr.length];
			
			
			for(int i=0;i<strArr.length;i++) {
				iArr[i]=Integer.valueOf(strArr[i]);
				System.out.println("몇번받아왔냐면"+iArr[i]);
				
			}
			
			
			
			int result1=0;
			int result2=0;
			int result3=0;
			
			for(int k=0;k<iArr.length;k++) {
				
			//아이템 테이블에서 스테이터스 y로 바꿔주기 
			result1=iService.updateItemEventStatus(iArr[k]);
			
			
			//이벤트 상품에 상품번호, 할인율, 이벤트 번호로 테이블 채우기 (기존 자료는 삭제)
			BannerItem i=new BannerItem();
			i.setItemNo(iArr[k]);
			i.setEventNo(eventNo);
			i.setItemDiscount(itemDiscount);
			
			System.out.println(i.getEventNo());
			System.out.println(i.getItemDiscount());
		
			
			result2=iService.deleteEventItemBefore(i);
			result3=iService.insertEventItem(i);
			
			}
			
		if(result1>0&&result3>0) {
		
			return "success";
			
		}else {
			throw new ItemException("이벤트 삭제 실패!");
		}
			
			
		
			
		}
		
		
		
		@RequestMapping("eventItemListChange.do")
		public void EventItemListChange(HttpServletResponse response, Integer page) throws IOException {
		
		
			int currentPage=1;
			
			if(page!=null) {
				currentPage=page;
			}
			
			int listCount=iService.getEventCount();
			
			PageInfo pi=new PageInfo();
			
			int pageLimit=10; //보여질 페이지 총 갯수
			int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
			pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
			
			//이벤트 등록이 안된 상품 목록
			ArrayList<BannerItem> list=iService.selectItems(pi);
		
			
			response.setContentType("application/json;charset=utf-8");

		
			if(list!=null) {
				
				System.out.println(list);
		
				JSONArray jarr=new JSONArray();
				
				for(int i=0;i<list.size();i++) {
					JSONObject jList=new JSONObject();
					
					jList.put("itemNo",list.get(i).getItemNo());
					jList.put("itemName",list.get(i).getItemName());
					jList.put("itemPrice",list.get(i).getItemPrice());
					jList.put("itemRate",list.get(i).getItemRate());
					
					jarr.add(jList);
				}
				
				JSONObject sendJson=new JSONObject();
				sendJson.put("list",jarr);
				
				PrintWriter out=response.getWriter();
				out.print(sendJson);
				out.flush();
				out.close();
				
				
				
			}else {
				throw new ItemException("리스트 갱신 실패!");
			}
		
		}
		
		
		
		
}
