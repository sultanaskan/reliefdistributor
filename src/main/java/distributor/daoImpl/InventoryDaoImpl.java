package distributor.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import distributor.dao.InventoryDao;
import distributor.entity.Inventory;

public class InventoryDaoImpl implements InventoryDao {
	Connection conn;

	public InventoryDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean AddInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		boolean r = false;
		String sql = "insert into inventory values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inventory.getInventory_id());
			ps.setString(2, inventory.getRelief_id());
			ps.setString(3, inventory.getHolder_id());
			ps.setString(4, inventory.getItem_id());
			ps.setDouble(5, inventory.getItem_quantity());
			r = !ps.execute();

		} catch (Exception e) {
			// TODO: handle exception
			e.addSuppressed(e);
		}
		return r;
	}

	@Override
	public String CheckInventoryItem(Inventory inventory) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String r = null;
		String sql = "select inventory_id from inventory where relief_id =? and holder_id =? and item_id =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inventory.getRelief_id());
			ps.setString(2, inventory.getHolder_id());
			ps.setString(3, inventory.getItem_id());
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				r = rs.getString(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.addSuppressed(e);
		}
		return r;
	}

	
	
	
	@Override
	public boolean SumInventoryItem(Inventory inventory) {
		// TODO Auto-generated method stub
		boolean r= false;
		String sql = "update inventory set item_quantity = item_quantity + ? where inventory_id =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, inventory.getItem_quantity());
			ps.setString(2, inventory.getInventory_id());
			
			int v= ps.executeUpdate();
			if(v == 1) {
				r= true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return r;
	}

	
	@Override
	public boolean SubInventoryItem(Inventory inventory) {
		boolean r= false;
		String sql = "update inventory set item_quantity = item_quantity - ? where inventory_id =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, inventory.getItem_quantity());
			ps.setString(2, inventory.getInventory_id());
			
			int v= ps.executeUpdate();
			if(v == 1) {
				r= true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public ArrayList<String> findAllInventoryId(Inventory inventory) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		String sql = "select inventory_id from inventory where relief_id =? and holder_id =?" ;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inventory.getRelief_id());
			ps.setString(2, inventory.getHolder_id());
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
	public Inventory findInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		Inventory inv = new Inventory();
		String sql = "select * from inventory where inventory_id =? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inventory.getInventory_id());
			ResultSet res= ps.executeQuery();
			while(res.next()) {
				inv.setInventory_id(res.getString(1));
				inv.setRelief_id(res.getString(2));
				inv.setHolder_id(res.getString(3));
				inv.setItem_id(res.getString(4));
				inv.setItem_quantity(res.getDouble(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return inv;
	}
	
	
	
	
	

}
