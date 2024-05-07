package distributor.dao;

import java.util.ArrayList;

import distributor.entity.ReliefAllocation;


public interface ReliefAllocationDao {
	public boolean createAllocation(ReliefAllocation allocation);
	public boolean updateAllocation(ReliefAllocation allocation);
	public ArrayList<String> findAllAllocationId(ReliefAllocation  allocation);
	
	public ReliefAllocation findAllocation(String allocation);
}
