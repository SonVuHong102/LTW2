package model;

public class NguoiDung {
	private int id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String sdt;
	public NguoiDung(int id,String username, String password, String name, String email, String sdt) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.sdt = sdt;
	}
	
	public NguoiDung(String username, String password, String name, String email, String sdt) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.sdt = sdt;
	}

	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "NguoiDung [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", sdt=" + sdt + "]";
	}
}
