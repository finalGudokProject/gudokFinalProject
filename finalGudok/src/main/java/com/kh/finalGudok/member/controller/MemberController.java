package com.kh.finalGudok.member.controller;

import static com.kh.finalGudok.common.pagination2.getPageInfo2;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import com.kh.finalGudok.member.model.vo.Inquiry;
import com.kh.finalGudok.item.model.vo.BannerItem;
import com.kh.finalGudok.item.model.vo.Item;
import com.kh.finalGudok.item.model.vo.PageInfo;
import com.kh.finalGudok.member.model.exception.MemberException;
import com.kh.finalGudok.member.model.service.MemberService;
import com.kh.finalGudok.member.model.vo.AdminBoard;
import com.kh.finalGudok.member.model.vo.AdminExchange;
import com.kh.finalGudok.member.model.vo.AdminMember;
import com.kh.finalGudok.member.model.vo.AdminPayment;
import com.kh.finalGudok.member.model.vo.AdminSecession;
import com.kh.finalGudok.member.model.vo.AdminSubscribe;
import com.kh.finalGudok.member.model.vo.Cancle;
import com.kh.finalGudok.member.model.vo.Cart;
import com.kh.finalGudok.member.model.vo.Chart;
import com.kh.finalGudok.member.model.vo.DeleteHeart;
import com.kh.finalGudok.member.model.vo.Delivery;
import com.kh.finalGudok.member.model.vo.Exchange;
import com.kh.finalGudok.member.model.vo.Grade;
import com.kh.finalGudok.member.model.vo.Heart;
import com.kh.finalGudok.member.model.vo.Member;
import com.kh.finalGudok.member.model.vo.Point;
import com.kh.finalGudok.member.model.vo.Reply;
import com.kh.finalGudok.member.model.vo.Review;
import com.kh.finalGudok.member.model.vo.Search;
import com.kh.finalGudok.member.model.vo.Subscribe;
import com.kh.finalGudok.member.model.vo.Withdrawal;
import com.kh.finalGudok.member.model.vo.Tempkey;

@SessionAttributes("loginUser")
@Controller
public class MemberController {

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

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView memberLogin(Member m, HttpSession session, ModelAndView mv) {

		Member loginUser = mService.loginMember(m);

		System.out.println(loginUser);

		int subscribeCount = mService.subscribeCount(loginUser.getMemberNo());
		int cartCount = mService.cartCount(loginUser.getMemberNo());
		int pointCount = mService.pointCount(loginUser.getMemberNo());

		System.out.println("����" + subscribeCount);
		System.out.println("��ٱ���" + cartCount);
		System.out.println("����Ʈ" + pointCount);

		if (bcryptPasswordEncoder.matches(m.getMemberPwd(), loginUser.getMemberPwd())) {
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("subscribeCount", subscribeCount);
			session.setAttribute("cartCount", cartCount);
			session.setAttribute("pointCount", pointCount);

			if (loginUser.getMemberId().equalsIgnoreCase("admin")) {
				mv.setViewName("admin/main");
			} else {
				mv.setViewName("home");
			}

		} else {
			throw new MemberException("�α��� ����");
		}
		return mv;
	}

	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
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

		// web.xml�� �ѱ� ���� ������ ���� ���� ���
		// bCrypt�� ��ȣȭ ó�� -> ���� ���̺귯�� �߰�, xml���� bean ����
		// @Autowired ����
		String encPwd = bcryptPasswordEncoder.encode(pwd);

