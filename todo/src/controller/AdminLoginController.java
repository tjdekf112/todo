package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Admin;


@WebServlet("/adminlogin")
public class AdminLoginController extends HttpServlet {
	private MemberService memberService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이미 로그인이 되었다면 요청 처리 불가
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {	// 이미 로그인 되어있는 상태다
			response.sendRedirect(request.getContextPath() + "/calendar");
			return;
		}
		// login 폼
		request.getRequestDispatcher("/WEB-INF/view/adminlogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		Admin admin = new Admin();
		if(session.getAttribute("loginMember") != null) {	// 이미 로그인 되어있는 상태다
			response.sendRedirect(request.getContextPath() + "/member/calendar");
		}
		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");
		admin.setAdminId(adminId);
		admin.setAdminPw(adminPw);
		this.memberService = new MemberService();
		Admin loginMember = memberService.adminlogin(admin);
		if(loginMember == null) {
			System.out.println("접속실패하였습니다");
			response.sendRedirect(request.getContextPath()+"/login");
		}
		else if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			System.out.println("접속성공하였습니다");
			request.getRequestDispatcher("/WEB-INF/view/adminindex.jsp").forward(request, response);
		}
	}

}
