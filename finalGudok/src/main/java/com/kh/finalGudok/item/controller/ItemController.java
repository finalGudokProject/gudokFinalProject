package com.kh.finalGudok.item.controller;

import static com.kh.finalGudok.common.pagination.getPageInfo;
import static com.kh.finalGudok.common.pagination2.getPageInfo2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.kh.finalGudok.item.model.vo.Image;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.ItemListView;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.item.model.vo.Review;
import com.kh.finalGudok.item.model.vo.ReviewImage;
import com.kh.finalGudok.item.model.vo.ReviewView;
import com.kh.finalGudok.item.model.vo.SearchItem;
import com.kh.finalGudok.member.model.vo.Member;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.AgainPaymentData;
import com.siot.IamportRestClient.request.ScheduleData;
import com.siot.IamportRestClient.request.ScheduleEntry;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.siot.IamportRestClient.response.Schedule;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class ItemController {

	@Autowired
	ItemService iService;

	@RequestMapping("itemNew.do")
	private ModelAndView itemNew(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			String sortNo) {
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		int listCount = iService.getNewCount();
		System.out.println("newListCount : " + listCount);
		PageInfo pi = getPageInfo(currentPage, listCount);
		if (sortNo == null) {
			ArrayList<Item> list = iService.selectNewList(pi);
			mv.addObject("list", list).addObject("pi", pi).setViewName("items/itemNew");
			System.out.println("itemNew list : " + list);
		} else if (sortNo != null) {
			ArrayList<Item> list = iService.selectNewList(pi, sortNo);
			mv.addObject("list", list).addObject("pi", pi).addObject("sortNo", sortNo).setViewName("items/itemNew");
			System.out.println("itemNew list : " + list);
		}
		return mv;
	}

	@RequestMapping("itemBest.do")
	private ModelAndView itemBest(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			String sortNo) {
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		int listCount = iService.getBestCount();
		System.out.println("bestListCount : " + listCount);
		PageInfo pi = getPageInfo(currentPage, listCount);
		if (sortNo == null) {
			ArrayList<Item> list = iService.selectBestList(pi);
			mv.addObject("list", list).addObject("pi", pi).setViewName("items/itemBest");
			System.out.println("itemBest list : " + list);
		} else if (sortNo != null) {
			ArrayList<Item> list = iService.selectBestList(pi, sortNo);
			mv.addObject("list", list).addObject("pi", pi).addObject("sortNo", sortNo).setViewName("items/itemBest");
			System.out.println("itemBest list : " + list);
		}
		return mv;
	}

	@RequestMapping("itemFood.do")
	public ModelAndView itemList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			String sortNo) {
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		int listCount = iService.getItemCount();
//		System.out.println("listCount : " + listCount);

		PageInfo pi = getPageInfo(currentPage, listCount);

		if (sortNo == null) {
			ArrayList<Item> list = iService.selectList(pi);
//			System.out.println("ArrayList : " + list);
			mv.addObject("list", list).addObject("pi", pi).setViewName("items/itemFood");
		} else if (sortNo != null) {
			ArrayList<Item> list = iService.selectList(pi, sortNo);
			mv.addObject("list", list).addObject("pi", pi).addObject("sortNo", sortNo).setViewName("items/itemFood");
		}

		return mv;
	}

	@RequestMapping("foodSort.do")
	public ModelAndView foodSort(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			String categoryNo) {
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		if (categoryNo.equals("F1")) {
			int dListCount = iService.dListCount();
//			System.out.println("���� Count : " + dListCount);
			PageInfo pi = getPageInfo(currentPage, dListCount);
			ArrayList<ItemListView> dList = iService.selectDList(pi);
			mv.addObject("list", dList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).setViewName("items/itemFood");
		} else if (categoryNo.equals("F2")) {
			int mListCount = iService.mListCount();
//			System.out.println("����ǰ Count : " + mListCount);
			PageInfo pi = getPageInfo(currentPage, mListCount);
			ArrayList<ItemListView> mList = iService.selectMList(pi);
			mv.addObject("list", mList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).setViewName("items/itemFood");
		} else if (categoryNo.equals("F3")) {
			int bListCount = iService.bListCount();
//			System.out.println("����Ŀ�� Count : " + bListCount);
			PageInfo pi = getPageInfo(currentPage, bListCount);
			ArrayList<ItemListView> bList = iService.selectBList(pi);
			mv.addObject("list", bList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).setViewName("items/itemFood");
		} else if (categoryNo.equals("F4")) {
			int sListCount = iService.sListCount();
//			System.out.println("���� Count : " + sListCount);
			PageInfo pi = getPageInfo(currentPage, sListCount);
			ArrayList<ItemListView> sList = iService.selectSList(pi);
			mv.addObject("list", sList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).setViewName("items/itemFood");
		} else if (categoryNo.equals("F5")) {
			int hListCount = iService.hListCount();
//			System.out.println("�ǰ� Count : " + hListCount);
			PageInfo pi = getPageInfo(currentPage, hListCount);
			ArrayList<ItemListView> hList = iService.selectHList(pi);
			mv.addObject("list", hList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).setViewName("items/itemFood");
		} else if (categoryNo.equals("F6")) {
			int diListCount = iService.diListCount();
//			System.out.println("���̾�Ʈ Count : " + diListCount);
			PageInfo pi = getPageInfo(currentPage, diListCount);
			ArrayList<ItemListView> diList = iService.selectDiList(pi);
			mv.addObject("list", diList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).setViewName("items/itemFood");
		}

		return mv;
	}

	@RequestMapping("livingSort.do")
	public ModelAndView livingSort(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			String categoryNo, @RequestParam(value = "sortNo", required = false) String sortNo) {
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		if (categoryNo != null) {
			int livingCateCount = iService.livingCateCount(categoryNo);
			System.out.println("���� Count : " + livingCateCount);
			PageInfo pi = getPageInfo(currentPage, livingCateCount);
			ArrayList<ItemListView> livingCateList = iService.livingCateList(pi, categoryNo, sortNo);
			mv.addObject("list", livingCateList).addObject("pi", pi).addObject("livingChk", "L0")
					.addObject("categoryNo", categoryNo).addObject("sortNo", sortNo).setViewName("items/itemLiving");
		}
		return mv;
	}

	@RequestMapping("fSort.do")
	public ModelAndView foodSort(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			String categoryNo, @RequestParam("sortNo") String sortNo) {
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		System.out.println("sortNo : " + sortNo);
		if (categoryNo.equals("F1") && sortNo != null) {
			int dListCounts = iService.dListCount();
			PageInfo pi = getPageInfo(currentPage, dListCounts);
			ArrayList<ItemListView> dLists = iService.selectDLists(pi, sortNo);
			mv.addObject("list", dLists).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).addObject("sortNo", sortNo).setViewName("items/itemFood");
		} else if (categoryNo.equals("F2") && sortNo != null) {
			int mListCount = iService.mListCount();
			PageInfo pi = getPageInfo(currentPage, mListCount);
			ArrayList<ItemListView> mList = iService.selectMLists(pi, sortNo);
			mv.addObject("list", mList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).addObject("sortNo", sortNo).setViewName("items/itemFood");
		} else if (categoryNo.equals("F3") && sortNo != null) {
			int bListCount = iService.bListCount();
			PageInfo pi = getPageInfo(currentPage, bListCount);
			ArrayList<ItemListView> bList = iService.selectBLists(pi, sortNo);
			mv.addObject("list", bList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).addObject("sortNo", sortNo).setViewName("items/itemFood");
		} else if (categoryNo.equals("F4") && sortNo != null) {
			int sListCount = iService.sListCount();
			PageInfo pi = getPageInfo(currentPage, sListCount);
			ArrayList<ItemListView> sList = iService.selectSLists(pi, sortNo);
			mv.addObject("list", sList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).addObject("sortNo", sortNo).setViewName("items/itemFood");
		} else if (categoryNo.equals("F5") && sortNo != null) {
			int hListCount = iService.hListCount();
			PageInfo pi = getPageInfo(currentPage, hListCount);
			ArrayList<ItemListView> hList = iService.selectHLists(pi, sortNo);
			mv.addObject("list", hList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).addObject("sortNo", sortNo).setViewName("items/itemFood");
		} else if (categoryNo.equals("F6") && sortNo != null) {
			int diListCount = iService.diListCount();
			PageInfo pi = getPageInfo(currentPage, diListCount);
			ArrayList<ItemListView> diList = iService.selectDiLists(pi, sortNo);
			mv.addObject("list", diList).addObject("pi", pi).addObject("foodChk", "F0")
					.addObject("categoryNo", categoryNo).addObject("sortNo", sortNo).setViewName("items/itemFood");
		}
		return mv;
	}

	@RequestMapping("itemLiving.do")
	public ModelAndView itemLivingList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			String sortNo) {
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		int listCount = iService.getItemLivingCount();
//		System.out.println("listCount : " + listCount);

		PageInfo pi = getPageInfo(currentPage, listCount);

		if (sortNo == null) {
			ArrayList<Item> list = iService.selectLivingList(pi);
//			System.out.println("ArrayList : " + list);
			mv.addObject("list", list).addObject("pi", pi).setViewName("items/itemLiving");
		} else if (sortNo != null) {
			ArrayList<Item> list = iService.selectLivingList(pi, sortNo);
			mv.addObject("list", list).addObject("pi", pi).addObject("sortNo", sortNo).setViewName("items/itemLiving");
		}

		return mv;
	}

	@RequestMapping("itemEvent.do")
	public ModelAndView itemEventList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			String sortNo) {
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		int listCount = iService.getItemEventCount();
//		System.out.println("listCount : " + listCount);

		PageInfo pi = getPageInfo(currentPage, listCount);
		if (sortNo == null) {
			ArrayList<Item> list = iService.selectEventList(pi);
//			System.out.println("ArrayList : " + list);
			mv.addObject("list", list).addObject("pi", pi).setViewName("items/itemEvent");
		} else if (sortNo != null) {
			ArrayList<Item> list = iService.selectEventList(pi, sortNo);
			mv.addObject("list", list).addObject("pi", pi).addObject("sortNo", sortNo).setViewName("items/itemEvent");
		}
		return mv;
	}

	@RequestMapping("idetail.do")
	public ModelAndView itemDetailPage(ModelAndView mv, Integer itemNo, @RequestParam("page") Integer page,
			Integer memberNo) {
//		System.out.println("itemNo : " + itemNo + ", page : " + page);
		int currentPage = page;
		int result = iService.detailCount(itemNo);
//		System.out.println("������? : " + result);
		if (result > 0) {
			ItemListView ilv = iService.selectItem(itemNo);

			if (ilv != null) {
				mv.addObject("ilv", ilv).addObject("currentPage", currentPage).setViewName("items/itemDetail");
			} else {
				throw new ItemException("��ȸ ����");
			}

			// �ش� ��ǰ ���� ��ȸ
			ArrayList<Review> review = iService.selectReview(itemNo);
//			System.out.println("review Ȯ�� : " + review);
			if (review != null) {
				ArrayList<ReviewView> reviewImg = iService.selectAllReviewImg(itemNo);
				mv.addObject("review", review).addObject("img", reviewImg).setViewName("items/itemDetail");
			}

			Heart hResult = iService.detailHeart(itemNo);
			System.out.println("hResult : " + hResult);
			mv.addObject("hResult", hResult).setViewName("items/itemDetail");

		} else {
			throw new ItemException("��ȸ�� ���� ����");
		}
		return mv;
	}

	@RequestMapping("itemReview.do")
	public ModelAndView reviewPage(ModelAndView mv, int itemNo) {
		ArrayList<Review> review = iService.selectAllReview(itemNo);
		if (review != null) {
			ArrayList<ReviewView> reviewImg = iService.selectAllReviewImg(itemNo);
			Item i = iService.reviewItemName(itemNo);
			mv.addObject("review", review).addObject("img", reviewImg).addObject("item", i)
					.setViewName("items/itemReview");
		}
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
//		System.out.println("�� Ȯ�� : " + result);
		int result2 = iService.updatePChoice(itemNo);
		if (result > 0 && result2 > 0) {
			return "success";
		} else {
			throw new ItemException("�� ����");
		}
	}

	@RequestMapping("choiceDel.do")
	@ResponseBody
	public String choiceDelete(HttpServletRequest request, Heart h, Integer itemNo) {
		int result = iService.deleteChoice(h);
//		System.out.println("�� ���� Ȯ�� : " + result);
		int result2 = iService.updateMChoice(itemNo);
		if (result > 0 && result2 > 0) {
			return "success";
		} else {
			throw new ItemException("�� ���� ����");
		}
	}

	// ��ٱ��� ���� ����Ʈ ����
	@ResponseBody
	@RequestMapping(value = "basketDel.do", method = RequestMethod.POST)
	public String cartDelete(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "checkboxArr[]") List<String> checkArr, Cart c) {
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();

		int cartNo = 0;

		if (member != null) {
			c.setMemberId(memberId);
			for (String i : checkArr) {
				cartNo = Integer.parseInt(i);
				c.setCartNo(cartNo);
				iService.deleteCart(c);
			}
		}
		return "success";

	}

	// ��ٱ��� �߰�
	@RequestMapping("basket.do")
	@ResponseBody
	public String insertCart(HttpServletRequest request, Cart c) {
		int result = iService.insertCart(c);
		if (result > 0) {
			return "success";
		} else {
			throw new ItemException("�߰� ����");
		}
	}

	// ��ٱ��� ������ ����Ʈ �ҷ�����
	@RequestMapping("basketPage.do")
	public ModelAndView basketPage(ModelAndView mv, Integer memberNo) {
		ArrayList<Cart> list = iService.selectBasket(memberNo);
		mv.addObject("list", list).setViewName("order/basket");
//			System.out.println("basketList : " + list);
		return mv;
	}

	// �� ������ ��ǰ ����
	@RequestMapping("inquire.do")
	@ResponseBody
	public String itemInquire(HttpServletRequest request, Board b) {
		int result = iService.insertInquired(b);
		if (result > 0) {
			iService.insertOneInquiry();
			iService.insertInquiry();
			return "success";
		} else {
			return "fail";
		}
	}

	// ���� �󼼺���
	@RequestMapping("reviewDetail.do")
	public ModelAndView reviewDetail(ModelAndView mv, @RequestParam("reviewNo") int reviewNo) {
		ArrayList<ReviewView> rv = iService.selectReviewDetail(reviewNo);
//		System.out.println("detail : " + rv);
		mv.addObject("rv", rv).setViewName("items/reviewUpdate");
		return mv;

	}

	private String saveFile(HttpServletRequest request, MultipartFile file) {

		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\uploadFiles";
		File folder = new File(savePath);

		if (!folder.exists()) {
			folder.mkdir();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
				+ originFileName.substring(originFileName.lastIndexOf(".") + 1);
		String filePath = folder + "\\" + renameFileName;

		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		return renameFileName;
	}

	// ��ǰ���-admin
	@RequestMapping("iInsert.do")
	public String itemInsert(HttpServletRequest request, AdminItem i,
			@RequestParam(value = "uploadFile1") MultipartFile uploadFile1,
			@RequestParam(value = "uploadFile2") MultipartFile uploadFile2) {

		int result1 = 0;
		int result2 = 0;

		String renameFileName = saveFile(request, uploadFile1);
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\uploadFiles";

		i.setImageOriginalName(uploadFile1.getOriginalFilename());
		i.setImageRename(renameFileName);
		i.setImagePath(savePath);

		result1 = iService.insertItem(i);

		String renameFileName2 = saveFile(request, uploadFile2);
		String root2 = request.getSession().getServletContext().getRealPath("resources");
		String savePath2 = root2 + "\\uploadFiles";

		i.setImageOriginalName(uploadFile2.getOriginalFilename());
		i.setImageRename(renameFileName2);
		i.setImagePath(savePath2);

		result2 = iService.insertImage(i);

		System.out.println(result1);
		System.out.println(result2);

		if (result1 > 0 && result2 > 0) {

			return "redirect:iInsertView.do";

		} else {
			throw new ItemException("��ǰ ��� ����");
		}

	}

	// ��� �̺�Ʈ ���-admin
	@RequestMapping("eInsert.do")
	public String insertEvent(HttpServletRequest request, Event e, @RequestParam("uploadFile") MultipartFile file) {

		System.out.println("�̺�Ʈ ��� ����");
		String renameFileName = saveFile(request, file);
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\uploadFiles";

		e.setImageOriginalName(file.getOriginalFilename());
		e.setImageRename(renameFileName);
		e.setImagePath(savePath);

		int result1 = iService.insertEvent(e);
		int result2 = iService.insertEventImg(e);

		if (result1 > 0 && result2 > 0) {
			return "redirect:eList.do";
		} else {
			throw new ItemException("��� ��� ����!");
		}

	}

	// �̺�Ʈ ��� ������ ����
	@RequestMapping("eRegisterView.do")
	public String eventRegisterView() {
		return "admin/bannerRegister";
	}

	// �̺�Ʈ ����Ʈ ����-admin
	@RequestMapping("eList.do")
	public ModelAndView selectEvent(ModelAndView mv, Integer page,
			@RequestParam(value = "word", required = false) String word) {

		if (word == "") {
			word = null;
		}

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = iService.getEventCount(word);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<BannerItem> list = iService.selectEventListA(word, pi); // �̺�Ʈ ����Ʈ
		ArrayList<Integer> eCountList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {

			Integer s = iService.selectEventListCount(list.get(i).getEventNo()); // �̺�Ʈ�� ��ǰ����
			if (s == null) {
				s = 0;
			}
			eCountList.add(s);
		}

		System.out.println(list);
		System.out.println(eCountList);

		if (list != null && eCountList != null) {
			mv.addObject("list", list);
			mv.addObject("eCountList", eCountList);
			mv.addObject("pi", pi);
			mv.setViewName("admin/bannerList");

		} else {
			throw new ItemException("�̺�Ʈ ��ü ��ȸ ����!");
		}
		return mv;
	}

	// �̺�Ʈ ����-admin
	@RequestMapping("eDelete.do")
	public String deleteEvent(HttpServletRequest request, String sendArr) {

		String dEvent = request.getParameter("sendArr");
		String[] strArr = dEvent.split(",");

		int[] dEventArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			dEventArr[i] = Integer.valueOf(strArr[i]);
			System.out.println("���õ� ��:" + strArr[i]);
		}

		int result1 = 0; // �̺�Ʈ ����
		int result2 = 0; // ����� ��ǰ ����
		int result3 = 0; // ��� �̹��� ����
		int result4 = 0; // �̹��� ����

		for (int k = 0; k < dEventArr.length; k++) {

			Event e = iService.selectDeleteEvent(dEventArr[k]);
			System.out.println(e.toString());
			if (e.getImageOriginalName() != null) {
				deleteFile(e.getImageRename(), request);
			}

			result1 = iService.deleteEvent(dEventArr[k]);
			result2 = iService.deleteEventItem(dEventArr[k]);
			result3 = iService.deleteEventImg(dEventArr[k]);
			result4 = iService.deleteEventBannerImg(dEventArr[k]);
		}

		if (result1 > 0 && result3 > 0 && result4 > 0) {

			return "redirect:eList.do";

		} else {
			throw new ItemException("�̺�Ʈ ���� ����!");
		}

	}

	// �̺�Ʈ �Խ�-admin
	@RequestMapping("eChangeY.do")
	@ResponseBody
	public String updateEventStatusY(String sendArr) {

		System.out.println("y��Ʈ�ѷ���");
		System.out.println(sendArr);

		String[] strArr = sendArr.split(",");
		System.out.println(strArr[0].toString());
		System.out.println(strArr.length);

		ArrayList<Event> dEventArr = new ArrayList<>();
		Event e = new Event();

		for (int i = 0; i < strArr.length; i++) {
			e = new Event(Integer.valueOf(strArr[i]));
			dEventArr.add(e);

			System.out.println(dEventArr.get(i).getEventNo());
		}

		System.out.println("dEventArr����" + dEventArr.size());
		System.out.println("Ȯ���Ұ�" + dEventArr.toString());

		int result = 0;

		result = iService.updateEventStatusY(dEventArr);

		System.out.println("����� ����" + result);

		if (result > 0) {

			return "success";

		} else {
			throw new ItemException("�̺�Ʈ �Խ� ���� ����!");
		}
	}

	// �̺�Ʈ ����-admin
	@RequestMapping("eChangeN.do")
	@ResponseBody
	public String updateEventStatusN(String sendArr) {

		System.out.println("y��Ʈ�ѷ���");
		System.out.println(sendArr);

		String[] strArr = sendArr.split(",");
		System.out.println(strArr[0].toString());
		System.out.println(strArr.length);

		ArrayList<Event> dEventArr = new ArrayList<>();
		Event e = new Event();

		for (int i = 0; i < strArr.length; i++) {
			e = new Event(Integer.valueOf(strArr[i]));
			dEventArr.add(e);

			System.out.println(dEventArr.get(i).getEventNo());
		}

		System.out.println("dEventArr����" + dEventArr.size());
		System.out.println("Ȯ���Ұ�" + dEventArr.toString());

		int result = 0;

		result = iService.updateEventStatusN(dEventArr);

		System.out.println("����� ����" + result);

		if (result > 0) {

			return "success";

		} else {
			throw new ItemException("�̺�Ʈ �Խ� ���� ����!");
		}
	}

	// ���� ����
	@RequestMapping("reviewUpdate.do")
	public ModelAndView reviewUpdate(Review r, ModelAndView mv, @RequestParam("itemNo") int itemNo) {
//			System.out.println("Review : " + r);
		int result = iService.reviewUpdate(r);
//			System.out.println("itemNo Ȯ�� : " + itemNo);
//			System.out.println("review update ��� : " + result);
		if (result > 0) {
			int rateResult = iService.updateReviewRate(itemNo);
//				System.out.println("��� update Ȯ�� : " + rateResult);
			mv.setViewName("redirect:itemReview.do?itemNo=" + itemNo);
		}
		return mv;
	}

	// ���� ����
	@RequestMapping("reviewDelete.do")
	public ModelAndView reviewDelete(HttpServletRequest request, ModelAndView mv, int reviewNo, int itemNo) {
//			System.out.println("reviewNo �Ѿ� ��? : " + reviewNo);

		ArrayList<ReviewView> rv = iService.selectDeleteReview(reviewNo);
		for (ReviewView r : rv) {
			if (r.getImageOriginalName() != null) {
				deleteFile(r.getImageRename(), request);
			}
		}
		int chkImg = iService.checkImage(reviewNo);
		System.out.println("ReviewImage ��ȸ �ǳ�? : " + chkImg);
		if (chkImg > 0) {
			int imResult = iService.imageDelete(reviewNo);
			if (imResult > 0) {
				iService.reviewImageDelete(reviewNo);
			}
		}
		int result = iService.reviewDelete(reviewNo);

		if (result > 0) {
			ArrayList<Review> review = iService.selectAllReview(itemNo);
			if (review.size() == 0) {
				int count0 = iService.updateReviewRate0(itemNo);
				mv.setViewName("redirect:itemReview.do?itemNo=" + itemNo);
			} else {
				iService.updateReviewRate(itemNo);
				mv.setViewName("redirect:itemReview.do?itemNo=" + itemNo);
			}
		}
		return mv;
	}

	private void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\iuploadFiles";
		File f1 = new File(savePath + "\\" + fileName);
		if (f1.exists()) {
			f1.delete();
		}
	}

	// ���� ����
	@RequestMapping(value = "reviewInsert.do", method = RequestMethod.POST)
	public String reviewInsert(Review r, Image i, ReviewImage ri, HttpServletRequest request,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "memberNo", required = false) int memberNo,
			@RequestParam(value = "itemNo", required = false) int itemNo,
			@RequestParam(value = "uploadFile1", required = false) MultipartFile file1,
			@RequestParam(value = "uploadFile2", required = false) MultipartFile file2) {
		int currentPage = page;

		int result = iService.insertReview(r);
		int updateResult = iService.updateReviewRate(itemNo);

		if (!file1.getOriginalFilename().equals("")) {
			String renameFileName1 = saveFile(file1, request);
			i.setImageOriginalName(file1.getOriginalFilename());
			i.setImageRename(renameFileName1);
			int imgResult1 = iService.insertReviewImage1(i);
			if (imgResult1 > 0) {
				iService.insertRI(ri);
			}
		}

		if (!file2.getOriginalFilename().equals("")) {
			String renameFileName2 = saveFile(file2, request);
			i.setImageOriginalName(file2.getOriginalFilename());
			i.setImageRename(renameFileName2);
			int imgResult2 = iService.insertReviewImage2(i);
			if (imgResult2 > 0) {
				iService.insertRI(ri);
			}
		}

		System.out.println("review result : " + result);
		if (result > 0 && updateResult > 0) {
			return "redirect:idetail.do?itemNo=" + itemNo + "&page=" + currentPage + "&memberNo=" + memberNo
					+ "#reviewPI";
		} else {
			throw new ItemException("���� ��� ����");
		}
	}

	private String saveFile(MultipartFile file, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\iuploadFiles";
		File folder = new File(savePath);
		if (!folder.exists()) {
			folder.mkdirs();
		}

//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//			String originFileName = file.getOriginalFilename();
//			String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "." + 
//			originFileName.substring(originFileName.lastIndexOf(".")+1);

		int random = (int) (Math.random() * 100000 + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + random + "."
				+ originFileName.substring(originFileName.lastIndexOf(".") + 1);

		String filePath = folder + "\\" + renameFileName;

		try {
			file.transferTo(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return renameFileName;
	}

	// �̺�Ʈ ����Ʈ ����-admin
	@RequestMapping("eListChange.do")
	public void selectEventChange(HttpServletResponse response, Integer page,
			@RequestParam(value = "itemCategory", required = false) String itemCategory) throws IOException {

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = iService.getEventCount(itemCategory);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<BannerItem> list = iService.selectEventListA(itemCategory, pi); // �̺�Ʈ ����Ʈ
		ArrayList<Integer> eCountList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {

			Integer s = iService.selectEventListCount(list.get(i).getEventNo()); // �̺�Ʈ�� ��ǰ����
			if (s == null) {
				s = 0;
			}
			eCountList.add(s);
		}

		response.setContentType("application/json;charset=utf-8");

		if (list != null && eCountList != null) {

			System.out.println(list);
			System.out.println(eCountList);
			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject jList = new JSONObject();

				jList.put("eventNo", list.get(i).getEventNo());
				jList.put("eventName", list.get(i).getEventName());
				jList.put("eventCnt", eCountList.get(i));
				jList.put("eventStatus", list.get(i).getEventStatus());

				jarr.add(jList);
			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("bannerList", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new ItemException("�̺�Ʈ ��ü ��ȸ ����!");
		}

	}

	// �̺�Ʈ �˻�-admin
	@RequestMapping("searchEventA.do")
	public String searchEventA(String keyword) {

		Event e = new Event();
		e.setEventName(keyword);
		System.out.println("����?" + keyword);

		return null;

	}

	// �Ǹ� ��ǰ ��ü ����-admin
	@RequestMapping("itemListA.do")
	public ModelAndView selectItemListA(ModelAndView mv, Integer page,
			@RequestParam(value = "categoryNo", required = false) String categoryNo,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "word", required = false) String word) throws IOException {

		if (type == "") {
			type = null;
		}
		if (categoryNo == "") {
			categoryNo = null;
		}
		if (word == "") {
			word = null;
		}

		System.out.println(categoryNo);
		System.out.println(type);
		System.out.println(word);

		SearchItem s = new SearchItem();
		s.setCategoryNo(categoryNo);

		if (type == null) {
			s.setItemNo(word);
			s.setItemName(word);

		} else {
			System.out.println("�ִ� ���");
			if (type.equalsIgnoreCase("itemNo")) {
				System.out.println("�ѹ��� �ܾ� ����");
				s.setItemNo(word);
			} else {
				System.out.println("�̸��� �ܾ� ����");
				s.setItemName(word);
			}
		}

		System.out.println(s);

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = iService.getItemCountA(s);
		System.out.println("������?" + listCount);
		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<BannerItem> rList = iService.selectRecommendList();

		ArrayList<BannerItem> list = iService.selectItemListA(s, pi);
		System.out.println(list);

		mv.addObject("list", list);
		mv.addObject("rList", rList);
		mv.addObject("pi", pi);
		mv.addObject("categoryNo", categoryNo);
		mv.addObject("type", type);
		mv.addObject("word", word);
		mv.setViewName("admin/itemList");

		return mv;

	}

	// ���� �̺�Ʈ ��ȣ�� ���� �����۵� ����Ʈ ����-admin
	@RequestMapping("bannerDetail.do")
	public ModelAndView bannerDetail(ModelAndView mv, int eventNo, Integer page) throws IOException {

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		Event ev = new Event();
		ev.setEventNo(eventNo);

		int listCount = iService.getbannerItemCount(eventNo);

		PageInfo pi = new PageInfo();
		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��

		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<BannerItem> biList = iService.selectBannerItem(eventNo, pi);
		mv.addObject("list", biList);
		mv.addObject("pi", pi);
		mv.addObject("ev", ev);
		mv.setViewName("admin/bannerDetail");
		return mv;
	}

	// �̺�Ʈ ��ǰ ����-admin
	@RequestMapping("bannerItemDelete.do")
	@ResponseBody
	public String deleteBannerItem(HttpServletRequest request, String sendArr) {

		System.out.println(sendArr);
		String dEvent = request.getParameter("sendArr");
		String[] strArr = dEvent.split(",");

		int[] dEventArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			dEventArr[i] = Integer.valueOf(strArr[i]);
			System.out.println(dEventArr[i]);

		}

		int result = iService.deleteBannerItem(dEventArr);

		System.out.println("1�� �ƴ�?" + result);

		if (result > 0) {
			System.out.println("���� ��Ʈ�ѷ����� ��");
			return "success";

		} else {
			throw new ItemException("�̺�Ʈ ���� ����!");
		}

	}

	// ��� ��ǰ ���� ajax�� -admin
	@RequestMapping("biChange.do")

	public void biChange(int eventNo, HttpServletResponse response, Integer page) throws IOException {

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		Event ev = new Event();
		ev.setEventNo(eventNo);

		int listCount = iService.getbannerItemCount(eventNo);

		PageInfo pi = new PageInfo();
		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��

		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<BannerItem> biList = iService.selectBannerItem(eventNo, pi);

		response.setContentType("application/json;charset=utf-8");

		if (biList != null) {

			System.out.println(biList);
			JSONArray jarr = new JSONArray();

			for (int i = 0; i < biList.size(); i++) {
				JSONObject jList = new JSONObject();

				jList.put("eventNo", biList.get(i).getEventNo());
				jList.put("itemNo", biList.get(i).getItemNo());
				jList.put("itemName", biList.get(i).getItemName());
				jList.put("itemPrice", biList.get(i).getItemPrice());
				jList.put("itemDpStatus", biList.get(i).getItemDpStatus());

				jarr.add(jList);
			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("list", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new ItemException("�̺�Ʈ�� ��ǰ ��ȸ ����!");
		}

	}

	// ������ �Խ�-admin
	@RequestMapping("iChangeY.do")
	@ResponseBody
	public String updateItemStatusY(String sendArr) {

		System.out.println("���� ��Ʈ�ѷ�");
		System.out.println(sendArr);

		String[] strArr = sendArr.split(",");
		System.out.println(strArr[0].toString());
		System.out.println(strArr.length);

		ArrayList<BannerItem> iArr = new ArrayList<>();

		for (int i = 0; i < strArr.length; i++) {

			BannerItem item = new BannerItem();
			item.setItemNo(Integer.valueOf(strArr[i]));
			iArr.add(item);

			System.out.println(iArr.get(i).getItemNo());
		}

		System.out.println("iArr����" + iArr.size());
		System.out.println("Ȯ���Ұ�" + iArr.toString());

		int result = 0;

		result = iService.updateItemStatusY(iArr);

		System.out.println("����� ����" + result);

		if (result > 0) {

			return "success";

		} else {
			throw new ItemException("�̺�Ʈ �Խ� ���� ����!");
		}
	}

	// ������ �Խ� ����-admin
	@RequestMapping("iChangeN.do")
	@ResponseBody
	public String updateItemStatusN(String sendArr) {

		System.out.println("���� ��Ʈ�ѷ�");
		System.out.println(sendArr);

		String[] strArr = sendArr.split(",");
		System.out.println(strArr[0].toString());
		System.out.println(strArr.length);

		ArrayList<BannerItem> iArr = new ArrayList<>();

		for (int i = 0; i < strArr.length; i++) {

			BannerItem item = new BannerItem();
			item.setItemNo(Integer.valueOf(strArr[i]));
			iArr.add(item);

			System.out.println(iArr.get(i).getItemNo());
		}

		System.out.println("iArr����" + iArr.size());
		System.out.println("Ȯ���Ұ�" + iArr.toString());

		int result = 0;

		result = iService.updateItemStatusN(iArr);

		System.out.println("����� ����" + result);

		if (result > 0) {

			return "success";

		} else {
			throw new ItemException("�̺�Ʈ �Խ� ���� ����!");
		}
	}

	// ���� ���� �� ��ǰ ����Ʈ ����-admin
	@RequestMapping("iListChange.do")
	public void selectItemChange(HttpServletResponse response, Integer page,
			@RequestParam(value = "categoryNo", required = false) String categoryNo,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "word", required = false) String word) throws IOException {

		if (type == "") {
			type = null;
		}
		if (categoryNo == "") {
			categoryNo = null;
		}
		if (word == "") {
			word = null;
		}

		System.out.println(categoryNo);
		System.out.println(type);
		System.out.println(word);

		SearchItem s = new SearchItem();
		s.setCategoryNo(categoryNo);

		if (type == null) {
			s.setItemNo(word);
			s.setItemName(word);

		} else {

			if (type.equalsIgnoreCase("itemNo")) {
				s.setItemNo(word);
			} else {
				s.setItemName(word);
			}
		}

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = iService.getItemCountA(s);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<BannerItem> list = iService.selectItemListA(s, pi);

		response.setContentType("application/json;charset=utf-8");

		if (list != null) {

			System.out.println(list);

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject jList = new JSONObject();

				jList.put("itemNo", list.get(i).getItemNo());
				jList.put("itemName", list.get(i).getItemName());
				jList.put("itemPrice", list.get(i).getItemPrice());
				jList.put("itemDiscount", list.get(i).getItemDiscount());
				jList.put("itemDpStatus", list.get(i).getItemDpStatus());

				jarr.add(jList);
			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("list", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new ItemException("�̺�Ʈ ��ü ��ȸ ����!");
		}

	}

	// ��ǰ �󼼺��� -admin
	@RequestMapping("itemDetail.do")
	public ModelAndView selectItemDetail(ModelAndView mv, int itemNo, Integer page, String type) {

		System.out.println("������ ������" + type);

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		BannerItem i = iService.selectAdminItem(itemNo); // ��ǰ ����
		ArrayList<BannerItem> m = iService.selectItemImg(itemNo); // �̹��� ����
		System.out.println(m);

		mv.addObject("i", i);
		mv.addObject("m", m);
		mv.addObject("type", type);
		mv.addObject("page", currentPage);
		mv.setViewName("admin/itemModify");

		return mv;
	}

	// ��ǰ ���� ����
	@RequestMapping("itemUpdate.do")
	public ModelAndView updateItem(ModelAndView mv, HttpServletRequest request, BannerItem i,
			@RequestParam("page") Integer page, @RequestParam("uploadFile") MultipartFile file) {

		int imgNo = iService.selectImageNo(i); // �̹��� ��ȣ ��������

		System.out.println(imgNo);
		String renameFileName = "";
		int result1 = 0;
		// ���� �̹��� ���� ����
		if (!file.getOriginalFilename().equals("")) {
			if (i.getImageOriginalName() != null) {
				deleteFile(i.getImageRename(), request);
			}
			renameFileName = saveFile(request, file);

			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\uploadFiles";

			i.setImageOriginalName(file.getOriginalFilename());
			i.setImageRename(renameFileName);
			i.setImagePath(savePath);
			i.setItemNo(imgNo);

			result1 = iService.updateItemImg(i); // �̹��� ���ϸ� DB���� ����

			System.out.println("����?" + result1);
			System.out.println(i.getItemNo());

		}

		int result2 = iService.updateItem(i); // item���̺� ���� ����
//			int result3=iService.deleteEventItem(i); //�̺�Ʈ ��� ���̺��� ��ǰ ����

		if (result1 > 0 || result2 > 0) {
			mv.addObject("page", page).setViewName("redirect:itemListA.do");
		} else {
			throw new ItemException("��ǰ ���� ���� ����!");
		}

		return mv;

	}

	// ��ǰ ����-admin
	@RequestMapping("iDelete.do")
	public ModelAndView deleteItemA(ModelAndView mv, HttpServletRequest request, String sendArr, Integer page) {

		String dEvent = request.getParameter("sendArr");
		String[] strArr = dEvent.split(",");

		int[] dEventArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			dEventArr[i] = Integer.valueOf(strArr[i]);
			System.out.println("���õ� ��:" + strArr[i]);
		}

		int result1 = 0; // ��ǰ ����
		int result2 = 0; // ��ǰ �̹��� ����
		int result3 = 0; // ��ǰ �̹��� ����
		int result4 = 0; // ��ǰ �̹��� ����

		// ������ ��ǰ�� ������ ��ü�� ��� ������ ���̺� �ִ� ���� ����
		for (int k = 0; k < dEventArr.length; k++) {

			BannerItem b = iService.selectDeleteItem(dEventArr[k]);
			System.out.println(b.toString());

			if (b.getImageOriginalName() != null) {
				deleteFile(b.getImageRename(), request);
			}
			System.out.println("���Ͷ�" + dEventArr[k]);

			result1 = iService.deleteImgA(dEventArr[k]);
			result2 = iService.deleteItemImgA(dEventArr[k]);
			result3 = iService.deleteItemEvent(dEventArr[k]);
			result4 = iService.deleteItemA(dEventArr[k]);

		}

		System.out.println("����" + result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);

		if (result1 > 0 && result2 > 0 && result4 > 0) {

			mv.addObject("page", page).setViewName("redirect:itemListA.do");
			return mv;

		} else {
			throw new ItemException("�̺�Ʈ ���� ����!");
		}

	}

	// �̺�Ʈ ��ǰ ���-admin
	@RequestMapping("iEventInsertView.do")
	public ModelAndView itemEventInsertView(ModelAndView mv, Integer page,
			@RequestParam(value = "itemCategory", required = false) String itemCategory) {

		if (itemCategory == "") {
			itemCategory = null;
		}
		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = iService.getNonEventItemCnt(itemCategory);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		// �̺�Ʈ ���
		ArrayList<BannerItem> eArr = iService.selectEventOption();

		// �̺�Ʈ ����� �ȵ� ��ǰ ����Ʈ
		ArrayList<BannerItem> list = iService.selectItems(itemCategory, pi);

		if (eArr != null && list != null) {

			mv.addObject("eArr", eArr);
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.addObject("itemCategory", itemCategory);

			mv.setViewName("admin/itemEvent");
			return mv;

		} else {
			throw new ItemException("�̺�Ʈ ���� ����!");
		}

	}

	// ������ �̺�Ʈ�� ��� -admin
	@RequestMapping("eventItemInsert.do")
	@ResponseBody
	public String eventItemInsert(HttpServletRequest request, int eventNo, int itemDiscount, String sendArr,
			Integer page) {

		String[] strArr = sendArr.split(",");

		int[] iArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			iArr[i] = Integer.valueOf(strArr[i]);

		}

		int result1 = 0;
		int result2 = 0;
		int result3 = 0;

		for (int k = 0; k < iArr.length; k++) {

			// ������ ���̺��� �������ͽ� y�� �ٲ��ֱ�
			result1 = iService.updateItemEventStatus(iArr[k]);

			// �̺�Ʈ ��ǰ�� ��ǰ��ȣ, ������, �̺�Ʈ ��ȣ�� ���̺� ä��� (���� �ڷ�� ����)
			BannerItem i = new BannerItem();
			i.setItemNo(iArr[k]);
			i.setEventNo(eventNo);
			i.setItemDiscount(itemDiscount);

			System.out.println(i.getEventNo());
			System.out.println(i.getItemDiscount());

			result2 = iService.deleteEventItemBefore(i);
			result3 = iService.insertEventItem(i);

		}

		if (result1 > 0 && result3 > 0) {

			return "success";

		} else {
			throw new ItemException("�̺�Ʈ ���� ����!");
		}

	}

	// �̺�Ʈ ��ǰ ����Ʈ ���� -admin
	@RequestMapping("eventItemListChange.do")
	public void EventItemListChange(HttpServletResponse response, Integer page,
			@RequestParam(value = "itemCategory", required = false) String itemCategory) throws IOException {

		if (itemCategory == "") {
			itemCategory = null;
		}

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = iService.getEventCount(itemCategory);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		// �̺�Ʈ ����� �ȵ� ��ǰ ���
		System.out.println("���� Ȯ���غ���");
		System.out.println("category��" + itemCategory);
		ArrayList<BannerItem> list = iService.selectItems(itemCategory, pi);

		response.setContentType("application/json;charset=utf-8");

		if (list != null) {

			System.out.println(list);

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject jList = new JSONObject();

				jList.put("itemNo", list.get(i).getItemNo());
				jList.put("itemName", list.get(i).getItemName());
				jList.put("itemPrice", list.get(i).getItemPrice());
				jList.put("itemRate", list.get(i).getItemRate());

				jarr.add(jList);
			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("list", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new ItemException("����Ʈ ���� ����!");
		}

	}

	// �̺�Ʈ ������ ��ȸ -admin
	@RequestMapping("selectItemDiscount.do")
	public void selectItemDiscount(HttpServletResponse response, int eventNo) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		JSONObject eNum = new JSONObject();

		System.out.println(eventNo);
		Integer d = iService.selectItemDiscount(eventNo);
		System.out.println(d);
		if (d == null) {
			d = 0;
		}

		String itemDiscount = String.valueOf(d);

		eNum.put("itemDiscount", itemDiscount);

		PrintWriter out = response.getWriter();

		out.print(eNum);
		out.flush();
		out.close();

	}

	// ��õ ���� Ȯ�� -admin

	@RequestMapping("recommendChk.do")
	public void recommendCheck(HttpServletResponse response, Integer sendCnt) throws IOException {

		response.setContentType("application/json;charset=utf-8");
		JSONObject iNum = new JSONObject();

		int cnt = iService.selectRecommendCnt();
		int i = sendCnt + cnt;

		iNum.put("iNum", i);

		PrintWriter out = response.getWriter();

		out.print(iNum);
		out.flush();
		out.close();

	}

	// ��õ ��ǰ ���º�ȯ�ϰ� ����Ʈ��������-admin

	@RequestMapping("recommend.do")
	public void recommendItemString(HttpServletResponse response, String sendArr) throws IOException {

		String[] strArr = sendArr.split(",");

		int result = iService.updateItemRecommend(strArr);

		System.out.println(result);
		ArrayList<BannerItem> rList = new ArrayList<>();

		if (result > 0) {

			rList = iService.selectRecommendList();

		}

		response.setContentType("application/json;charset=utf-8");
		JSONArray jarr = new JSONArray();

		for (int i = 0; i < rList.size(); i++) {
			JSONObject jList = new JSONObject();

			jList.put("imageRename", rList.get(i).getImageRename());
			jList.put("itemName", rList.get(i).getItemName());
			jList.put("itemNo", rList.get(i).getItemNo());

			jarr.add(jList);
		}

		JSONObject sendJson = new JSONObject();
		sendJson.put("list", jarr);

		PrintWriter out = response.getWriter();
		out.print(sendJson);
		out.flush();
		out.close();

	}

	// ------------------------------���� ����-----------------------------------------

	IamportClient client = new IamportClient("3086404975484077",
			"EsAndJxwJmc8oD49ezXFzHqWyessiK4XcFlpoSW8f8hDMmN0VLFus6r1kTtDDyBQdWfCOcK4l2I7ow7j");

	@RequestMapping(value = "payment.do", method = RequestMethod.POST)
	@ResponseBody
	public String payment(@RequestBody String param) throws ParseException, IamportResponseException, IOException {
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		JSONObject jobj = (JSONObject) parser.parse(param);

		String customerUid = (String) jobj.get("customer_uid");
//					String merchantUid = (String) jobj.get("merchant_uid");
		BigDecimal price = new BigDecimal(((Long) jobj.get("price")).intValue());
		String name = (String) jobj.get("name");
//					String impUid = (String)jobj.get("imp_uid");
		int cycle = 1;

		System.out.println("customerUid : " + customerUid);
//					System.out.println("merchatUid : " + merchantUid);
		System.out.println("price : " + price);
		System.out.println("name : " + name);
//					System.out.println("impUid : " + impUid);

		firstPayment(customerUid, price, name, cycle);

		return "success";

	}

	// ------------------------------��� ���� ��û-------------------------------------

	private void firstPayment(String customerUid, BigDecimal price, String name, int cycle)
			throws IamportResponseException, IOException {

		AgainPaymentData againData = new AgainPaymentData(customerUid, getRandomMerchantUid(), price);
		againData.setName(name);
		String firstPaymentStatus = "";
		String impUid = "";

		try {
			// ���� ���� ����
			IamportResponse<Payment> payment_response = client.againPayment(againData);
//						assertEquals(payment_response.getResponse().getStatus(), "paid");
			// ���� ���� ����
			firstPaymentStatus = payment_response.getResponse().getStatus();
			impUid = payment_response.getResponse().getImpUid();

		} catch (IamportResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//					System.out.println("���ʰ��� ��� : " + firstPaymentStatus);
		if (firstPaymentStatus.equalsIgnoreCase("paid") == true) {
			if ((client.paymentByImpUid(impUid).getResponse().getStatus()).equalsIgnoreCase("paid") == true) {

				// DB�� customerUid, price����

				// DB�� ���������� ������� ������ ����
				subscriptionPayment(customerUid, price, cycle);
			}
		} else {
			try {
				client.againPayment(againData);
			} catch (IamportResponseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// ------------------------------���� ����-----------------------------------

	private void subscriptionPayment(String customerUid, BigDecimal price, int cycle)
			throws IamportResponseException, IOException {

		// ����ð� unixtime���� ��������
		long currentTime = System.currentTimeMillis() / 1000L;
		long subscriptionTime = 0;
		// �����ֱ⿡ ���� ���� ��¥ ������ �ٸ��� �ؾߵ�(unixtime���� ����ؾ� ��)
		// 1���� : ����ð� + 604800
		// 2���� : ����ð� + 1209600
		// 3���� : ����ð� + 1814400
		// 4���� : ����ð� + 2419200
		String merchantUid = "";
//					subscriptionTime = currentTime + 180;
//					merchantUid = getRandomMerchantUid();
		Date date = new Date();

//					for(int i = 0 ; i<5; i++) {

		switch (cycle) {
		case 1:
			subscriptionTime = currentTime + 120;
			merchantUid = getRandomMerchantUid();
			date.setTime(subscriptionTime * 1000L);
			break;

		case 2:
			subscriptionTime = currentTime + 1209600;
			merchantUid = getRandomMerchantUid();
			date.setTime(subscriptionTime * 1000L);
			break;

		case 3:
			subscriptionTime = currentTime + 1814400;
			merchantUid = getRandomMerchantUid();
			date.setTime(subscriptionTime * 1000L);
			break;

		case 4:
			subscriptionTime = currentTime + 2419200;
			merchantUid = getRandomMerchantUid();
			date.setTime(subscriptionTime * 1000L);
			break;
		}

		ScheduleEntry schduleEntry = new ScheduleEntry(merchantUid, date, price);

		ScheduleData scheduleData = new ScheduleData(customerUid);

		scheduleData.addSchedule(schduleEntry);

//					}

		IamportResponse<List<Schedule>> schedule_response = client.subscribeSchedule(scheduleData);

		List<Schedule> schedules = schedule_response.getResponse();
//					System.out.println(schedule_response.getResponse().size());
//					List<ScheduleEntry> req_schedules = scheduleData.getSchedules();

		// ���� �ð��� ���� �ƴٰ� �����ؼ� ������ ���� ��
		for (int i = 0; i < schedules.size(); i++) {
			if ((schedules.get(i).getMerchantUid()).equalsIgnoreCase(merchantUid)
					&& (schedules.get(i).getScheduleAt()).equals(date)) {
				System.out.println("���� ���� ����");
			}
		}

	}

	private String getRandomMerchantUid() {
		DateFormat df = new SimpleDateFormat("$$hhmmssSS");
		int n = (int) (Math.random() * 100) + 1;

		return df.format(new Date()) + "_" + n;
	}

	/*
	 * private void assertDateEquals(Date d1, Date d2) { assertEquals(d1.getTime() /
	 * 1000L, d2.getTime() / 1000L); }
	 */

}
