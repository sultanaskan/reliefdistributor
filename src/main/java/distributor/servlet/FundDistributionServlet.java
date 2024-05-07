package distributor.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import distributor.daoImpl.Database;
import distributor.daoImpl.FundDistributionImpl;
import distributor.entity.FundDistribution;

@WebServlet("/fund_distribution")
public class FundDistributionServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			Connection conn = new Database().Dbconn();
			HttpSession se = req.getSession();
			String fund_distribution_id = req.getParameter("fund_distribution_id");
			String relief_id = req.getParameter("relief_id");
			String fund_distributor_id = req.getParameter("fund_distributor_id");
			String fund_collector_id = req.getParameter("fund_collector_id");
			String item_id = req.getParameter("fund_item_id");
			System.out.println(item_id);
			Double item_quantity = 0.0;
			try {
				item_quantity = Double.parseDouble(req.getParameter("item_quantity"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			Date date = null;
			try {
				date = Date.valueOf(req.getParameter("date"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			String status = req.getParameter("status");

			FundDistribution fund = new FundDistribution(fund_distribution_id, relief_id, fund_distributor_id,
					fund_collector_id, item_id, item_quantity, date, status);
		
			FundDistributionImpl dao = new FundDistributionImpl(conn);
			FundDistribution r = dao.findDistribution(fund);
			System.out.println(r);

		} catch (

		Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
