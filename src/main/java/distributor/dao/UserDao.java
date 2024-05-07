package distributor.dao;

import distributor.entity.User;

public interface UserDao {
	public boolean saveUser(User user);
	public User UserLogin(String user_phone, String user_password);
	public boolean updateUser(User user);
	
}
