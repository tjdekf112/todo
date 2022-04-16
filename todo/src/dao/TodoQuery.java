package dao;

public class TodoQuery {
	public static final String DELETE_TODO;
	public static final String SELECT_TODO_LIST_BY_DATE;
	public static final String INSERT_TODO;
	public static final String SELECT_TODO_LIST_BY_MONTH;
	public static final String UPDATE_TODO;
	public static final String DELETE_TODO_CALENDAR;
	static {
		INSERT_TODO
		="INSERT INTO todo(todo_date, member_id, todo_content, create_date, update_date, font_color) VALUES(?,?,?,now(),now(),?)";
		
		SELECT_TODO_LIST_BY_DATE
		= "SELECT todo_no todoNo, todo_date todoDate, todo_content todoContent, create_date createDate, SUBSTR(update_date,1,11) updateDate FROM todo WHERE todo_Date=? AND member_id=?";
		
		DELETE_TODO = "DELETE FROM todo WHERE member_id=?";
		
		SELECT_TODO_LIST_BY_MONTH
		="SELECT todo_date todoDate , SUBSTR(todo_content,1,5) todoContent5, font_color FROM todo WHERE member_id = ? AND SUBSTR(todo_date,1,7)=? ORDER BY tododate";
		
		UPDATE_TODO
		="UPDATE todo SET todo_content = ? WHERE todo_no=?";
		
		DELETE_TODO_CALENDAR
		="DELETE FROM todo WHERE todo_no =?";
	}
}
