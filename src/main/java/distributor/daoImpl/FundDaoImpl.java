package distributor.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import distributor.dao.FundDao;
import distributor.entity.Fund;


public class FundDaoImpl implements FundDao{
	Connection conn;
	public FundDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean addFundItem(Fund fund) {
		// TODO Auto-generated method stub
		boolean r= false;
		String Sql= "insert into fund values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(Sql);
			ps.setString(1, fund.getFund_id());
			ps.setString(2, fund.getRelief_id());
			ps.setString(3, fund.getHolder_id());
			ps.setString(4, fund.getItem_id());
			ps.setDouble(5, fund.getItem_quantity());
			
			r= !ps.execute();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public String checkFundItem(Fund fund) {
		// TODO Auto-generated method stub
		String fund_id = null;
		String sql = "SELECT fund_id FROM fund WHERE "
		           + "relief_id = ? "
		           + "AND holder_id = ? "
		           + "AND item_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fund.getRelief_id());
			ps.setString(2, fund.getHolder_id());
			ps.setString(3, fund.getItem_id());
			ResultSet res= ps.executeQuery();
			while(res.next()) {
				fund_id = res.getString(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fund_id;
	}

	@Override
	public boolean sumFundItem(Fund fund) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "UPDATE fund SET "
		           + "item_quantity = item_quantity + ? "
		           + "WHERE fund_id = ? ";

		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setDouble(1, fund.getItem_quantity());
			ps.setString(2, fund.getFund_id());
			int i = ps.executeUpdate();
			if(i == 1) {
				r= true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public boolean subFundItem(Fund fund) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "UPDATE fund SET "
		           + "item_quantity = item_quantity - ? "
		           + "WHERE fund_id = ? ";

		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setDouble(1, fund.getItem_quantity());
			ps.setString(2, fund.getFund_id());
			int i = ps.executeUpdate();
			if(i == 1) {
				r= true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<String> findAllFundIds(String relief_id, String holder_id) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_id from fund "
				+ "where relief_id = ? "
				+ "and holder_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, relief_id);
			ps.setString(2, holder_id);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				ids.add(res.getString(1));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public Fund findFund(String fund_id) {
		// TODO Auto-generated method stub
		Fund fund = new Fund();
		String sql ="select * from fund where fund_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fund_id);
			ResultSet res=  ps.executeQuery();
			while(res.next()) {
				fund.setFund_id(res.getString(1));
				fund.setRelief_id(res.getString(2));
				fund.setHolder_id(res.getString(3));
				fund.setItem_id(res.getString(4));
				fund.setItem_quantity(res.getDouble(5));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fund;
	}

	@Override
	public int countFundRecord(Fund fund) {
		// TODO Auto-generated method stub
		int r = 0;
		String sql = "select count(fund_id) from fund where relief_id = ? and holder_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fund.getRelief_id());
			ps.setString(2, fund.getHolder_id());
			ResultSet res= ps.executeQuery();
			while(res.next()) {
			 	r= res.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}
	
	
	
	

}
