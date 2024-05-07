package distributor.dao;

import java.util.ArrayList;

import distributor.entity.FundBelow;


public interface FundBelowDao {
	public boolean addFundBelow(FundBelow fundbelow);
	public String checkFundBelow(FundBelow fundbelow);
	public boolean sumFundBelow(FundBelow fundbelow);
	public boolean subFundBelow(FundBelow fundbelow);
	public FundBelow findFundBelow(FundBelow fundbelow);
	public ArrayList<String> findAllFundBelowIds(FundBelow fundbelow);
	public int countFundBelow(FundBelow fundbelow);
}