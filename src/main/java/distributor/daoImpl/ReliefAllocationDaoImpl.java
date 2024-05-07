package distributor.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import distributor.dao.ReliefAllocationDao;
import distributor.entity.ReliefAllocation;


public class ReliefAllocationDaoImpl implements ReliefAllocationDao{
	Connection conn;
	public ReliefAllocationDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean createAllocation(ReliefAllocation allocation) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "insert into relief_allocation values (?,?,?,?)";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, allocation.getAllocation_id());
			ps.setString(2, allocation.getRelief_id());
			ps.setString(3, allocation.getItem_id());
			ps.setDouble(4, allocation.getItem_quantity());
			
			r= !ps.execute();
			
			
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public boolean updateAllocation(ReliefAllocation allocation) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "update relief_allocation set"
				+ "allocation_id = case when ? is not null then ? else allocation_id end"
				+ "relief_id = case when ? is not null then ? else relief_id end"
				+ "item_id = case when ? is not null then ? else item_id end"
				+ "item_quantity = case when ? is not null then ? else item_quantity end"
				+ "where allocation_id = ?";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, allocation.getAllocation_id());
			ps.setString(2, allocation.getAllocation_id());
			ps.setString(3, allocation.getRelief_id());
			ps.setString(4, allocation.getRelief_id());
			ps.setString(5, allocation.getItem_id());
			ps.setString(6, allocation.getItem_id());
			ps.setDouble(7, allocation.getItem_quantity());
			ps.setDouble(8, allocation.getItem_quantity());
			ps.setString(9, allocation.getAllocation_id());

			
			int i = ps.executeUpdate();
			if(i == 1 ) {
				r =true;
			}
			
			
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<String> findAllAllocationId(ReliefAllocation  allocation) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select allocation_id where relief_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, allocation.getRelief_id());
			 ResultSet res =  ps.executeQuery();
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
	public ReliefAllocation findAllocation(String allocation_id) {
		// TODO Auto-generated method stub
		ReliefAllocation allocation = new ReliefAllocation();
		String sql ="select * from relief_allocation where allocation_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, allocation_id);
			ResultSet res =  ps.executeQuery();
			while(res.next()) {
				allocation.setAllocation_id(res.getString(1));
				allocation.setRelief_id(res.getString(2));
				allocation.setRelief_id(res.getString(3));
				allocation.setItem_id(res.getString(4));
				allocation.setItem_quantity(res.getDouble(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return allocation;
	}

	

	
}
