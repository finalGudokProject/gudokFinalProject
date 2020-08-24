package com.kh.finalGudok.member.controller;

import static com.kh.finalGudok.common.pagination2.getPageInfo2;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.kh.finalGudok.member.model.vo.Inquiry;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.member.model.exception.MemberException;
import com.kh.finalGudok.member.model.service.MemberService;
import com.kh.finalGudok.member.model.vo.AdminMember;
import com.kh.finalGudok.member.model.vo.AdminPayment;
import com.kh.finalGudok.member.model.vo.AdminSecession;
import com.kh.finalGudok.member.model.vo.Cart;
import com.kh.finalGudok.member.model.vo.DeleteHeart;
import com.kh.finalGudok.member.model.vo.Delivery;
import com.kh.finalGudok.member.model.vo.Exchange;
import com.kh.finalGudok.member.model.vo.Grade;
import com.kh.finalGudok.member.model.vo.Heart;
import com.kh.finalGudok.member.model.vo.Member;
import com.kh.finalGudok.member.model.vo.Point;
import com.kh.finalGudok.member.model.vo.Reply;
import com.kh.finalGudok.member.model.vo.Review;
import com.kh.finalGudok.member.model.vo.Withdrawal;
import com.kh.finalGudok.member.model.vo.Tempkey;

@SessionAttributes("loginUser")
@Controller
public class MemberController {

//	@Autowired
//	MemberService mService;

	@Autowired
	private MemberService mService;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private Member m;

	@RequestMapping("moveToLogin.do")
	public String moveTologin() {
		return "member/login";
	}

	@RequestMapping("moveToSignUp.do")
	public String moveTosignUp() {
		return "member/signUp";
	}

	@RequestMapping("moveToFind.do")
	public String findId() {
		return "member/find";
	}

	@RequestMapping("payment.do")
	public String payment() {
		return "items/payment";
	}


//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(HttpServletRequest request){
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		
//		return "home";
//	}

//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(@RequestParam("id") String id, @RequestParam("pwd") String pwd){
//
//		System.out.println(id);
//		System.out.println(pwd);
//		return "home";
//	}

//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(@RequestParam(value="id", required=false, defaultValue="1") String id, @RequestParam("pwd") String pwd){
//
//		System.out.println(id);
//		System.out.println(pwd);
//		return "home";
//	} 

//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(String id, String pwd) {
//		System.out.println(id);
//		System.out.println(pwd);
//		return "home";
//	}

//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(@ModelAttribute Member m) {
//		System.out.println(m.getMemberId());
//		System.out.println(m.getMemberPwd());
//		return "home";
//	}

//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(Member m, HttpSession session, Model model) {
//		
////		System.out.println(m.getMemberId());
////		System.out.println(m.getMemberPwd());
//		
//		Member loginUser = mService.loginMember(m);
//		
//		
//		if(loginUser != null) {
//			session.setAttribute("loginUser", loginUser);
//			return "home";
//		}else {
//			model.addAttribute("msg","로그인 실패");
//			return "common/errorPage";
//		}
//	}

//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String memberLogin(Member m, Model model) {
//		
//		Member loginUser = mService.loginMember(m);
//		
//		
//		if(loginUser != null) {
//			model.addAttribute("loginUser", loginUser);
//			return "home";
//		}else {
//			throw new MemberException("로그인 실패");
//		}
//	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView memberLogin(Member m, HttpSession session, ModelAndView mv) {

		Member loginUser = mService.loginMember(m);

		if (bcryptPasswordEncoder.matches(m.getMemberPwd(), loginUser.getMemberPwd())) {
			session.setAttribute("loginUser", loginUser);
			
			if(loginUser.getMemberId().equalsIgnoreCase("admin")) {
				mv.setViewName("admin/main");
			}else {
			mv.setViewName("home");
			}
			
		} else {
			throw new MemberException("로그인 실패");
		}
		return mv;
	}

//	@RequestMapping(value = "login.do", method = RequestMethod.POST)
//	public String memberLogin(Member m, Model model) {
//		
//		Member loginUser = mService.loginMember(m);
//
//		if (bcryptPasswordEncoder.matches(m.getMemberPwd(), loginUser.getMemberPwd())) {
//			model.addAttribute("loginUser", loginUser);
//			return "home";
//		} else {
//			throw new MemberException("로그인 실패");
//		}
//	}
//
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}


	@RequestMapping(value = "signUp.do", method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestBody String param) throws ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jobj = (JSONObject) parser.parse(param);

		String id = (String) jobj.get("id");
		String pwd = (String) jobj.get("pwd");
		String name = (String) jobj.get("name");
		String email = (String) jobj.get("email");
		String address1 = (String) jobj.get("address1");
		String address2 = (String) jobj.get("address2");
		String address3 = (String) jobj.get("address3");
		String gender = (String) jobj.get("gender");

		// web.xml에 한글 깨짐 방지를 위해 필터 등록
		// bCrypt로 암호화 처리 -> 관련 라이브러리 추가, xml만들어서 bean 설정
		// @Autowired 선언
		String encPwd = bcryptPasswordEncoder.encode(pwd);

		// Member객체에 담기
		m.setMemberId(id);
		m.setMemberPwd(encPwd);
		m.setMemberName(name);
		m.setEmail(email);
		m.setAddress1(address1);
		m.setAddress2(address2);
		m.setAddress3(address3);
		m.setGender(gender);

