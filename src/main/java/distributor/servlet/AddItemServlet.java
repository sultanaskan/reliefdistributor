package distributor.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import distributor.daoImpl.Database;
import distributor.daoImpl.ItemDaoImpl;
import distributor.entity.Item;



@WebServlet("/add_item")
public class AddItemServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = new Database().Dbconn();
		HttpSession se = req.getSession();
		String item_id = UUID.randomUUID().toString();
		String relief_id= req.getParameter("relief_id");
		String item_name= req.getParameter("item_name");
		String item_unit= req.getParameter("item_unit");
		String item_price = req.getParameter("item_price");
		Double price= 0.0;
		try {
			 price= Double.parseDouble(item_price) ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Item item = new Item(item_id, relief_id, item_name, item_unit, price);
		ItemDaoImpl dao = new ItemDaoImpl(conn);
		
		if(dao.addItem(item)) {
			se.setAttribute("add_item_msg", "Idem Added Successfuly !");
			resp.sendRedirect("index.jsp");
		}else {
			se.setAttribute("add_item_msg", "Somthing wrong on server !");
			resp.sendRedirect("index.jsp");
			
		}
		
		
		
	}

}
