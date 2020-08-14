package com.kh.finalGudok.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalGudok.member.model.exception.MemberException;
import com.kh.finalGudok.member.model.service.MemberService;
import com.kh.finalGudok.member.model.vo.Member;

//@SessionAttributes("loginUser")
@Controller
public class MemberController {

	@Autowired
	private MemberService mService;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@RequestMapping("moveToLogin.do")
	public String moveTologin() {
		return "member/login";
	}

	@RequestMapping("moveToSignUp.do")
	public String moveTosignUp() {
		return "member/signUp";
	}

	@RequestMapping("find.do")
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
	
	@RequestMapping("signUp.do")
	public String signUp(Member m) {
		
		// web.xml에 한글 깨짐 방지를 위해 필터 등록
		// bCrypt로 암호화 처리 -> 관련 라이브러리 추가, xml만들어서 bean 설정
		// @Autowired 선언
		String encPwd = bcryptPasswordEncoder.encode(m.getMemberPwd());
//		System.out.println(encPwd);
		
		// setter를 통해 암호화 된 비밀번호로 교체
		m.setMemberPwd(encPwd);
		
		int result = mService.insertMember(m);
		
		if(result > 0) {
			return "home";
		}else {
			throw new MemberException("회원가입 실패!");
		}
		
	}
	
//	@RequestMapping("dupid.do")
//	public void idDuplicateCheck(HttpServlet response, String id) throws IOException{
//		boolean isUsable = mService.checkIdDup(id) == 0? true : false;
//		
//		PrintWriter pw = response.getWriter();
//		pw.print(isUsable);
//		pw.flush();
//		pw.close();
//	}

}
