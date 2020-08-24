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
import com.kh.finalGudok.board.model.vo.Inquiry;
import com.kh.finalGudok.board.model.vo.bPageInfo;
import com.kh.finalGudok.board.model.vo.secret;

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
		
		int listCount = bService.getListCountNotice();
		
		bPageInfo pi = getPageInfo(currentPage, listCount);
		
		// 페이징 처리가 끝나면 게시글을 추려오자
		ArrayList<Board> list = bService.selectListNotice(pi);
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
	@RequestMapping("adminNoticeInsert.do")
	public String adminNoticeInsert(){
		return "admin/adminNoticeInsert";
	}
	
	@RequestMapping("noticeInsert.do")
	public String noticeInsert(HttpServletRequest request, Board b,
			@RequestParam(value="uploadNotice", required=false) MultipartFile file) { // 다중 업로드 파일은 List<MultipartFile> file 이용 찾아서 해봐		
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
		int result2 = bService.insertImage(b);
		
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
			Board board = bService.selectIDetail(bBoard_no);
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
	
	@RequestMapping("adminNoticeUpdate.do")
	public ModelAndView adminFAQUpdate(ModelAndView mv, Integer bBoard_no,
										@RequestParam("page") Integer page) {
		Board board = bService.selectIDetail(bBoard_no);
		System.out.println(board);
		mv.addObject("board", board).addObject("currentPage", page).setViewName("admin/adminNoticeUpdate");

		return mv;
	}
	
	@RequestMapping(value="noticeUpdate.do", method=RequestMethod.POST)
	public ModelAndView noticeUpdate(ModelAndView mv, Board b, 
											HttpServletRequest request,
											@RequestParam("page") Integer page,
											@RequestParam(value="uploadNotice", required=false)
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
			

			int result1 = bService.updateImage(b);
			int result2 = bService.updateBoard(b);
			
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
	
	@RequestMapping("noticeDelete.do")
	public String noticeDelete(Integer bBoard_no, HttpServletRequest request) {
		System.out.println(bBoard_no);
		Board b = bService.selectIDetail(bBoard_no);
		System.out.println(b);
		if(b.getOriginalFileName() != null) {
			deleteFile(b.getRenameFileName(), request);
		}
		
		// 게시글 삭제하기
		int result1 = bService.deleteImage(bBoard_no);
		int result2 = bService.deleteBoardImage(bBoard_no);
		int result3 = bService.deleteBoard(bBoard_no);
		
		if(result1 > 0 && result2 > 0 && result3 > 0) {
			return "redirect:adminNoticeList.do";
		}else {
			throw new BoardException("게시물 삭제 실패!");
		}
	}
	
	
	//------------------------------------------------------------------------------------
	
	// FAQ
	
	// 리스트 출력
	@RequestMapping("adminFAQList.do")
		public ModelAndView adminFAQList(ModelAndView mv, 
		@RequestParam(value="page", required=false) Integer page) {	// 기본 자료형으로 받을 수 없기 때문에 Integer를 쓴다

		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
			
		int listCount = bService.getListCountFAQ();
			
		bPageInfo pi = getPageInfo(currentPage, listCount);
			

		ArrayList<Board> list = bService.selectListFAQ(pi);

			if(list != null) {
				mv.addObject("list",list);
				mv.addObject("pi",pi);
				mv.setViewName("admin/adminFAQList");
			}else {
				throw new BoardException("게시글 전체 조회 실패!");
			}
			
			return mv;
		}

	// Insert
	@RequestMapping("adminFAQInsert.do")
		public String adminFAQInsert(){
		return "admin/adminFAQInsert";
			}
		
	@RequestMapping("insertFAQ.do")
	public String insertFAQ(HttpServletRequest request, Board b) { 

			int result = bService.insertFAQ(b);

			if(result > 0) {
				return "redirect:adminFAQList.do";
			}else {
				throw new BoardException("게시글 등록 실패!");
			}
		}
	
	// Detail
	@RequestMapping("adminFAQDetail.do")
	public ModelAndView adminFAQDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;
		
		int result = bService.addReadCount(bBoard_no); // 조회수가 증가 되어야만 게시물 상세보기가 가능하다
		
		if (result > 0) {
			Board board = bService.selectDetail (bBoard_no);
			if(board != null) {
				mv.addObject("board", board).addObject("currentPage",currentPage).setViewName("admin/adminFAQDetail");
			}else {
				throw new BoardException("게시글 조회 실패");
			}			
		}else {
			throw new BoardException("게시글 조회수 증가 실패!");
		}		
		return mv;
	}
	
	// Update
	@RequestMapping("adminFAQUpdate.do")
	public ModelAndView FAQUpdateView(ModelAndView mv, Integer bBoard_no,
										@RequestParam("page") Integer page) {
		Board board = bService.selectDetail (bBoard_no);
		mv.addObject("board", board).addObject("currentPage", page).setViewName("admin/adminFAQUpdate");

		return mv;
	}
	
	@RequestMapping(value="FAQUpdate.do", method=RequestMethod.POST)
	public ModelAndView FAQUpdate(ModelAndView mv, Board b, @RequestParam("page") Integer page) {

			int result = bService.updateBoard(b);
			
			if(result > 0) { 
			mv.addObject("page",page).setViewName("redirect:adminFAQList.do");
			}else {
			throw new BoardException("게시글 수정 실패!!");
			}
			
			return mv;
		
	}
	
	
	// Delete
	@RequestMapping("FAQDelete.do")
	public String FAQDelete(Integer bBoard_no, HttpServletRequest request) {
		
		int result = bService.deleteBoard(bBoard_no);
		
		if(result > 0) {
			return "redirect:adminFAQList.do";
		}else {
			throw new BoardException("게시물 삭제 실패!");
		}
	}
		
	
	//-------------------------------------------------------------------
	
	// adminProductProposal 
	//List
	@RequestMapping("adminProductProposalList.do")
	public ModelAndView adminProductProposalList(ModelAndView mv, 
			@RequestParam(value="page", required=false) Integer page) {	// 기본 자료형으로 받을 수 없기 때문에 Integer를 쓴다
		// 페이징 관련 처리부터 하자
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int listCount = bService.getListCountProductProposal();
		
		bPageInfo pi = getPageInfo(currentPage, listCount);
		

		ArrayList<Board> list = bService.selectListProductProposal(pi);

		if(list != null) {
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("admin/adminProductProposalList");
		}else {
			throw new BoardException("게시글 전체 조회 실패!");
		}
		
		return mv;
	}
		
	// Detail
	@RequestMapping("adminProductProposalDetail.do")
	public ModelAndView adminProductProposalDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;
		
		int result = bService.addReadCount(bBoard_no); // 조회수가 증가 되어야만 게시물 상세보기가 가능하다
		
		if (result > 0) {
			Board board = bService.selectIDetail (bBoard_no);
			if(board != null) {
				mv.addObject("board", board).addObject("currentPage",currentPage).setViewName("admin/adminProductProposalDetail");
			}else {
				throw new BoardException("게시글 조회 실패");
			}			
		}else {
			throw new BoardException("게시글 조회수 증가 실패!");
		}		
		return mv;
	}
	
	// Delete
			
			@RequestMapping("aProposalDelete.do")
			public String aPoposalDelete(Integer bBoard_no, HttpServletRequest request) {
				System.out.println(bBoard_no);
				Board b = bService.selectIDetail(bBoard_no);
				System.out.println(b);
				if(b.getOriginalFileName() != null) {
					PdeleteFile(b.getRenameFileName(), request);
				}
				
				// 게시글 삭제하기
				int result1 = bService.deleteImage(bBoard_no);
				int result2 = bService.deleteBoardImage(bBoard_no);
				int result3 = bService.deleteBoard(bBoard_no);
				
				if(result1 > 0 && result2 > 0 && result3 > 0) {
					return "redirect:adminProductProposalList.do";
				}else {
					throw new BoardException("게시물 삭제 실패!");
				}
			}
	
	
	//-----------------------------------------------
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

	
	// Notice List
	@RequestMapping("noticeList.do")
	public ModelAndView noticeList(ModelAndView mv, 
			@RequestParam(value="page", required=false) Integer page) {	// 기본 자료형으로 받을 수 없기 때문에 Integer를 쓴다
		// 페이징 관련 처리부터 하자
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int listCount = bService.getListCountNotice();
		
		bPageInfo pi = getPageInfo(currentPage, listCount);
		

		ArrayList<Board> list = bService.selectListNotice(pi);

		if(list != null) {
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("serviceCenter/noticeList");
		}else {
			throw new BoardException("게시글 전체 조회 실패!");
		}
		
		return mv;
	}
	
	
	// Notice Detail
	@RequestMapping("noticeDetail.do")
	public ModelAndView noticeDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;
		
		int result = bService.addReadCount(bBoard_no); // 조회수가 증가 되어야만 게시물 상세보기가 가능하다
		
		if (result > 0) {
			Board board = bService.selectDetail (bBoard_no);
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
	
	// FAQ List
	@RequestMapping("FAQList.do")
	public ModelAndView FAQList(ModelAndView mv, 
			@RequestParam(value="page", required=false) Integer page) {	// 기본 자료형으로 받을 수 없기 때문에 Integer를 쓴다
		// 페이징 관련 처리부터 하자
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int listCount = bService.getListCountFAQ();
		
		bPageInfo pi = getPageInfo(currentPage, listCount);
		

		ArrayList<Board> list = bService.selectListFAQ(pi);

		if(list != null) {
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("serviceCenter/FAQList");
		}else {
			throw new BoardException("게시글 전체 조회 실패!");
		}
		
		return mv;
	}
	

	// FAQ Detail
		@RequestMapping("FAQDetail.do")
		public ModelAndView FAQDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
			int currentPage = page;
			
			int result = bService.addReadCount(bBoard_no); // 조회수가 증가 되어야만 게시물 상세보기가 가능하다
			
			if (result > 0) {
				Board board = bService.selectDetail (bBoard_no);
				if(board != null) {
					mv.addObject("board", board).addObject("currentPage",currentPage).setViewName("serviceCenter/FAQDetail");
				}else {
					throw new BoardException("게시글 조회 실패");
				}			
			}else {
				throw new BoardException("게시글 조회수 증가 실패!");
			}		
			return mv;
		}
		
	// productProposal List
		@RequestMapping("productProposalList.do")
		public ModelAndView productProposalList(ModelAndView mv, 
				@RequestParam(value="page", required=false) Integer page) {	// 기본 자료형으로 받을 수 없기 때문에 Integer를 쓴다
			// 페이징 관련 처리부터 하자
			int currentPage = 1;
			if(page != null) {
				currentPage = page;
			}
			
			int listCount = bService.getListCountProductProposal();
			
			bPageInfo pi = getPageInfo(currentPage, listCount);
			

			ArrayList<Board> list = bService.selectListProductProposal(pi);

			if(list != null) {
				mv.addObject("list",list);
				mv.addObject("pi",pi);
				mv.setViewName("serviceCenter/productProposalList");
			}else {
				throw new BoardException("게시글 전체 조회 실패!");
			}
			
			return mv;
		}
		
	// productProposal Detail
		@RequestMapping("ProductProposalDetail")
		public ModelAndView ProductProposalDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
			int currentPage = page;
			
			int result = bService.addReadCount(bBoard_no); // 조회수가 증가 되어야만 게시물 상세보기가 가능하다
			
			if (result > 0) {
				Board board = bService.selectIDetail(bBoard_no);
				if(board != null) {
					mv.addObject("board", board).addObject("currentPage",currentPage).setViewName("serviceCenter/productProposalDetail");
				}else {
					throw new BoardException("게시글 조회 실패");
				}			
			}else {
				throw new BoardException("게시글 조회수 증가 실패!");
			}		
			return mv;
		}
		
	// productProposal Insert
		@RequestMapping("productProposalInsert.do")
		public String productProposalInsert(){
			return "serviceCenter/productProposalInsert";
		}
		
		@RequestMapping("ProductProposalInsert.do")
		public String ProductProposalInsert(HttpServletRequest request, Board b,
				@RequestParam(value="uploadProposal", required=false) MultipartFile file) { 	
			// NoticeController에 있는 saveFile 메소드 가져오고 buploadFiles폴더로 수정하자
			// 그리고 이번엔 날짜를 활용한 rename을 적용해 보자
			System.out.println(file.getOriginalFilename());
			if(!file.getOriginalFilename().equals("")) {
				
				String renameFileName=pSaveFile(file,request);
			      String root=request.getSession().getServletContext().getRealPath("resources");
			      String savePath=root+"\\proposalUploadFiles";
			      
			      b.setOriginalFileName(file.getOriginalFilename());
			      b.setRenameFileName(renameFileName);
			      b.setImagePath(savePath);

			}
			
			int result1 = bService.insertProductProposal(b);
			int result2 = bService.insertImage(b);
			
			if((result1>0&& result2>0) || (result1>0 && result2<0)) {
				return "redirect:productProposalList.do";
			}else {
				throw new BoardException("게시글 등록 실패!");
			}
		}
		
		// 파일이 저장 될 경로를 설정하는 메소드
				private String pSaveFile(MultipartFile file, HttpServletRequest request) {
					
					String root = request.getSession().getServletContext().getRealPath("resources");
					// request.getSession().getServletContext() -> webapp경로
					// getRealPath -> File: 빼고나오는 경로
					
					String savePath = root + "\\proposalUploadFiles";
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
		
		// productProposal Delete
		private void PdeleteFile(String fileName, HttpServletRequest request) {
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\proposalUploadFiles";
			
			File f = new File(savePath + "\\" + fileName);
			if(f.exists()) {
				f.delete();
			}
		}
		
		@RequestMapping("proposalDelete.do")
		public String proposalDelete(Integer bBoard_no, HttpServletRequest request) {
			System.out.println(bBoard_no);
			Board b = bService.selectIDetail(bBoard_no);
			System.out.println(b);
			if(b.getOriginalFileName() != null) {
				PdeleteFile(b.getRenameFileName(), request);
			}
			
			// 게시글 삭제하기
			int result1 = bService.deleteImage(bBoard_no);
			int result2 = bService.deleteBoardImage(bBoard_no);
			int result3 = bService.deleteBoard(bBoard_no);
			
			if(result1 > 0 && result2 > 0 && result3 > 0) {
				return "redirect:productProposalList.do";
			}else {
				throw new BoardException("게시물 삭제 실패!");
			}
		}
		
		// productProposal Update
		@RequestMapping("productProposalUpdate.do")
		public ModelAndView productProposalUpdate(ModelAndView mv, Integer bBoard_no,
											@RequestParam("page") Integer page) {
			Board board = bService.selectIDetail(bBoard_no);
			System.out.println(board);
			mv.addObject("board", board).addObject("currentPage", page).setViewName("serviceCenter/productProposalUpdate");

			return mv;
		}
		
		@RequestMapping(value="proposalUpdate.do", method=RequestMethod.POST)
		public ModelAndView proposalUpdate(ModelAndView mv, Board b, 
												HttpServletRequest request,
												@RequestParam("page") Integer page,
												@RequestParam(value="uploadProposal", required=false)
												MultipartFile file) {

				if(!file.getOriginalFilename().equals("")) {	// 원래 파일명이 존재하면
					if(b.getRenameFileName() != null) {			// 바뀐이름이 존재하면
					deleteFile(b.getRenameFileName(), request);	// 바뀐이름 삭제
					}
					String renameFileName = pSaveFile(file, request);
				
				
				b.setOriginalFileName(file.getOriginalFilename());
				b.setRenameFileName(renameFileName);
				} 
				String root=request.getSession().getServletContext().getRealPath("resources");
				String savePath=root+"\\proposalUploadFiles";
				b.setImagePath(savePath);
				

				int result1 = bService.updateImage(b);
				int result2 = bService.updateBoard(b);
				
				if(result1>0 || result2>0) { 
				mv.addObject("page",page).setViewName("redirect:productProposalList.do");
				}else {
				throw new BoardException("게시글 수정 실패!!");
				}
				
				return mv;
			
		}
		
		// Inquiry List
		@RequestMapping("inquiryList")
		public ModelAndView inquirylList(ModelAndView mv, 
				@RequestParam(value="page", required=false) Integer page) {	// 기본 자료형으로 받을 수 없기 때문에 Integer를 쓴다
			// 페이징 관련 처리부터 하자
			int currentPage = 1;
			if(page != null) {
				currentPage = page;
			}
			
			int listCount = bService.getListCountInquiry();
			
			bPageInfo pi = getPageInfo(currentPage, listCount);
			

			ArrayList<Board> list1 = bService.selectListInquiry1(pi);
			// 비공개, 공개, 답변상태를 표기하기 위한 ArrayList
			ArrayList<secret> list2 = bService.selectListInquiry2(pi);
			ArrayList<Inquiry> list3 = bService.selectListInquiry3(pi);
			System.out.println("list1 : " + list1);
			System.out.println("list2 : " + list2);
			System.out.println("list3 : " + list3);
			
			if(list1 != null && list2 != null && list3 != null) {
				mv.addObject("list1",list1);
				mv.addObject("list2",list2);
				mv.addObject("list3",list3);
				mv.addObject("pi",pi);
				mv.setViewName("serviceCenter/inquiryList");
			}else {
				throw new BoardException("게시글 전체 조회 실패!");
			}
			
			return mv;
		}
		
		// Inquiry Detail
		@RequestMapping("inquiryDetail")
		public ModelAndView inquiryDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
			int currentPage = page;
			
			int result = bService.addReadCount(bBoard_no); // 조회수가 증가 되어야만 게시물 상세보기가 가능하다
			
			if (result > 0) {
				Board board = bService.selectOIDetail1(bBoard_no);
				System.out.println("detail: " + board);
				secret secret = bService.selectOIDetail2(bBoard_no);
				System.out.println("detail: " +secret);
				Inquiry inquiry = bService.selectOIDetail3(bBoard_no);
				System.out.println("detail: " +inquiry);
				if(board != null && secret != null && inquiry != null) {
					mv.addObject("board", board).addObject("secret", secret).addObject("inquiry", inquiry).addObject("currentPage",currentPage).setViewName("serviceCenter/inquiryDetail");
				}else {
					throw new BoardException("게시글 조회 실패");
				}			
			}else {
				throw new BoardException("게시글 조회수 증가 실패!");
			}		
			return mv;
		}
		// Inquiry Insert
		@RequestMapping("inquiryInsert.do")
		public String inquiryInsert(){
			return "serviceCenter/inquiryInsert";
		}
		
		@RequestMapping("oInquiryInsert.do")
		public String inquiryInsert(HttpServletRequest request, Board b, secret s, Inquiry i, 
				@RequestParam("oSecret") String oSecret,
				@RequestParam(value="uploadInquiry", required=false) MultipartFile file) { 	
			// NoticeController에 있는 saveFile 메소드 가져오고 buploadFiles폴더로 수정하자
			// 그리고 이번엔 날짜를 활용한 rename을 적용해 보자
			
			if(!file.getOriginalFilename().equals("")) {
				
				String renameFileName=iSaveFile(file,request);
			      String root=request.getSession().getServletContext().getRealPath("resources");
			      String savePath=root+"\\inquiryUploadFiles";
			      
			      b.setOriginalFileName(file.getOriginalFilename());
			      b.setRenameFileName(renameFileName);
			      b.setImagePath(savePath);

			}
			
			if(oSecret.equals("N")) {
				s.setoSecret("N");
			}else {
				s.setoSecret("Y");
			}
			
			int result1 = bService.insertInquiry1(b);
			int result2 = bService.insertInquiry2(s);
			int result3 = bService.insertInquiry3(i);
			int result4 = bService.insertImage(b);
			
			if((result1>0 && result2>0 && result3>0 && result4>0) || (result1>0 && result2>0 && result3>0 && result4<0)) {
				return "redirect:inquiryList.do";
			}else {
				throw new BoardException("게시글 등록 실패!");
			}
		}
		
		// 파일이 저장 될 경로를 설정하는 메소드
				private String iSaveFile(MultipartFile file, HttpServletRequest request) {
					
					String root = request.getSession().getServletContext().getRealPath("resources");
					// request.getSession().getServletContext() -> webapp경로
					// getRealPath -> File: 빼고나오는 경로
					
					String savePath = root + "\\inquiryUploadFiles";
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
		
		// Inquiry Update
				@RequestMapping("inquiryUpdate.do")
				public ModelAndView inquiryUpdate(ModelAndView mv, Integer bBoard_no,
													@RequestParam("page") Integer page) {
					Board board = bService.selectOIDetail1(bBoard_no);
					secret secret = bService.selectOIDetail2(bBoard_no);
					Inquiry inquiry = bService.selectOIDetail3(bBoard_no);
					System.out.println(board);
					System.out.println(secret);
					System.out.println(inquiry);
					mv.addObject("board", board).addObject("secret", secret).addObject("inquiry", inquiry).addObject("currentPage", page).setViewName("serviceCenter/inquiryUpdate");

					return mv;
				}
				
				@RequestMapping(value="rInquiryUpdate.do", method=RequestMethod.POST)
				public ModelAndView inquiryUpdate(ModelAndView mv, Board b, secret s, Inquiry i,
														@RequestParam("oSecret") String oSecret,
														HttpServletRequest request,
														@RequestParam("page") Integer page,
														@RequestParam(value="uploadInquiry", required=false)
														MultipartFile file) {

						if(!file.getOriginalFilename().equals("")) {	// 원래 파일명이 존재하면
							if(b.getRenameFileName() != null) {			// 바뀐이름이 존재하면
							deleteFile(b.getRenameFileName(), request);	// 바뀐이름 삭제
							}
							String renameFileName = iSaveFile(file, request);
						
						
						b.setOriginalFileName(file.getOriginalFilename());
						b.setRenameFileName(renameFileName);
						} 
						
						String root=request.getSession().getServletContext().getRealPath("resources");
						String savePath=root+"\\inquiryUploadFiles";
						b.setImagePath(savePath);
						
						System.out.println(oSecret);
						
						if(oSecret.equals("N")) {
							s.setoSecret("Y");
						}else {
							s.setoSecret("N");
						}
						
						int result1 = bService.updateImage(b);
						int result2 = bService.updateBoard(b);
						int result3 = bService.updateOneInquiry(s);
						int result4 = bService.updateInquiry(i);
						
						if(result1>0 || result2>0 || result3>0 || result4>0) { 
						mv.addObject("page",page).setViewName("redirect:inquiryList.do");
						}else {
						throw new BoardException("게시글 수정 실패!!");
						}
						
						return mv;
					
				}
		// Inquiry Delete
				private void iDeleteFile(String fileName, HttpServletRequest request) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\inquiryUploadFiles";
					
					File f = new File(savePath + "\\" + fileName);
					if(f.exists()) {
						f.delete();
					}
				}
				
				@RequestMapping("inquiryDelete.do")
				public String inquiryDelete(Integer bBoard_no, HttpServletRequest request) {
					System.out.println(bBoard_no);
					Board b = bService.selectIDetail(bBoard_no);
					System.out.println(b);
					if(b.getOriginalFileName() != null) {
						iDeleteFile(b.getRenameFileName(), request);
					}
					
					// 게시글 삭제하기
					int result1 = bService.deleteImage(bBoard_no);
					int result2 = bService.deleteBoardImage(bBoard_no);
					int result3 = bService.deleteBoard(bBoard_no);
					int result4 = bService.deleteOneInquiryBoard(bBoard_no);
					int result5 = bService.deleteInquiryBoard(bBoard_no);
					
					if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result5 > 0) {
						return "redirect:inquiryList.do";
					}else {
						throw new BoardException("게시물 삭제 실패!");
					}
				}
		
}