		// Member��ü�� ���
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
			throw new MemberException("ȸ������ ����");
		}

	}

	@RequestMapping("dupId.do")
	public void idDuplicateCheck(HttpServletResponse response, String memberId) throws IOException {
		boolean idCheckResult = mService.checkIdDup(memberId) == 0 ? true : false;

		PrintWriter out = response.getWriter();
		out.print(idCheckResult);
		out.flush();
		out.close();
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
				messageHelper.setSubject("�̸��� ����");
				messageHelper.setText("������ȣ��" + authCode + "�Դϴ�.");
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

	@RequestMapping(value = "findPwd.do", method = RequestMethod.POST)
	public ModelAndView findPwd(ModelAndView mv, String name, String email, String id) {

		Map map = new HashMap();

		// Tempkey Ŭ���� ����ؼ� ��������(����, ����, Ư������ ����)
		String authCode = new Tempkey().generateKey(10); // ����Ű ����
		System.out.println("authCode : " + authCode);

		m.setMemberId(id);
		m.setEmail(email);
		m.setMemberName(name);
		int result = mService.checkMember(m);
		if (result > 0) { // ����ڰ� �Է��� ���� ��ġ�ϴ� ȸ���� �����ϸ� ���� �߼�

			String user = "p.jaemyung91@gmai.com";
			MimeMessage msg = mailSender.createMimeMessage();

			try {

//		      	MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");
				MimeMessageHelper messageHelper = new MimeMessageHelper(msg, "UTF-8");
				messageHelper.setSubject("�ӽ� ��й�ȣ �߱�");
				messageHelper.setText("�ӽ� ��й�ȣ��" + authCode + "�Դϴ�.");
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

			if (result2 > 0) { // ������Ʈ ���� ��
				map.put("msg", "success");
				mv.addAllObjects(map);
				mv.setViewName("jsonView");
			}

		}
		return mv;
	}

	// ------------------------------ ���������� ----------------------------------------------

	// ���������� �̵�
	@RequestMapping("mypage.do")
	public String mypageView() {
		return "mypage/subscribe";
	}

	// ȸ������ Ȯ�� �� ���� Ȯ��
	@RequestMapping("myInfo.do")
	public String myInfoView() {
		return "mypage/memberConfirm";
	}

	// ȸ�� Ż�� ������
	@RequestMapping("myWithdrawal.do")
	public String withdrawalView() {
		return "mypage/memberWithdrawal";
	}

	// �� ��� ������
	@RequestMapping("heartView.do")
	public String heartView() {
		return "mypage/heart";
	}

	@RequestMapping("gradeView.do")
	public String gradeView() {
		return "mypage/gradeInfo";
	}

	// ���� ��� ������
	@RequestMapping("subscribeView.do")
	public String subscribeView() {
		return "mypage/subscribe";
	}

	// ��ٱ��� ��� ������
	@RequestMapping("cartView.do")
	public String cartView() {
		return "mypage/cart";
	}

	// ���� ��ȸ
	@RequestMapping("subscribeList.do")
	@ResponseBody
	public void subscribeList(HttpServletResponse response, Integer memberNo) throws JsonIOException, IOException { // ����

		ArrayList<Subscribe> list = mService.selectSubscribeList(memberNo);

		System.out.println("���� ����  : " + list);

		response.setContentType("application/json;charset=utf-8");

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(list, response.getWriter());
	}

	// �� ��� �ҷ�����(ajax)
	@RequestMapping("heartList.do")
	@ResponseBody
	public void heartList(HttpServletResponse response, Integer memberNo) throws JsonIOException, IOException {
		ArrayList<Heart> list = mService.selectHeartList(memberNo);

		System.out.println("�� ����  : " + list);

		response.setContentType("application/json;charset=utf-8");

		new Gson().toJson(list, response.getWriter());
	}

	// ���� Ȯ��
	@RequestMapping(value = "memberConfirm.do", method = RequestMethod.POST)
	public String memberConfirm(Member m, HttpSession session, Model model) { // ����
		Member loginUser = mService.loginMember(m);

		System.out.println(m);
		System.out.println(loginUser);

		// ���������� ��ȣȭ ó���� �̷������. (��ȣȭ�� ȸ���� �α��� ����)
		if (bcryptPasswordEncoder.matches(m.getMemberPwd(), loginUser.getMemberPwd())) { // �α��� �� ��� ��ü�� ��ȸ �Ǿ��� ��
			model.addAttribute("loginUser", loginUser);
			return "mypage/memberInfoView";
		} else { // �α��� ���н�
			throw new MemberException("����Ȯ�� ����");
			// ���ܸ� �߻����Ѽ� ������������ �Ѿ ����
			// �켱 ���� Ŭ������ RuntimeException�� ��� �޾�
			// ���� ó���� ���� �ʿ� ����.

			// �׸��� ���ܰ� �߻� ���� �� common�� �ִ� errorPage����
			// ó���� �� �ֵ��� web.xml�� ���� ���� �������� ����Ϸ� ����!
		}

	}

	// ȸ�� ���� ����
	@RequestMapping(value = "memberModify.do", method = RequestMethod.POST)
	public String memberModify(Member m, Model model) { // ����

		int result = mService.updateMember(m);

		System.out.println("ȸ������ ���� ��  : " + m);

		if (result > 0) {
			// ȸ�������� �����Ǹ� ���� �α��� �� ����� ������
			// ������Ʈ ��Ű�� ���� session�� ������ ��ü�� ������ �ȴ�.
			// @SessionAttribute("loginUser")�� Ŭ���� ���� �޾���� ������
			// model�� ������ ȸ�� ��ü�� ����
			model.addAttribute("loginUser", m);
		} else {
			throw new MemberException("���� ����!");
		}

		return "mypage/memberInfoView";
	}

	// ������ ����
	@RequestMapping(value = "pointList.do")
	public ModelAndView pointList(ModelAndView mv, Integer memberNo) { // ����
		ArrayList<Point> list = mService.selectPointList(memberNo);

		System.out.println("������ ����  : " + list);

		if (list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/pointList");
		} else {
			throw new MemberException("�����ݳ��� ����Ʈ �ҷ����� ����");
		}

		return mv;
	}

	// ���� ���
	@RequestMapping(value = "reviewList.do")
	public ModelAndView reviewList(ModelAndView mv, Integer memberNo) { // ����
		ArrayList<Review> list = mService.selectReviewList(memberNo);

		System.out.println("���� ����  : " + list);

		if (list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/review");
		} else {
			throw new MemberException("���� ����Ʈ �ҷ����� ����");
		}

		return mv;
	}

	// ���� ����
	@RequestMapping(value = "inquiryList.do")
	public ModelAndView inquiryList(ModelAndView mv, Integer memberNo) {
		ArrayList<Inquiry> list = mService.selectInquiryList(memberNo);

		System.out.println("1:1 ���� ���� : " + list);

		if (list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/inquiry");
		} else {
			throw new MemberException("1:1 ����Ʈ �ҷ����� ����");
		}

		return mv;
	}

	// ��ȯ ����
	@RequestMapping(value = "exchangeList.do")
	public ModelAndView exchangeList(ModelAndView mv, Integer memberNo) { // ����
		ArrayList<Exchange> list = mService.selectExchangeList(memberNo);

		System.out.println("��ȯ ���� : " + list);

		if (list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/exchange");
		} else {
			throw new MemberException("��ȯ ����Ʈ �ҷ����� ����");
		}

		return mv;
	}

	// ��� ����
	@RequestMapping(value = "deliveryList.do")
	public ModelAndView deliveryList(ModelAndView mv, Integer memberNo) { // ����
		ArrayList<Delivery> list = mService.selectDeliveryList(memberNo);

		System.out.println("��� ���� : " + list);

		if (list != null) {
			mv.addObject("list", list);
			mv.setViewName("mypage/delivery");
		} else {
			throw new MemberException("��� ����Ʈ �ҷ����� ����");
		}

		return mv;
	}

	// ��ٱ��� ����
	@RequestMapping("cartList.do")
	@ResponseBody
	public void cartList(HttpServletResponse response, Integer memberNo) throws JsonIOException, IOException { // ����
		ArrayList<Cart> list = mService.selectCartList(memberNo);

		System.out.println("��ٱ��� ���� : " + list);

		response.setContentType("application/json;charset=utf-8");

		new Gson().toJson(list, response.getWriter());
	}

	// ��ȯ ��û
	@RequestMapping("exchangeInsert.do")
	public String exchangeInsert(HttpServletRequest request, Exchange e) { // ����

		if (e.getExchangeCategory() == 1) {
			e.setExchangeContent("ǰ���ҷ�");
		} else if (e.getExchangeCategory() == 2) {
			e.setExchangeContent("�����");
		}

		System.out.println("��ȯ ���� : " + e);

		int result = mService.insertExchange(e);
		int result2 = mService.updateSubscribe(e.getSubscribeNo());

		if (result > 0 && result2 > 0) {
			return "redirect:exchangeList.do";
		} else {
			throw new MemberException("��ȯ ��û ����");
		}
	}

	

	// Ż���ϱ�
	@RequestMapping("withdrawalInsert.do")
	public String withdrawalInsert(HttpServletRequest request, Withdrawal w) {
		if (w.getSecessionCategory() == 1) {
			w.setSecessionContent("���񽺰� ������ ���� ����");
		} else if (w.getSecessionCategory() == 2) {
			w.setSecessionContent("������ ���");
		} else if (w.getSecessionCategory() == 3) {
			w.setSecessionContent("���ϴ� ��ǰ�� ����");
		} else if (w.getSecessionCategory() == 4) {
			w.setSecessionContent("����������ȣ�� ����");
		}

		System.out.println("Ż�� ���� : " + w);

		int result = mService.insertSecession(w);
		int result2 = mService.updateMemberStatus(w.getMemberNo());

		if (result > 0 && result2 > 0) {
			return "home";
		} else {
			throw new MemberException("Ż�� ����");
		}
	}

	// ���� ����
	@RequestMapping("mreviewDelete.do")
	public String reviewDelete(HttpServletRequest request, Integer reviewNo) {// ����
//		Review review = mService.selectReview(reviewNo); 

		int result = mService.deleteReview(reviewNo);

		if (result > 0) {
			return "redirect:reviewList.do";
		} else {
			throw new MemberException("���� ���� ����");
		}
	}

	// �����ֱ� ����
	@RequestMapping("cycleChange.do")
	public String cycleChange(HttpServletRequest request, Subscribe subscribe) {
		System.out.println("������ȣ : " + subscribe.getSubscribeNo());
		System.out.println("������ �����ֱ� : " + subscribe.getCycleNo());

		if (subscribe.getCycleNo() == 1) {
			subscribe.setCycleNo(1);
		} else if (subscribe.getCycleNo() == 2) {
			subscribe.setCycleNo(2);
		} else if (subscribe.getCycleNo() == 3) {
			subscribe.setCycleNo(3);
		} else {
			subscribe.setCycleNo(4);
		}

		System.out.println("�ֱ� ���� : " + subscribe);

		int result = mService.cycleChange(subscribe);

		if (result > 0) {
			return "mypage/subscribe";
		} else {
			throw new MemberException("�����ֱ⺯�� ����");
		}
	}

	// �� ����
	@RequestMapping("heartDelete.do")
	@ResponseBody
	public String heartDelete(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "checkArr[]") List<String> heartList) {
		Member loginUser = (Member) session.getAttribute("loginUser");

		System.out.println("���û��� �����");

		System.out.println(heartList);

		DeleteHeart dh = new DeleteHeart();

		int heartNo;
		int memberNo = loginUser.getMemberNo();

		int result = 0;

		for (int i = 0; i < heartList.size(); i++) {
			heartNo = Integer.parseInt(heartList.get(i));
			dh.setHeartNo(heartNo);
			dh.setMemberNo(memberNo);
			result = mService.deleteHeart(dh);
			result += result;
		}

		if (result > 0) {
			return "success";
		} else {
			throw new MemberException("�� ���� ����");
		}
	}

	// �������
	@RequestMapping("subscribeCancle.do")
	public String subscribeCancle(HttpServletRequest request, Cancle c) { // ����

		if (c.getCancleCategory() == 1) {
			c.setCancleContent("��ǰ�� ���ʿ�");
		} else if (c.getCancleCategory() == 2) {
			c.setCancleContent("������ ���");
		}

		System.out.println("��� ���� : " + c);

		int result = mService.insertCancle(c);
		int result2 = mService.updateSubscribeStatus(c.getSubscribeNo());

		if (result > 0 && result2 > 0) {
			return "mypage/subscribe";
		} else {
			throw new MemberException("��� ��û ����");
		}
	}

	// ��ٱ��� ����
	@RequestMapping("cartDelete.do")
	@ResponseBody
	public String cartDelete(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "checkArr[]") List<String> cartList) {
		Member loginUser = (Member) session.getAttribute("loginUser");

		System.out.println("���û��� �����");

		System.out.println(cartList);

		DeleteHeart dh = new DeleteHeart();

		int cartNo;

		int memberNo = loginUser.getMemberNo();

		int result = 0;

		for (int i = 0; i < cartList.size(); i++) {
			cartNo = Integer.parseInt(cartList.get(i));

			HashMap map = new HashMap<Integer, Integer>();

			map.put("cartNo", cartNo);
			map.put("memberNo", memberNo);

			result = mService.deleteCart(map);

			result += result;

		}

		if (result > 0) {
			return "success";
		} else {
			throw new MemberException("��ٱ��� ���� ����");
		}
	}

	// ��ٱ��� �߰�
	@RequestMapping("addCart.do")
	@ResponseBody
	public String addCart(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "checkArr[]") List<String> cartList) {
		Member loginUser = (Member) session.getAttribute("loginUser");

		System.out.println("��ٱ��� �߰�");

		int itemNo;
		int result = 0;

		for (int i = 0; i < cartList.size(); i++) {
			itemNo = Integer.parseInt(cartList.get(i));
			Item item = mService.selectItem(itemNo);

			HashMap map = new HashMap<Object, Object>();

			System.out.println("������ �� ��ǰ : " + item);

			if (item != null) {
				map.put("item", item);
				map.put("member", loginUser);
				result = mService.addCart(map);
			}
			result += result;
		}

		if (result > 0) {
			return "success";
		} else {
			throw new MemberException("��ٱ��� �߰� ����");
		}
	}

	// 1:1���� �亯
	@RequestMapping("inquiryReply.do")
	@ResponseBody
	public void inquiryReply(HttpServletResponse response, HttpServletRequest request, Integer boardNo)
			throws JsonIOException, IOException {

		Reply reply = mService.selectReply(boardNo);

		System.out.println("�亯 ����  : " + reply);

		response.setContentType("application/json;charset=utf-8");

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(reply, response.getWriter());
	}

	// ��й�ȣ ����
	@RequestMapping("modifyPassword.do")
	public String modifyPassword(Member m, Model model,
			@RequestParam(value = "changeMemberPwd") String changeMemberPwd) {
		Member loginUser = mService.loginMember(m);

		System.out.println(m);
		System.out.println(loginUser);

		if (bcryptPasswordEncoder.matches(m.getMemberPwd(), loginUser.getMemberPwd())) {

			String encPwd = bcryptPasswordEncoder.encode(changeMemberPwd);

			m.setMemberPwd(encPwd);

			int result = mService.updatePassword(m);

			System.out.println("��й�ȣ ���� �� : " + m);

			if (result > 0) {
				model.addAttribute("loginUser", m);
			} else {
				throw new MemberException("���� ����!");
			}

			model.addAttribute("loginUser", loginUser);

			return "mypage/memberInfoView";
		} else {
			throw new MemberException("����Ȯ�� ����");
		}
	}
	
	// ------------------------------ ���������� ----------------------------------------------
	
	// ------------------------------ ������ ----------------------------------------------
	// ������ ��� & ȸ�� ����Ʈ ����-admin
	@RequestMapping("gradeList.do")
	public ModelAndView selectGradeList(ModelAndView mv, Integer page,
			@RequestParam(value = "categoryNo", required = false) String categoryNo,
			@RequestParam(value = "word", required = false) String word) {

		if (categoryNo == "") {
			categoryNo = null;
		}
		if (word == "") {
			word = null;
		}
		System.out.println(categoryNo);

		Search s = new Search();

		if (categoryNo == null) {
			s.setMemberNo(word);
			s.setMemberName(word);
			s.setMemberId(word);
		} else if (categoryNo.equalsIgnoreCase("memberNo")) {
			s.setMemberNo(word);
		} else if (categoryNo.equalsIgnoreCase("memberId")) {
			s.setMemberId(word);
		} else if (categoryNo.equalsIgnoreCase("memberName")) {
			s.setMemberName(word);
		}

		System.out.println("������ ���� ����" + s);

		// ���� �������
		ArrayList<Grade> gList = mService.selectGradeList();

		// ��޺� ȸ�� �� ����
		for (int i = 0; i < gList.size(); i++) {
			Integer cnt = mService.selectGradeCnt(gList.get(i).getGradeNo());

			if (cnt == null) {
				cnt = 0;
			}

			gList.get(i).setTotal(cnt);
			gList.get(i).setGradeRate(gList.get(i).getGradeRate() * 100);

		}

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = mService.getMemberCnt(s);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		// Ż������ ���� ȸ�� ����Ʈ
		ArrayList<AdminMember> mList = mService.selectMemberN(s, pi);

		// ȸ���� �� ���űݾ� ����
		for (int i = 0; i < mList.size(); i++) {

			Integer cnt = mService.selectTotalPay(mList.get(i).getMemberNo());

			if (cnt == null) {
				cnt = 0;
			}

			mList.get(i).setTotalPay(cnt);
		}

		if (gList != null && mList != null) {
			mv.addObject("gList", gList).addObject("word", word).addObject("categoryNo", categoryNo)
					.addObject("mList", mList).addObject("pi", pi).setViewName("admin/userList");
			return mv;
		} else {
			throw new MemberException("ȸ�� ����Ʈ Ȯ�� ����!");
		}

	}

	// ��޺� ������ ����-admin
	@RequestMapping("gradeRateInfoChang.do")
	@ResponseBody
	public String updateGradeRate(String sendGradeArr, String sendRateArr) {

		System.out.println(sendGradeArr);
		System.out.println(sendRateArr);

		String[] gArr = sendGradeArr.split(",");
		String[] rArr = sendRateArr.split(",");

		ArrayList<Grade> g = new ArrayList<>();
		int result = 0;

		for (int k = 0; k < gArr.length; k++) {

			Grade grade = new Grade();

			grade.setGradeNo(Integer.valueOf(gArr[k]));
			grade.setGradeRate(Double.valueOf(rArr[k]) / 100);

			g.add(grade);
		}

		result = mService.updateGradeRate(g);
		System.out.println(result);

		System.out.println(result);

		if (result < 0) {
			return "success";

		} else {
			throw new MemberException("������ ���� ����!");

		}
	}

	// ��޺� �ּ� �ݾ� ����-admin
	@RequestMapping("gradeMinInfoChang.do")
	@ResponseBody
	public String updateGradeMin(String sendGradeMinArr, String sendGradeArr) {

		System.out.println(sendGradeArr);
		System.out.println(sendGradeMinArr);

		String[] gArr = sendGradeArr.split(",");
		String[] rArr = sendGradeMinArr.split(",");

		ArrayList<Grade> g = new ArrayList<>();
		int result = 0;

		for (int k = 0; k < gArr.length; k++) {

			Grade grade = new Grade();

			grade.setGradeNo(Integer.valueOf(gArr[k]));
			grade.setGradeMin(Integer.valueOf(rArr[k]));

			g.add(grade);
		}

		result = mService.updateGradeMin(g);

		if (result < 0) {
			return "success";

		} else {
			throw new MemberException("������ ���� ����!");

		}
	}

	// ajax �� ����Ʈ ����-admin
	@RequestMapping("gListChange.do")
	public void updateGradeList(HttpServletResponse response, ModelAndView mv, Integer page,
			@RequestParam(value = "categoryNo", required = false) String categoryNo,
			@RequestParam(value = "word", required = false) String word) throws IOException {

		if (categoryNo == "") {
			categoryNo = null;
		}
		if (word == "") {
			word = null;
		}

		Search s = new Search();
		if (categoryNo.equalsIgnoreCase("memberNo")) {
			s.setMemberNo(word);
		} else if (categoryNo.equalsIgnoreCase("memberId")) {
			s.setMemberId(word);
		} else if (categoryNo.equalsIgnoreCase("memberName")) {
			s.setMemberName(word);
		} else {
			s.setMemberNo(word);
			s.setMemberName(word);
			s.setMemberId(word);
		}

		// ���� �������
		ArrayList<Grade> gList = mService.selectGradeList();

		// ��޺� ȸ�� �� ����
		for (int i = 0; i < gList.size(); i++) {
			Integer cnt = mService.selectGradeCnt(gList.get(i).getGradeNo());

			if (cnt == null) {
				cnt = 0;
			}

			gList.get(i).setTotal(cnt);
			gList.get(i).setGradeRate(gList.get(i).getGradeRate() * 100);
		}

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = mService.getMemberCnt(s);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		// Ż������ ���� ȸ�� ����Ʈ
		ArrayList<AdminMember> mList = mService.selectMemberN(s, pi);

		response.setContentType("application/json;charset=utf-8");

		if (gList != null && mList != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < gList.size(); i++) {
				JSONObject jList = new JSONObject();

				jList.put("gradeNo", gList.get(i).getGradeNo());
				jList.put("gradeName", gList.get(i).getGradeName());
				jList.put("gradeMin", gList.get(i).getGradeMin());
				jList.put("total", gList.get(i).getTotal());
				jList.put("gradeRate", gList.get(i).getGradeRate());
				jList.put("categoryNo", categoryNo);
				jList.put("word", word);

				jarr.add(jList);
			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("list", jarr);
			System.out.println(jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new MemberException("�̺�Ʈ ��ü ��ȸ ����!");
		}

	}

	// ����������� -admin
	@RequestMapping("rListChang.do")
	public void updateRateList(HttpServletResponse response, ModelAndView mv, Integer page,
			@RequestParam(value = "categoryNo", required = false) String categoryNo,
			@RequestParam(value = "word", required = false) String word) throws IOException {

		if (categoryNo == "") {
			categoryNo = null;
		}
		if (word == "") {
			word = null;
		}

		Search s = new Search();
		if (categoryNo.equalsIgnoreCase("memberNo")) {
			s.setMemberNo(word);
		} else if (categoryNo.equalsIgnoreCase("memberId")) {
			s.setMemberId(word);
		} else if (categoryNo.equalsIgnoreCase("memberName")) {
			s.setMemberName(word);
		} else {
			s.setMemberNo(word);
			s.setMemberName(word);
			s.setMemberId(word);
		}

		// ���� �������
		ArrayList<Grade> gList = mService.selectGradeList();

		// ��޺� ȸ�� �� ����
		for (int i = 0; i < gList.size(); i++) {
			Integer cnt = mService.selectGradeCnt(gList.get(i).getGradeNo());

			if (cnt == null) {
				cnt = 0;
			}

			gList.get(i).setTotal(cnt);
			gList.get(i).setGradeRate(gList.get(i).getGradeRate() * 100);
		}

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = mService.getMemberCnt(s);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		// Ż������ ���� ȸ�� ����Ʈ
		ArrayList<AdminMember> mList = mService.selectMemberN(s, pi);

		response.setContentType("application/json;charset=utf-8");

		if (gList != null && mList != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < gList.size(); i++) {
				JSONObject jList = new JSONObject();

				jList.put("gradeNo", gList.get(i).getGradeNo());
				jList.put("gradeName", gList.get(i).getGradeName());
				jList.put("gradeMin", gList.get(i).getGradeMin());
				jList.put("total", gList.get(i).getTotal());
				jList.put("gradeRate", gList.get(i).getGradeRate());

				jarr.add(jList);
			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("list", jarr);
			System.out.println(jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new MemberException("�̺�Ʈ ��ü ��ȸ ����!");
		}

	}

	// �� ȸ�� ���� �󼼺���-admin
	@RequestMapping("mDetail.do")
	public ModelAndView selectOneMember(ModelAndView mv, Integer page, int memberNo, Integer detailPage, String type) {

		// �� �������� �̵��ϱ���, ȸ�� ����Ʈ�� ������ ��ȣ
		int beforePage = page;

		// �ϴ� ���� �������� ������ ��ȣ
		int currentPage = 1;

		if (detailPage != null) {
			currentPage = detailPage;
		}

		int listCount = mService.getMemberPayCnt(memberNo);

		// �� ������ �� ���� �������� ����
		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		// �ش� ȸ�� ����
		AdminMember m = mService.selectOneMember(memberNo);

		// ȸ���� ��������Ʈ
		ArrayList<AdminPayment> pList = mService.selectMemberPay(memberNo, pi);
		Integer totalPayment = mService.selectTotalPay(memberNo);
		if (totalPayment == null) {
			totalPayment = 0;
		}

		System.out.println(m);
		System.out.println("pList��" + pList);

		if (m != null) {
			mv.addObject("pList", pList).addObject("totalPayment", totalPayment).addObject("memberNo", memberNo)
					.addObject("m", m).addObject("pi", pi).addObject("beforePage", beforePage).addObject("type", type)
					.setViewName("admin/userDetail");
			return mv;
		} else {
			throw new MemberException("ȸ�� �� Ȯ�� ����!");
		}

	}

	// ȸ�� ���� ����(������)-admin
	@RequestMapping("mUpdateA.do")
	public ModelAndView updateMemberA(ModelAndView mv, AdminMember m, Integer beforePage) {

		System.out.println(m);
		int result = mService.updateMemberA(m);

		if (result > 0) {
			mv.addObject("page", beforePage).setViewName("redirect:gradeList.do");
			return mv;

		} else {
			throw new MemberException("ȸ�� ���� ���� ����!");
		}
	}

	// ȸ�� ����-admin
	@RequestMapping("deleteM.do")
	public ModelAndView deleteMemberA(ModelAndView mv, Integer memberNo, Integer beforePage) {

		System.out.println("������");

		System.out.println(m);
		int result = mService.deleteMemberA(memberNo);
		int result1 = mService.deleteMemberSecession(memberNo);
		int result2 = mService.deleteMemberBoard(memberNo);
		int result3 = mService.deleteMemberHeart(memberNo);
		int result7 = mService.deleteMemberCart(memberNo);
		int result4 = mService.deleteMemberReview(memberNo);
		int result5 = mService.deleteMemberPayment(memberNo);
		int result6 = mService.deleteMemberSubscribe(memberNo);

		System.out.println(result);

		if (result > 0) {
			mv.addObject("page", beforePage).setViewName("redirect:gradeList.do");
			return mv;

		} else {
			throw new MemberException("ȸ�� ���� ����!");
		}

	}

	// Ż��ȸ�� ����Ʈ -admin
	@RequestMapping("sList.do")
	public ModelAndView selectSecessionList(ModelAndView mv, Integer page,
			@RequestParam(value = "categoryNo", required = false) String categoryNo,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "word", required = false) String word) {

		if (categoryNo == "") {
			categoryNo = null;
		}
		if (type == "") {
			type = null;
		}
		if (word == "") {
			word = null;
		}

		System.out.println("ī�װ���" + categoryNo);
		System.out.println("Ÿ����" + type);
		System.out.println("�ܾ��" + word);

		Search s = new Search();
		if (categoryNo != null) {
			s.setCategory1(categoryNo); // secessionCategory
		}

		if (type != null) {
			if (type.equalsIgnoreCase("memberId")) {
				s.setMemberId(word);
			} else if (type.equalsIgnoreCase("memberNo")) {
				s.setMemberNo(word);
			} else if (type.equalsIgnoreCase("memberName")) {
				s.setMemberName(word);
			} else {
				s.setCategory2(word); // sessionContent
			}
		}

		if (categoryNo == null && type == null) {
			s.setMemberId(word);
			s.setMemberNo(word);
			s.setMemberName(word);
			s.setCategory2(word);
		}

		System.out.println("s��" + s);

		// Ż�� ������ ���� ������ ����Ʈ

		ArrayList<AdminSecession> sList = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
			AdminSecession as = new AdminSecession();
			as.setSecessionCategory(i);
			Integer t = mService.selectSecessionCnt(as);
			if (t == null) {
				t = 0;
			}
			as.setTotal(t);
			sList.add(as);
		}

		// ��޺� Ż�� �ο�

		ArrayList<AdminSecession> mList = new ArrayList<>();

		for (int i = 1; i < 5; i++) {
			AdminSecession as = new AdminSecession();
			as.setGradeNo(i);
			Integer t = mService.selectMemberSecessionCnt(as);
			if (t == null) {
				t = 0;
			}
			as.setTotal(t);
			mList.add(as);
		}

		System.out.println("mList" + mList);

		// Ż�� ȸ���� ����Ʈ

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		// Ż��ȸ�� ����
		int listCount = mService.getMemberCntY(s);

		System.out.println("��� �����°ž�" + listCount);
		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<AdminSecession> msList = mService.selectMemberSecession(s, pi);

		System.out.println("msList" + msList);

		if (sList != null && mList != null && msList != null) {
			mv.addObject("sList", sList).addObject("word", word).addObject("type", type)
					.addObject("categoryNo", categoryNo).addObject("mList", mList).addObject("msList", msList)
					.addObject("pi", pi).setViewName("admin/secessionList");
			return mv;
		} else {
			throw new MemberException("Ż�� ���� Ȯ�� ����!");
		}
	}

	// �ֹ� ��ǰ ����Ʈ-admin
	@RequestMapping("oList.do")
	public ModelAndView selectOrderList(ModelAndView mv, Integer page,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "word", required = false) String word,
			@RequestParam(value = "type", required = false) String type) {

		System.out.println(category);
		System.out.println(word);
		System.out.println(type);

		if (category == "") {
			category = null;
		}

		if (word == "") {
			word = null;
		}

		if (type == "") {
			type = null;
		}

		Search s = new Search();
		s.setCategory1(category);

		if (type == null) {
			s.setSubscribeNo(word);
			s.setItemName(word);

		} else if (type.equalsIgnoreCase("subscribeNo")) {
			s.setSubscribeNo(word);

		} else if (type.equalsIgnoreCase("itemName")) {
			s.setItemName(word);
		} else if (type.equalsIgnoreCase("memberId")) {
			s.setMemberId(word);
		}

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = mService.getOrderCnt(s);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<AdminSubscribe> oList = mService.selectOrderList(s, pi);
		System.out.println(oList);
		System.out.println(listCount);

		if (oList != null) {

			mv.addObject("pi", pi).addObject("oList", oList).addObject("type", type).addObject("category", category)
					.addObject("word", word).setViewName("admin/orderList");

			return mv;
		} else {
			throw new MemberException("�ֹ� ���� Ȯ�� ����!");
		}

	}

	// ������ ��� ���� ����-admin
	@RequestMapping("updateDelivery.do")
	@ResponseBody
	public String updateDelivery(String sendArr, String deliveryStatus) {

		String[] strArr = sendArr.split(",");

		ArrayList<AdminSubscribe> dArr = new ArrayList<>();

		for (int i = 0; i < strArr.length; i++) {
			AdminSubscribe e = new AdminSubscribe();
			e.setSubscribeNo(Integer.valueOf(strArr[i]));
			e.setDeliveryStatus(deliveryStatus);
			dArr.add(e);
		}

		System.out.println(dArr);

		int result = mService.updateDelivery(dArr);

		System.out.println("�����" + result);
		if (result < 0) {

			return "success";

		} else {
			throw new MemberException("���� ���� ����!");
		}
	}

	// �ֹ����º��� -admin
	@RequestMapping("oListChange.do")
	public void changeOrderList(HttpServletResponse response, Integer page,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "word", required = false) String word,
			@RequestParam(value = "type", required = false) String type) throws IOException {

		System.out.println("���� ���� �Ͷ�");

		if (category == "") {
			category = null;
		}

		if (word == "") {
			word = null;
		}

		if (type == "") {
			type = null;
		}

		Search s = new Search();
		s.setCategory1(category);

		if (type == null) {
			s.setSubscribeNo(word);
			s.setItemName(word);

		} else if (type.equalsIgnoreCase("subscribeNo")) {
			s.setSubscribeNo(word);

		} else if (type.equalsIgnoreCase("itemName")) {
			s.setItemName(word);
		} else if (type.equalsIgnoreCase("memberId")) {
			s.setMemberId(word);
		}

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = mService.getOrderCnt(s);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<AdminSubscribe> oList = mService.selectOrderList(s, pi);

		for (int i = 0; i < oList.size(); i++) {
			if (oList.get(i).getDeliveryStatus().equalsIgnoreCase("N")) {
				oList.get(i).setDeliveryStatus("��� ���");
			} else if (oList.get(i).getDeliveryStatus().equalsIgnoreCase("D")) {
				oList.get(i).setDeliveryStatus("�����");
			} else {
				oList.get(i).setDeliveryStatus("��ۿϷ�");
			}

		}

		System.out.println("���� ���� �Ͷ�2");

		response.setContentType("application/json;charset=utf-8");

		JSONArray jarr = new JSONArray();

		for (int i = 0; i < oList.size(); i++) {
			JSONObject jList = new JSONObject();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			jList.put("subscribeNo", oList.get(i).getSubscribeNo());
			jList.put("subscribeDate", sdf.format(oList.get(i).getSubscribeDate()));
			jList.put("itemNo", oList.get(i).getItemNo());
			jList.put("itemName", oList.get(i).getItemName());
			jList.put("amount", oList.get(i).getAmount());
			jList.put("memberId", oList.get(i).getMemberId());
			jList.put("deliveryStatus", oList.get(i).getDeliveryStatus());
			jList.put("category", category);
			jList.put("word", word);
			jList.put("type", type);

			jarr.add(jList);
		}

		JSONObject sendJson = new JSONObject();
		sendJson.put("list", jarr);

		PrintWriter out = response.getWriter();
		out.print(sendJson);
		out.flush();
		out.close();

	}

	// �������� �󼼺��� -admin
	@RequestMapping("oDetail.do")
	public ModelAndView selectOrderDetail(ModelAndView mv, Integer page, Integer subscribeNo, String type) {

		System.out.println("Ÿ����???" + type);
		// ���� �� ���� ��ȸ
		AdminSubscribe sc = mService.selectOrder(subscribeNo);

		System.out.println("sc" + sc);
		// �� �ݾ�(���� �� �ݾ�)
		int total = mService.selectItemTotalP(subscribeNo);
		System.out.println("total" + total);

		// ���� ���� ��ȸ
		AdminPayment p = mService.selectPayment(subscribeNo);

		p.setTotalPayment(mService.selectTotalPayment(subscribeNo));

		System.out.println("p" + p);

		System.out.println("�������¿�" + page);

		if (sc != null && p != null) {

			mv.addObject("sc", sc).addObject("p", p).addObject("page", page).addObject("type", type)
					.addObject("total", total).setViewName("admin/orderDetail");

			return mv;
		} else {
			throw new MemberException("���� ���� ����!");
		}

	}

	// ���� ���� ���� -admin
	@RequestMapping("updateSubscribe.do")
	public ModelAndView updateSubscribeA(ModelAndView mv, Integer page, Integer subscribeNo) {

		int result = mService.updateSubscribeA(subscribeNo);

		System.out.println("��ȣ��" + subscribeNo + "��������" + page + "�����!!!" + result);

		if (result > 0) {
			mv.addObject("page", page).setViewName("redirect:oList.do");
			return mv;
		} else {
			throw new MemberException("���� ��� ����!");
		}
	}

	// ��ȯ ����Ʈ -admin
	@RequestMapping("exchangList.do")
	public ModelAndView exchangeListView(ModelAndView mv, Integer page,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "word", required = false) String word,
			@RequestParam(value = "type", required = false) String type) {
		// �ְ� ��ȯ ������ ������ ��ȸ�ϱ� ���� ��¥ ����
		Calendar start = Calendar.getInstance(); // ���� �ð�
		Date startDate = new Date(start.getTimeInMillis()); // Date������ ��ȯ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDay = sdf.format(startDate);

		start.add(Calendar.DATE, -7);
		Date lastDate = new Date(start.getTimeInMillis());
		String lastDay = sdf.format(lastDate); // 7����
		System.out.println(startDay);
		System.out.println(lastDay);

		// ��Ʈ�� ����Ʈ
		ArrayList<Search> list = new ArrayList<>();

		for (int i = 1; i < 4; i++) {
			Search s = new Search();
			s.setStartDay(startDay);
			s.setLastDay(lastDay);
			s.setTemp1(i);
			list.add(s);

			Integer temp = mService.selectExchangeChart(list.get(i - 1));

			if (temp == null) {
				temp = 0;
			}
			s.setTemp2(temp);

			System.out.println(list.get(i - 1).getTemp2());
		}

		// ��ȯ����Ʈ

		System.out.println("ī�װ��� " + category);
		System.out.println("Ÿ���� " + type);
		System.out.println("�˻���� " + word);

		if (category == "") {
			category = null;
		}

		if (word == "") {
			word = null;
		}

		if (type == "") {
			type = null;
		}

		Search s = new Search();
		s.setCategory1(category);

		if (type == null) {
			s.setSubscribeNo(word);
			s.setWord(word);
			s.setMemberId(word);

		} else if (type.equalsIgnoreCase("subscribeNo")) {
			s.setSubscribeNo(word);

		} else if (type.equalsIgnoreCase("exchangeContent")) {
			s.setWord(word);
		} else if (type.equalsIgnoreCase("memberId")) {
			s.setMemberId(word);
		}

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		System.out.println("s��" + s);
		int listCount = mService.getExchangeCnt(s);

		System.out.println("�?" + listCount);
		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<AdminExchange> eList = mService.selectExchange(s, pi);

		for (int i = 0; i < eList.size(); i++) {
			if (eList.get(i).getExchangeStatus().equalsIgnoreCase("N")) {
				eList.get(i).setExchangeStatus("��ȯ ���");
			} else {
				eList.get(i).setExchangeStatus("��ȯ �Ϸ�");
			}

		}

		if (list != null && eList != null) {

			mv.addObject("list", list).addObject("pi", pi).addObject("eList", eList).addObject("category", category)
					.addObject("word", word).addObject("type", type).addObject("pi", pi)
					.setViewName("admin/exchangeList");

			return mv;
		} else {
			throw new MemberException("��ȯ ���� ��ȸ ����!");
		}
	}

	// ��ȯ ���� ����-admin
	@RequestMapping("eChange.do")
	@ResponseBody
	public String exchangeChange(Integer page, String type, String sendArr) {

		System.out.println(page);
		System.out.println(type);

		String[] strArr = sendArr.split(",");

		ArrayList<AdminExchange> dArr = new ArrayList<>();

		for (int i = 0; i < strArr.length; i++) {
			AdminExchange e = new AdminExchange();
			e.setExchangeNo(Integer.valueOf(strArr[i]));
			e.setExchangeStatus(type);
			dArr.add(e);
		}

		int result = mService.updateExchange(dArr);

		if (result < 0) {
			return "success";

		} else {
			throw new MemberException("��ȯ ���� ���� ����!");
		}
	}

	// ��ȯ ���º��� �� ����Ʈ ��������-admin
	@RequestMapping("exchangeListChange.do")
	public void selectChangedExchangeList(HttpServletResponse response, Integer page,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "word", required = false) String word,
			@RequestParam(value = "type", required = false) String type) throws IOException {

		// ��ȯ����Ʈ
		if (category == "") {
			category = null;
		}

		if (word == "") {
			word = null;
		}

		if (type == "") {
			type = null;
		}
		Search s = new Search();
		s.setCategory1(category);

		if (type == null) {
			s.setSubscribeNo(word);
			s.setItemName(word);
			s.setMemberId(word);

		} else if (type.equalsIgnoreCase("subscribeNo")) {
			s.setSubscribeNo(word);

		} else if (type.equalsIgnoreCase("exchangeContent")) {
			s.setItemName(word);
		} else if (type.equalsIgnoreCase("memberId")) {
			s.setMemberId(word);
		}

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		int listCount = mService.getExchangeCnt(s);

		PageInfo pi = new PageInfo();

		int pageLimit = 10; // ������ ������ �� ����
		int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
		pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

		ArrayList<AdminExchange> eList = mService.selectExchange(s, pi);

		for (int i = 0; i < eList.size(); i++) {
			if (eList.get(i).getExchangeStatus().equalsIgnoreCase("N")) {
				eList.get(i).setExchangeStatus("��ȯ ���");
			} else {
				eList.get(i).setExchangeStatus("��ȯ �Ϸ�");
			}

		}

		response.setContentType("application/json;charset=utf-8");

		if (!eList.isEmpty()) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < eList.size(); i++) {
				JSONObject jList = new JSONObject();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				jList.put("exchangeNo", eList.get(i).getExchangeNo());
				jList.put("exchangeDate", sdf.format(eList.get(i).getExchangeDate()));
				jList.put("exchangeContent", eList.get(i).getExchangeContent());
				jList.put("subscribeNo", eList.get(i).getSubscribeNo());
				jList.put("itemName", eList.get(i).getItemName());
				jList.put("memberId", eList.get(i).getMemberId());
				jList.put("itemPrice", eList.get(i).getItemPrice());
				jList.put("exchangeStatus", eList.get(i).getExchangeStatus());
				jList.put("category", category);
				jList.put("word", word);
				jList.put("type", type);

				jarr.add(jList);
			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("list", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new MemberException("�̺�Ʈ ��ü ��ȸ ����!");
		}

	}

	// �Ⱓ�� ���-admin
	@RequestMapping("sDateList.do")
	public ModelAndView selectSalesDate(ModelAndView mv, Integer page, String type,
			@RequestParam(value = "startD", required = false) String startD,
			@RequestParam(value = "lastD", required = false) String lastD) {

		System.out.println("Ÿ����?" + type);
		System.out.println("ù����?" + startD);
		System.out.println("������?" + lastD);

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		// ���� ����

		Calendar last = Calendar.getInstance(); // ���� �ð�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM");
		String lastDay = "";
		String startDay = "";
		int sumTotalP = 0; // �� ����
		int sumTotalC = 0; // �� �� ��

		ArrayList<String> pArr = new ArrayList<>();
		Search s = new Search();
		PageInfo pi = new PageInfo();
		ArrayList<AdminPayment> pList = new ArrayList<>();

		// �⺻ ù ȭ�� (N) --> �ش�⵵�� 1�� 1�Ϻ��� �˻�
		if (type.equalsIgnoreCase("N")) {

			lastDay = sdf.format(last.getTime());
			startDay = lastDay.substring(0, 4).concat("-01-01");

			// �˻��� ��¥ �̾ƿ���

			s.setLastDay(lastDay); // ������ ��¥
			s.setStartDay(startDay); // ó�� ��¥
			System.out.println(s);
			pArr = mService.selectDateList(s);

			// ȭ�鿡 ����� ���� ����Ʈ �����
			int listCount = mService.getSalesCnt(s);
			int pageLimit = 10; // ������ ������ �� ����
			int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
			pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

			pList = mService.selectPaymentList(pArr, pi);

			// �˻��� ���� �� �հ�
			ArrayList<AdminPayment> tot = mService.selectPaymentList(pArr);

			for (int i = 0; i < tot.size(); i++) {
				int c = tot.get(i).getTotalCount();
				int p = tot.get(i).getTotalPayment();
				sumTotalC += c;
				sumTotalP += p;
			}

			// ���� �˻�(T)
		} else if (type.equalsIgnoreCase("T")) {

			lastDay = sdf.format(last.getTime());
			startDay = lastDay;

			// �˻��� ��¥ �̾ƿ���

			s.setLastDay(lastDay); // ������ ��¥
			s.setStartDay(startDay); // ó�� ��¥
			System.out.println(s);
			pArr = mService.selectDateList(s);

			// ȭ�鿡 ����� ���� ����Ʈ �����
			int listCount = mService.getSalesCnt(s);
			int pageLimit = 10; // ������ ������ �� ����
			int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
			pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

			pList = mService.selectPaymentList(pArr, pi);

			// �˻��� ���� �� �հ�
			ArrayList<AdminPayment> tot = mService.selectPaymentList(pArr);

			for (int i = 0; i < tot.size(); i++) {
				int c = tot.get(i).getTotalCount();
				int p = tot.get(i).getTotalPayment();
				sumTotalC += c;
				sumTotalP += p;
			}

			// ������ �˻�(W)
		} else if (type.equalsIgnoreCase("W")) {

			lastDay = sdf.format(last.getTime());
			last.add(Calendar.DATE, -7);
			Date lastDate = new Date(last.getTimeInMillis());
			startDay = sdf.format(lastDate); // 7����

			// �˻��� ��¥ �̾ƿ���

			s.setLastDay(lastDay); // ������ ��¥
			s.setStartDay(startDay); // ó�� ��¥
			System.out.println(s);
			pArr = mService.selectDateList(s);

			// ȭ�鿡 ����� ���� ����Ʈ �����
			int listCount = mService.getSalesCnt(s);
			int pageLimit = 10; // ������ ������ �� ����
			int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
			pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

			pList = mService.selectPaymentList(pArr, pi);

			// �˻��� ���� �� �հ�
			ArrayList<AdminPayment> tot = mService.selectPaymentList(pArr);

			for (int i = 0; i < tot.size(); i++) {
				int c = tot.get(i).getTotalCount();
				int p = tot.get(i).getTotalPayment();
				sumTotalC += c;
				sumTotalP += p;
			}

			// �Ѵ� �˻� (O)
		} else if (type.equalsIgnoreCase("O")) {

			lastDay = sdf.format(last.getTime());
			last.add(Calendar.MONTH, -1);
			Date lastDate = new Date(last.getTimeInMillis());
			startDay = sdf.format(lastDate); // 1����
			System.out.println(lastDay);
			System.out.println(startDay);

			// �˻��� ��¥ �̾ƿ���

			s.setLastDay(lastDay); // ������ ��¥
			s.setStartDay(startDay); // ó�� ��¥
			System.out.println(s);
			pArr = mService.selectDateList(s);

			// ȭ�鿡 ����� ���� ����Ʈ �����
			int listCount = mService.getSalesCnt(s);
			int pageLimit = 10; // ������ ������ �� ����
			int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
			pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

			pList = mService.selectPaymentList(pArr, pi);

			// �˻��� ���� �� �հ�
			for (int i = 0; i < pList.size(); i++) {
				int p = pList.get(i).getTotalPayment();
				sumTotalP += p;
				int c = pList.get(i).getTotalCount();
				sumTotalC += c;
			}

			// ������ �˻� (Y)
		} else if (type.equalsIgnoreCase("Y")) {

			System.out.println(startD);
			System.out.println(lastD);
			startDay = startD.substring(0, 4);
			lastDay = lastD.substring(0, 4);
			System.out.println(startDay);
			System.out.println(lastDay);

			s.setLastDay(lastDay); // ������ ��¥
			s.setStartDay(startDay); // ó�� ��¥
			System.out.println(s);
			pArr = mService.selectYearList(s); // ���� �Ⱓ �̾ƿ���

			// ȭ�鿡 ����� ���� ����Ʈ �����
			int listCount = mService.getSalesYearCnt(pArr);
			System.out.println("����Ʈī��Ʈ��������" + listCount);
			int pageLimit = 10; // ������ ������ �� ����
			int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
			pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

			pList = mService.selectPaymentYearsList(pArr, pi);
			for (int i = 0; i < pList.size(); i++) {
				String d = sdfy.format(pList.get(i).getPaymentDate());
				pList.get(i).setItemName(d);
			}

			System.out.println(pList);

			// �˻��� ���� �� �հ�
			ArrayList<AdminPayment> tot = mService.selectPaymentYearsList(pArr);

			for (int i = 0; i < tot.size(); i++) {
				int c = tot.get(i).getTotalCount();
				int p = tot.get(i).getTotalPayment();
				sumTotalC += c;
				sumTotalP += p;
			}

			// ���� �˻� (M)
		} else if (type.equalsIgnoreCase("M")) {

			System.out.println(startD);
			System.out.println(lastD);
			startDay = startD.substring(0, 7);
			lastDay = lastD.substring(0, 7);
			System.out.println(startDay);
			System.out.println(lastDay);

			s.setLastDay(lastDay); // ������ ��¥
			s.setStartDay(startDay); // ó�� ��¥
			System.out.println(s);
			pArr = mService.selectMonthList(s); // ���� �Ⱓ �̾ƿ���
			System.out.println(pArr);

			// ȭ�鿡 ����� ���� ����Ʈ �����
			int listCount = mService.getSalesMonthsCnt(pArr);
			System.out.println("����Ʈī��Ʈ��������" + listCount);
			int pageLimit = 10; // ������ ������ �� ����
			int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
			pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

			pList = mService.selectPaymentMonthsList(pArr, pi);
			for (int i = 0; i < pList.size(); i++) {
				String d = sdfm.format(pList.get(i).getPaymentDate());
				pList.get(i).setItemName(d);
			}

			System.out.println(pList);

			// �˻��� ���� �� �հ�
			ArrayList<AdminPayment> tot = mService.selectPaymentMonthsList(pArr);

			for (int i = 0; i < tot.size(); i++) {
				int c = tot.get(i).getTotalCount();
				int p = tot.get(i).getTotalPayment();
				sumTotalC += c;
				sumTotalP += p;
			}

			// �Ϻ� �˻� (D)
		} else if (type.equalsIgnoreCase("D")) {

			lastDay = lastD;
			startDay = startD;

			// �˻��� ��¥ �̾ƿ���

			s.setLastDay(lastDay); // ������ ��¥
			s.setStartDay(startDay); // ó�� ��¥
			System.out.println(s);
			pArr = mService.selectDateList(s);

			// ȭ�鿡 ����� ���� ����Ʈ �����
			int listCount = mService.getSalesCnt(s);
			int pageLimit = 10; // ������ ������ �� ����
			int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
			pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

			pList = mService.selectPaymentList(pArr, pi);

			// �˻��� ���� �� �հ�
			ArrayList<AdminPayment> tot = mService.selectPaymentList(pArr);

			for (int i = 0; i < tot.size(); i++) {
				int c = tot.get(i).getTotalCount();
				int p = tot.get(i).getTotalPayment();
				sumTotalC += c;
				sumTotalP += p;
			}
		}

		mv.addObject("pList", pList).addObject("pi", pi).addObject("type", type).addObject("lastDay", lastDay)
				.addObject("startDay", startDay).addObject("sumTotalP", sumTotalP).addObject("sumTotalC", sumTotalC)
				.setViewName("admin/salesDateList");
		return mv;
	}

	// ī�װ��� ����Ʈ -admin
	@RequestMapping("sCategoryList.do")
	public ModelAndView selectSalesCategory(ModelAndView mv, String type,
			@RequestParam(value = "startD", required = false) String startD,
			@RequestParam(value = "lastD", required = false) String lastD) {

		System.out.println("Ÿ����?" + type);

		// ���� ����

		Calendar last = Calendar.getInstance(); // ���� �ð�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM");
		Search sc = new Search();
		String lastDay = "";
		String startDay = "";
		int sumTotalP = 0; // �� ����
		int sumTotalC = 0; // �� �� ��

		ArrayList<AdminPayment> pList = new ArrayList<>();
		ArrayList<Double> ratio = new ArrayList<>();
		ArrayList<Search> cat = new ArrayList<>();
		String[] ct = { "F1", "F2", "F3", "F4", "F5", "F6", "L1", "L2", "L3" };

		for (int i = 0; i < ct.length; i++) {
			Search s = new Search();
			s.setCategory1(ct[i]);
			cat.add(s);
		}

		// �⺻ ù ȭ�� (N) --> �ش�⵵�� 1�� 1�Ϻ��� �˻�
		if (type.equalsIgnoreCase("N")) {

			lastDay = sdf.format(last.getTime());
			startDay = lastDay.substring(0, 4).concat("-01-01");

			for (int i = 0; i < cat.size(); i++) {
				cat.get(i).setStartDay(startDay);
				cat.get(i).setLastDay(lastDay);
			}

			// ȭ�鿡 ����� ���� ����Ʈ �����

			for (int i = 0; i < cat.size(); i++) {

				AdminPayment p = mService.selectPaymentCategoryList(cat.get(i));

				if (p == null) {
					AdminPayment np = new AdminPayment();
					np.setCategoryNo(cat.get(i).getCategory1());
					np.setTotalPayment(0);
					np.setTotalCount(0);
					pList.add(np);
				} else {
					pList.add(p);
				}

			}

			// �˻��� ���� �� �հ�
			for (int i = 0; i < pList.size(); i++) {
				int p = pList.get(i).getTotalPayment();
				sumTotalP += p;

				int c = pList.get(i).getTotalCount();
				sumTotalC += c;
			}

			// ī�װ��� ����

			for (int i = 0; i < pList.size(); i++) {
				System.out.println(pList.get(i).getTotalPayment());
				System.out.println(sumTotalP);

				double r = 0;
				if (sumTotalP != 0) {
					r = (pList.get(i).getTotalPayment() * 100) / sumTotalP;
					System.out.println(r);
				}
				ratio.add(r);
			}

			System.out.println(ratio);

			// ���� �˻�(T)
		} else if (type.equalsIgnoreCase("T")) {

			lastDay = sdf.format(last.getTime());
			startDay = lastDay;
			for (int i = 0; i < cat.size(); i++) {
				cat.get(i).setStartDay(startDay);
				cat.get(i).setLastDay(lastDay);
			}

			// ȭ�鿡 ����� ���� ����Ʈ �����

			for (int i = 0; i < cat.size(); i++) {

				AdminPayment p = mService.selectPaymentCategoryList(cat.get(i));

				if (p == null) {
					AdminPayment np = new AdminPayment();
					np.setCategoryNo(cat.get(i).getCategory1());
					np.setTotalPayment(0);
					np.setTotalCount(0);
					pList.add(np);
				} else {
					pList.add(p);
				}

			}

			// �˻��� ���� �� �հ�
			for (int i = 0; i < pList.size(); i++) {
				int p = pList.get(i).getTotalPayment();
				sumTotalP += p;
				int c = pList.get(i).getTotalCount();
				sumTotalC += c;
			}

			// ī�װ��� ����

			for (int i = 0; i < pList.size(); i++) {
				System.out.println(pList.get(i).getTotalPayment());
				System.out.println(sumTotalP);

				double r = 0;
				if (sumTotalP != 0) {
					r = (pList.get(i).getTotalPayment() * 100) / sumTotalP;
					System.out.println(r);
				}

				ratio.add(r);

			}

			// ������ �˻�(W)
		} else if (type.equalsIgnoreCase("W")) {

			lastDay = sdf.format(last.getTime());
			last.add(Calendar.DATE, -7);
			Date lastDate = new Date(last.getTimeInMillis());
			startDay = sdf.format(lastDate); // 7����
			for (int i = 0; i < cat.size(); i++) {
				cat.get(i).setStartDay(startDay);
				cat.get(i).setLastDay(lastDay);
			}

			// ȭ�鿡 ����� ���� ����Ʈ �����

			for (int i = 0; i < cat.size(); i++) {

				AdminPayment p = mService.selectPaymentCategoryList(cat.get(i));

				if (p == null) {
					AdminPayment np = new AdminPayment();
					np.setCategoryNo(cat.get(i).getCategory1());
					np.setTotalPayment(0);
					np.setTotalCount(0);
					pList.add(np);
				} else {
					pList.add(p);
				}

			}
			// �˻��� ���� �� �հ�
			for (int i = 0; i < pList.size(); i++) {
				int p = pList.get(i).getTotalPayment();
				sumTotalP += p;
				int c = pList.get(i).getTotalCount();
				sumTotalC += c;
			}
			// ī�װ��� ����

			for (int i = 0; i < pList.size(); i++) {
				System.out.println(pList.get(i).getTotalPayment());
				System.out.println(sumTotalP);

				double r = 0;
				if (sumTotalP != 0) {
					r = (pList.get(i).getTotalPayment() * 100) / sumTotalP;
					System.out.println(r);
				}

				ratio.add(r);

			}

			// �Ѵ� �˻� (O)
		} else if (type.equalsIgnoreCase("O")) {

			lastDay = sdf.format(last.getTime());
			last.add(Calendar.MONTH, -1);
			Date lastDate = new Date(last.getTimeInMillis());
			startDay = sdf.format(lastDate); // 1����
			System.out.println(lastDay);
			System.out.println(startDay);
			for (int i = 0; i < cat.size(); i++) {
				cat.get(i).setStartDay(startDay);
				cat.get(i).setLastDay(lastDay);
			}

			// ȭ�鿡 ����� ���� ����Ʈ �����

			for (int i = 0; i < cat.size(); i++) {

				AdminPayment p = mService.selectPaymentCategoryList(cat.get(i));

				if (p == null) {
					AdminPayment np = new AdminPayment();
					np.setCategoryNo(cat.get(i).getCategory1());
					np.setTotalPayment(0);
					np.setTotalCount(0);
					pList.add(np);
				} else {
					pList.add(p);
				}

			}

			// �˻��� ���� �� �հ�
			for (int i = 0; i < pList.size(); i++) {
				int p = pList.get(i).getTotalPayment();
				sumTotalP += p;
				int c = pList.get(i).getTotalCount();
				sumTotalC += c;
			}
			// ī�װ��� ����

			for (int i = 0; i < pList.size(); i++) {
				System.out.println(pList.get(i).getTotalPayment());
				System.out.println(sumTotalP);

				double r = 0;
				if (sumTotalP != 0) {
					r = (pList.get(i).getTotalPayment() * 100) / sumTotalP;
					System.out.println(r);
				}
				ratio.add(r);
			}

			// �Ϻ� �˻� (D)
		} else if (type.equalsIgnoreCase("D")) {

			lastDay = lastD;
			startDay = startD;
			for (int i = 0; i < cat.size(); i++) {
				cat.get(i).setStartDay(startDay);
				cat.get(i).setLastDay(lastDay);
			}

			// ȭ�鿡 ����� ���� ����Ʈ �����

			for (int i = 0; i < cat.size(); i++) {

				AdminPayment p = mService.selectPaymentCategoryList(cat.get(i));

				if (p == null) {
					AdminPayment np = new AdminPayment();
					np.setCategoryNo(cat.get(i).getCategory1());
					np.setTotalPayment(0);
					np.setTotalCount(0);
					pList.add(np);
				} else {
					pList.add(p);
				}
			}
			// �˻��� ���� �� �հ�
			for (int i = 0; i < pList.size(); i++) {
				int p = pList.get(i).getTotalPayment();
				sumTotalP += p;
				int c = pList.get(i).getTotalCount();
				sumTotalC += c;
			}
			// ī�װ��� ����

			for (int i = 0; i < pList.size(); i++) {
				System.out.println(pList.get(i).getTotalPayment());
				System.out.println(sumTotalP);

				double r = 0;
				if (sumTotalP != 0) {
					r = (pList.get(i).getTotalPayment() * 100) / sumTotalP;
					System.out.println(r);
				}
				ratio.add(r);
			}
		}

		mv.addObject("pList", pList).addObject("type", type).addObject("lastDay", lastDay).addObject("ratio", ratio)
				.addObject("startD", startD).addObject("startDay", startDay).addObject("sumTotalP", sumTotalP)
				.addObject("sumTotalC", sumTotalC).setViewName("admin/salesCategoryList");
		return mv;

	}

	// ���� �󼼸���Ʈ -admin
	@RequestMapping("sDetail.do")
	public ModelAndView selectSalesDetail(ModelAndView mv, Integer beforePage, Integer page, String startD,
			String startDay, String lastDay, String type, String type2,
			@RequestParam(value = "lastD", required = false) String lastD,
			@RequestParam(value = "categoryNo", required = false) String categoryNo,
			@RequestParam(value = "word", required = false) String word,
			@RequestParam(value = "category", required = false) String category) throws java.text.ParseException {

		// ���� ����

		ArrayList<AdminPayment> pList = new ArrayList<>();
		// ������
		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		PageInfo pi = new PageInfo();
		String start = "";
		String last = "";

		System.out.println("���޹��� Ÿ����!!!!!!" + type);
		System.out.println("startD��" + startD);
		System.out.println("lastD��" + lastD);
		System.out.println(category);

		if (type2.equals("date")) {

			if (word == "") {
				word = null;
			}

			if (categoryNo == "") {
				categoryNo = null;
			}

			// �Ϻ� �˻��϶�
			if (startD.length() == 10) {

				start = startD;

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar st = Calendar.getInstance();
				st.setTime(sdf.parse(startD));
				st.add(Calendar.DATE, +1);
				Date lastDate = new Date(st.getTimeInMillis());
				last = sdf.format(lastDate); // �Ϸ� ��

			} else if (startD.length() == 7) { // ���� �˻��϶�

				start = startD.concat("-01");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				Calendar st = Calendar.getInstance();
				st.setTime(sdf.parse(startD));
				st.add(Calendar.MONTH, +1);
				Date lastDate = new Date(st.getTimeInMillis());
				last = sdf.format(lastDate).concat("-01"); // �Ϸ� ��

			} else if (startD.length() == 4) { // ���� �˻��϶�

				start = startD.concat("-01-01");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				Calendar st = Calendar.getInstance();
				st.setTime(sdf.parse(startD));
				st.add(Calendar.YEAR, +1);
				Date lastDate = new Date(st.getTimeInMillis());
				last = sdf.format(lastDate).concat("-01-01"); // �Ϸ� ��

				System.out.println("4��¥���϶�");

			}

			if (category == null || category == "") {
				category = "N";
			}

			System.out.println("īīī�װ���" + category);

			Search s = new Search();
			s.setStartDay(start); // �˻� ��¥
			s.setLastDay(last);
			s.setCategoryNo(categoryNo); // ī�װ�
			s.setCategory1(category);

			if (category.equalsIgnoreCase("subscribeNo")) {
				s.setSubscribeNo(word);
			} else if (category.equalsIgnoreCase("itemNo")) {
				s.setItemNo(word);

			} else if (category.equalsIgnoreCase("itemName")) {
				s.setItemName(word);

			} else if (category.equalsIgnoreCase("memberId")) {
				s.setMemberId(word);
			} else {

				s.setSubscribeNo(word);
				s.setItemNo(word);
				s.setItemName(word);
				s.setMemberId(word);

			}

			System.out.println(s);

			int listCount = mService.getSalesDetailCnt(s);
			System.out.println("������" + listCount);

			int pageLimit = 10; // ������ ������ �� ����
			int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
			pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

			// ����Ʈ �������� (�� �����ݾ� ����)
			pList = mService.selectPaymentDetail(s, pi);
			System.out.println(pList.size());

			// ī�װ����� ������
		} else {

			if (word == "") {
				word = null;
			}

			start = startDay;
			last = lastDay;

			if (category == null || category == "") {
				category = "N";
			}

			System.out.println("īīī�װ���" + category);

			Search s = new Search();
			s.setStartDay(start); // �˻� ��¥
			s.setLastDay(last);
			s.setCategoryNo(categoryNo); // ī�װ�
			s.setCategory1(category);

			if (category.equalsIgnoreCase("subscribeNo")) {
				s.setSubscribeNo(word);
			} else if (category.equalsIgnoreCase("itemNo")) {
				s.setItemNo(word);

			} else if (category.equalsIgnoreCase("itemName")) {
				s.setItemName(word);

			} else if (category.equalsIgnoreCase("memberId")) {
				s.setMemberId(word);
			} else {

				s.setSubscribeNo(word);
				s.setItemNo(word);
				s.setItemName(word);
				s.setMemberId(word);

			}

			System.out.println(s);

			int listCount = mService.getSalesDetailCnt(s);
			System.out.println("������" + listCount);

			int pageLimit = 10; // ������ ������ �� ����
			int boardLimit = 5; // �Խ��� �� �������� �ѷ��� �Խñ� ��
			pi = getPageInfo2(currentPage, listCount, pageLimit, boardLimit);

			// ����Ʈ �������� (�� �����ݾ� ����)
			pList = mService.selectPaymentDetail(s, pi);
			System.out.println(pList.size());

		}

		mv.addObject("pList", pList).addObject("beforePage", beforePage).addObject("startDay", startDay)
				.addObject("lastDay", lastDay).addObject("startD", startD).addObject("categoryNo", categoryNo)
				.addObject("pi", pi).addObject("type", type).addObject("type2", type2).setViewName("admin/salesDetail");
		return mv;
	}

	// �����ڸ���---admin
	@RequestMapping("aMain.do")
	public ModelAndView selectAdminMain(ModelAndView mv) {

		// �湮 ���� ��� ��Ʈ

		Calendar last = Calendar.getInstance(); // ���� �ð�
		Date startDate = new Date(last.getTimeInMillis()); // Date������ ��ȯ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDay = sdf.format(startDate);

		last.add(Calendar.DATE, -7);
		Date lastDate = new Date(last.getTimeInMillis());
		String startDay = sdf.format(lastDate); // 7����

		Search s = new Search();
		s.setLastDay(lastDay);// �ֱ� ��¥
		s.setStartDay(startDay); // 7���� ��¥

		// 7���� ��¥ ������ �̾ƿ���
		ArrayList<String> dArr = mService.selectDateList(s);

		ArrayList<Chart> cArr = new ArrayList<>();

		// �湮&���� ��Ʈ �����
		for (int i = 0; i < dArr.size(); i++) {
			Chart c = new Chart();
			System.out.println("i��° dArr��?" + dArr.get(i));
			int mCnt = mService.selectTodayMember(dArr.get(i));
			int vCnt = mService.selectTodayVisitor(dArr.get(i));
			String vDay = dArr.get(i).substring(5, 10).replace("-", "/");

			c.setVisitorNum(vCnt);
			c.setvDay(vDay);
			c.setMemberNum(mCnt);
			cArr.add(c);
		}

		// �ְ� ������Ȳ ��Ʈ
		int sumTotalP = 0; // �� ����
		int sumTotalC = 0; // �� �� ��

		// ȭ�鿡 ����� ���� ����Ʈ �����

		ArrayList<AdminPayment> pList = new ArrayList<>();

		for (int i = dArr.size() - 1; i >= 0; i--) {

			AdminPayment p = mService.selectPaymentMainList(dArr.get(i));
			System.out.println(p);
			if (p == null) {
				AdminPayment p2 = new AdminPayment();
				p2.setCategoryNo(dArr.get(i));
				p2.setTotalPayment(0);
				p2.setTotalCount(0);
				pList.add(p2);
			} else {
				p.setCategoryNo(dArr.get(i));
				pList.add(p);
			}

		}

		System.out.println("pList��" + pList);
		System.out.println("pList���̴�" + pList.size());

		for (int i = 0; i < pList.size(); i++) {
			int c = pList.get(i).getTotalCount();
			int p = pList.get(i).getTotalPayment();
			sumTotalC += c;
			sumTotalP += p;
		}

		// ��ȯ ��� ����Ʈ
		ArrayList<AdminExchange> exList = mService.selectExchangeMain();

		// ��� ��� ����Ʈ
		ArrayList<AdminSubscribe> dList = mService.selectDeliveryMain();

		// �̴亯 ���� ����Ʈ
		ArrayList<AdminBoard> bList = mService.selectBoardMain();

		// �������� ����Ʈ
		ArrayList<AdminBoard> nList = mService.selectNoticeMain();

		// �̺�Ʈ ����Ʈ
		ArrayList<BannerItem> eList = mService.selectEventMain();
		System.out.println(eList);

		mv.addObject("cArr", cArr).addObject("pList", pList).addObject("exList", exList).addObject("dList", dList)
				.addObject("bList", bList).addObject("eList", eList).addObject("nList", nList)
				.setViewName("admin/main");
		return mv;
	}

	// ------------------------------ ������ ----------------------------------------------

}