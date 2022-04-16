package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.DBUtil;
import dao.TodoDao;
import vo.Todo;

public class CalendarService {
   private TodoDao todoDao;
   
   public void getDeleteCalendar(Todo todo) {
	   Connection conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
	   try {
		   todoDao = new TodoDao();
		   todoDao.deleteCalendar(conn, todo);
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		   try {
			   conn.close();
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
	   }
   }
   
   
   public void getUpdateCalendar(Todo todo) {
	   Connection conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
	   try {
		   todoDao = new TodoDao();
		   todoDao.updateCalendar(conn, todo);
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		   try {
			   conn.close();
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
	   }
   }
 
   
   public Map<String, Object> getTargetCalendar(String memberId, String currentYear, String currentMonth, String option) { // option : pre, next
      // 1. �޷� �ڵ�
      Map<String, Object> map = new HashMap<>();
      
      Calendar c = Calendar.getInstance(); // ���� ��¥�� �⵵�� ���� ������
      
      if(currentYear != null && currentMonth != null) {
         int y = 0;
         int m = 0;
         y = Integer.parseInt(currentYear);
         // 1�� ~ 12��
         m = Integer.parseInt(currentMonth);
         if(option != null && option.equals("pre")) {
            m = m-1; // issue : 0�϶�
            if(m == 0) {
               m = 12;      
               y--; // y-=1; y = y-1;
            }
         } else if(option != null && option.equals("next")) {
            m = m+1; // issue : 13�϶�
            if(m == 13) {
               m = 1;
               y++;
            }
         }
         c.set(Calendar.YEAR, y);
         c.set(Calendar.MONTH, m-1);// 0��~11��
      }
   
      c.set(Calendar.DATE, 1); // c��ü ������ ���� -> ���� �� 1�Ϸ� ����
      // �޷¿� �ʿ��� ������
      int targetYear = c.get(Calendar.YEAR);
      int targetMonth = c.get(Calendar.MONTH) + 1;
      int endDay = c.getActualMaximum(Calendar.DATE);
      // �޷� ��,�� ������ ����
      int startBlank = 0; // Ÿ���� �Ǵ� ���� 1���� ���� -> �Ͽ����̸� 0, ������ 1.... ������̸� 6�� �ʿ�
      startBlank = c.get(Calendar.DAY_OF_WEEK) - 1;
      
      int endBlank = 0; // ��ü�� <td>���� = startBlank+endDay+endBlnk <- �̰��� 7�� ������ ����������
      endBlank = 7 - (startBlank+endDay)%7;
      if(endBlank == 7) {
         endBlank = 0;
      }
      
      map.put("targetYear", targetYear);
      map.put("targetMonth", targetMonth);
      map.put("endDay", endDay);
      map.put("startBlank", startBlank);
      map.put("endBlank", endBlank);
      
      // �޷¿� �߰��� �� �˰���
      List<Todo> list = null;
      Connection conn = null;
      try {
         conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
         todoDao = new TodoDao();
         Todo todo = new Todo(); 
         // memberId <- �Ű������� �Է¹���
         // todoDate�� �� �� <- targetYear��targetMonth�� ����ؼ�...
         todo.setMemberId(memberId);
         
         String strYear = ""+targetYear;
         String strMonth = ""+targetMonth;
         if(targetMonth < 10) {
            strMonth = "0"+targetMonth;
         }
         todo.setTodoDate(strYear+"-"+strMonth); 
         // �����
         System.out.println(todo+" <--todo");
         
         list = todoDao.selectTodoListByMonth(conn, todo);
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      map.put("todoList", list);
      
      return map;
   }
}