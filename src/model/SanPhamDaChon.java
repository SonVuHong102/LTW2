package model;

public class SanPhamDaChon {
	private int id;
	private String hinhanh;
	private String ten;
	private int gia;
	private int soluong;
	public SanPhamDaChon(int id,String hinhanh, String ten, int gia, int soluong) {
		super();
		this.id = id;
		this.hinhanh = hinhanh;
		this.ten = ten;
		this.gia = gia;
		this.soluong = soluong;
	}
	
	public int getId() {
		return id;
	}

	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	
	
}
