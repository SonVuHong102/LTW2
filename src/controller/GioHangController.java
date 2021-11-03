package controller;

import java.util.ArrayList;

import dao.GioHangDAO;
import dao.SanPhamDAO;
import model.GioHang;
import model.SanPham;
import model.SanPhamDaChon;

public class GioHangController {
	public ArrayList<GioHang> getGioHang(int id) {
		GioHangDAO ghd = new GioHangDAO();
		return ghd.getGioHang(id);
	}

	public ArrayList<SanPhamDaChon> getDaChon(ArrayList<GioHang> gh) {
		 ArrayList<SanPhamDaChon> dc = new ArrayList<SanPhamDaChon>();
		 SanPhamDAO spd = new SanPhamDAO();
		 for(GioHang i : gh) {
			 SanPham sp = spd.getSanPham(i.getSanphamID());
			 dc.add(new SanPhamDaChon(sp.getId(),sp.getHinhanh(),sp.getTen(),sp.getGia(),i.getSoluong()));
		 }
		 return dc;
	}

	public int tongtien(ArrayList<SanPhamDaChon> list) {
		int s = 0;
		for (SanPhamDaChon i : list) {
			s += i.getGia()*i.getSoluong();
		}
		return s;
	}
	
	public void giamDonHang(int khachhangID,int sanphamID) {
		GioHangDAO ghd = new GioHangDAO();
		ghd.giamDonHang(khachhangID, sanphamID);
	}
	
	public void tangDonHang(int khachhangID,int sanphamID) {
		GioHangDAO ghd = new GioHangDAO();
		ghd.tangDonHang(khachhangID, sanphamID);
	}
	
	public void xoaDonHang(int khachhangID,int sanphamID) {
		GioHangDAO ghd = new GioHangDAO();
		ghd.xoaDonHang(khachhangID, sanphamID);
	}
	
	public void xoaAllDonHang(int khachhangID) {
		GioHangDAO ghd = new GioHangDAO();
		ghd.xoaAllDonHang(khachhangID);
	}

}
