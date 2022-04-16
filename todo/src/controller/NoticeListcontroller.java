package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;
import vo.Notice;


@WebServlet("/noticelist")
public class NoticeListcontroller extends HttpServlet {
	private NoticeService noticeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;
		int rowPerPage = 10;
		int beginRow = (currentPage - 1) * rowPerPage;
		noticeService = new NoticeService();
		List<Notice> noticeList = noticeService.getNoticeList(beginRow, rowPerPage);
		request.setAttribute("noticeList", noticeList);
		
		request.getRequestDispatcher("/WEB-INF/view/noticeList.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		int beginRow = 0;
		int startPage = 0;
		int displayPage = 10;
		int lastPage = 0;
		beginRow = (currentPage - 1) * rowPerPage;
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / rowPerPage;
		if(totalCount % rowPerPage != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		*/
	}

}
