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
import service.NoticeService;
import vo.Member;
import vo.Notice;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	private NoticeService noticeService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�̹� �α����� �Ǿ��ٸ� ��û ó�� �Ұ�
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {	// �̹� �α��� �Ǿ��ִ� ���´�
			response.sendRedirect(request.getContextPath() + "/calendar");
			return;
		}
		noticeService = new NoticeService();
		List<Notice> noticeList = noticeService.getNoticeList5();
		request.setAttribute("noticeList", noticeList);
		
		// login ��
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login �׼�
		
		//���ڵ� -> �ѱ� ���� ����
		//request.setCharacterEncoding("utf8");
		//�̹� �α����� �Ǿ��ٸ� ��û ó�� �Ұ�
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {	// �̹� �α��� �Ǿ��ִ� ���´�
			response.sendRedirect(request.getContextPath() + "/member/calendar");
		}
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		Member paramMember = new Member();
		paramMember.setMemberId(memberId);
		paramMember.setMemberPw(memberPw);
		
		this.memberService = new MemberService();
		Member loginMember = memberService.login(paramMember);
		if(loginMember == null) {
			System.out.println("���ӽ����Ͽ����ϴ�");
			response.sendRedirect(request.getContextPath()+"/login");
		}else if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			System.out.println("���Ӽ����Ͽ����ϴ�");
			response.sendRedirect(request.getContextPath()+"/member/calendar");
			//request.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(request, response);
		
		}
		
		
	}

}