//		System.out.println(m);

		int result = mService.insertMember(m);

		if (result > 0) {
			return "success";
		} else {
			throw new MemberException("회원가입 실패");
		}

	}

//	@RequestMapping("dupId.do")
//	public ModelAndView idDuplicateCheck(ModelAndView mv, String memberId){
//		boolean idCheckResult = mService.checkIdDup(memberId) == 0? true : false;
//		
//		Map map = new HashMap();
//		
//		map.put("idCheckResult", idCheckResult);
//		
//		mv.addAllObjects(map);
//		
//		mv.setViewName("jsonView");
//		
//		return mv;
//	}

	@RequestMapping("dupId.do")
	public void idDuplicateCheck(HttpServletResponse response, String memberId) throws IOException {
		boolean idCheckResult = mService.checkIdDup(memberId) == 0 ? true : false;

		PrintWriter out = response.getWriter();
		out.print(idCheckResult);
		out.flush();
		out.close();
	}
	
//	마이페이지
	
	// 마이페이지 이동(구독내역 코드로 다시 재 작성)
	@RequestMapping("mypage.do") 
	public String mypageView() { // 민지
		return "mypage/subscribe";
	}
	
	// 회원정보 확인 전 본인 확인
	@RequestMapping("myInfo.do") 
	public String myInfoView() { // 민지
		return "mypage/memberConfirm";
	}
	
	// 회원 탈퇴 페이지
	@RequestMapping("myWithdrawal.do")
	public String withdrawalView() {
		return "mypage/memberWithdrawal";
	}
	
	// 찜 목록 페이지
	@RequestMapping("heartView.do")
	public String heartView() {
		return "mypage/heart";
	}
	
	// 찜 목록 페이지
	@RequestMapping("cartView.do")
	public String cartView() {
		return "mypage/cart";
	}
	
	// 찜 목록 불러오기(ajax)
	@RequestMapping("heartList.do")
	@ResponseBody
	public void heartList(HttpServletResponse response, Integer memberNo) throws JsonIOException, IOException {
		ArrayList<Heart> list = mService.selectHeartList(memberNo);
		
		System.out.println("찜 내역  : " + list);
		
		response.setContentType("application/json;charset=utf-8");
		
		new Gson().toJson(list, response.getWriter());
	}
	
	// 본인 확인
	@RequestMapping(value="memberConfirm.do", method=RequestMethod.POST)
	public String memberConfirm(Member m, HttpSession session, Model model) { // 민지
		Member loginUser = mService.loginMember(m);
		
		System.out.println(m);
		System.out.println(loginUser);
		
		// 내부적으로 복호화 처리가 이루어진다. (암호화된 회원만 로그인 가능)
		if(bcryptPasswordEncoder.matches(m.getMemberPwd(), loginUser.getMemberPwd())) {	// 로그인 할 멤버 객체가 조회 되었을 시
			model.addAttribute("loginUser", loginUser);
			return "mypage/memberInfoView";
		} else {				// 로그인 실패시
			throw new MemberException("본인확인 실패");
			// 예외를 발생시켜서 에러페이지로 넘어갈 껀데
			// 우선 예외 클래스는 RuntimeException을 상속 받아
			// 예외 처리가 따로 필요 없다.
			
			// 그리고 예외가 발생 했을 때 common에 있는 errorPage에서
			// 처리될 수 있도록 web.xml에 공용 에러 페이지를 등록하러 가자!
		}
		
	}
	
	// 회원 정보 수정
	@RequestMapping(value="memberModify.do", method=RequestMethod.POST)
	public String memberModify(Member m, Model model) { // 민지
		
		int result = mService.updateMember(m);
		
		System.out.println("회원정보 수정 후  : " +m);
		
		if(result > 0) {
			// 회원정보가 수정되면 현재 로그인 한 사람의 정보를
			// 업데이트 시키기 위해 session에 수정된 객체를 담아줘야 된다.
			// @SessionAttribute("loginUser")를 클래스 위에 달아줬기 때문에
			// model에 수정된 회원 객체를 담자
			model.addAttribute("loginUser", m);
		} else {
			throw new MemberException("수정 실패!");
		}
		
		return "mypage/memberInfoView";
	}
	
	// 적립금 내역
	@RequestMapping(value="pointList.do")
	public ModelAndView pointList(ModelAndView mv, Integer memberNo) { // 민지
		ArrayList<Point> list = mService.selectPointList(memberNo);
		
		System.out.println("적립금 내역  : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/pointList");
		} else {
			throw new MemberException("적립금내역 리스트 불러오기 실패");
		}
		
		return mv;
	}
	
	// 리뷰 목록
	@RequestMapping(value="reviewList.do")
	public ModelAndView reviewList(ModelAndView mv, Integer memberNo) { // 민지
		ArrayList<Review> list = mService.selectReviewList(memberNo);
		
		System.out.println("리뷰 내역  : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/review");
		} else {
			throw new MemberException("리뷰 리스트 불러오기 실패");
		}
		
		return mv;
	}
	
	// 문의 내역
	@RequestMapping(value="inquiryList.do")
	public ModelAndView inquiryList(ModelAndView mv, Integer memberNo) {
		ArrayList<Inquiry> list = mService.selectInquiryList(memberNo);
		
		System.out.println("1:1 문의 내역 : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/inquiry");
		} else {
			throw new MemberException("1:1 리스트 불러오기 실패");
		}
		
		return mv;
	}
	
	// 교환 내역
	@RequestMapping(value="exchangeList.do")
	public ModelAndView exchangeList(ModelAndView mv, Integer memberNo) { // 민지
		ArrayList<Exchange> list = mService.selectExchangeList(memberNo);
		
		System.out.println("교환 내역 : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/exchange");
		} else {
			throw new MemberException("교환 리스트 불러오기 실패");
		}
		
		return mv;
	}
	
	// 배송 내역
	@RequestMapping(value="deliveryList.do")
	public ModelAndView deliveryList(ModelAndView mv, Integer memberNo) { // 민지
		ArrayList<Delivery> list = mService.selectDeliveryList(memberNo);
		
		System.out.println("배송 내역 : " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/delivery");
		} else {
			throw new MemberException("배송 리스트 불러오기 실패");
		}
		
		return mv;
	}
	
	// 장바구니 내역
	@RequestMapping("cartList.do")
	@ResponseBody
	public void cartList(HttpServletResponse response, Integer memberNo) throws JsonIOException, IOException { // 민지
		ArrayList<Cart> list = mService.selectCartList(memberNo);
		
		System.out.println("장바구니 내역 : " + list);
		
		response.setContentType("application/json;charset=utf-8");
		
		new Gson().toJson(list, response.getWriter());
	}

	// 교환 신청
	@RequestMapping("exchangeInsert.do")
	public String exchangeInsert(HttpServletRequest request, Exchange e) { // 민지
		
		if(e.getExchangeCategory() == 1) {
			e.setExchangeContent("품질불량");
		} else if(e.getExchangeCategory() == 2) {
			e.setExchangeContent("오배송");
		} 
		
		System.out.println("교환 내용 : " + e);
		
		int result = mService.insertExchange(e);
		int result2 = mService.updateSubscribe(e.getSubscribeNo());
		
		if(result > 0 && result2 > 0) {
			return "redirect:exchangeList.do";
		} else {
			throw new MemberException("교환 신청 실패");
		}
	}

	@RequestMapping("emailDupCheck.do")
	public ModelAndView emailDupCheck(ModelAndView mv, String email) {

		boolean emailCheckResult = mService.emailDupCheck(email) == 0 ? true : false;
//		System.out.println(emailCheckResult);
		String user = "p.jaemyung91@gmai.com";

		Map map = new HashMap();

		int random = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
		String authCode = String.valueOf(random);

		map.put("emailCheckResult", emailCheckResult);

		if (emailCheckResult == true) {
			MimeMessage msg = mailSender.createMimeMessage();

			try {

//      MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");
				MimeMessageHelper messageHelper = new MimeMessageHelper(msg, "UTF-8");
				messageHelper.setSubject("이메일 인증");
				messageHelper.setText("인증번호는" + authCode + "입니다.");
				msg.setFrom(new InternetAddress(user, "Goose"));
				messageHelper.setTo(email);
				msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}

			mailSender.send(msg);
			map.put("authCode", authCode);
		}

		mv.addAllObjects(map);
		mv.setViewName("jsonView");
		return mv;
	}
	
	// 탈퇴하기
	@RequestMapping("withdrawalInsert.do")
	public String withdrawalInsert(HttpServletRequest request, Withdrawal w) {
		if(w.getSecessionCategory() == 1) {
			w.setSecessionContent("서비스가 마음에 들지 않음");
		} else if(w.getSecessionCategory() == 2) {
			w.setSecessionContent("가격이 비쌈");
		} else if(w.getSecessionCategory() == 3) {
			w.setSecessionContent("원하는 상품이 없음");
		} else if(w.getSecessionCategory() == 4) {
			w.setSecessionContent("개인정보보호를 위해");
		}
		
		System.out.println("탈퇴 내용 : " + w);
		
		int result = mService.insertSecession(w);
		int result2 = mService.updateMemberStatus(w.getMemberNo());
		
		if(result > 0 && result2 > 0) {
			return "home";
		} else {
			throw new MemberException("탈퇴 실패");
		}
	}
	
	// 리뷰 삭제
	@RequestMapping("mreviewDelete.do")
	public String reviewDelete(HttpServletRequest request, Integer reviewNo) {// 민지
//		Review review = mService.selectReview(reviewNo); 
		
		int result = mService.deleteReview(reviewNo);
		
		if(result > 0) {
			return "redirect:reviewList.do";
		} else {
			throw new MemberException("리뷰 삭제 실패");
		}
	}
	
	// 찜 삭제
	@RequestMapping("heartDelete.do")
	@ResponseBody
	public String heartDelete(HttpSession session, HttpServletRequest request, @RequestParam(value="checkArr[]")List<String> heartList) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		System.out.println("선택삭제 실행됨");
		
		System.out.println(heartList);
		
		DeleteHeart dh = new DeleteHeart();
		
		int heartNo;
		int memberNo = loginUser.getMemberNo();
		
		int result = 0;
		
		for(int i = 0; i <heartList.size(); i++) {
			heartNo = Integer.parseInt(heartList.get(i));
			dh.setHeartNo(heartNo);
			dh.setMemberNo(memberNo);
			result = mService.deleteHeart(dh);
			result += result;
		}
		
		if(result > 0) {			
			return "success";
		} else {
			throw new MemberException("찜 삭제 실패");
		}
	}
	
	// 장바구니 삭제
	@RequestMapping("cartDelete.do")
	@ResponseBody
	public String cartDelete(HttpSession session, HttpServletRequest request, @RequestParam(value="checkArr[]")List<String> cartList) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		System.out.println("선택삭제 실행됨");
		
		System.out.println(cartList);
		
		DeleteHeart dh = new DeleteHeart();
		
		int cartNo;
		
		int memberNo = loginUser.getMemberNo();
		
		int result = 0;
		
		for(int i = 0; i <cartList.size(); i++) {
			cartNo = Integer.parseInt(cartList.get(i));
			
			HashMap map = new HashMap<Integer, Integer>();
			
			map.put("cartNo", cartNo);
			map.put("memberNo", memberNo);

			result = mService.deleteCart(map);
			
			result += result;
			
		}
		
		
		if(result > 0) {			
			return "success";
		} else {
			throw new MemberException("장바구니 삭제 실패");
		}
	}
	
	// 장바구니 추가
	@RequestMapping("addCart.do")
	@ResponseBody
	public String addCart(HttpSession session, HttpServletRequest request, @RequestParam(value="checkArr[]")List<String> cartList) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		System.out.println("장바구니 추가");
		
		int itemNo;
		int result = 0;
		
		for(int i = 0; i < cartList.size(); i++) {
			itemNo = Integer.parseInt(cartList.get(i));
			Item item = mService.selectItem(itemNo);
			
			HashMap map = new HashMap<Object, Object>();
			
			System.out.println("선택한 찜 상품 : " + item);
			
			if(item != null) {
				map.put("item", item);
				map.put("member", loginUser);
				result = mService.addCart(map);
			}
			result += result;
		}
		
		if(result > 0) {			
			return "success";
		} else {
			throw new MemberException("장바구니 추가 실패");
		}
	}
	
	// 1:1문의 답변
	@RequestMapping("inquiryReply.do")
	@ResponseBody
	public void inquiryReply(HttpServletResponse response, HttpServletRequest request, Integer boardNo) throws JsonIOException, IOException {
		/*
		 * ArrayList<Delivery> list = mService.selectDeliveryList(memberNo);
		 * 
		 * System.out.println("배송 내역 : " + list);
		 * 
		 * if(list != null) { mv.addObject("list", list);
		 * mv.setViewName("mypage/delivery"); } else { throw new
		 * MemberException("배송 리스트 불러오기 실패"); }
		 * 
		 * return mv;
		 */
		
		Reply reply = mService.selectReply(boardNo);
		
		System.out.println("답변 내역  : " + reply);
		
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(reply, response.getWriter());
	}
	
	// 비밀번호 변경
	@RequestMapping("modifyPassword.do")
	public String modifyPassword(Member m, Model model, @RequestParam(value="changeMemberPwd") String changeMemberPwd) {
		Member loginUser = mService.loginMember(m);
		
		System.out.println(m);
		System.out.println(loginUser);
		
		// 내부적으로 복호화 처리가 이루어진다. (암호화된 회원만 로그인 가능)
		if(bcryptPasswordEncoder.matches(m.getMemberPwd(), loginUser.getMemberPwd())) {	// 로그인 할 멤버 객체가 조회 되었을 시
			
			String encPwd = bcryptPasswordEncoder.encode(changeMemberPwd);
//			System.out.println(encPwd);

			m.setMemberPwd(encPwd);
			
			int result = mService.updatePassword(m);
			
			System.out.println("비밀번호 변경 후 : " + m);
			
			if(result > 0) {
				// 회원정보가 수정되면 현재 로그인 한 사람의 정보를
				// 업데이트 시키기 위해 session에 수정된 객체를 담아줘야 된다.
				// @SessionAttribute("loginUser")를 클래스 위에 달아줬기 때문에
				// model에 수정된 회원 객체를 담자
				model.addAttribute("loginUser", m);
			} else {
				throw new MemberException("수정 실패!");
			}
			
			model.addAttribute("loginUser", loginUser);
			
			return "mypage/memberInfoView";
		} else {				// 로그인 실패시
			throw new MemberException("본인확인 실패");
			// 예외를 발생시켜서 에러페이지로 넘어갈 껀데
			// 우선 예외 클래스는 RuntimeException을 상속 받아
			// 예외 처리가 따로 필요 없다.
			
			// 그리고 예외가 발생 했을 때 common에 있는 errorPage에서
			// 처리될 수 있도록 web.xml에 공용 에러 페이지를 등록하러 가자!
		}
	}
	
	//관리자 등급 & 회원 리스트 보기
	@RequestMapping("gradeList.do")
	public ModelAndView selectGradeList(ModelAndView mv, Integer page) {
		
		
		//현재 등급정보
		ArrayList<Grade> gList=mService.selectGradeList();
	

		//등급별 회원 수 주입
		for(int i=0;i<gList.size();i++) {
			Integer cnt=mService.selectGradeCnt(gList.get(i).getGradeNo());
			
			if(cnt==null) {
				cnt=0;
			}
			
			gList.get(i).setTotal(cnt);
			gList.get(i).setGradeRate(gList.get(i).getGradeRate()*100);
			
		}
		

		int currentPage=1;
		
		if(page!=null) {
			currentPage=page;
		}
		
		int listCount=mService.getMemberCnt();
		
		PageInfo pi=new PageInfo();
		
		int pageLimit=10; //보여질 페이지 총 갯수
		int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
		pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
		
		//탈퇴하지 않은 회원 리스트 
		ArrayList<AdminMember> mList=mService.selectMemberN(pi);
		
		//회원별 총 구매금액 주입
//		for(int i=0;i<mList.size();i++) {
//			Integer cnt=mService.selectTotalPay(mList.get(i).getMemberNo());
//			
//			if(cnt==null) {
//				cnt=0;
//			}
//			
//			mList.get(i).setTotalPay(cnt);
//		
//			
//		}
	
		

		if(gList!=null&&mList!=null) {
			mv.addObject("gList",gList).addObject("mList",mList).addObject("pi",pi).setViewName("admin/userList");
			return mv;
		} else {			
			throw new MemberException("회원 리스트 확인 실패!");
		}
	
	
	}
	
	
	//등급별 적립율 변경
	@RequestMapping("gradeRateInfoChang.do")
	@ResponseBody
	public String updateGradeRate(String sendGradeArr, String sendRateArr){
		
		System.out.println(sendGradeArr);
		System.out.println(sendRateArr);
		
		String[] gArr=sendGradeArr.split(",");
		String[] rArr=sendRateArr.split(",");
		
		ArrayList<Grade> g=new ArrayList<>();
		int result=0;
	
		for(int k=0; k<gArr.length;k++) {
			
			Grade grade=new Grade();
			
			grade.setGradeNo(Integer.valueOf(gArr[k]));
			grade.setGradeRate(Double.valueOf(rArr[k])/100);
			
			g.add(grade);
		}
		
		
		result=mService.updateGradeRate(g);
		System.out.println(result);


		System.out.println(result);
		
		
		if(result<0) {
		return "success";
		
		}else {
			throw new MemberException("적립율 변경 실패!");
			
		}
	}
	
	
	//등급별 최소 금액 변경
	@RequestMapping("gradeMinInfoChang.do")
	@ResponseBody
	public String updateGradeMin(String sendGradeMinArr, String sendGradeArr){
		
		System.out.println(sendGradeArr);
		System.out.println(sendGradeMinArr);
		
		String[] gArr=sendGradeArr.split(",");
		String[] rArr=sendGradeMinArr.split(",");
		
	
		ArrayList<Grade> g=new ArrayList<>();
		int result=0;
	
		for(int k=0; k<gArr.length;k++) {
			
			Grade grade=new Grade();
			
			grade.setGradeNo(Integer.valueOf(gArr[k]));
			grade.setGradeMin(Integer.valueOf(rArr[k]));
			
			g.add(grade);
		}
		
		
		result=mService.updateGradeMin(g);
	
		if(result<0) {
		return "success";
		
		}else {
			throw new MemberException("적립율 변경 실패!");
			
		}
	}
	
	//ajax 후 리스트 갱신
	@RequestMapping("gListChange.do")
	public void updateGradeList(HttpServletResponse response, ModelAndView mv, Integer page) throws IOException {
		
			//현재 등급정보
			ArrayList<Grade> gList=mService.selectGradeList();
		
			//등급별 회원 수 주입
			for(int i=0;i<gList.size();i++) {
				Integer cnt=mService.selectGradeCnt(gList.get(i).getGradeNo());
				
				if(cnt==null) {
					cnt=0;
				}
				
				gList.get(i).setTotal(cnt);
				gList.get(i).setGradeRate(gList.get(i).getGradeRate()*100);
			}
			
			

			int currentPage=1;
			
			if(page!=null) {
				currentPage=page;
			}
			
			int listCount=mService.getMemberCnt();
			
			PageInfo pi=new PageInfo();
			
			int pageLimit=10; //보여질 페이지 총 갯수
			int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
			pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
			
			//탈퇴하지 않은 회원 리스트 
			ArrayList<AdminMember> mList=mService.selectMemberN(pi);
			
			response.setContentType("application/json;charset=utf-8");


			if(gList!=null&&mList!=null) {
		
				JSONArray jarr=new JSONArray();
				
				for(int i=0;i<gList.size();i++) {
					JSONObject jList=new JSONObject();
					
					jList.put("gradeNo",gList.get(i).getGradeNo());
					jList.put("gradeName",gList.get(i).getGradeName());
					jList.put("gradeMin",gList.get(i).getGradeMin());
					jList.put("total",gList.get(i).getTotal());
					jList.put("gradeRate",gList.get(i).getGradeRate());
					
					jarr.add(jList);
				}
				
				JSONObject sendJson=new JSONObject();
				sendJson.put("list",jarr);
				System.out.println(jarr);
				
				PrintWriter out=response.getWriter();
				out.print(sendJson);
				out.flush();
				out.close();
				
				
				
			}else {
				throw new MemberException("이벤트 전체 조회 실패!");
			}
		
		
		}
	

	
		@RequestMapping("rListChang.do")
		public void updateRateList(HttpServletResponse response, ModelAndView mv, Integer page) throws IOException {
			
			//현재 등급정보
			ArrayList<Grade> gList=mService.selectGradeList();
		
			//등급별 회원 수 주입
			for(int i=0;i<gList.size();i++) {
				Integer cnt=mService.selectGradeCnt(gList.get(i).getGradeNo());
				
				if(cnt==null) {
					cnt=0;
				}
				
				gList.get(i).setTotal(cnt);
				gList.get(i).setGradeRate(gList.get(i).getGradeRate()*100);
			}
			
			
			int currentPage=1;
			
			if(page!=null) {
				currentPage=page;
			}
			
			int listCount=mService.getMemberCnt();
			
			PageInfo pi=new PageInfo();
			
			int pageLimit=10; //보여질 페이지 총 갯수
			int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
			pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
			
			//탈퇴하지 않은 회원 리스트 
			ArrayList<AdminMember> mList=mService.selectMemberN(pi);
			
			response.setContentType("application/json;charset=utf-8");


			if(gList!=null&&mList!=null) {
		
				JSONArray jarr=new JSONArray();
				
				for(int i=0;i<gList.size();i++) {
					JSONObject jList=new JSONObject();
					
					jList.put("gradeNo",gList.get(i).getGradeNo());
					jList.put("gradeName",gList.get(i).getGradeName());
					jList.put("gradeMin",gList.get(i).getGradeMin());
					jList.put("total",gList.get(i).getTotal());
					jList.put("gradeRate",gList.get(i).getGradeRate());
					
					jarr.add(jList);
				}
				
				JSONObject sendJson=new JSONObject();
				sendJson.put("list",jarr);
				System.out.println(jarr);
				
				PrintWriter out=response.getWriter();
				out.print(sendJson);
				out.flush();
				out.close();
				
				
				
			}else {
				throw new MemberException("이벤트 전체 조회 실패!");
			}
		
		
		}
		
		//★ 회원 정보 상세보기
		@RequestMapping("mDetail.do")
		public ModelAndView selectOneMember(ModelAndView mv,Integer page,int memberNo,Integer detailPage, String type) {
			
			//상세 페이지로 이동하기전, 회원 리스트의 페이지 번호
			int beforePage=page;
			
			
			
			//하단 결제 페이지의 페이지 번호
			int currentPage=1;
			
			if(detailPage!=null) {
				currentPage=detailPage;
			}
			
			int listCount=mService.getMemberPayCnt(memberNo);
			
			//상세 페이지 내 결제 페이지의 정보
			PageInfo pi=new PageInfo();
			
			int pageLimit=10; //보여질 페이지 총 갯수
			int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
			pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
			
		
			//해당 회원 정보
			AdminMember m=mService.selectOneMember(memberNo);
			
			//회원별 결제리스트
			ArrayList<AdminPayment> pList=mService.selectMemberPay(memberNo,pi);

			System.out.println("pList는"+pList);
			
	
				if(pList!=null) {
					mv.addObject("pList",pList).addObject("m",m).addObject("pi",pi).addObject("beforePage",beforePage).addObject("type",type).setViewName("admin/userDetail");
					return mv;
				} else {			
					throw new MemberException("회원 상세 확인 실패!");
				}
			
	
			
		}
		
		
	//회원 정보 수정(관리자)
		@RequestMapping("mUpdateA.do")
		public ModelAndView updateMemberA(ModelAndView mv,AdminMember m ,Integer beforePage) {
			
			System.out.println(m);
			int result=mService.updateMemberA(m);
			
			if(result>0) {
				mv.addObject("page",beforePage).setViewName("redirect:gradeList.do");
				return mv;
			
			} else {			
				throw new MemberException("회원 정보 수정 실패!");
			}
		}
		
	
		//회원 삭제
		@RequestMapping("deleteM.do")
		public ModelAndView deleteMemberA(ModelAndView mv, Integer memberNo ,Integer beforePage) {
	
				System.out.println("도차쿠");
			
			System.out.println(m);
			int result=mService.deleteMemberA(memberNo);
			int result1=mService.deleteMemberSecession(memberNo);
			int result2=mService.deleteMemberBoard(memberNo);
			int result3=mService.deleteMemberHeart(memberNo);
			int result7=mService.deleteMemberCart(memberNo);
			int result4=mService.deleteMemberReview(memberNo);
			int result5=mService.deleteMemberPayment(memberNo);
			int result6=mService.deleteMemberSubscribe(memberNo);
			
			System.out.println(result);
			
			if(result>0) {
				mv.addObject("page",beforePage).setViewName("redirect:gradeList.do");
				return mv;
			
			} else {			
				throw new MemberException("회원 삭제 실패!");
			}
			
		}
		
		
		@RequestMapping("sList.do")
		public ModelAndView selectSecessionList(ModelAndView mv,Integer page) {
			
			//탈퇴 사유별 비율 보여줄 리스트 
			
			ArrayList<AdminSecession> sList=new ArrayList<>();
			
			for(int i=1; i<6;i++) {
				AdminSecession s=new AdminSecession();
				s.setSecessionCategory(i);
				Integer t=mService.selectSecessionCnt(s);
				if(t==null) {
					t=0;
				}
				s.setTotal(t);
				sList.add(s);
			}
			
			System.out.println("sList"+sList);
			System.out.println("사이즈는"+sList.size());
			
			//등급별 탈퇴 인원
			
			ArrayList<AdminSecession> mList=new ArrayList<>();
			
			for(int i=1; i<5;i++) {
				AdminSecession s=new AdminSecession();
				s.setGradeNo(i);
				System.out.println("확인"+s.getGradeNo());
				Integer t=mService.selectMemberSecessionCnt(s);
				if(t==null) {
					t=0;
				}
				s.setTotal(t);
				mList.add(s);
			}
			
			System.out.println("mList"+mList);
			
			//탈퇴 회원들 리스트 
			
			int currentPage=1;
			
			if(page!=null) {
				currentPage=page;
			}
			
			int listCount=mService.getMemberCnt();
			
			System.out.println("몇명 가져온거야"+listCount);
			PageInfo pi=new PageInfo();
			
			int pageLimit=10; //보여질 페이지 총 갯수
			int boardLimit=5; //게시판 한 페이지에 뿌려질 게시글 수
			pi=getPageInfo2(currentPage,listCount,pageLimit,boardLimit);
			
			ArrayList<AdminSecession> msList=mService.selectMemberSecession(pi);
			
			System.out.println("msList"+msList);
			
			if(sList!=null&&mList!=null&&msList!=null) {
				mv.addObject("sList",sList).addObject("mList",mList).addObject("msList",msList).addObject("pi",pi).setViewName("admin/secessionList");
				return mv;
			} else {			
				throw new MemberException("탈퇴 내역 확인 실패!");
			}
		}

