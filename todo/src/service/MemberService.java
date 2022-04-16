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
	      //DB��� ����
	      Connection conn = DBUtil.getConnection("jdbc:mariadb://3.38.166.31:3306/todo", "root", "java1004");
	      try {
	    	 // conn�� �ڵ����� Ŀ�� ��ü
	         conn.setAutoCommit(false);
	         todoDao = new TodoDao();
	        
	         memberDao = new MemberDao();
	         todoDao.deleteTodo(conn, memberId);
	         if( memberDao.deleteMember(conn, memberId, memberPw) != 1) {
	        	 throw new Exception();
	         }
	         // ������ ó���� ������ ���ٸ� commit ����
	         conn.commit();
	         result = true;
	      } catch (Exception e) {
	    	  //���� ���� 
	         e.printStackTrace();
	         try {
	        	 // ���� �߻� �� rollback ó��
	            conn.rollback();
	         } catch (SQLException e1) {
	            e1.printStackTrace();
	         }
	      } finally {	//������ �߻��ϵ� ���ϵ� ������ ����
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
