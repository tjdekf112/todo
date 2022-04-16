package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CalendarService;
import service.TodoService;
import vo.Member;

@WebServlet("/member/calendar")
public class CalendarController extends HttpServlet {
   private CalendarService calendarService;
   private TodoService todoService;
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String currentYear = request.getParameter("currentYear");
      String currentMonth = request.getParameter("currentMonth");
      String option = request.getParameter("option");
      
      // �����
      
      calendarService = new CalendarService();
      String memberId = ((Member)request.getSession().getAttribute("loginMember")).getMemberId();
      //�����
      Map<String, Object> map = calendarService.getTargetCalendar(memberId, currentYear, currentMonth, option);
      
      // ��
      request.setAttribute("targetYear", map.get("targetYear"));
      request.setAttribute("targetMonth", map.get("targetMonth"));
      request.setAttribute("endDay", map.get("endDay"));
      // �޷��� ����Ҵ� ��/�� �ʿ��� ����<td>
      request.setAttribute("startBlank", map.get("startBlank"));
      request.setAttribute("endBlank", map.get("endBlank"));
      // �޷¿� ����� todo �� ���
      request.setAttribute("todoList", map.get("todoList"));
      System.out.println(map.get("todoList") + "<-- todoList");
      request.getRequestDispatcher("/WEB-INF/view/calendar.jsp").forward(request, response);
   }
}