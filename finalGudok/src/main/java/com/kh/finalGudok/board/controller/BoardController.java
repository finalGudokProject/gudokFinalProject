package com.kh.finalGudok.board.controller;

import static com.kh.finalGudok.board.common.pagination.getPageInfo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalGudok.board.model.exception.BoardException;
import com.kh.finalGudok.board.model.service.BoardService;
import com.kh.finalGudok.board.model.vo.Board;
import com.kh.finalGudok.board.model.vo.bPageInfo;

@Controller
public class BoardController {
	@Autowired
	BoardService bService;
	
	// admin Notice
	// List
	@RequestMapping("adminNoticeList.do")
	public ModelAndView adminNoticeList(ModelAndView mv, 
			@RequestParam(value="page", required=false) Integer page) {	// 기본 자료형으로 받을 수 없기 때문에 Integer를 쓴다
		// 페이징 관련 처리부터 하자
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int listCount = bService.getListCount();
		
		bPageInfo pi = getPageInfo(currentPage, listCount);
		
		// 페이징 처리가 끝나면 게시글을 추려오자
		ArrayList<Board> list = bService.selectList(pi);
//		System.out.println(list);
		if(list != null) {
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("admin/adminNoticeList");
		}else {
			throw new BoardException("게시글 전체 조회 실패!");
		}
		
		return mv;
	}
	
	// Insert
	@RequestMapping("adminNoticeInsert")
	public String adminNoticeInsert(){
		return "admin/adminNoticeInsert";
	}
	
	@RequestMapping("aNoticeInsert")
	public String aNoticeInsert(HttpServletRequest request, Board b,
			@RequestParam(value="uploadFile", required=false) MultipartFile file) { // 다중 업로드 파일은 List<MultipartFile> file 이용 찾아서 해봐		
		// NoticeController에 있는 saveFile 메소드 가져오고 buploadFiles폴더로 수정하자
		// 그리고 이번엔 날짜를 활용한 rename을 적용해 보자
		
		if(!file.getOriginalFilename().equals("")) {
			
			String renameFileName=saveFile(file,request);
		      String root=request.getSession().getServletContext().getRealPath("resources");
		      String savePath=root+"\\aNoticeUploadFiles";
		      
		      b.setOriginalFileName(file.getOriginalFilename());
		      b.setRenameFileName(renameFileName);
		      b.setImagePath(savePath);

		}
		
		int result1 = bService.insertNotice(b);
		int result2 = bService.insertNoticeImg(b);
		
		if((result1>0&& result2<0) || (result1>0 && result2>0)) {
			return "redirect:adminNoticeList.do";
		}else {
			throw new BoardException("게시글 등록 실패!");
		}
	}
	
