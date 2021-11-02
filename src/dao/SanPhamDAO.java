package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import model.SanPham;

public class SanPhamDAO extends DAO {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public SanPhamDAO() {
		this.con = getInstance();
	}

	public ArrayList<SanPham> getAllSanPham() {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			String query = "SELECT * FROM sanpham";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new SanPham(rs.getInt("id"), rs.getString("ten"), rs.getString("tieude"), rs.getInt("gia"),
						rs.getString("mota"), rs.getString("hinhanh"), rs.getInt("danhmucID"),rs.getInt("tieuthu")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public SanPham getSanPham(int id) {
		SanPham sp = null;
		try {
			String query = "SELECT * FROM sanpham WHERE id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				sp = new SanPham(rs.getInt("id"), rs.getString("ten"), rs.getString("tieude"), rs.getInt("gia"),
						rs.getString("mota"), rs.getString("hinhanh"), rs.getInt("danhmucID"),rs.getInt("tieuthu"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sp;
	}
	
	public ArrayList<SanPham> getDeNghi() {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			String query = "SELECT * FROM sanpham ORDER BY tieuthu DESC LIMIT 3";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new SanPham(rs.getInt("id"), rs.getString("ten"), rs.getString("tieude"), rs.getInt("gia"),
						rs.getString("mota"), rs.getString("hinhanh"), rs.getInt("danhmucID"),rs.getInt("tieuthu")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
