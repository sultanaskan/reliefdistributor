package distributor.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import distributor.daoImpl.Database;
import distributor.daoImpl.UserDaoImpl;
import distributor.entity.User;


@WebServlet("/user_registration")
@MultipartConfig
public class UserRegistrationServlet extends javax.servlet.http.HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = new Database().Dbconn();
		HttpSession se = req.getSession();
		String uer_id = UUID.randomUUID().toString();
		String user_name = req.getParameter("user_name");
		String user_phone = req.getParameter("user_phone");
		String user_nid = req.getParameter("user_nid");
		String user_email = req.getParameter("user_email");
		String user_password = req.getParameter("user_password");
		String user_country = req.getParameter("user_country");
		String user_division = req.getParameter("user_division");
		String user_district = req.getParameter("user_district");
		String user_upazila = req.getParameter("user_upazila");
		String user_union = req.getParameter("user_union");
		String user_word = req.getParameter("user_word");
		 Part user_photo = req.getPart("user_photo");

		User user = new User(uer_id, user_name, user_nid, user_phone, user_email, user_password, user_country, user_division,
				user_district, user_upazila, user_union, user_word, user_photo);
		System.out.println(user + " " + conn);
		UserDaoImpl dao = new UserDaoImpl(conn);

		if (dao.saveUser(user)) {
			se.setAttribute("reg_msg", "User Registration Successfull!");
			resp.sendRedirect("login.jsp");
		} else {
			se.setAttribute("reg_msg", "User Registration Failed !");
			resp.sendRedirect("user registration.jsp");
		}

	}
}
