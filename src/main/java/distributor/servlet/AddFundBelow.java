package distributor.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import distributor.daoImpl.Database;
import distributor.daoImpl.FundBelowDaoImpl;
import distributor.entity.FundBelow;


@WebServlet("/add_fund_below")
public class AddFundBelow extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = new Database().Dbconn();
		HttpSession se = req.getSession();
		String fund_below_id = req.getParameter("fund_below_id");
		String relief_id = req.getParameter("relief_id");
		String holder_id = req.getParameter("holder_id");
		String item_id = req.getParameter("item_id");
		Double item_quantity = Double.parseDouble(req.getParameter("item_quantity"));
		
		
		FundBelow fund_below = new FundBelow(fund_below_id,relief_id,holder_id,item_id,item_quantity);
		FundBelowDaoImpl dao = new FundBelowDaoImpl(conn);
		System.out.println(dao.countFundBelow(fund_below));
	}

}
