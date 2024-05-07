package distributor.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import distributor.dao.ItemDao;
import distributor.entity.Item;


public class ItemDaoImpl implements ItemDao {
	Connection conn;

	public ItemDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "insert into item values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item.getItem_id());
			ps.setString(2, item.getRelief_id());
			ps.setString(3, item.getItem_name());
			ps.setString(4, item.getItem_unit());
			ps.setDouble(5, item.getItem_price());

			r = !ps.execute();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<String> findAllItemId(Item item) {
		ArrayList<String> item_ids = new ArrayList();
		String sql = "select item_id  from item where relief_id =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, null);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				item_ids.add(r.getString(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return item_ids;
	}

	@Override
	public boolean updateItem(Item item) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "update item set " + "item_id = case when ? is not null then ? else item_id end"
				+ "relief_id = case when ? is not null then ? else relief_id end"
				+ "item_name = case when ? is not null then ? else  item_name end"
				+ "item_unit = case when ? is not null then ? else  item_unit end"
				+ "item_price = case when ? is not null then ? else item_price end" + "where item_id ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item.getItem_id());
			ps.setString(2, item.getItem_id());
			ps.setString(3, item.getRelief_id());
			ps.setString(4, item.getRelief_id());
			ps.setString(5, item.getItem_name());
			ps.setString(6, item.getItem_name());
			ps.setString(7, item.getItem_unit());
			ps.setString(8, item.getItem_unit());
			ps.setDouble(9, item.getItem_price());
			ps.setDouble(10, item.getItem_price());
			ps.setString(11, item.getItem_id());
			
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
	public String findItemNameById(String item_id) {
		String name = null;
		String sql = "select item_name from item where item_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item_id);
		    ResultSet res = 	ps.executeQuery();
		    while(res.next()) {
		    	name = res.getString(1);
		    }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return name;
	}

	@Override
	public String findItemUnitById(String item_id) {
		// TODO Auto-generated method stub
		String unit = null;
		String sql = "select item_unit from item where item_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item_id);
		    ResultSet res = 	ps.executeQuery();
		    while(res.next()) {
		    	unit = res.getString(1);
		    }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return unit;
	}

	@Override
	public Double findItemPriceById(String item_id) {
		// TODO Auto-generated method stub
		Double price = null;
		String sql = "select item_price from item where item_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item_id);
		    ResultSet res = 	ps.executeQuery();
		    while(res.next()) {
		    	price = res.getDouble(1);
		    }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return price;
	}

	@Override
	public String checkItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findItem(String item_id) {
		Item item = new Item();
		String sql = "Select * from item where item_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item_id);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				item.setItem_id(res.getString(1));
				item.setRelief_id(res.getString(2));
				item.setItem_name(res.getString(3));
				item.setItem_unit(res.getString(4));
				item.setItem_price(res.getDouble(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return item;
	}
	
	
	
	

}
