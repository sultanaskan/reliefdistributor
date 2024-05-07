package distributor.entity;

public class Fund {
	private String fund_id;
	private String relief_id;
	private String holder_id;
	private String item_id;
	private Double item_quantity;
	
	
	public Fund() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Fund(String fund_id, String relief_id, String holder_id, String item_id, Double item_quantity) {
		super();
		this.fund_id = fund_id;
		this.relief_id = relief_id;
		this.holder_id = holder_id;
		this.item_id = item_id;
		this.item_quantity = item_quantity;
	}


	public String getFund_id() {
		return fund_id;
	}


	public void setFund_id(String fund_id) {
		this.fund_id = fund_id;
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
		return "Fund [fund_id=" + fund_id + ", relief_id=" + relief_id + ", holder_id=" + holder_id + ", item_id="
				+ item_id + ", item_quantity=" + item_quantity + "]";
	}
	
	

}
