package distributor.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import distributor.daoImpl.Database;
import distributor.daoImpl.UserDaoImpl;
import distributor.entity.User;

import javax.servlet.annotation.WebServlet;

@WebServlet("/user_login")
public class UserLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession se = req.getSession();
		Connection conn = new Database().Dbconn();
		String user_phone = req.getParameter("user_phone");
		String user_password = req.getParameter("user_password");
		
		UserDaoImpl  dao = new UserDaoImpl(conn);
		User user = new User();
		user =dao.UserLogin(user_phone, user_password);
		if(user != null) {
			System.out.println("user login success ");
			se.setAttribute("loged_user", user);
			resp.sendRedirect("user/index.jsp");
		}else {
			System.out.println("user login Failed ");
		}
		
	}

}
