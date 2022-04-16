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
	//�Է� ��
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ż�� ��
		request.getRequestDispatcher("/WEB-INF/view/removeMember.jsp").forward(request, response);
	}
	
	//�Է� �׼�
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �Է� ������ �޾ƿ� �� ������ ����
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		//��ü ����
		memberService = new MemberService();
		//removeMemver�� �Ű������� �ְ� ȣ��
		boolean result = memberService.removeMember(memberId, memberPw);
		if(result == true) {
			//ȸ�� Ż�� ���������� ���� �ȴٸ�
			response.sendRedirect(request.getContextPath()+"/member/logout");
			System.out.println("ȸ��Ż��!");
			return;
		} else {
			//ȸ��Ż�� �����ߴٸ� Ķ������ ���ư��� �ٽ� ȸ�� Ż�� Ŭ��
			response.sendRedirect(request.getContextPath()+"/member/removeMember");
			System.out.println("ȸ��Ż�� ����!");
			return;
		}
		
	}

}
