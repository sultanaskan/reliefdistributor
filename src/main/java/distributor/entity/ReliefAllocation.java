package distributor.entity;

public class ReliefAllocation {
	private String allocation_id;
	private String relief_id;
	private String item_id;
	private Double item_quantity;
	
	
	public ReliefAllocation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReliefAllocation(String allocation_id, String relief_id, String item_id, Double item_quantity) {
		super();
		this.allocation_id = allocation_id;
		this.relief_id = relief_id;
		this.item_id = item_id;
		this.item_quantity = item_quantity;
	}


	public String getAllocation_id() {
		return allocation_id;
	}


	public void setAllocation_id(String allocation_id) {
		this.allocation_id = allocation_id;
	}


	public String getRelief_id() {
		return relief_id;
	}


	public void setRelief_id(String relief_id) {
		this.relief_id = relief_id;
	}


	public String getItem_id() {
		return item_id;
	}


	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}


	public Double getItem_quantity() {
		return item_quantity;
	}


	public void setItem_quantity(Double item_quantity) {
		this.item_quantity = item_quantity;
	}


	@Override
	public String toString() {
		return "ReliefAllocation [allocation_id=" + allocation_id + ", relief_id=" + relief_id + ", item_id=" + item_id
				+ ", item_quantity=" + item_quantity + "]";
	}
	
	

}
