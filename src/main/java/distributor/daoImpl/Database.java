package distributor.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements distributor.dao.Database{
	
	
	
	
	

	public Database() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Connection Dbconn() {
		// TODO Auto-generated method stub
		Connection conn  = null;
		String url= "jdbc:mysql://localhost:3306/relief_distributor";
		String user= "root";
		String password= "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			conn = DriverManager.getConnection(url,user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	

}
