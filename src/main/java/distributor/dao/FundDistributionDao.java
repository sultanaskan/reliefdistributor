package distributor.dao;

import java.util.ArrayList;

import distributor.entity.FundDistribution;


public interface FundDistributionDao {
	public boolean addDistribution(FundDistribution distribution);
	public boolean updateDistribution(FundDistribution distribution);
	public ArrayList<String> findAllDistributionId(FundDistribution distribution);
	public ArrayList<String> findAllSuccessDistributionId(FundDistribution distribution);
	public ArrayList<String> findAllPaindingDistributionId(FundDistribution distribution);
	
	
	public ArrayList<String> findAllMyCollectedDistributionId(FundDistribution distribution);
	public ArrayList<String> findAllMySucessCollectedDistributionId(FundDistribution distribution);
	public ArrayList<String> findAllMyPaindingCollectedDistributionId(FundDistribution distribution);
	
	public ArrayList<String> findAllMyCollectedFromDistributionId(FundDistribution distribution);
	public ArrayList<String> findAllMySuccessCollectedFromDistributionId(FundDistribution distribution);
	public ArrayList<String> findAllMyPaindingCollectedFromDistributionId(FundDistribution distribution);
	
	
	public ArrayList<String> findAllMyDistributedToDistributionId(FundDistribution distribution);
	public ArrayList<String> findAllMySuccessDistributedToDistributionId(FundDistribution distribution);
	public ArrayList<String> findAllMyPaindingDistributedToDistributionId(FundDistribution distribution);
	
	
	public ArrayList<String> findAllMyDistributedDistributionId(FundDistribution distribution);
	public ArrayList<String> findAllMySuccessDistributedDistributionId(FundDistribution distribution);
	public ArrayList<String> findAllMyPaindingDistributedDistributionId(FundDistribution distribution);
	
	
	public FundDistribution findDistribution(FundDistribution distribution);


}
