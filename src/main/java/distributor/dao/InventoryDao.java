package distributor.dao;

import java.util.ArrayList;

import distributor.entity.Inventory;

public interface InventoryDao {
	public boolean AddInventory(Inventory inventory);
	public String CheckInventoryItem(Inventory inventory);
	public boolean SumInventoryItem(Inventory inventory);
	public boolean SubInventoryItem(Inventory inventory);
	public ArrayList<String> findAllInventoryId(Inventory inventory);
	public Inventory findInventory(Inventory inventory);

}
