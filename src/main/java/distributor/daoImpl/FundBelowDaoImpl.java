package distributor.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import distributor.dao.FundBelowDao;
import distributor.entity.FundBelow;


public class FundBelowDaoImpl implements FundBelowDao {

	Connection conn;

	public FundBelowDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean addFundBelow(FundBelow fundbelow) {
		boolean r = false;
		String sql = "insert into fund_below values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fundbelow.getFund_below_id());
			ps.setString(2, fundbelow.getRelief_id());
			ps.setString(3, fundbelow.getHolder_id());
			ps.setString(4, fundbelow.getItem_id());
			ps.setDouble(5, fundbelow.getItem_quantity());

			r = !ps.execute();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public String checkFundBelow(FundBelow fundbelow) {
		// TODO Auto-generated method stubString r = null;
		String r = null;
		String sql = "select fund_below_id from fund_below where relief_id = ? and holder_id =? and item_id =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fundbelow.getRelief_id());
			ps.setString(2, fundbelow.getHolder_id());
			ps.setString(3, fundbelow.getItem_id());

			ResultSet res = ps.executeQuery();
			while (res.next()) {
				r = res.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public boolean sumFundBelow(FundBelow fundbelow) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "update fund_below set item_quantity = item_quantity + ? where fund_below_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, fundbelow.getItem_quantity());
			ps.setString(2, fundbelow.getFund_below_id());
			int i = ps.executeUpdate();
			if (i == 1) {
				r = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public boolean subFundBelow(FundBelow fundbelow) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "update fund_below set item_quantity = item_quantity - ? where fund_below_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, fundbelow.getItem_quantity());
			ps.setString(2, fundbelow.getFund_below_id());
			int i = ps.executeUpdate();
			if (i == 1) {
				r = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public FundBelow findFundBelow(FundBelow fundbelow) {
		// TODO Auto-generated method stub
		FundBelow fund = new FundBelow();
		String sql = "select * from  fund_below where fund_below_id =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fundbelow.getFund_below_id());
		
			
			ResultSet res= ps.executeQuery();
			while(res.next()) {
				fund.setFund_below_id(res.getString(1));
				fund.setRelief_id(res.getString(2));
				fund.setHolder_id(res.getString(3));
				fund.setItem_id(res.getString(4));
				fund.setItem_quantity(res.getDouble(5));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fund;
	}

	@Override
	public ArrayList<String> findAllFundBelowIds(FundBelow fundbelow) {
		// TODO Auto-generated method stub
		ArrayList<String> funds = new ArrayList<String>();
		String sql = "select fund_below_id from  fund_below where "
				+ "relief_id = ? and"
				+ " holder_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, fundbelow.getRelief_id());
			ps.setString(2, fundbelow.getHolder_id());
			
			ResultSet res= ps.executeQuery();
			while(res.next()) {
				funds.add(res.getString(1));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return funds;
	}

	@Override
	public int countFundBelow(FundBelow fundbelow) {
		// TODO Auto-generated method stub
		int c = 0;
		String sql = "select count(fund_below_id) from fund_below where relief_id = ? and holder_id =? and item_id =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fundbelow.getRelief_id());
			ps.setString(2, fundbelow.getHolder_id());
			ps.setString(3, fundbelow.getItem_id());
			ResultSet res=  ps.executeQuery();
			while(res.next()) {
				c= res.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}
	
	

}
