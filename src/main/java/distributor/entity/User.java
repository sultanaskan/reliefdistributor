package distributor.entity;


import javax.servlet.http.Part;

public class User {
	private String user_id;
	private String user_name;
	private String user_nid;
	private String user_phone;
	private String user_email;
	private String user_password;
	private String user_country;
	private String user_division;
	private String user_district;
	private String user_upazila;
	private String user_union;
	private String user_word;
	private Part user_photo;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String user_id, String user_name, String user_nid, String user_phone, String user_email,
			String user_password, String user_country, String user_division, String user_district, String user_upazila,
			String user_union, String user_word, Part user_photo) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_nid = user_nid;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_country = user_country;
		this.user_division = user_division;
		this.user_district = user_district;
		this.user_upazila = user_upazila;
		this.user_union = user_union;
		this.user_word = user_word;
		this.user_photo = user_photo;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_nid() {
		return user_nid;
	}


	public void setUser_nid(String user_nid) {
		this.user_nid = user_nid;
	}


	public String getUser_phone() {
		return user_phone;
	}


	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getUser_country() {
		return user_country;
	}


	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}


	public String getUser_division() {
		return user_division;
	}


	public void setUser_division(String user_division) {
		this.user_division = user_division;
	}


	public String getUser_district() {
		return user_district;
	}


	public void setUser_district(String user_district) {
		this.user_district = user_district;
	}


	public String getUser_upazila() {
		return user_upazila;
	}


	public void setUser_upazila(String user_upazila) {
		this.user_upazila = user_upazila;
	}


	public String getUser_union() {
		return user_union;
	}


	public void setUser_union(String user_union) {
		this.user_union = user_union;
	}


	public String getUser_word() {
		return user_word;
	}


	public void setUser_word(String user_word) {
		this.user_word = user_word;
	}


	public Part getUser_photo() {
		return user_photo;
	}


	public void setUser_photo(Part user_photo) {
		this.user_photo = user_photo;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_nid=" + user_nid + ", user_phone="
				+ user_phone + ", user_email=" + user_email + ", user_password=" + user_password + ", user_country="
				+ user_country + ", user_division=" + user_division + ", user_district=" + user_district
				+ ", user_upazila=" + user_upazila + ", user_union=" + user_union + ", user_word=" + user_word
				+ ", user_photo=" + user_photo + "]";
	}
	
	
	
	
	
	

}
