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
import distributor.daoImpl.InventoryDaoImpl;
import distributor.entity.Inventory;


@WebServlet("/add_inventory")
public class AddInventoryServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = new Database().Dbconn();
		HttpSession se = req.getSession();
		String inventory_id  = UUID.randomUUID().toString();
		String relief_id = req.getParameter("relief_id");
		String holder_id = req.getParameter("holder_id");
		String item_id = req.getParameter("item_id");
		Double item_quantity = 0.0;
		try {
				item_quantity = Double.parseDouble(req.getParameter("item_quantity"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Inventory inventory = new Inventory(inventory_id, relief_id, holder_id, item_id, item_quantity);
		InventoryDaoImpl dao = new InventoryDaoImpl(conn);
		
		String i_id= dao.CheckInventoryItem(inventory);
		System.out.println(i_id);
		if(i_id == null) {
			dao.AddInventory(inventory);
			se.setAttribute("add_inventory_msg", "Inventory added Succesfuly !");
			resp.sendRedirect("index.jsp");
			
		}else {
			inventory = new Inventory(i_id, relief_id, holder_id, item_id, item_quantity);
			dao.SumInventoryItem(inventory);
			se.setAttribute("add_inventory_msg", "Inventory Update Succesfuly !");
			resp.sendRedirect("index.jsp");
		}
		
		
		
	}

}
