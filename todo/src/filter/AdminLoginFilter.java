package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLoginFilter
 */
@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	      // ������
	      // ���� �α��� ���¿����� ��û�� �� �ֵ��� ���͸�
	      System.out.println("LoginFilter ����");
	      HttpSession session = ((HttpServletRequest)request).getSession();
	      if(session.getAttribute("adminId") == null) {	
	         ((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/adminLogin");
	         return;
	      }

	      chain.doFilter(request, response);
	   
	      //������
	   }
}
