package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/member/removeMember")
public class RemoveController extends HttpServlet {
	private MemberService memberService;
	//입력 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 탈퇴 폼
		request.getRequestDispatcher("/WEB-INF/view/removeMember.jsp").forward(request, response);
	}
	
	//입력 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력 폼에서 받아온 값 변수에 저장
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		//객체 선언
		memberService = new MemberService();
		//removeMemver에 매개변수를 넣고 호출
		boolean result = memberService.removeMember(memberId, memberPw);
		if(result == true) {
			//회원 탈퇴가 성공적으로 실행 된다면
			response.sendRedirect(request.getContextPath()+"/member/logout");
			System.out.println("회원탈퇴!");
			return;
		} else {
			//회원탈퇴가 실패했다면 캘린더로 돌아가서 다시 회원 탈퇴 클릭
			response.sendRedirect(request.getContextPath()+"/member/removeMember");
			System.out.println("회원탈퇴 실패!");
			return;
		}
		
	}

}
