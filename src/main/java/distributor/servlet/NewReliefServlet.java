package distributor.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import distributor.daoImpl.Database;
import distributor.daoImpl.ReliefDaoImpl;
import distributor.daoImpl.ReliefMemberDaoImpl;
import distributor.entity.Relief;
import distributor.entity.ReliefMember;
import distributor.entity.User;


@WebServlet("/new_relief")
@MultipartConfig
public class NewReliefServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		Connection conn = new Database().Dbconn();
		HttpSession se = req.getSession();
		String relief_id  = UUID.randomUUID().toString();
		String relief_name = req.getParameter("relief_name");
		String relief_description = req.getParameter("relief_description");
		String user_id = req.getParameter("user_id");
		
		
		
		
	
		ReliefDaoImpl dao = new ReliefDaoImpl(conn);
		Relief relief = new Relief(relief_id, relief_name, relief_description);
	
		// Create new Relief program
		boolean r = dao.NewRelief(relief);
		System.out.println(r);
		if(r) {
			// Adding new member as a root admin
			String relief_member_id = UUID.randomUUID().toString();
			
			ReliefMember member = new ReliefMember();
			member.setRelief_member_id(relief_member_id);
			member.setRelief_id(relief_id);
			member.setUser_id(user_id);
			member.setRole("*");
			System.out.println(member);			
			ReliefMemberDaoImpl mdao = new ReliefMemberDaoImpl(conn);
			mdao.addMember(member);
			resp.sendRedirect("user/");
		}
		
		
		
	}
	

}
