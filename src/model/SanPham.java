package model;

public class SanPham {
	private int id;
	private String ten;
	private String tieude;
	private int gia;
	private String mota;
	private String hinhanh;
	private int danhmucID;
	private int tieuthu;
	public SanPham(int id, String ten, String tieude, int gia, String mota, String hinhanh, int danhmucID,int tieuthu) {
		super();
		this.id = id;
		this.ten = ten;
		this.tieude = tieude;
		this.gia = gia;
		this.mota = mota;
		this.hinhanh = hinhanh;
		this.danhmucID = danhmucID;
		this.tieuthu = tieuthu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTieude() {
		return tieude;
	}
	public void setTieude(String tieude) {
		this.tieude = tieude;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public int getDanhmucID() {
		return danhmucID;
	}
	public void setDanhmucID(int danhmucID) {
		this.danhmucID = danhmucID;
	}
	public int getTieuthu() {
		return tieuthu;
	}
	public void setTieuthu(int tieuthu) {
		this.tieuthu = tieuthu;
	}
	@Override
	public String toString() {
		return "SanPham [id=" + id + ", ten=" + ten + ", tieude=" + tieude + ", gia=" + gia + ", mota=" + mota
				+ ", hinhanh=" + hinhanh + ", danhmucID=" + danhmucID + "]";
	}
}
