package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.TodoService;
import vo.Member;
import vo.Todo;


@WebServlet("/member/addTodo")
public class addTodoController extends HttpServlet {

	private TodoService todoService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // ÀÏÁ¤ Ãß°¡
	      todoService = new TodoService();
	      String todoDate = request.getParameter("todoDate");
	      String todoContent = request.getParameter("todoContent");
	      String fontColor = request.getParameter("fontColor");
	      // µð¹ö±ë
	      System.out.println(todoDate + todoContent + fontColor +"AddTodoController.java");
	      String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
	      Todo todo = new Todo();
	      todo.setMemberId(memberId);
	      todo.setTodoDate(todoDate);
	      todo.setTodoContent(todoContent);
	      todo.setFontColor(fontColor);
	      System.out.println(todo.toString() + "debug");
	      todoService.addTodo(todo);
	      
	      String y = todoDate.substring(0,4);
	      String m = todoDate.substring(5,7);
	      String d = todoDate.substring(todoDate.length()-2, todoDate.length());
	      // µð¹ö±ë
	      
	      System.out.println(todoDate.substring(0,4)+todoDate.substring(5,6)+"/"+todoDate.substring(todoDate.length()-2,todoDate.length()));
	      
	      response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d);
	   }

}
