package distributor.entity;

import java.sql.Blob;

import javax.servlet.http.Part;

public class Relief {
	private String relief_id;
	private String relief_name;
	private String relief_description;
	
	
	
	
	public Relief() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Relief(String relief_id, String relief_name, String relief_description) {
		super();
		this.relief_id = relief_id;
		this.relief_name = relief_name;
		this.relief_description = relief_description;
	}




	public String getRelief_id() {
		return relief_id;
	}




	public void setRelief_id(String relief_id) {
		this.relief_id = relief_id;
	}




	public String getRelief_name() {
		return relief_name;
	}




	public void setRelief_name(String relief_name) {
		this.relief_name = relief_name;
	}




	public String getRelief_description() {
		return relief_description;
	}




	public void setRelief_description(String relief_description) {
		this.relief_description = relief_description;
	}




	@Override
	public String toString() {
		return "Relief [relief_id=" + relief_id + ", relief_name=" + relief_name + ", relief_description="
				+ relief_description + "]";
	}
	
	
	
	
	
	
	

}