//	@RequestMapping("emailDupCheck.do")
//	public void emailDupCheck(HttpServletResponse response, @RequestParam("email") String email) throws IOException {
//		response.setContentType("application/json;charset=utf-8");
//		
//		boolean emailCheckResult = mService.emailDupCheck(email) == 0? true : false;
//		//	System.out.println(emailCheckResult);
//		String user = "p.jaemyung91@gmai.com";
//			
//	
//		int random = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
//	    String authCode = String.valueOf(random);
//		
//		JSONObject job = new JSONObject();
//		job.put("emailCheckResult", emailCheckResult);
//		job.put("authCode", authCode);
//		
//		mailSender.createMimeMessage();
//		
//		MimeMessage msg = mailSender.createMimeMessage();
//        
//		try {
//        
//        MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");
//        messageHelper.setSubject("이메일 인증");
//        messageHelper.setText("인증번호는" + authCode + "입니다.");
//		msg.setFrom(new InternetAddress(user, "Goose"));
//        messageHelper.setTo(email);
//        msg.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(email));
//        } catch (UnsupportedEncodingException e) {
//        	e.printStackTrace();
//        } catch (MessagingException e) {
//        	e.printStackTrace();
//        }
//		
//        mailSender.send(msg);
//		
//		PrintWriter out = response.getWriter();
//		
//		out.print(job);
//		out.flush();
//		out.close();
//	}

	@RequestMapping(value = "findId.do", method = RequestMethod.POST)
	public ModelAndView findId(ModelAndView mv, String name, String email) {

//		System.out.println(name);
//		System.out.println(email);

		m.setEmail(email);
		m.setMemberName(name);

		Map map = new HashMap();
		String id = mService.findId(m);
//		System.out.println(id);

		map.put("id", id);
		mv.addAllObjects(map);
		mv.setViewName("jsonView");
		return mv;

	}

