package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Admin;
import vo.Member;


public class AdminDao {
	public Admin adminlogin(Connection conn, Admin admin) throws SQLException {
		Admin loginMember = null;
		String sql = AdminDaoQuery.adminlogin;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, admin.getAdminId());
		stmt.setString(2, admin.getAdminPw());
		System.out.println(stmt + "<-- stmt");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			loginMember = new Admin();
			loginMember.setAdminId(rs.getString("adminId"));
		}
		rs.close();
		stmt.close();
		return loginMember;
		
	}
}
