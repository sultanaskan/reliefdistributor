package distributor.entity;

public class FundBelow {
	private String fund_below_id;
	private String relief_id;
	private String holder_id;
	private String item_id;
	private Double item_quantity;
	
	
	
	public FundBelow() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FundBelow(String fund_below_id, String relief_id, String holder_id, String item_id, Double item_quantity) {
		super();
		this.fund_below_id = fund_below_id;
		this.relief_id = relief_id;
		this.holder_id = holder_id;
		this.item_id = item_id;
		this.item_quantity = item_quantity;
	}



	public String getFund_below_id() {
		return fund_below_id;
	}



	public void setFund_below_id(String fund_below_id) {
		this.fund_below_id = fund_below_id;
	}



	public String getRelief_id() {
		return relief_id;
	}



	public void setRelief_id(String relief_id) {
		this.relief_id = relief_id;
	}



	public String getHolder_id() {
		return holder_id;
	}



	public void setHolder_id(String holder_id) {
		this.holder_id = holder_id;
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
		return "FundBelow [fund_below_id=" + fund_below_id + ", relief_id=" + relief_id + ", holder_id=" + holder_id
				+ ", item_id=" + item_id + ", item_quantity=" + item_quantity + "]";
	}
	
	

 

}
