package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Notice;

public class NoticeDao {
	public List<Notice> selectNoticeList5(Connection conn) throws SQLException{
		List<Notice> list = new ArrayList<>();
		String sql = NoticeQuery.SELECT_NOTICE_LIST5;
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Notice notice = new Notice();
			notice.setNoticeNo(rs.getInt("noticeNo"));
			notice.setNoticeTitle(rs.getString("noticeTitle"));
			notice.setCreateDate(rs.getString("createDate"));
			list.add(notice);
		}
		
		return list;
		
	}
	
	public List<Notice> selectNoticeList(Connection conn, int beginRow, int rowPerPage) throws SQLException{
		List<Notice> list = new ArrayList<>();
		String sql = NoticeQuery.SELECT_NOTICE_LIST;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		System.out.println(stmt + "stmt");
		while(rs.next()) {
			Notice notice = new Notice();
			notice.setNoticeNo(rs.getInt("noticeNo"));
			notice.setNoticeTitle(rs.getString("noticeTitle"));
			notice.setNoticeContent(rs.getString("noticeContent"));
			notice.setCreateDate(rs.getString("createDate"));
			notice.setUpdateDate(rs.getString("updateDate"));
			
			list.add(notice);
		}
		
		return list;
		
	}
	
	public int selectNoticeLastPage(Connection conn) throws SQLException {
		int totalCount = 0;
		String sql = NoticeQuery.SELECT_NOTICE_LAST_PAGE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			totalCount = rs.getInt("count(*)");
		}
		return totalCount;
	}
	
	public Notice selectNoticeOne(Connection conn,int noticeNo) throws SQLException {
		Notice notice = new Notice();
		String sql = NoticeQuery.SELECT_NOTICE_ONE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, noticeNo);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			
			notice.setNoticeNo(rs.getInt("noticeNo"));
			notice.setNoticeTitle(rs.getString("noticeTitle"));
			notice.setNoticeContent(rs.getString("noticeContent"));
			notice.setCreateDate(rs.getString("createDate"));
			notice.setUpdateDate(rs.getString("updateDate"));
		}
		return notice;
	}
	
}
