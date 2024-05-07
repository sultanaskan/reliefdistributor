package distributor.dao;

import java.util.ArrayList;
import java.util.List;

import distributor.entity.Item;


public interface ItemDao {
	public boolean addItem(Item item);
	public ArrayList<String> findAllItemId(Item item);
	public boolean updateItem(Item item);
	public String checkItem(Item item);
	public Item findItem(String item_id);
	
	
	
	
	
	
	
	
	
	
	public String findItemNameById(String item_id);
	public String findItemUnitById(String item_id);
	public Double findItemPriceById(String item_id);

}
