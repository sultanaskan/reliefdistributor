package distributor.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import distributor.daoImpl.Database;
import distributor.daoImpl.FundDaoImpl;
import distributor.entity.Fund;


@WebServlet("/add_fund")
public class AddFundServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection conn = new Database().Dbconn();
			HttpSession se = req.getSession();
			String fund_id = req.getParameter("fund_id");
			//fund_id = UUID.randomUUID().toString();
			String relief_id = req.getParameter("relief_id");
			String holder_id = req.getParameter("holder_id");
			String item_id = req.getParameter("item_id");
			Double item_quantity = Double.parseDouble(req.getParameter("item_quantity"));

			Fund fund = new Fund(fund_id, relief_id, holder_id, item_id, item_quantity);
	
			FundDaoImpl dao = new FundDaoImpl(conn);
			
			
			boolean r = dao.subFundItem(fund);
			int  rs= dao.countFundRecord(fund);
			System.out.println(rs);
			for(int i = 0; i < 5; i++) {
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
