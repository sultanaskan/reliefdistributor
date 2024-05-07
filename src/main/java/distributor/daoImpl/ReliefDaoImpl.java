package distributor.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import javax.servlet.http.Part;

import distributor.dao.ReliefDao;
import distributor.entity.Relief;


public class ReliefDaoImpl implements ReliefDao{
	Connection conn ;
	
	public ReliefDaoImpl(Connection conn) {
		this.conn = conn;
	}
  
	@Override
	public boolean NewRelief(Relief relief) {
		
		boolean r = false;
		// TODO Auto-generated method stub
		String sql = "insert into relief(relief_id, relief_name, relief_description) values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, relief.getRelief_id());
			ps.setString(2, relief.getRelief_name());
			ps.setString(3, relief.getRelief_description());
			
			r= !ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public boolean updateRelief(Relief relief) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "update relief set  "
				+ "relief_id = case when ? is not null then ? esle relief_id end ,"
				+ "relief_name = case when ? is not null then ? esle relief_id end ,"
				+ "relief_description = case when ? is not null then ? esle relief_id end "
				+ "where relief_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, relief.getRelief_id());
			ps.setString(2, relief.getRelief_id());
			ps.setString(3, relief.getRelief_name());
			ps.setString(4, relief.getRelief_name());
			ps.setString(5, relief.getRelief_description());
			ps.setString(6, relief.getRelief_description());
			ps.setString(7, relief.getRelief_id());
			
			int i =  ps.executeUpdate();
			if(i == 1) {
				r= true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Relief findRelief(Relief relief) {
		// TODO Auto-generated method stub
		Relief rel = new Relief();
		String sql = " select * from relief where relief_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, relief.getRelief_id());
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				rel.setRelief_id(res.getString(1));
				rel.setRelief_name(res.getString(2));
				rel.setRelief_description(res.getString(3));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rel;
	}
	
	

}
