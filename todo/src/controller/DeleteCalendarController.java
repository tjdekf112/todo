package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CalendarService;
import vo.Todo;

@WebServlet("/member/delete")
public class DeleteCalendarController extends HttpServlet {

	private CalendarService calendarService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String todoNo = request.getParameter("todoNo");
		String todoDate = request.getParameter("todoDate");
		
		System.out.println(todoNo +"<-- todoNo");
		System.out.println(todoDate +"<-- todoDate");
		
		request.setAttribute("todoNo", todoNo);
		request.setAttribute("todoDate", todoDate);
		
		request.getRequestDispatcher("/WEB-INF/view/deleteCalendar.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int todoNo = Integer.parseInt( request.getParameter("todoNo"));
		String todoDate = request.getParameter("todoDate");
		
		System.out.println(todoNo + "<-- todoNo");
		System.out.println(todoDate + "<-- todoDate");
		
		Todo todo = new Todo();
		todo.setTodoNo(todoNo);
		todo.setTodoDate(todoDate);
		
		calendarService = new CalendarService();
		calendarService.getDeleteCalendar(todo);
		
		String y = todoDate.substring(0,4);
		String m = todoDate.substring(5,7);
		String d = todoDate.substring(8,10);
		System.out.println(y);
		System.out.println(m);
		System.out.println(d);
		
		response.sendRedirect(request.getContextPath() + "/member/todoList?y="+y+"&m="+m+"&d="+d);
		
	}

}
