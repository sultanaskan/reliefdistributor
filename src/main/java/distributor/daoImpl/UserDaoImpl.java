package distributor.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import distributor.dao.UserDao;
import distributor.entity.User;
public class UserDaoImpl implements UserDao{
	Connection conn ;
		
		

	public UserDaoImpl(Connection conn) {
			this.conn = conn;
			// TODO Auto-generated constructor stub
		}



	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		boolean r = false;
		
		String sql = "insert into user(user_id, user_name, user_phone, user_email,user_password, user_country, user_division, user_district, user_upazila, user_union, user_word, user_photo) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser_id());
			ps.setString(2, user.getUser_name());
			ps.setString(3, user.getUser_phone());
			ps.setString(4, user.getUser_email());
			ps.setString(5, user.getUser_password());
			ps.setString(6, user.getUser_country());
			ps.setString(7, user.getUser_division());
			ps.setString(8, user.getUser_district());
			ps.setString(9, user.getUser_upazila());
			ps.setString(10, user.getUser_union());
			ps.setString(11, user.getUser_word());
			ps.setBlob(12, user.getUser_photo().getInputStream());
			
			r = !ps.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}



	public User UserLogin(String user_phone, String user_password) {
		// TODO Auto-generated method stub
		User user = new User();
		String sql = "select user_name, user_phone,user_email, user_country, user_division, user_district, user_district, user_upazila, user_union, user_word, user_id from user where user_phone = ? and user_password=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user_phone);
			ps.setString(2, user_password);
			
			ResultSet r = ps.executeQuery();
			
			while(r.next()) {
				user.setUser_name(r.getString(1));
				user.setUser_phone(r.getString(2));
				user.setUser_email(r.getString(3));
				user.setUser_country(r.getString(4));
				user.setUser_division(r.getString(5));
				user.setUser_district(r.getString(6));
				user.setUser_upazila(r.getString(7));
				user.setUser_union(r.getString(8));
				user.setUser_word(r.getString(9));
				user.setUser_id(r.getString(10));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return user;
	}



	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "update user set "
				+ "user_id = case when ? is not null then ? else user_id end,"
				+ "user_name = case when ? is not null then ? else user_name end"
				+ "user_phone = case when ? is not null then ? else user_phone end"
				+ "user_email = case when ? is not null then ? else user_email end"
				+ "user_password = case when ? is not null then ? else user_password end"
				+ "user_country = case when ? is not null then ? else user_country end"
				+ "user_division = case when ? is not null then ? else user_division end"
				+ "user_district = case when ? is not null then ? else user_district end"
				+ "user_upazila = case when ? is not null then ? else user_upazila end"
				+ "user_union = case when ? is not null then ? else user_union end"
				+ "user_word = case when ? is not null then ? else user_word end"
				+ " where user_id = ?";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, user.getUser_id());
			ps.setString(2, user.getUser_id());
			ps.setString(3, user.getUser_name());
			ps.setString(4, user.getUser_name());
			ps.setString(5, user.getUser_email());
			ps.setString(6, user.getUser_email());
			ps.setString(7, user.getUser_phone());
			ps.setString(8, user.getUser_phone());
			ps.setString(9, user.getUser_password());
			ps.setString(10, user.getUser_password());
			ps.setString(11, user.getUser_country());
			ps.setString(12, user.getUser_country());
			ps.setString(13, user.getUser_division());
			ps.setString(14, user.getUser_division());
			ps.setString(15, user.getUser_district());
			ps.setString(16, user.getUser_district());
			ps.setString(17, user.getUser_upazila());
			ps.setString(18, user.getUser_upazila());
			ps.setString(19, user.getUser_union());
			ps.setString(20, user.getUser_union());
			ps.setString(21, user.getUser_word());
			ps.setString(22, user.getUser_word());
			ps.setString(23, user.getUser_id());
			
			int i =ps.executeUpdate();
			if(i == 1) {
				r =true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return r;
	}
	
	

}