	// 파일이 저장 될 경로를 설정하는 메소드
		private String saveFile(MultipartFile file, HttpServletRequest request) {
			
			String root = request.getSession().getServletContext().getRealPath("resources");
			// request.getSession().getServletContext() -> webapp경로
			// getRealPath -> File: 빼고나오는 경로
			
			String savePath = root + "\\aNoticeUploadFiles";
			// 폴더가 없으면 만들면 되고 폴더가 없으면 이렇게 파일 이름을 써서 만든다
			
			File folder = new File(savePath);
			
			if(!folder.exists()) {	// webapp아래에 있는 resources 폴더 아래에
									// nuloadFiles가 없어서 File객체를 찾을 수 없다면
				folder.mkdirs();	// 폴더를 만들어라
				
			}
			
			// 공지글은 파일명 중복 제거는 신경쓰지 않고 했지만
			// 게시판에서는 파일명을 날짜(업로드 시간)로 rename 해보자
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String originFileName = file.getOriginalFilename();
			String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()))
					+ "." + originFileName.substring(originFileName.lastIndexOf(".")+1);
			
			
			String filePath = folder + "\\" + renameFileName;
			// 실제 저장 될 파일의 경로 + rename파일명	
			
			try {
				file.transferTo(new File(filePath));
				// 이 상태로는 파일 업로드가 되지 않는다.
				// 왜냐면 파일 제한크기에 대한 설정을 주지 않았기 때문이다.
				// root-context.xml에 업로드 제한 파일 크기를 지정해 주자.
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return renameFileName;
		}
		
	// Detail
	@RequestMapping("adminNoticeDetail.do")
	public ModelAndView adminNoticeDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;
		
		int result = bService.addReadCount(bBoard_no); // 조회수가 증가 되어야만 게시물 상세보기가 가능하다
		
		if (result > 0) {
			Board board = bService.selectAdminNoticeDetail(bBoard_no);
			if(board != null) {
				mv.addObject("board", board).addObject("currentPage",currentPage).setViewName("admin/adminNoticeDetail");
			}else {
				throw new BoardException("게시글 조회 실패");
			}			
		}else {
			throw new BoardException("게시글 조회수 증가 실패!");
		}		
		return mv;
	}
	
	
	
		
	// UpDate
	
	@RequestMapping("aNoticeUpdateView.do")
	public ModelAndView boardUpdateView(ModelAndView mv, Integer bBoard_no,
										@RequestParam("page") Integer page) {
		Board board = bService.selectAdminNoticeDetail(bBoard_no);
		System.out.println(board);
		mv.addObject("board", board).addObject("currentPage", page).setViewName("admin/adminNoticeUpdate");

		return mv;
	}
	
	@RequestMapping(value="aNoticeUpdate", method=RequestMethod.POST)
	public ModelAndView adminNoticeUpdate(ModelAndView mv, Board b, 
											HttpServletRequest request,
											@RequestParam("page") Integer page,
											@RequestParam(value="uploadFile", required=false)
											MultipartFile file) {

			if(!file.getOriginalFilename().equals("")) {	// 원래 파일명이 존재하면
				if(b.getRenameFileName() != null) {			// 바뀐이름이 존재하면
				deleteFile(b.getRenameFileName(), request);	// 바뀐이름 삭제
				}
				String renameFileName = saveFile(file, request);
			
			
			b.setOriginalFileName(file.getOriginalFilename());
			b.setRenameFileName(renameFileName);
			} 
			String root=request.getSession().getServletContext().getRealPath("resources");
			String savePath=root+"\\aNoticeUploadFiles";
			b.setImagePath(savePath);
			

			int result1 = bService.updateAdminNoticeUpdateImg(b);
			int result2 = bService.updateAdminNoticeUpdate(b);
			
			if(result1>0 || result2>0) { 
			mv.addObject("page",page).setViewName("redirect:adminNoticeList.do");
			}else {
			throw new BoardException("게시글 수정 실패!!");
			}
			
			return mv;
		
	}
	
	
	// Delete
	
	private void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\aNoticeUploadFiles";
		
		File f = new File(savePath + "\\" + fileName);
		if(f.exists()) {
			f.delete();
		}
	}
	
	@RequestMapping("adminNoticeDelete.do")
	public String boardDelete(Integer bBoard_no, HttpServletRequest request) {
		System.out.println(bBoard_no);
		Board b = bService.selectAdminNoticeDetail(bBoard_no);
		System.out.println(b);
		if(b.getOriginalFileName() != null) {
			deleteFile(b.getRenameFileName(), request);
		}
		
		// 게시글 삭제하기
		int result1 = bService.deleteAdminNoticeImage(bBoard_no);
		int result2 = bService.deleteAdminNoticeBoardImg(bBoard_no);
		int result3 = bService.deleteAdminNoticeBoard(bBoard_no);
		
		if(result1 > 0 && result2 > 0 && result3 > 0) {
			return "redirect:adminNoticeList.do";
		}else {
			throw new BoardException("게시물 삭제 실패!");
		}
	}
	
	
		

	

	// serviceCenter
	
	// etc
	@RequestMapping("tierOfBenefit")
	public String tierOfBenefit(){
		return "serviceCenter/tierOfBenefit";
	}
	@RequestMapping("termsOfService")
	public String termsOfService(){
		return "event/termsOfService";
	}
	@RequestMapping("privacyPolicy")
	public String privacyPolicy(){
		return "event/privacyPolicy";
	}

	// Notice
	// List
	@RequestMapping("noticeList.do")
	public ModelAndView noticeList(ModelAndView mv, 
			@RequestParam(value="page", required=false) Integer page) {	// 기본 자료형으로 받을 수 없기 때문에 Integer를 쓴다
		// 페이징 관련 처리부터 하자
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int listCount = bService.getListCount();
		
		bPageInfo pi = getPageInfo(currentPage, listCount);
		
		// 페이징 처리가 끝나면 게시글을 추려오자
		ArrayList<Board> list = bService.selectList(pi);
//		System.out.println(list);
		if(list != null) {
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("serviceCenter/noticeList");
		}else {
			throw new BoardException("게시글 전체 조회 실패!");
		}
		
		return mv;
	}
	
	
	// Detail
	@RequestMapping("noticeDetail.do")
	public ModelAndView noticeDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;
		
		int result = bService.addReadCount(bBoard_no); // 조회수가 증가 되어야만 게시물 상세보기가 가능하다
		
		if (result > 0) {
			Board board = bService.selectNoticeDetail(bBoard_no);
			if(board != null) {
				mv.addObject("board", board).addObject("currentPage",currentPage).setViewName("serviceCenter/noticeDetail");
			}else {
				throw new BoardException("게시글 조회 실패");
			}			
		}else {
			throw new BoardException("게시글 조회수 증가 실패!");
		}		
		return mv;
	}
	
	

}
