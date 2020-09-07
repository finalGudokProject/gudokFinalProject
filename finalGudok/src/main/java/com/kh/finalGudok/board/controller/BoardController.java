package com.kh.finalGudok.board.controller;

import static com.kh.finalGudok.board.common.pagination.getPageInfo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalGudok.board.model.exception.BoardException;
import com.kh.finalGudok.board.model.service.BoardService;
import com.kh.finalGudok.board.model.vo.Board;
import com.kh.finalGudok.board.model.vo.EventBoard;
import com.kh.finalGudok.board.model.vo.Inquiry;
import com.kh.finalGudok.board.model.vo.Search;
import com.kh.finalGudok.board.model.vo.bPageInfo;
import com.kh.finalGudok.board.model.vo.secret;
import com.kh.finalGudok.item.model.exception.ItemException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class BoardController {
	@Autowired
	BoardService bService;

	// admin Notice
	// List
	@RequestMapping("adminNoticeList.do")
	public ModelAndView adminNoticeList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) { // �⺻
																															// �ڷ�������
																															// ����
																															// ��
																															// ����
																															// ������
																															// Integer��
																															// ����
		// ����¡ ���� ó������ ����
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountNotice();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		// ����¡ ó���� ������ �Խñ��� �߷�����
		ArrayList<Board> list = bService.selectListNotice(pi);
//		System.out.println(list);
		if (list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("admin/adminNoticeList");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// Insert
	@RequestMapping("adminNoticeInsert.do")
	public String adminNoticeInsert() {
		return "admin/adminNoticeInsert";
	}

	@RequestMapping("noticeInsert.do")
	public String noticeInsert(HttpServletRequest request, Board b,
			@RequestParam(value = "uploadNotice", required = false) MultipartFile file) { // ���� ���ε� ������
																							// List<MultipartFile> file
																							// �̿� ã�Ƽ� �غ�
		// NoticeController�� �ִ� saveFile �޼ҵ� �������� buploadFiles������ ��������
		// �׸��� �̹��� ��¥�� Ȱ���� rename�� ������ ����

		if (!file.getOriginalFilename().equals("")) {

			String renameFileName = saveFile(file, request);
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\aNoticeUploadFiles";

			b.setOriginalFileName(file.getOriginalFilename());
			b.setRenameFileName(renameFileName);
			b.setImagePath(savePath);

		}

		int result1 = bService.insertNotice(b);
		int result2 = bService.insertImage(b);

		if ((result1 > 0 && result2 < 0) || (result1 > 0 && result2 > 0)) {
			return "redirect:adminNoticeList.do";
		} else {
			throw new BoardException("�Խñ� ��� ����!");
		}
	}

	// ������ ���� �� ��θ� �����ϴ� �޼ҵ�
	private String saveFile(MultipartFile file, HttpServletRequest request) {

		String root = request.getSession().getServletContext().getRealPath("resources");
		// request.getSession().getServletContext() -> webapp���
		// getRealPath -> File: �������� ���

		String savePath = root + "\\aNoticeUploadFiles";
		// ������ ������ ����� �ǰ� ������ ������ �̷��� ���� �̸��� �Ἥ �����

		File folder = new File(savePath);

		if (!folder.exists()) { // webapp�Ʒ��� �ִ� resources ���� �Ʒ���
								// nuloadFiles�� ��� File��ü�� ã�� �� ���ٸ�
			folder.mkdirs(); // ������ ������

		}

		// �������� ���ϸ� �ߺ� ���Ŵ� �Ű澲�� �ʰ� ������
		// �Խ��ǿ����� ���ϸ��� ��¥(���ε� �ð�)�� rename �غ���

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
				+ originFileName.substring(originFileName.lastIndexOf(".") + 1);

		String filePath = folder + "\\" + renameFileName;
		// ���� ���� �� ������ ��� + rename���ϸ�

		try {
			file.transferTo(new File(filePath));
			// �� ���·δ� ���� ���ε尡 ���� �ʴ´�.
			// �ֳĸ� ���� ����ũ�⿡ ���� ������ ���� �ʾұ� �����̴�.
			// root-context.xml�� ���ε� ���� ���� ũ�⸦ ������ ����.

		} catch (Exception e) {
			e.printStackTrace();
		}

		return renameFileName;
	}

	// Detail
	@RequestMapping("adminNoticeDetail.do")
	public ModelAndView adminNoticeDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;

		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectIDetail(bBoard_no);
			if (board != null) {
				mv.addObject("board", board).addObject("currentPage", currentPage)
						.setViewName("admin/adminNoticeDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}
		return mv;
	}

	// UpDate

	@RequestMapping("adminNoticeUpdate.do")
	public ModelAndView adminFAQUpdate(ModelAndView mv, Integer bBoard_no, @RequestParam("page") Integer page) {
		Board board = bService.selectIDetail(bBoard_no);
		System.out.println(board);
		mv.addObject("board", board).addObject("currentPage", page).setViewName("admin/adminNoticeUpdate");

		return mv;
	}

	@RequestMapping(value = "noticeUpdate.do", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(ModelAndView mv, Board b, HttpServletRequest request,
			@RequestParam("page") Integer page,
			@RequestParam(value = "uploadNotice", required = false) MultipartFile file) {

		if (!file.getOriginalFilename().equals("")) { // ���� ���ϸ��� �����ϸ�
			if (b.getRenameFileName() != null) { // �ٲ��̸��� �����ϸ�
				deleteFile(b.getRenameFileName(), request); // �ٲ��̸� ����
			}
			String renameFileName = saveFile(file, request);

			b.setOriginalFileName(file.getOriginalFilename());
			b.setRenameFileName(renameFileName);
		}
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\aNoticeUploadFiles";
		b.setImagePath(savePath);

		int result1 = bService.updateImage(b);
		int result2 = bService.updateBoard(b);

		if (result1 > 0 || result2 > 0) {
			mv.addObject("page", page).setViewName("redirect:adminNoticeList.do");
		} else {
			throw new BoardException("�Խñ� ���� ����!!");
		}

		return mv;

	}

	// Delete

	private void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\aNoticeUploadFiles";

		File f = new File(savePath + "\\" + fileName);
		if (f.exists()) {
			f.delete();
		}
	}

	@RequestMapping("noticeDelete.do")
	public String noticeDelete(Integer bBoard_no, HttpServletRequest request) {
		System.out.println(bBoard_no);
		Board b = bService.selectIDetail(bBoard_no);
		System.out.println(b);
		if (b.getOriginalFileName() != null) {
			deleteFile(b.getRenameFileName(), request);
		}

		// �Խñ� �����ϱ�
		int result1 = bService.deleteImage(bBoard_no);
		int result2 = bService.deleteBoardImage(bBoard_no);
		int result3 = bService.deleteBoard(bBoard_no);

		if (result1 > 0 && result2 > 0 && result3 > 0) {
			return "redirect:adminNoticeList.do";
		} else {
			throw new BoardException("�Խù� ���� ����!");
		}
	}

	// ���� ����
	@RequestMapping("noticeDeleteCheck.do")
	@ResponseBody
	public String noticeDeleteCheck(HttpServletRequest request, String sendArr) {

		String[] strArr = sendArr.split(",");

		int[] NoticeArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			NoticeArr[i] = Integer.valueOf(strArr[i]);
			System.out.println("���õ� ��:" + strArr[i]);
		}

		int result1 = 0;
		int result2 = 0;
		int result3 = 0;

		for (int k = 0; k < NoticeArr.length; k++) {

			Board b = bService.selectDeleteBoard(NoticeArr[k]);

			if (b.getOriginalFileName() != null) {
				deleteFile(b.getRenameFileName(), request);
			}
			result1 = bService.deleteImage(NoticeArr[k]);
			result2 = bService.deleteBoardImage(NoticeArr[k]);
			result3 = bService.deleteBoard(NoticeArr[k]);
		}

		if (result1 > 0 && result2 > 0 && result3 > 0) {

			return "redirect:adminNoticeList.do";

		} else {
			throw new BoardException("������ ���� ����!");
		}

	}

	// ���� �� �ٲ� �Խ��� ����
	@RequestMapping("noticeListChange.do")
	public void noticeListChange(HttpServletResponse response, Integer page) throws IOException {

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountNotice();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectListNotice(pi);

		System.out.println("���� �� ��� : " + list);

		response.setContentType("application/json;charset=utf-8");

		if (list != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject jList = new JSONObject();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				jList.put("bBoard_no", list.get(i).getbBoard_no());
				jList.put("rownum", list.get(i).getRownum());
				jList.put("bTitle", list.get(i).getbTitle());
				jList.put("bWrite_date", sdf.format(list.get(i).getbWrite_date()));
				jList.put("bRead_num", list.get(i).getbRead_num());

				jarr.add(jList);

			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("adminNoticeList", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new BoardException("���� ��ü ��ȸ ����!");
		}
	}

	// �˻�
	@RequestMapping("searchNoticeList.do")
	public ModelAndView searchNoticeList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam("searchType") String searchType, @RequestParam("keyword") String keyword) {

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		System.out.println(searchType);
		System.out.println(keyword);
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);

		int listCount = bService.getListCountNotice();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectSearchListNotice(pi, search);

		System.out.println(list);
		if (list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.addObject("searchType", searchType);
			mv.addObject("keyword", keyword);
			mv.setViewName("admin/adminNoticeSearch");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// �˻� �� ���� ��ȯ �� ������
	@RequestMapping("noticeSearchListChange.do")
	public void noticeSearchListChange(HttpServletResponse response, Integer page,
			@RequestParam("searchType") String searchType, @RequestParam("keyword") String keyword) throws IOException {

		System.out.println("�˻� �� ��ȯ ������ : " + searchType);
		System.out.println(keyword);

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);

		int listCount = bService.getListCountNotice();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectSearchListNotice(pi, search);

		System.out.println(list);

		response.setContentType("application/json;charset=utf-8");

		if (list != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject jList = new JSONObject();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				jList.put("bBoard_no", list.get(i).getbBoard_no());
				jList.put("rownum", list.get(i).getRownum());
				jList.put("bTitle", list.get(i).getbTitle());
				jList.put("bWrite_date", sdf.format(list.get(i).getbWrite_date()));
				jList.put("bRead_num", list.get(i).getbRead_num());

				jarr.add(jList);

			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("adminNoticeSearch", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new BoardException("���� ��ȸ ����!");
		}
	}

	// ------------------------------------------------------------------------------------

	// FAQ

	// ����Ʈ ���
	@RequestMapping("adminFAQList.do")
	public ModelAndView adminFAQList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) { // �⺻
																														// �ڷ�������
																														// ����
																														// ��
																														// ����
																														// ������
																														// Integer��
																														// ����

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountFAQ();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectListFAQ(pi);

		if (list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("admin/adminFAQList");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// Insert
	@RequestMapping("adminFAQInsert.do")
	public String adminFAQInsert() {
		return "admin/adminFAQInsert";
	}

	@RequestMapping("insertFAQ.do")
	public String insertFAQ(HttpServletRequest request, Board b) {

		int result = bService.insertFAQ(b);

		if (result > 0) {
			return "redirect:adminFAQList.do";
		} else {
			throw new BoardException("�Խñ� ��� ����!");
		}
	}

	// Detail
	@RequestMapping("adminFAQDetail.do")
	public ModelAndView adminFAQDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;

		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectDetail(bBoard_no);
			if (board != null) {
				mv.addObject("board", board).addObject("currentPage", currentPage).setViewName("admin/adminFAQDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}
		return mv;
	}

	// Update
	@RequestMapping("adminFAQUpdate.do")
	public ModelAndView FAQUpdateView(ModelAndView mv, Integer bBoard_no, @RequestParam("page") Integer page) {
		Board board = bService.selectDetail(bBoard_no);
		mv.addObject("board", board).addObject("currentPage", page).setViewName("admin/adminFAQUpdate");

		return mv;
	}

	@RequestMapping(value = "FAQUpdate.do", method = RequestMethod.POST)
	public ModelAndView FAQUpdate(ModelAndView mv, Board b, @RequestParam("page") Integer page) {

		int result = bService.updateBoard(b);

		if (result > 0) {
			mv.addObject("page", page).setViewName("redirect:adminFAQList.do");
		} else {
			throw new BoardException("�Խñ� ���� ����!!");
		}

		return mv;

	}

	// Delete
	@RequestMapping("FAQDelete.do")
	public String FAQDelete(Integer bBoard_no, HttpServletRequest request) {

		int result = bService.deleteBoard(bBoard_no);

		if (result > 0) {
			return "redirect:adminFAQList.do";
		} else {
			throw new BoardException("�Խù� ���� ����!");
		}
	}

	// ���� ����
	@RequestMapping("FAQDeleteCheck.do")
	@ResponseBody
	public String FAQDeleteCheck(HttpServletRequest request, String sendArr) {

		String[] strArr = sendArr.split(",");

		int[] FAQArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			FAQArr[i] = Integer.valueOf(strArr[i]);
			System.out.println("���õ� ��:" + strArr[i]);
		}

		int result = 0;

		for (int k = 0; k < FAQArr.length; k++) {

			Board b = bService.selectDeleteBoard(FAQArr[k]);

			if (b.getOriginalFileName() != null) {
				deleteFile(b.getRenameFileName(), request);
			}
			result = bService.deleteBoard(FAQArr[k]);
		}

		if (result > 0) {

			return "redirect:adminFAQList.do";

		} else {
			throw new BoardException("FAQ�� ���� ����!");
		}

	}

	// ���� �� �ٲ� �Խ��� ����
	@RequestMapping("FAQListChange.do")
	public void FAQListChange(HttpServletResponse response, Integer page) throws IOException {

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountFAQ();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectListFAQ(pi);

		System.out.println("���� �� ��� : " + list);

		response.setContentType("application/json;charset=utf-8");

		if (list != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject jList = new JSONObject();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				jList.put("bBoard_no", list.get(i).getbBoard_no());
				jList.put("rownum", list.get(i).getRownum());
				jList.put("bTitle", list.get(i).getbTitle());
				jList.put("bWrite_date", sdf.format(list.get(i).getbWrite_date()));
				jList.put("bRead_num", list.get(i).getbRead_num());

				jarr.add(jList);

			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("adminFAQList", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new BoardException("FAQ ��ü ��ȸ ����!");
		}
	}

	// �˻�
	@RequestMapping("searchFAQList.do")
	public ModelAndView searchFAQList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam("searchType") String searchType, @RequestParam("keyword") String keyword) {

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		System.out.println(searchType);
		System.out.println(keyword);
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);

		int listCount = bService.getListCountFAQ();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectSearchListFAQ(pi, search);

		System.out.println(list);
		if (list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.addObject("searchType", searchType);
			mv.addObject("keyword", keyword);
			mv.setViewName("admin/adminFAQSearch");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// �˻� �� ���� ��ȯ �� ������
	@RequestMapping("FAQSearchListChange.do")
	public void FAQSearchListChange(HttpServletResponse response, Integer page,
			@RequestParam("searchType") String searchType, @RequestParam("keyword") String keyword) throws IOException {

		System.out.println("�˻� �� ��ȯ ������ : " + searchType);
		System.out.println(keyword);

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);

		int listCount = bService.getListCountFAQ();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectSearchListFAQ(pi, search);

		System.out.println(list);

		response.setContentType("application/json;charset=utf-8");

		if (list != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject jList = new JSONObject();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				jList.put("bBoard_no", list.get(i).getbBoard_no());
				jList.put("rownum", list.get(i).getRownum());
				jList.put("bTitle", list.get(i).getbTitle());
				jList.put("bWrite_date", sdf.format(list.get(i).getbWrite_date()));
				jList.put("bRead_num", list.get(i).getbRead_num());

				jarr.add(jList);

			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("adminFAQSearch", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new BoardException("FAQ ��ȸ ����!");
		}
	}

	// -------------------------------------------------------------------

	// adminProductProposal
	// List
	@RequestMapping("adminProductProposalList.do")
	public ModelAndView adminProductProposalList(ModelAndView mv,
			@RequestParam(value = "page", required = false) Integer page) { // �⺻ �ڷ������� ���� �� ���� ������ Integer�� ����
		// ����¡ ���� ó������ ����
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountProductProposal();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectListProductProposal(pi);

		if (list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("admin/adminProductProposalList");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// Detail
	@RequestMapping("adminProductProposalDetail.do")
	public ModelAndView adminProductProposalDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;

		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectIDetail(bBoard_no);
			if (board != null) {
				mv.addObject("board", board).addObject("currentPage", currentPage)
						.setViewName("admin/adminProductProposalDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}
		return mv;
	}

	// Delete

	@RequestMapping("aProposalDelete.do")
	public String aPoposalDelete(Integer bBoard_no, HttpServletRequest request) {
		System.out.println(bBoard_no);
		Board b = bService.selectIDetail(bBoard_no);
		System.out.println(b);
		if (b.getOriginalFileName() != null) {
			PdeleteFile(b.getRenameFileName(), request);
		}

		// �Խñ� �����ϱ�
		int result1 = bService.deleteImage(bBoard_no);
		int result2 = bService.deleteBoardImage(bBoard_no);
		int result3 = bService.deleteBoard(bBoard_no);

		if (result1 > 0 && result2 > 0 && result3 > 0) {
			return "redirect:adminProductProposalList.do";
		} else {
			throw new BoardException("�Խù� ���� ����!");
		}
	}

	// ���� ����
	@RequestMapping("proposalDeleteCheck.do")
	@ResponseBody
	public String proposalDeleteCheck(HttpServletRequest request, String sendArr) {

		String[] strArr = sendArr.split(",");

		int[] ProposalArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			ProposalArr[i] = Integer.valueOf(strArr[i]);
			System.out.println("���õ� ��:" + strArr[i]);
		}

		int result1 = 0;
		int result2 = 0;
		int result3 = 0;

		for (int k = 0; k < ProposalArr.length; k++) {

			Board b = bService.selectDeleteBoard(ProposalArr[k]);

			if (b.getOriginalFileName() != null) {
				PdeleteFile(b.getRenameFileName(), request);
			}
			result1 = bService.deleteImage(ProposalArr[k]);
			result2 = bService.deleteBoardImage(ProposalArr[k]);
			result3 = bService.deleteBoard(ProposalArr[k]);

		}

		if (result1 > 0 && result2 > 0 && result3 > 0) {

			return "redirect:adminProductProposalList.do";

		} else {
			throw new BoardException("Proposal�� ���� ����!");
		}

	}

	// ���� �� �ٲ� �Խ��� ����
	@RequestMapping("proposalListChange.do")
	public void proposalListChange(HttpServletResponse response, Integer page) throws IOException {

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountProductProposal();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectListProductProposal(pi);

		System.out.println("���� �� ��� : " + list);

		response.setContentType("application/json;charset=utf-8");

		if (list != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject jList = new JSONObject();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				jList.put("bBoard_no", list.get(i).getbBoard_no());
				jList.put("rownum", list.get(i).getRownum());
				jList.put("bTitle", list.get(i).getbTitle());
				jList.put("bMember_id", list.get(i).getbMember_id());
				jList.put("bWrite_date", sdf.format(list.get(i).getbWrite_date()));
				jList.put("bRead_num", list.get(i).getbRead_num());

				jarr.add(jList);

			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("adminProductProposalList", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new BoardException("Proposal ��ü ��ȸ ����!");
		}
	}

	// �˻�
	@RequestMapping("searchProposalList.do")
	public ModelAndView searchProposalList(ModelAndView mv,
			@RequestParam(value = "page", required = false) Integer page, @RequestParam("searchType") String searchType,
			@RequestParam("keyword") String keyword) {

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		System.out.println(searchType);
		System.out.println(keyword);
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);

		int listCount = bService.getListCountProductProposal();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectSearchListProductProposal(pi, search);

		System.out.println(list);
		if (list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.addObject("searchType", searchType);
			mv.addObject("keyword", keyword);
			mv.setViewName("admin/adminProductProposalSearch");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// �˻� �� ���� ��ȯ �� ������
	@RequestMapping("proposalSearchListChange.do")
	public void proposalSearchListChange(HttpServletResponse response, Integer page,
			@RequestParam("searchType") String searchType, @RequestParam("keyword") String keyword) throws IOException {

		System.out.println("�˻� �� ��ȯ ������ : " + searchType);
		System.out.println(keyword);

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);

		int listCount = bService.getListCountProductProposal();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectSearchListProductProposal(pi, search);

		System.out.println(list);

		response.setContentType("application/json;charset=utf-8");

		if (list != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject jList = new JSONObject();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				jList.put("bBoard_no", list.get(i).getbBoard_no());
				jList.put("rownum", list.get(i).getRownum());
				jList.put("bTitle", list.get(i).getbTitle());
				jList.put("bMember_id", list.get(i).getbMember_id());
				jList.put("bWrite_date", sdf.format(list.get(i).getbWrite_date()));
				jList.put("bRead_num", list.get(i).getbRead_num());

				jarr.add(jList);

			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("adminProductProposalSearch", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new BoardException("Proposal ��ȸ ����!");
		}
	}

	// -----------------------------------------------
	// admin Inquiry List
	@RequestMapping("adminInquiryList")
	public ModelAndView adminInquiryList(ModelAndView mv,
			@RequestParam(value = "page", required = false) Integer page) { // �⺻ �ڷ������� ���� �� ���� ������ Integer�� ����
		// ����¡ ���� ó������ ����
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountInquiry();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list1 = bService.selectListInquiry1(pi);
		// �����, ����, �亯���¸� ǥ���ϱ� ���� ArrayList
		ArrayList<secret> list2 = bService.selectListInquiry2(pi);
		ArrayList<Inquiry> list3 = bService.selectListInquiry3(pi);
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println("list3 : " + list3);

		if (list1 != null && list2 != null && list3 != null) {
			mv.addObject("list1", list1);
			mv.addObject("list2", list2);
			mv.addObject("list3", list3);
			mv.addObject("pi", pi);
			mv.setViewName("admin/adminInquiryList");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// Detail
	@RequestMapping("adminInquiryDetail")
	public ModelAndView adminInquiryDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;

		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectOIDetail1(bBoard_no);
			System.out.println("detail: " + board);
			secret secret = bService.selectOIDetail2(bBoard_no);
			System.out.println("detail: " + secret);
			Inquiry inquiry = bService.selectOIDetail3(bBoard_no);
			System.out.println("detail: " + inquiry);
			if (board != null && secret != null && inquiry != null) {
				mv.addObject("board", board).addObject("secret", secret).addObject("inquiry", inquiry)
						.addObject("currentPage", currentPage).setViewName("admin/adminInquiryDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}
		return mv;
	}

	// Insert(Update)
	@RequestMapping("adminInquiryUpdate.do")
	public ModelAndView adminInquiryUpdate(ModelAndView mv, Integer bBoard_no, @RequestParam("page") Integer page) {
		Board board = bService.selectOIDetail1(bBoard_no);
		secret secret = bService.selectOIDetail2(bBoard_no);
		Inquiry inquiry = bService.selectOIDetail3(bBoard_no);
		System.out.println(board);
		System.out.println(secret);
		System.out.println(inquiry);
		mv.addObject("board", board).addObject("secret", secret).addObject("inquiry", inquiry)
				.addObject("currentPage", page).setViewName("admin/adminInquiryUpdate");

		return mv;
	}

	@RequestMapping("aInquiryUpdate.do")
	public String aInquiryUpdate(HttpServletRequest request, Inquiry i) {

		int result = bService.updateInquiryAnswer1(i);

		if (result > 0) {
			return "redirect:adminInquiryList.do";
		} else {
			throw new BoardException("�Խñ� ��� ����!");
		}
	}

	// Delete
	@RequestMapping("adminInquiryDelete.do")
	public String adminInquiryDelete(Integer bBoard_no, HttpServletRequest request) {
		System.out.println(bBoard_no);
		Board b = bService.selectIDetail(bBoard_no);
		System.out.println(b);
		if (b.getOriginalFileName() != null) {
			iDeleteFile(b.getRenameFileName(), request);
		}

		// �Խñ� �����ϱ�
		int result1 = bService.deleteImage(bBoard_no);
		int result2 = bService.deleteBoardImage(bBoard_no);
		int result3 = bService.deleteBoard(bBoard_no);
		int result4 = bService.deleteOneInquiryBoard(bBoard_no);
		int result5 = bService.deleteInquiryBoard(bBoard_no);

		if (result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result5 > 0) {
			return "redirect:adminInquiryList.do";
		} else {
			throw new BoardException("�Խù� ���� ����!");
		}
	}

	// ���� ����
	@RequestMapping("inquiryDeleteCheck.do")
	@ResponseBody
	public String inquiryDeleteCheck(HttpServletRequest request, String sendArr) {

		String[] strArr = sendArr.split(",");

		int[] InquriyArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			InquriyArr[i] = Integer.valueOf(strArr[i]);
			System.out.println("���õ� ��:" + strArr[i]);
		}

		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		int result5 = 0;

		for (int k = 0; k < InquriyArr.length; k++) {

			Board b = bService.selectDeleteBoard(InquriyArr[k]);

			if (b.getOriginalFileName() != null) {
				iDeleteFile(b.getRenameFileName(), request);
			}
			result1 = bService.deleteImage(InquriyArr[k]);
			result2 = bService.deleteBoardImage(InquriyArr[k]);
			result3 = bService.deleteBoard(InquriyArr[k]);
			result4 = bService.deleteOneInquiryBoard(InquriyArr[k]);
			result5 = bService.deleteInquiryBoard(InquriyArr[k]);

		}

		if (result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result5 > 0) {

			return "redirect:adminInquiryList.do";

		} else {
			throw new BoardException("���Ǳ� ���� ����!");
		}

	}

	// ���� �� �ٲ� �Խ��� ����
	@RequestMapping("inquiryListChange.do")
	public void inquiryListChange(HttpServletResponse response, Integer page) throws IOException {

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountInquiry();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list1 = bService.selectListInquiry1(pi);
		ArrayList<secret> list2 = bService.selectListInquiry2(pi);
		ArrayList<Inquiry> list3 = bService.selectListInquiry3(pi);

		System.out.println("���� �� ��� : " + list1);
		System.out.println("���� �� ��� : " + list2);
		System.out.println("���� �� ��� : " + list3);

		response.setContentType("application/json;charset=utf-8");

		if (list1 != null && list2 != null && list3 != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list1.size(); i++) {
				JSONObject jList = new JSONObject();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				jList.put("bBoard_no", list1.get(i).getbBoard_no());
				jList.put("rownum", list1.get(i).getRownum());
				jList.put("oSecret", list2.get(i).getoSecret());
				jList.put("bTitle", list1.get(i).getbTitle());
				jList.put("bMember_id", list1.get(i).getbMember_id());
				jList.put("bWrite_date", sdf.format(list1.get(i).getbWrite_date()));
				jList.put("iInquiry_yn", list3.get(i).getiInquiry_yn());

				jarr.add(jList);

			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("adminInquiryList", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new BoardException("���� ��ü ��ȸ ����!");
		}
	}

	// �˻�
	@RequestMapping("searchInquiryList.do")
	public ModelAndView searchInquiryList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam("searchType") String searchType, @RequestParam("keyword") String keyword,
			@RequestParam("inquiry_yn") String inquiry_yn) {

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		System.out.println(searchType);
		System.out.println(keyword);
		System.out.println(inquiry_yn);
		Search search = new Search();
		search.setSearchType(searchType);
		search.setInquiry_yn(inquiry_yn);
		search.setKeyword(keyword);

		System.out.println(search);

		int listCount = bService.getListCountInquiry();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list1 = bService.selectSearchListInquiry1(pi, search);
		ArrayList<secret> list2 = bService.selectSearchListInquiry2(pi, search);
		ArrayList<Inquiry> list3 = bService.selectSearchListInquiry3(pi, search);

		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		if (list1 != null && list2 != null && list3 != null) {
			mv.addObject("list1", list1);
			mv.addObject("list2", list2);
			mv.addObject("list3", list3);
			mv.addObject("pi", pi);
			mv.addObject("searchType", searchType);
			mv.addObject("keyword", keyword);
			mv.addObject("inquiry_yn", inquiry_yn);
			mv.setViewName("admin/adminInquirySearch");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// �˻� �� ���� ��ȯ �� ������
	@RequestMapping("inquirySearchListChange.do")
	public void inquirySearchListChange(HttpServletResponse response, Integer page,
			@RequestParam("searchType") String searchType, @RequestParam("keyword") String keyword,
			@RequestParam("inquiry_yn") String inquiry_yn) throws IOException {

		System.out.println("�˻� �� ��ȯ ������ : " + searchType);
		System.out.println(keyword);
		System.out.println(inquiry_yn);

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		Search search = new Search();
		search.setSearchType(searchType);
		search.setInquiry_yn(inquiry_yn);
		search.setKeyword(keyword);

		int listCount = bService.getListCountInquiry();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list1 = bService.selectSearchListInquiry1(pi, search);
		ArrayList<secret> list2 = bService.selectSearchListInquiry2(pi, search);
		ArrayList<Inquiry> list3 = bService.selectSearchListInquiry3(pi, search);

		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);

		response.setContentType("application/json;charset=utf-8");

		if (list1 != null && list2 != null && list3 != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list1.size(); i++) {
				JSONObject jList = new JSONObject();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				jList.put("bBoard_no", list1.get(i).getbBoard_no());
				jList.put("rownum", list1.get(i).getRownum());
				jList.put("oSecret", list2.get(i).getoSecret());
				jList.put("bTitle", list1.get(i).getbTitle());
				jList.put("bMember_id", list1.get(i).getbMember_id());
				jList.put("bWrite_date", sdf.format(list1.get(i).getbWrite_date()));
				jList.put("iInquiry_yn", list3.get(i).getiInquiry_yn());

				jarr.add(jList);

			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("adminInquirySearch", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new BoardException("���� ��ȸ ����!");
		}
	}

	// -------------------------------------------------
	// admin Event
	// List
	@RequestMapping("adminEventList.do")
	public ModelAndView adminEventDetail(ModelAndView mv,
			@RequestParam(value = "page", required = false) Integer page) { // �⺻ �ڷ������� ���� �� ���� ������ Integer�� ����
		// ����¡ ���� ó������ ����
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountEvent();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		// ����¡ ó���� ������ �Խñ��� �߷�����
		ArrayList<Board> list1 = bService.selectListEvent1(pi);
		// �Խÿ��θ� ���� ArrayList
		ArrayList<EventBoard> list2 = bService.selectListEvent2(pi);
		System.out.println(list1);
		System.out.println(list2);
		if (list1 != null && list2 != null) {
			mv.addObject("list1", list1);
			mv.addObject("list2", list2);
			mv.addObject("pi", pi);
			mv.setViewName("admin/adminEventList");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// Detail
	@RequestMapping("adminEventDetail")
	public ModelAndView adminEventDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;

		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectIDetail(bBoard_no);
			System.out.println("detail: " + board);
			EventBoard eventBoard = bService.selectEDetail(bBoard_no);
			System.out.println("detail: " + eventBoard);
			if (board != null && eventBoard != null) {
				mv.addObject("board", board).addObject("eventBoard", eventBoard).addObject("currentPage", currentPage)
						.setViewName("admin/adminEventDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}
		return mv;
	}

	// Insert
	@RequestMapping("adminEventInsert.do")
	public String adminEventInsert() {
		return "admin/adminEventInsert";
	}

	@RequestMapping("eventInsert.do")
	public String eventInsert(HttpServletRequest request, Board b, EventBoard e,
			@RequestParam(value = "uploadEvent", required = false) MultipartFile file) { // ���� ���ε� ������
																							// List<MultipartFile> file
																							// �̿� ã�Ƽ� �غ�
		// NoticeController�� �ִ� saveFile �޼ҵ� �������� buploadFiles������ ��������
		// �׸��� �̹��� ��¥�� Ȱ���� rename�� ������ ����

		if (!file.getOriginalFilename().equals("")) {

			String renameFileName = eSaveFile(file, request);
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\eventUploadFiles";

			b.setOriginalFileName(file.getOriginalFilename());
			b.setRenameFileName(renameFileName);
			b.setImagePath(savePath);

		}

		int result1 = bService.insertEvent1(b);
		int result2 = bService.insertEvent2(e);
		int result3 = bService.insertImage(b);

		if ((result1 > 0 && result2 > 0 && result3 < 0) || (result1 > 0 && result2 > 0 && result3 > 0)) {
			return "redirect:adminEventList.do";
		} else {
			throw new BoardException("�Խñ� ��� ����!");
		}
	}

	// ������ ���� �� ��θ� �����ϴ� �޼ҵ�
	private String eSaveFile(MultipartFile file, HttpServletRequest request) {

		String root = request.getSession().getServletContext().getRealPath("resources");
		// request.getSession().getServletContext() -> webapp���
		// getRealPath -> File: �������� ���

		String savePath = root + "\\eventUploadFiles";
		// ������ ������ ����� �ǰ� ������ ������ �̷��� ���� �̸��� �Ἥ �����

		File folder = new File(savePath);

		if (!folder.exists()) { // webapp�Ʒ��� �ִ� resources ���� �Ʒ���
								// nuloadFiles�� ��� File��ü�� ã�� �� ���ٸ�
			folder.mkdirs(); // ������ ������

		}

		// �������� ���ϸ� �ߺ� ���Ŵ� �Ű澲�� �ʰ� ������
		// �Խ��ǿ����� ���ϸ��� ��¥(���ε� �ð�)�� rename �غ���

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
				+ originFileName.substring(originFileName.lastIndexOf(".") + 1);

		String filePath = folder + "\\" + renameFileName;
		// ���� ���� �� ������ ��� + rename���ϸ�

		try {
			file.transferTo(new File(filePath));
			// �� ���·δ� ���� ���ε尡 ���� �ʴ´�.
			// �ֳĸ� ���� ����ũ�⿡ ���� ������ ���� �ʾұ� �����̴�.
			// root-context.xml�� ���ε� ���� ���� ũ�⸦ ������ ����.

		} catch (Exception e) {
			e.printStackTrace();
		}

		return renameFileName;
	}

	// Update
	@RequestMapping("adminEventUpdate.do")
	public ModelAndView adminEventUpdate(ModelAndView mv, Integer bBoard_no, @RequestParam("page") Integer page) {
		Board board = bService.selectIDetail(bBoard_no);
		System.out.println(board);
		EventBoard eventBoard = bService.selectEDetail(bBoard_no);
		mv.addObject("board", board).addObject("eventBoard", eventBoard).addObject("currentPage", page)
				.setViewName("admin/adminEventUpdate");

		return mv;
	}

	@RequestMapping(value = "eventUpdate.do", method = RequestMethod.POST)
	public ModelAndView eventUpdate(ModelAndView mv, Board b, HttpServletRequest request,
			@RequestParam("page") Integer page,
			@RequestParam(value = "uploadEvent", required = false) MultipartFile file) {

		if (!file.getOriginalFilename().equals("")) { // ���� ���ϸ��� �����ϸ�
			if (b.getRenameFileName() != null) { // �ٲ��̸��� �����ϸ�
				eDeleteFile(b.getRenameFileName(), request); // �ٲ��̸� ����
			}
			String renameFileName = eSaveFile(file, request);

			b.setOriginalFileName(file.getOriginalFilename());
			b.setRenameFileName(renameFileName);
		}
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\eventUploadFiles";
		b.setImagePath(savePath);

		int result1 = bService.updateImage(b);
		int result2 = bService.updateBoard(b);

		if (result1 > 0 || result2 > 0) {
			mv.addObject("page", page).setViewName("redirect:adminEventList.do");
		} else {
			throw new BoardException("�Խñ� ���� ����!!");
		}

		return mv;

	}

	// Delete
	private void eDeleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\eventUploadFiles";

		File f = new File(savePath + "\\" + fileName);
		if (f.exists()) {
			f.delete();
		}
	}

	@RequestMapping("eventDelete.do")
	public String eventDelete(Integer bBoard_no, HttpServletRequest request) {
		System.out.println(bBoard_no);
		Board b = bService.selectIDetail(bBoard_no);
		System.out.println(b);
		if (b.getOriginalFileName() != null) {
			eDeleteFile(b.getRenameFileName(), request);
		}

		// �Խñ� �����ϱ�
		int result1 = bService.deleteEventBoard(bBoard_no);
		int result2 = bService.deleteImage(bBoard_no);
		int result3 = bService.deleteBoardImage(bBoard_no);
		int result4 = bService.deleteBoard(bBoard_no);

		if (result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0) {
			return "redirect:adminEventList.do";
		} else {
			throw new BoardException("�Խù� ���� ����!");
		}
	}

	// ���� ����
	// �Խ�
	@RequestMapping("eventChangeY.do")
	@ResponseBody
	public String updateEventStatusY(String sendArr) {

		System.out.println("y��Ʈ�ѷ���");
		System.out.println(sendArr);

		String[] strArr = sendArr.split(",");
		System.out.println(strArr[0].toString());
		System.out.println(strArr.length);

		ArrayList<EventBoard> EventArr = new ArrayList<>();
		EventBoard e = new EventBoard();

		for (int i = 0; i < strArr.length; i++) {
			e = new EventBoard(Integer.valueOf(strArr[i]));
			EventArr.add(e);

			System.out.println(EventArr.get(i).geteBoard_no());
		}

		System.out.println("EventArr����" + EventArr.size());
		System.out.println("Ȯ���Ұ�" + EventArr.toString());

		int result = 0;

		result = bService.updateEventStatusY(EventArr);

		System.out.println("����� ����" + result);

		if (result > 0) {

			return "success";

		} else {
			throw new BoardException("�̺�Ʈ �Խ� ���� ����!");
		}
	}

	// ����

	@RequestMapping("eventChangeN.do")
	@ResponseBody
	public String updateEventStatusN(String sendArr) {

		System.out.println("n��Ʈ�ѷ���");
		System.out.println(sendArr);

		String[] strArr = sendArr.split(",");
		System.out.println(strArr[0].toString());
		System.out.println(strArr.length);

		ArrayList<EventBoard> EventArr = new ArrayList<>();
		EventBoard e = new EventBoard();

		for (int i = 0; i < strArr.length; i++) {
			e = new EventBoard(Integer.valueOf(strArr[i]));
			EventArr.add(e);

			System.out.println(EventArr.get(i).geteBoard_no());
		}

		System.out.println("EventArr����" + EventArr.size());
		System.out.println("Ȯ���Ұ�" + EventArr.toString());

		int result = 0;

		result = bService.updateEventStatusN(EventArr);

		System.out.println("����� ����" + result);

		if (result > 0) {

			return "success";

		} else {
			throw new BoardException("�̺�Ʈ �Խ� ���� ����!");
		}
	}

	// �Խ�or����or���� �� �ٲ� �Խ��� ����
	@RequestMapping("eventListChange.do")
	public void eventListChange(HttpServletResponse response, Integer page) throws IOException {
		// ����¡ ���� ó������ ����
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountEvent();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		// ����¡ ó���� ������ �Խñ��� �߷�����
		ArrayList<Board> list1 = bService.selectListEvent1(pi);
		// �Խÿ��θ� ���� ArrayList
		ArrayList<EventBoard> list2 = bService.selectListEvent2(pi);
		System.out.println(list1);
		System.out.println(list2);

		response.setContentType("application/json;charset=utf-8");

		if (list1 != null && list2 != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list1.size(); i++) {
				JSONObject jList = new JSONObject();
				jList.put("bBoard_no", list1.get(i).getbBoard_no());
				jList.put("rownum", list1.get(i).getRownum());
				jList.put("bTitle", list1.get(i).getbTitle());
				jList.put("bRead_num", list1.get(i).getbRead_num());
				jList.put("eE_status", list2.get(i).geteE_status());

				jarr.add(jList);

			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("adminEventList", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new ItemException("�̺�Ʈ ��ü ��ȸ ����!");
		}
	}

	// ���� ����
	@RequestMapping("eventDeleteCheck.do")
	@ResponseBody
	public String eventDeleteCheck(HttpServletRequest request, String sendArr) {

		String[] strArr = sendArr.split(",");

		int[] dEventArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			dEventArr[i] = Integer.valueOf(strArr[i]);
			System.out.println("���õ� ��:" + strArr[i]);
		}

		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;

		for (int k = 0; k < dEventArr.length; k++) {

			Board b = bService.selectDeleteBoard(dEventArr[k]);

			if (b.getOriginalFileName() != null) {
				eDeleteFile(b.getRenameFileName(), request);
			}

			result1 = bService.deleteEventBoard(dEventArr[k]);
			result2 = bService.deleteImage(dEventArr[k]);
			result3 = bService.deleteBoardImage(dEventArr[k]);
			result4 = bService.deleteBoard(dEventArr[k]);
		}

		if (result1 > 0 && result3 > 0 && result4 > 0) {

			return "redirect:adminEventList.do";

		} else {
			throw new BoardException("�̺�Ʈ ���� ����!");
		}

	}

	// �˻�
	@RequestMapping("adminEventSearch.do")
	public ModelAndView searchEventList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam("post_yn") String post_yn, @RequestParam("searchType") String searchType,
			@RequestParam("keyword") String keyword) {

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		System.out.println(post_yn);
		System.out.println(searchType);
		System.out.println(keyword);
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		search.setPost_yn(post_yn);

		int listCount = bService.getListCountEventSearch();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list1 = bService.selectSearchListEvent1(pi, search);

		ArrayList<EventBoard> list2 = bService.selectSearchListEvent2(pi, search);

		System.out.println(list1);
		System.out.println(list2);
		if (list1 != null && list2 != null) {
			mv.addObject("list1", list1);
			mv.addObject("list2", list2);
			mv.addObject("pi", pi);
			mv.addObject("searchType", searchType);
			mv.addObject("keyword", keyword);
			mv.addObject("post_yn", post_yn);
			mv.setViewName("admin/adminEventSearch");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// �˻� �� ���� ��ȯ �� ������
	@RequestMapping("eventSearchListChange.do")
	public void eventSearchListChange(HttpServletResponse response, Integer page,
			@RequestParam("searchType") String searchType, @RequestParam("keyword") String keyword,
			@RequestParam("post_yn") String post_yn) throws IOException {

		System.out.println("�˻� �� ��ȯ ������ : " + searchType);
		System.out.println(keyword);

		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		search.setPost_yn(post_yn);

		int listCount = bService.getListCountEvent();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list1 = bService.selectSearchListEvent1(pi, search);

		ArrayList<EventBoard> list2 = bService.selectSearchListEvent2(pi, search);
		System.out.println(list1);
		System.out.println(list2);

		response.setContentType("application/json;charset=utf-8");

		if (list1 != null && list2 != null) {

			JSONArray jarr = new JSONArray();

			for (int i = 0; i < list1.size(); i++) {
				JSONObject jList = new JSONObject();
				jList.put("bBoard_no", list1.get(i).getbBoard_no());
				jList.put("rownum", list1.get(i).getRownum());
				jList.put("bTitle", list1.get(i).getbTitle());
				jList.put("bRead_num", list1.get(i).getbRead_num());
				jList.put("eE_status", list2.get(i).geteE_status());

				jarr.add(jList);

			}

			JSONObject sendJson = new JSONObject();
			sendJson.put("adminEventSearch", jarr);

			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			out.close();

		} else {
			throw new ItemException("�̺�Ʈ ��ü ��ȸ ����!");
		}
	}

	// -------------------------------------------------
	// serviceCenter

	// etc
	@RequestMapping("tierOfBenefit")
	public String tierOfBenefit() {
		return "serviceCenter/tierOfBenefit";
	}

	@RequestMapping("termsOfService")
	public String termsOfService() {
		return "event/termsOfService";
	}

	@RequestMapping("privacyPolicy")
	public String privacyPolicy() {
		return "event/privacyPolicy";
	}

	// Notice List
	@RequestMapping("noticeList.do")
	public ModelAndView noticeList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) { // �⺻
																													// �ڷ�������
																													// ����
																													// ��
																													// ����
																													// ������
																													// Integer��
																													// ����
		// ����¡ ���� ó������ ����
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountNotice();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectListNotice(pi);

		if (list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("serviceCenter/noticeList");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// Notice Detail
	@RequestMapping("noticeDetail.do")
	public ModelAndView noticeDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;

		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectDetail(bBoard_no);
			if (board != null) {
				mv.addObject("board", board).addObject("currentPage", currentPage)
						.setViewName("serviceCenter/noticeDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}
		return mv;
	}

	// FAQ List
	@RequestMapping("FAQList.do")
	public ModelAndView FAQList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) { // �⺻
																													// �ڷ�������
																													// ����
																													// ��
																													// ����
																													// ������
																													// Integer��
																													// ����
		// ����¡ ���� ó������ ����
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountFAQ();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectListFAQ(pi);

		if (list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("serviceCenter/FAQList");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// FAQ Detail
	@RequestMapping("FAQDetail.do")
	public ModelAndView FAQDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;

		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectDetail(bBoard_no);
			if (board != null) {
				mv.addObject("board", board).addObject("currentPage", currentPage)
						.setViewName("serviceCenter/FAQDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}
		return mv;
	}

	// productProposal List
	@RequestMapping("productProposalList.do")
	public ModelAndView productProposalList(ModelAndView mv,
			@RequestParam(value = "page", required = false) Integer page) { // �⺻ �ڷ������� ���� �� ���� ������ Integer�� ����
		// ����¡ ���� ó������ ����
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountProductProposal();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list = bService.selectListProductProposal(pi);

		if (list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("serviceCenter/productProposalList");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// productProposal Detail
	@RequestMapping("ProductProposalDetail")
	public ModelAndView ProductProposalDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;

		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectIDetail(bBoard_no);
			if (board != null) {
				mv.addObject("board", board).addObject("currentPage", currentPage)
						.setViewName("serviceCenter/productProposalDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}
		return mv;
	}

	// productProposal Insert
	@RequestMapping("productProposalInsert.do")
	public String productProposalInsert() {
		return "serviceCenter/productProposalInsert";
	}

	@RequestMapping("ProductProposalInsert.do")
	public String ProductProposalInsert(HttpServletRequest request, Board b,
			@RequestParam(value = "uploadProposal", required = false) MultipartFile file) {
		// NoticeController�� �ִ� saveFile �޼ҵ� �������� buploadFiles������ ��������
		// �׸��� �̹��� ��¥�� Ȱ���� rename�� ������ ����
		System.out.println(file.getOriginalFilename());
		if (!file.getOriginalFilename().equals("")) {

			String renameFileName = pSaveFile(file, request);
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\proposalUploadFiles";

			b.setOriginalFileName(file.getOriginalFilename());
			b.setRenameFileName(renameFileName);
			b.setImagePath(savePath);

		}

		int result1 = bService.insertProductProposal(b);
		int result2 = bService.insertImage(b);

		if ((result1 > 0 && result2 > 0) || (result1 > 0 && result2 < 0)) {
			return "redirect:productProposalList.do";
		} else {
			throw new BoardException("�Խñ� ��� ����!");
		}
	}

	// ������ ���� �� ��θ� �����ϴ� �޼ҵ�
	private String pSaveFile(MultipartFile file, HttpServletRequest request) {

		String root = request.getSession().getServletContext().getRealPath("resources");
		// request.getSession().getServletContext() -> webapp���
		// getRealPath -> File: �������� ���

		String savePath = root + "\\proposalUploadFiles";
		// ������ ������ ����� �ǰ� ������ ������ �̷��� ���� �̸��� �Ἥ �����

		File folder = new File(savePath);

		if (!folder.exists()) { // webapp�Ʒ��� �ִ� resources ���� �Ʒ���
								// nuloadFiles�� ��� File��ü�� ã�� �� ���ٸ�
			folder.mkdirs(); // ������ ������

		}

		// �������� ���ϸ� �ߺ� ���Ŵ� �Ű澲�� �ʰ� ������
		// �Խ��ǿ����� ���ϸ��� ��¥(���ε� �ð�)�� rename �غ���

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
				+ originFileName.substring(originFileName.lastIndexOf(".") + 1);

		String filePath = folder + "\\" + renameFileName;
		// ���� ���� �� ������ ��� + rename���ϸ�

		try {
			file.transferTo(new File(filePath));
			// �� ���·δ� ���� ���ε尡 ���� �ʴ´�.
			// �ֳĸ� ���� ����ũ�⿡ ���� ������ ���� �ʾұ� �����̴�.
			// root-context.xml�� ���ε� ���� ���� ũ�⸦ ������ ����.

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
		if (f.exists()) {
			f.delete();
		}
	}

	@RequestMapping("proposalDelete.do")
	public String proposalDelete(Integer bBoard_no, HttpServletRequest request) {
		System.out.println(bBoard_no);
		Board b = bService.selectIDetail(bBoard_no);
		System.out.println(b);
		if (b.getOriginalFileName() != null) {
			PdeleteFile(b.getRenameFileName(), request);
		}

		// �Խñ� �����ϱ�
		int result1 = bService.deleteImage(bBoard_no);
		int result2 = bService.deleteBoardImage(bBoard_no);
		int result3 = bService.deleteBoard(bBoard_no);

		if (result1 > 0 && result2 > 0 && result3 > 0) {
			return "redirect:productProposalList.do";
		} else {
			throw new BoardException("�Խù� ���� ����!");
		}
	}

	// productProposal Update
	@RequestMapping("productProposalUpdate.do")
	public ModelAndView productProposalUpdate(ModelAndView mv, Integer bBoard_no, @RequestParam("page") Integer page) {
		Board board = bService.selectIDetail(bBoard_no);
		System.out.println(board);
		mv.addObject("board", board).addObject("currentPage", page).setViewName("serviceCenter/productProposalUpdate");

		return mv;
	}

	@RequestMapping(value = "proposalUpdate.do", method = RequestMethod.POST)
	public ModelAndView proposalUpdate(ModelAndView mv, Board b, HttpServletRequest request,
			@RequestParam("page") Integer page,
			@RequestParam(value = "uploadProposal", required = false) MultipartFile file) {

		if (!file.getOriginalFilename().equals("")) { // ���� ���ϸ��� �����ϸ�
			if (b.getRenameFileName() != null) { // �ٲ��̸��� �����ϸ�
				deleteFile(b.getRenameFileName(), request); // �ٲ��̸� ����
			}
			String renameFileName = pSaveFile(file, request);

			b.setOriginalFileName(file.getOriginalFilename());
			b.setRenameFileName(renameFileName);
		}
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\proposalUploadFiles";
		b.setImagePath(savePath);

		int result1 = bService.updateImage(b);
		int result2 = bService.updateBoard(b);

		if (result1 > 0 || result2 > 0) {
			mv.addObject("page", page).setViewName("redirect:productProposalList.do");
		} else {
			throw new BoardException("�Խñ� ���� ����!!");
		}

		return mv;

	}

	// Inquiry List
	@RequestMapping("sinquiryList")
	public ModelAndView inquirylList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) { // �⺻
																														// �ڷ�������
																														// ����
																														// ��
																														// ����
																														// ������
																														// Integer��
																														// ����
		// ����¡ ���� ó������ ����
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountInquiry();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		ArrayList<Board> list1 = bService.selectListInquiry1(pi);
		// �����, ����, �亯���¸� ǥ���ϱ� ���� ArrayList
		ArrayList<secret> list2 = bService.selectListInquiry2(pi);
		ArrayList<Inquiry> list3 = bService.selectListInquiry3(pi);
		System.out.println("list1 : " + list1.size());
		System.out.println("list2 : " + list2.size());
		System.out.println("list3 : " + list3.size());

		if (list1 != null && list2 != null && list3 != null) {
			mv.addObject("list1", list1);
			mv.addObject("list2", list2);
			mv.addObject("list3", list3);
			mv.addObject("pi", pi);
			mv.setViewName("serviceCenter/inquiryList");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// Inquiry Password
	@RequestMapping("inquiryPassword.do")
	public ModelAndView inquiryPassword(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {

		Board board = bService.selectOIDetail1(bBoard_no);

		int currentPage = page;

		if (board != null) {
			mv.addObject("board", board).addObject("currentPage", currentPage)
					.setViewName("serviceCenter/inquiryPassword");
		} else {
			throw new BoardException("�Խñ� ��ȸ ����");
		}
		return mv;
	}

	@RequestMapping("inquiryEqPwdYN.do")
	@ResponseBody
	public String inquiryEqPwdYN(@RequestParam("pwd") String pwd, @RequestParam("page") Integer page, int bBoard_no) {
		System.out.println(bBoard_no);

		String result = bService.selectInquiryPwd(bBoard_no);

		System.out.println(page);

		System.out.println(result);

		System.out.println(pwd);

		if (result.equals(pwd)) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping("inquiryEqualPwd.do")
	public ModelAndView inquiryEqualPwd(HttpServletRequest request, Board b, secret s, Inquiry i, ModelAndView mv,
			int bBoard_no, @RequestParam("page") Integer page) {
		System.out.println(page);

		int currentPage = page;
		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectOIDetail1(bBoard_no);
			System.out.println("����detail: " + board);
			secret secret = bService.selectOIDetail2(bBoard_no);
			System.out.println("����detail: " + secret);
			Inquiry inquiry = bService.selectOIDetail3(bBoard_no);
			System.out.println("����detail: " + inquiry);
			if (board != null && secret != null && inquiry != null) {
				mv.addObject("board", board).addObject("secret", secret).addObject("inquiry", inquiry)
						.addObject("currentPage", currentPage).setViewName("serviceCenter/inquiryDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}

		return mv;
	}

	// Inquiry Detail
	@RequestMapping("inquiryDetail")
	public ModelAndView inquiryDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;
		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectOIDetail1(bBoard_no);
			System.out.println("detail: " + board);
			secret secret = bService.selectOIDetail2(bBoard_no);
			System.out.println("detail: " + secret);
			Inquiry inquiry = bService.selectOIDetail3(bBoard_no);
			System.out.println("detail: " + inquiry);
			if (board != null && secret != null && inquiry != null) {
				mv.addObject("board", board).addObject("secret", secret).addObject("inquiry", inquiry)
						.addObject("currentPage", currentPage).setViewName("serviceCenter/inquiryDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}
		return mv;
	}

	// Inquiry Insert
	@RequestMapping("inquiryInsert.do")
	public String inquiryInsert() {
		return "serviceCenter/inquiryInsert";
	}

	@RequestMapping("oInquiryInsert.do")
	public String inquiryInsert(HttpServletRequest request, Board b, secret s, Inquiry i,
			@RequestParam("oSecret") String oSecret,
			@RequestParam(value = "uploadInquiry", required = false) MultipartFile file) {
		// NoticeController�� �ִ� saveFile �޼ҵ� �������� buploadFiles������ ��������
		// �׸��� �̹��� ��¥�� Ȱ���� rename�� ������ ����

		if (!file.getOriginalFilename().equals("")) {

			String renameFileName = iSaveFile(file, request);
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\inquiryUploadFiles";

			b.setOriginalFileName(file.getOriginalFilename());
			b.setRenameFileName(renameFileName);
			b.setImagePath(savePath);

		}

		if (oSecret.equals("N")) {
			s.setoSecret("N");
		} else {
			s.setoSecret("Y");
		}

		int result1 = bService.insertInquiry1(b);
		int result2 = bService.insertInquiry2(s);
		int result3 = bService.insertInquiry3(i);
		int result4 = bService.insertImage(b);

		if ((result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0)
				|| (result1 > 0 && result2 > 0 && result3 > 0 && result4 < 0)) {
			return "redirect:sinquiryList.do";
		} else {
			throw new BoardException("�Խñ� ��� ����!");
		}
	}

	// ������ ���� �� ��θ� �����ϴ� �޼ҵ�
	private String iSaveFile(MultipartFile file, HttpServletRequest request) {

		String root = request.getSession().getServletContext().getRealPath("resources");
		// request.getSession().getServletContext() -> webapp���
		// getRealPath -> File: �������� ���

		String savePath = root + "\\inquiryUploadFiles";
		// ������ ������ ����� �ǰ� ������ ������ �̷��� ���� �̸��� �Ἥ �����

		File folder = new File(savePath);

		if (!folder.exists()) { // webapp�Ʒ��� �ִ� resources ���� �Ʒ���
								// nuloadFiles�� ��� File��ü�� ã�� �� ���ٸ�
			folder.mkdirs(); // ������ ������

		}

		// �������� ���ϸ� �ߺ� ���Ŵ� �Ű澲�� �ʰ� ������
		// �Խ��ǿ����� ���ϸ��� ��¥(���ε� �ð�)�� rename �غ���

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
				+ originFileName.substring(originFileName.lastIndexOf(".") + 1);

		String filePath = folder + "\\" + renameFileName;
		// ���� ���� �� ������ ��� + rename���ϸ�

		try {
			file.transferTo(new File(filePath));
			// �� ���·δ� ���� ���ε尡 ���� �ʴ´�.
			// �ֳĸ� ���� ����ũ�⿡ ���� ������ ���� �ʾұ� �����̴�.
			// root-context.xml�� ���ε� ���� ���� ũ�⸦ ������ ����.

		} catch (Exception e) {
			e.printStackTrace();
		}

		return renameFileName;
	}

	// Inquiry Update
	@RequestMapping("inquiryUpdate.do")
	public ModelAndView inquiryUpdate(ModelAndView mv, Integer bBoard_no, @RequestParam("page") Integer page) {
		Board board = bService.selectOIDetail1(bBoard_no);
		secret secret = bService.selectOIDetail2(bBoard_no);
		Inquiry inquiry = bService.selectOIDetail3(bBoard_no);
		System.out.println(board);
		System.out.println(secret);
		System.out.println(inquiry);
		mv.addObject("board", board).addObject("secret", secret).addObject("inquiry", inquiry)
				.addObject("currentPage", page).setViewName("serviceCenter/inquiryUpdate");

		return mv;
	}

	@RequestMapping(value = "rInquiryUpdate.do", method = RequestMethod.POST)
	public ModelAndView inquiryUpdate(ModelAndView mv, Board b, secret s, Inquiry i,
			@RequestParam("oSecret") String oSecret, HttpServletRequest request, @RequestParam("page") Integer page,
			@RequestParam(value = "uploadInquiry", required = false) MultipartFile file) {

		if (!file.getOriginalFilename().equals("")) { // ���� ���ϸ��� �����ϸ�
			if (b.getRenameFileName() != null) { // �ٲ��̸��� �����ϸ�
				deleteFile(b.getRenameFileName(), request); // �ٲ��̸� ����
			}
			String renameFileName = iSaveFile(file, request);

			b.setOriginalFileName(file.getOriginalFilename());
			b.setRenameFileName(renameFileName);
		}

		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\inquiryUploadFiles";
		b.setImagePath(savePath);

		System.out.println(oSecret);

		if (oSecret.equals("N")) {
			s.setoSecret("N");
		} else {
			s.setoSecret("Y");
		}

		System.out.println(oSecret);

		int result1 = bService.updateImage(b);
		int result2 = bService.updateBoard(b);
		int result3 = bService.updateOneInquiry(s);
		int result4 = bService.updateInquiry(i);

		if (result1 > 0 || result2 > 0 || result3 > 0 || result4 > 0) {
			mv.addObject("page", page).setViewName("redirect:sinquiryList.do");
		} else {
			throw new BoardException("�Խñ� ���� ����!!");
		}

		return mv;

	}

	// Inquiry Delete
	private void iDeleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\inquiryUploadFiles";

		File f = new File(savePath + "\\" + fileName);
		if (f.exists()) {
			f.delete();
		}
	}

	@RequestMapping("inquiryDelete.do")
	public String inquiryDelete(Integer bBoard_no, HttpServletRequest request) {
		System.out.println(bBoard_no);
		Board b = bService.selectIDetail(bBoard_no);
		System.out.println(b);
		if (b.getOriginalFileName() != null) {
			iDeleteFile(b.getRenameFileName(), request);
		}

		// �Խñ� �����ϱ�
		int result1 = bService.deleteImage(bBoard_no);
		int result2 = bService.deleteBoardImage(bBoard_no);
		int result3 = bService.deleteBoard(bBoard_no);
		int result4 = bService.deleteOneInquiryBoard(bBoard_no);
		int result5 = bService.deleteInquiryBoard(bBoard_no);

		if (result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result5 > 0) {
			return "redirect:sinquiryList.do";
		} else {
			throw new BoardException("�Խù� ���� ����!");
		}
	}

	// event
	// List
	@RequestMapping("eventList.do")
	public ModelAndView eventList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) { // �⺻
																													// �ڷ�������
																													// ����
																													// ��
																													// ����
																													// ������
																													// Integer��
																													// ����
		// ����¡ ���� ó������ ����
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}

		int listCount = bService.getListCountEvent();

		bPageInfo pi = getPageInfo(currentPage, listCount);

		// ����¡ ó���� ������ �Խñ��� �߷�����
		ArrayList<Board> list1 = bService.selectListEvent1(pi);
		// �Խÿ��θ� ���� ArrayList
		ArrayList<EventBoard> list2 = bService.selectListEvent2(pi);
		System.out.println(list1);
		System.out.println(list2);
		if (list1 != null && list2 != null) {
			mv.addObject("list1", list1);
			mv.addObject("list2", list2);
			mv.addObject("pi", pi);
			mv.setViewName("event/eventList");
		} else {
			throw new BoardException("�Խñ� ��ü ��ȸ ����!");
		}

		return mv;
	}

	// Detail
	@RequestMapping("eventDetail")
	public ModelAndView eventDetail(ModelAndView mv, int bBoard_no, @RequestParam("page") Integer page) {
		int currentPage = page;

		int result = bService.addReadCount(bBoard_no); // ��ȸ���� ���� �Ǿ�߸� �Խù� �󼼺��Ⱑ �����ϴ�

		if (result > 0) {
			Board board = bService.selectIDetail(bBoard_no);
			System.out.println("detail: " + board);
			EventBoard eventBoard = bService.selectEDetail(bBoard_no);
			System.out.println("detail: " + eventBoard);
			if (board != null && eventBoard != null) {
				mv.addObject("board", board).addObject("eventBoard", eventBoard).addObject("currentPage", currentPage)
						.setViewName("event/eventDetail");
			} else {
				throw new BoardException("�Խñ� ��ȸ ����");
			}
		} else {
			throw new BoardException("�Խñ� ��ȸ�� ���� ����!");
		}
		return mv;
	}

}
