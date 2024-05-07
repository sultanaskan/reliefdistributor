package distributor.entity;

public class ReliefDistribution {
	private String relief_distribution_id;
	private String relief_id;
	private String distributor_id;
	private String member_id;
	private String allocation_id;
	
	
	
	
	public ReliefDistribution() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReliefDistribution(String relief_distribution_id, String relief_id, String distributor_id, String member_id,
			String allocation_id) {
		super();
		this.relief_distribution_id = relief_distribution_id;
		this.relief_id = relief_id;
		this.distributor_id = distributor_id;
		this.member_id = member_id;
		this.allocation_id = allocation_id;
	}


	public String getRelief_distribution_id() {
		return relief_distribution_id;
	}


	public void setRelief_distribution_id(String relief_distribution_id) {
		this.relief_distribution_id = relief_distribution_id;
	}


	public String getRelief_id() {
		return relief_id;
	}


	public void setRelief_id(String relief_id) {
		this.relief_id = relief_id;
	}


	public String getDistributor_id() {
		return distributor_id;
	}


	public void setDistributor_id(String distributor_id) {
		this.distributor_id = distributor_id;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getAllocation_id() {
		return allocation_id;
	}


	public void setAllocation_id(String allocation_id) {
		this.allocation_id = allocation_id;
	}


	@Override
	public String toString() {
		return "ReliefDistribution [relief_distribution_id=" + relief_distribution_id + ", relief_id=" + relief_id
				+ ", distributor_id=" + distributor_id + ", member_id=" + member_id + ", allocation_id=" + allocation_id
				+ "]";
	}
	
	
	


}
