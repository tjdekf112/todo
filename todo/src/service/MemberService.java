package service;

import java.sql.Connection;
import java.sql.SQLException;

import commons.DBUtil;
import dao.AdminDao;
import dao.MemberDao;
import dao.TodoDao;
import vo.Admin;
import vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private TodoDao todoDao;
	private AdminDao adminDao;
	
	public Admin adminlogin(Admin admin) {
		Admin loginMember = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
			this.adminDao = new AdminDao();
			loginMember = adminDao.adminlogin(conn , admin);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}
		
	
	
	public void insertMember(Member member) {
		 Connection conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
		 try {
			 memberDao = new MemberDao();
			 memberDao.insertMember(conn, member);
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
	
	
	public boolean removeMember(String memberId, String memberPw) {
	      boolean result = false;
	      //DB경로 설정
	      Connection conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
	      try {
	    	 // conn을 자동으로 커밋 해체
	         conn.setAutoCommit(false);
	         todoDao = new TodoDao();
	        
	         memberDao = new MemberDao();
	         todoDao.deleteTodo(conn, memberId);
	         if( memberDao.deleteMember(conn, memberId, memberPw) != 1) {
	        	 throw new Exception();
	         }
	         // 데이터 처리시 에러가 없다면 commit 수행
	         conn.commit();
	         result = true;
	      } catch (Exception e) {
	    	  //오류 내용 
	         e.printStackTrace();
	         try {
	        	 // 에러 발생 시 rollback 처리
	            conn.rollback();
	         } catch (SQLException e1) {
	            e1.printStackTrace();
	         }
	      } finally {	//에러가 발생하든 안하든 무조건 실행
	         try {
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return result;
	   }
	
	public Member login(Member member) {
		Member loginMember = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
			this.memberDao = new MemberDao();
			loginMember = memberDao.login(conn, member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}
	
	public void test() {
		
	}
}
