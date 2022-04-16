package dao;

public class AdminDaoQuery {
	public static final String adminlogin;
	static {
		adminlogin = "SELECT admin_id adminId FROM admin WHERE admin_id=? AND admin_pw=?";
	}
}
