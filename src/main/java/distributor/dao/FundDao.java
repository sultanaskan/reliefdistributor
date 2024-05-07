package distributor.dao;

import java.util.ArrayList;

import distributor.entity.Fund;

public interface FundDao {
	public boolean addFundItem(Fund fund);
	public String checkFundItem(Fund fund);
	public boolean  sumFundItem(Fund fund);
	public boolean  subFundItem(Fund fund);
	public ArrayList<String> findAllFundIds(String relief_id, String holder_id);
	public Fund findFund(String fund_id);
	public int countFundRecord(Fund fund);

}