//	@RequestMapping(value="find.do", method=RequestMethod.POST)
//	@ResponseBody
//	public void findMember(@RequestBody String param) throws ParseException {
//		
//		JSONParser parser = new JSONParser();
//		JSONObject jobj = (JSONObject)parser.parse(param);
////		(JSONObject)parser.parse(param);
//		
//		String name = (String)jobj.get("name");
//		String email = (String)jobj.get("email");
////		m.setMemberName(name);
////		m.setEmail(email);
//		System.out.println(name);
//		System.out.println(email);
//		
////		String id = mService.findId(m);
//		
////		System.out.println(id);
//	}

	@RequestMapping(value = "findPwd.do", method = RequestMethod.POST)
	public ModelAndView findPwd(ModelAndView mv, String name, String email, String id) {

		Map map = new HashMap();

		// Tempkey 클래스 사용해서 난수생성(영어, 숫자, 특수문자 조합)
		String authCode = new Tempkey().generateKey(10); // 인증키 생성
		System.out.println("authCode : " + authCode);

		m.setMemberId(id);
		m.setEmail(email);
		m.setMemberName(name);
		int result = mService.checkMember(m);
		if (result > 0) { // 사용자가 입력한 값과 일치하는 회원이 존재하면 메일 발송

			String user = "p.jaemyung91@gmai.com";
			MimeMessage msg = mailSender.createMimeMessage();

			try {

//		      	MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");
				MimeMessageHelper messageHelper = new MimeMessageHelper(msg, "UTF-8");
				messageHelper.setSubject("임시 비밀번호 발급");
				messageHelper.setText("임시 비밀번호는" + authCode + "입니다.");
				msg.setFrom(new InternetAddress(user, "Goose"));
				messageHelper.setTo(email);
				msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}

			mailSender.send(msg);
			String encPwd = bcryptPasswordEncoder.encode(authCode);

			m.setMemberPwd(encPwd);
			int result2 = mService.changePwd(m);

			if (result2 > 0) { // 업데이트 성공 시
				map.put("msg", "success");
				mv.addAllObjects(map);
				mv.setViewName("jsonView");
			}

		}
		return mv;
	}
}
