package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;
import vo.Notice;

@WebServlet("/noticeOne")
public class NoticeOneController extends HttpServlet{
	private NoticeService noticeService;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		noticeService = new NoticeService();
		Notice notice = new Notice();
		notice = noticeService.getNoticeOne(noticeNo);
		request.setAttribute("notice", notice);
		
		request.getRequestDispatcher("/WEB-INF/view/noticeOne.jsp?noticeNo="+noticeNo).forward(request, response);
	}
}
