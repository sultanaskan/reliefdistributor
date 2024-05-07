package distributor.entity;

import java.sql.Date;

public class ReliefMember {
	private String relief_member_id;
	private String relief_id;
	private String user_id;
	private String role;
	private String representative_id;
	private int collection_code;
	private String collection_status;
	
	
	
	public ReliefMember() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ReliefMember(String relief_member_id, String relief_id, String user_id, String role,
			String representative_id, int collection_code, String collection_status) {
		super();
		this.relief_member_id = relief_member_id;
		this.relief_id = relief_id;
		this.user_id = user_id;
		this.role = role;
		this.representative_id = representative_id;
		this.collection_code = collection_code;
		this.collection_status = collection_status;
	}



	public String getRelief_member_id() {
		return relief_member_id;
	}



	public void setRelief_member_id(String relief_member_id) {
		this.relief_member_id = relief_member_id;
	}



	public String getRelief_id() {
		return relief_id;
	}



	public void setRelief_id(String relief_id) {
		this.relief_id = relief_id;
	}



	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getRepresentative_id() {
		return representative_id;
	}



	public void setRepresentative_id(String representative_id) {
		this.representative_id = representative_id;
	}



	public int getCollection_code() {
		return collection_code;
	}



	public void setCollection_code(int collection_code) {
		this.collection_code = collection_code;
	}



	public String getCollection_status() {
		return collection_status;
	}



	public void setCollection_status(String collection_status) {
		this.collection_status = collection_status;
	}



	@Override
	public String toString() {
		return "ReliefMember [relief_member_id=" + relief_member_id + ", relief_id=" + relief_id + ", user_id="
				+ user_id + ", role=" + role + ", representative_id=" + representative_id + ", collection_code="
				+ collection_code + ", collection_status=" + collection_status + "]";
	}
	
	
	
	
	
	

}
