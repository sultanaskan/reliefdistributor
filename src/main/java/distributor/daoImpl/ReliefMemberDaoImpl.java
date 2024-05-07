package distributor.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import distributor.dao.ReliefMemberDao;
import distributor.entity.ReliefMember;
import distributor.entity.User;


public class ReliefMemberDaoImpl implements ReliefMemberDao {
	Connection conn;

	public ReliefMemberDaoImpl(Connection conn) {
		super();
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean addMember(ReliefMember member) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "insert into relief_member values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, member.getRelief_member_id());
			ps.setString(2, member.getRelief_id());
			ps.setString(3, member.getUser_id());
			ps.setString(4, member.getRole());
			ps.setString(5, member.getRepresentative_id());
			ps.setInt(6, member.getCollection_code());
			ps.setString(7, member.getCollection_status());

			r = !ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public boolean updateMember(ReliefMember member) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "update relief_member set "
				+ "relief_member_id = case when ? is not null then ? else relief_member_id end,"
				+ " relief_id= case when ? is not null then ? else relief_id end,"
				+ " user_id= case when ? is not null then ? else user_id end,"
				+ " role= case when ? is not null then ? else role end,"
				+ " representative_id = case when ? is not null then ? else representative_id end,"
				+ " collection_code= case when ? is  not null then ? else collection_code end,"
				+ " collection_status = case when ? is not null then ? else collection_status end"
				+ " where relief_member_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, member.getRelief_member_id());
			ps.setString(2, member.getRelief_member_id());
			ps.setString(3, member.getRelief_id());
			ps.setString(4, member.getRelief_id());
			ps.setString(5, member.getUser_id());
			ps.setString(6, member.getUser_id());
			ps.setString(7, member.getRole());
			ps.setString(8, member.getRole());
			ps.setString(9, member.getRepresentative_id());
			ps.setString(10, member.getRepresentative_id());
			ps.setInt(11, member.getCollection_code());
			ps.setInt(12, member.getCollection_code());
			ps.setString(13, member.getCollection_status());
			ps.setString(14, member.getCollection_status());
			ps.setString(15, member.getRelief_member_id());

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
	public ReliefMember findMember(ReliefMember member_id) {
		// TODO Auto-generated method stub
		ReliefMember member = new ReliefMember();
		String sql = "select * from relief_member where relief_member_id =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, member_id.getRelief_member_id());
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				member.setRelief_member_id(res.getString(1));
				member.setRelief_id(res.getString(2));
				member.setUser_id(res.getString(3));
				member.setRole(res.getString(4));
				member.setRepresentative_id(res.getString(5));
				member.setCollection_code(res.getInt(6));
				member.setCollection_status(res.getString(7));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return member;
	}

	@Override
	public ArrayList<String> findAllSubHolderId(ReliefMember member) {
		// TODO Auto-generated method stub
		ArrayList<String> holders = new ArrayList<String>();
		String sql = "select * from relief_member where role is not null and relief_id =? and representative_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, member.getRelief_id());
			ps.setString(1, member.getRepresentative_id());
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				holders.add(res.getString(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return holders;
	}

	@Override
	public ArrayList<String> findAllSubMemberId(ReliefMember member) {
		// TODO Auto-generated method stub
		ArrayList<String> holders = new ArrayList<String>();
		String sql = "select relief_member_id from relief_member where  relief_id =? and representative_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, member.getRelief_id());
			ps.setString(2, member.getRepresentative_id());
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				holders.add(res.getString(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return holders;
	}

	@Override
	public ArrayList<String> findAllSubNonRecivedMemberId(ReliefMember member) {
		// TODO Auto-generated method stub
		ArrayList<String> members = new ArrayList<String>();
		String sql = "select relief_member_id from relief_member where and relief_id =? and representative_id = ? and collection_status is null ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, member.getRelief_id());
			ps.setString(2, member.getRepresentative_id());
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				members.add(res.getString(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return members;
	}

	@Override
	public ArrayList<String> findAllSubRecivedMemberId(ReliefMember member) {
		// TODO Auto-generated method stub
		ArrayList<String> members = new ArrayList<String>();
		String sql = "select relief_member_id from relief_member where  relief_id =? and representative_id = ? and collection_status is not null ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, member.getRelief_id());
			ps.setString(2, member.getRepresentative_id());
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				members.add(res.getString(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return members;
	}

	@Override
	public ReliefMember findRootHolder(ReliefMember relief_id) {
		// TODO Auto-generated method stub
		ReliefMember member = new ReliefMember();
		String sql = "select * from relief_member where role is null and relief_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, relief_id.getRelief_id());
			ResultSet res= ps.executeQuery();
			while(res.next()) {
				member.setRelief_member_id(res.getString(1));
				member.setRelief_id(res.getString(2));
				member.setUser_id(res.getString(3));
				member.setRole(res.getString(4));
				member.setRepresentative_id(res.getString(5));
				member.setCollection_code(res.getInt(6));
				member.setCollection_status(res.getString(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public ArrayList<String> findAllReliefId(User user) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select relief_id from relief_member where user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser_id());			
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
	
	
	
	
	
	
	
	
	

}
