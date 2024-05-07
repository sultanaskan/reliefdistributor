package distributor.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import distributor.dao.FundDistributionDao;
import distributor.entity.Fund;
import distributor.entity.FundDistribution;

public class FundDistributionImpl implements FundDistributionDao {
	Connection conn;

	public FundDistributionImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean addDistribution(FundDistribution fund) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "insert into fund_distribution values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fund.getFund_distribution_id());
			ps.setString(2, fund.getRelief_id());
			ps.setString(3, fund.getFund_distributor_id());
			ps.setString(4, fund.getFund_collector_id());
			ps.setString(5, fund.getItem_id());
			ps.setDouble(6, fund.getItem_quantity());
			ps.setDate(7, fund.getDate());
			ps.setString(8, fund.getStatus());

			r = !ps.execute();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return r;
	}

	@Override
	public boolean updateDistribution(FundDistribution fund) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "UPDATE fund_distribution SET  fund_distribution_id = CASE WHEN ? IS NOT NULL THEN ? ELSE fund_distribution_id END,  relief_id = CASE WHEN ? IS NOT NULL THEN ? ELSE relief_id END,  fund_distributor_id = CASE WHEN ? IS NOT NULL THEN ? ELSE fund_distributor_id END, fund_collector_id = CASE WHEN ? IS NOT NULL THEN ? ELSE fund_collector_id END,  item_id = CASE WHEN ? IS NOT NULL THEN ? ELSE item_id END,  item_quantity = CASE WHEN ? IS NOT NULL THEN ? ELSE item_quantity END,  date = CASE WHEN ? IS NOT NULL THEN ? ELSE date END,   status = CASE WHEN ? IS NOT NULL THEN ? ELSE status END WHERE fund_distribution_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fund.getFund_distribution_id());
			ps.setString(2, fund.getFund_distribution_id());
			ps.setString(3, fund.getRelief_id());
			ps.setString(4, fund.getRelief_id());
			ps.setString(5, fund.getFund_distributor_id());
			ps.setString(6, fund.getFund_distributor_id());
			ps.setString(7, fund.getFund_collector_id());
			ps.setString(8, fund.getFund_collector_id());
			ps.setString(9, fund.getItem_id());
			ps.setString(10, fund.getItem_id());
			ps.setDouble(11, fund.getItem_quantity());
			ps.setDouble(12, fund.getItem_quantity());
			ps.setDate(13, fund.getDate());
			ps.setDate(14, fund.getDate());
			ps.setString(15, fund.getStatus());
			ps.setString(16, fund.getStatus());
			ps.setString(17, fund.getFund_distribution_id());

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
	public ArrayList<String> findAllDistributionId(FundDistribution distribution) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_distributor_id =? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_distributor_id());
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllSuccessDistributionId(FundDistribution distribution) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_distributor_id =? and status = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_distributor_id());
			ps.setString(3, "s");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllPaindingDistributionId(FundDistribution distribution) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_distributor_id =? and status = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_distributor_id());
			ps.setString(3, "p");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllMyCollectedDistributionId(FundDistribution distribution) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_collector_id =?  ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_collector_id());
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllMyCollectedFromDistributionId(FundDistribution distribution) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_collector_id =?  and fund_distributor_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_collector_id());
			ps.setString(3, distribution.getFund_distributor_id());
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllMyDistributedToDistributionId(FundDistribution distribution) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_collector_id =?  and fund_distributor_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_collector_id());
			ps.setString(3, distribution.getFund_distributor_id());
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllMyDistributedDistributionId(FundDistribution distribution) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_distributor_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_distributor_id());
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}
	
	
	
	

	@Override
	public ArrayList<String> findAllMySucessCollectedDistributionId(FundDistribution distribution) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_collector_id = ? and status = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_collector_id());
			ps.setString(3, "s");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllMyPaindingCollectedDistributionId(FundDistribution distribution) {
		// TODO Auto-generated method stub
				ArrayList<String> ids = new ArrayList<String>();
				String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_collector_id = ? and status = ?";
				try {
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, distribution.getRelief_id());
					ps.setString(2, distribution.getFund_collector_id());
					ps.setString(3, "p");
					ResultSet res = ps.executeQuery();
					while (res.next()) {
						ids.add(res.getString(1));
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return ids;
	}

	@Override
	public ArrayList<String> findAllMySuccessCollectedFromDistributionId(FundDistribution distribution) {
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_distributor_id =? and fund_collector_id = ?  and status = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_distributor_id());
			ps.setString(3, distribution.getFund_collector_id());
			ps.setString(4, "s");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllMyPaindingCollectedFromDistributionId(FundDistribution distribution) {
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_distributor_id =? and fund_collector_id = ?  and status = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_distributor_id());
			ps.setString(3, distribution.getFund_collector_id());
			ps.setString(4, "p");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllMySuccessDistributedToDistributionId(FundDistribution distribution) {
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_distributor_id =? and fund_collector_id = ?  and status = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_distributor_id());
			ps.setString(3, distribution.getFund_collector_id());
			ps.setString(4, "s");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllMyPaindingDistributedToDistributionId(FundDistribution distribution) {
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_distributor_id =? and fund_collector_id = ?  and status = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_distributor_id());
			ps.setString(3, distribution.getFund_collector_id());
			ps.setString(4, "p");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllMySuccessDistributedDistributionId(FundDistribution distribution) {
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_distributor_id =? and  status = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_distributor_id());
			ps.setString(3, "s");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public ArrayList<String> findAllMyPaindingDistributedDistributionId(FundDistribution distribution) {
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select fund_distribution_id from fund_distribution where relief_id =? and fund_distributor_id =? and  status = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getRelief_id());
			ps.setString(2, distribution.getFund_distributor_id());
			ps.setString(3, "p");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				ids.add(res.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ids;
	}

	@Override
	public FundDistribution findDistribution(FundDistribution distribution) {
		FundDistribution fund = new FundDistribution();
		String sql = "select * from fund_distribution where fund_distribution_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, distribution.getFund_distribution_id());
			
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				fund.setFund_distribution_id(res.getString(1));
				fund.setRelief_id(res.getString(2));
				fund.setFund_distributor_id(res.getString(3));
				fund.setFund_collector_id(res.getString(4));
				fund.setItem_id(res.getString(5));
				fund.setItem_quantity(res.getDouble(6));
				fund.setDate(res.getDate(7));
				fund.setStatus(res.getString(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fund;
	}

}
