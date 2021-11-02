package controller;

import java.util.ArrayList;
import java.util.Random;

import dao.DanhMucDAO;
import dao.SanPhamDAO;
import model.DanhMuc;
import model.SanPham;

public class HomePageController {
	public ArrayList<SanPham> getAllSanPham() {
		SanPhamDAO spd = new SanPhamDAO();
		return spd.getAllSanPham();
	}
	public ArrayList<DanhMuc> getAllDanhMuc() {
		DanhMucDAO dmd = new DanhMucDAO();
		return dmd.getAllDanhMuc();
	}
	public ArrayList<SanPham> getLoai(int id) {
		DanhMucDAO dmd = new DanhMucDAO();
		return dmd.getLoai(id);
	}
	public SanPham getSanPham(int id) {
		SanPhamDAO spd = new SanPhamDAO();
		return spd.getSanPham(id);
	}
	public ArrayList<SanPham> getDeNghi() {
		SanPhamDAO spd = new SanPhamDAO();
		ArrayList<SanPham> list = spd.getDeNghi();
		return list;
	}
}
