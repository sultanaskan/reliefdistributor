package distributor.entity;

public class Item {
	private String  item_id;
	private String relief_id;
	private String item_name;
	private String item_unit;
	private Double item_price;
	
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Item(String item_id, String relief_id, String item_name, String item_unit, Double item_price) {
		super();
		this.item_id = item_id;
		this.relief_id = relief_id;
		this.item_name = item_name;
		this.item_unit = item_unit;
		this.item_price = item_price;
	}



	public String getItem_id() {
		return item_id;
	}



	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}



	public String getRelief_id() {
		return relief_id;
	}



	public void setRelief_id(String relief_id) {
		this.relief_id = relief_id;
	}



	public String getItem_name() {
		return item_name;
	}



	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}



	public String getItem_unit() {
		return item_unit;
	}



	public void setItem_unit(String item_unit) {
		this.item_unit = item_unit;
	}



	public Double getItem_price() {
		return item_price;
	}



	public void setItem_price(Double itme_price) {
		this.item_price = itme_price;
	}



	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", relief_id=" + relief_id + ", item_name=" + item_name + ", item_unit="
				+ item_unit + ", itme_price=" + item_price + "]";
	}
	
	

}
