package com.kh.finalGudok.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalGudok.member.model.exception.MemberException;
import com.kh.finalGudok.member.model.service.MemberService;
import com.kh.finalGudok.member.model.vo.Member;
import com.kh.finalGudok.member.model.vo.Tempkey;

//@SessionAttributes("loginUser")
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
			mv.setViewName("home");
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

//	@RequestMapping(value="logout.do", method=RequestMethod.GET)
//	public String logout(SessionStatus status) {
////		session.invalidate();
//		status.setComplete();
//		return "home";
//	}

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
