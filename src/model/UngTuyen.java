package model;

public class UngTuyen {
	private String ten;
	private String email;
	private String sdt;
	public UngTuyen(String ten, String email, String sdt) {
		this.ten = ten;
		this.email = email;
		this.sdt = sdt;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	
}
