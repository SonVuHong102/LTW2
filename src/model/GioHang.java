package model;

public class GioHang {
	private int nguoidungID;
	private int sanphamID;
	private int soluong;
	public GioHang(int nguoidungID, int sanphamID, int soluong) {
		this.nguoidungID = nguoidungID;
		this.sanphamID = sanphamID;
		this.soluong = soluong;
	}
	public int getNguoidungID() {
		return nguoidungID;
	}
	public void setNguoidungID(int nguoidungID) {
		this.nguoidungID = nguoidungID;
	}
	public int getSanphamID() {
		return sanphamID;
	}
	public void setSanphamID(int sanphamID) {
		this.sanphamID = sanphamID;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public String toString() {
		return "GioHang [nguoidungID=" + nguoidungID + ", sanphamID=" + sanphamID + ", soluong="
				+ soluong + "]";
	}
	
	
}
