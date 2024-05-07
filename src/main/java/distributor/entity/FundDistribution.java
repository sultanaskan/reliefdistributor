package distributor.entity;

import java.sql.Date;

public class FundDistribution {
	private String fund_distribution_id;
	private String relief_id;
	private String fund_distributor_id;
	private String fund_collector_id;
	private String item_id;
	private Double item_quantity;
	private Date date;
	private String status;
	
	
	
	public FundDistribution() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FundDistribution(String fund_distribution_id, String relief_id, String fund_distributor_id,
			String fund_collector_id, String item_id, Double item_quantity, Date date, String status) {
		super();
		this.fund_distribution_id = fund_distribution_id;
		this.relief_id = relief_id;
		this.fund_distributor_id = fund_distributor_id;
		this.fund_collector_id = fund_collector_id;
		this.item_id = item_id;
		this.item_quantity = item_quantity;
		this.date = date;
		this.status = status;
	}



	public String getFund_distribution_id() {
		return fund_distribution_id;
	}



	public void setFund_distribution_id(String fund_distribution_id) {
		this.fund_distribution_id = fund_distribution_id;
	}



	public String getRelief_id() {
		return relief_id;
	}



	public void setRelief_id(String relief_id) {
		this.relief_id = relief_id;
	}



	public String getFund_distributor_id() {
		return fund_distributor_id;
	}



	public void setFund_distributor_id(String fund_distributor_id) {
		this.fund_distributor_id = fund_distributor_id;
	}



	public String getFund_collector_id() {
		return fund_collector_id;
	}



	public void setFund_collector_id(String fund_collector_id) {
		this.fund_collector_id = fund_collector_id;
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



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "FundDistribution [fund_distribution_id=" + fund_distribution_id + ", relief_id=" + relief_id
				+ ", fund_distributor_id=" + fund_distributor_id + ", fund_collector_id=" + fund_collector_id
				+ ", item_id=" + item_id + ", item_quantity=" + item_quantity + ", date=" + date + ", status=" + status
				+ "]";
	}
	
	
	
	
	
}
