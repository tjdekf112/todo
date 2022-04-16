package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import commons.DBUtil;
import dao.NoticeDao;
import vo.Notice;

public class NoticeService {
	private NoticeDao noticeDao;
	
	public List<Notice> getNoticeList5(){
		List<Notice> list = null;

		
		Connection conn = null;
		conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
		noticeDao = new NoticeDao();
		try {
			list = noticeDao.selectNoticeList5(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Notice> getNoticeList(int beginRow, int rowPerPage){
		List<Notice> list = null;

		
		Connection conn = null;
		conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
		noticeDao = new NoticeDao();
		try {
			list = noticeDao.selectNoticeList(conn, beginRow, rowPerPage);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public int getTotalCount(){
		int totalCount =0;
		Connection conn = null;
		conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
		noticeDao = new NoticeDao();
		try {
			totalCount = noticeDao.selectNoticeLastPage(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return totalCount;
	}
	
	public Notice getNoticeOne(int noticeNo) {
		Notice notice = null;
		Connection conn = null;
		conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
		noticeDao = new NoticeDao();
		try {
			notice = noticeDao.selectNoticeOne(conn, noticeNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return notice;
	}
}
