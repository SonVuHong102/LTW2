package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GioHang;

public class GioHangDAO extends DAO {
	
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public GioHangDAO() {
		this.con = getInstance();
	}
	
	public ArrayList<GioHang> getGioHang(int id) {
		ArrayList<GioHang> list = new ArrayList<GioHang>();
		try {
			String query = "SELECT sanphamID,SUM(soluong) soluong FROM donhang WHERE nguoidungID = ? GROUP BY sanphamID";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new GioHang(id,rs.getInt("sanphamID"),rs.getInt("soluong")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void giamDonHang(int nguoidungID,int sanphamID) {
		try {
			String query = "UPDATE donhang SET soluong = soluong-1 WHERE nguoidungID = ? AND sanphamID = ? ";
			ps = con.prepareStatement(query);
			ps.setInt(1, nguoidungID);
			ps.setInt(2, sanphamID);
			ps.executeUpdate();
			query = "DELETE FROM donhang WHERE soluong = 0";
			ps = con.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void tangDonHang(int nguoidungID,int sanphamID) {
		try {
			String query = "SELECT * FROM donhang WHERE nguoidungID = ? AND sanphamID = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, nguoidungID);
			ps.setInt(2, sanphamID);
			rs = ps.executeQuery();
			if (rs.next()) {
				query = "UPDATE donhang SET soluong = soluong+1 WHERE nguoidungID = ? AND sanphamID = ? ";
				ps = con.prepareStatement(query);
				ps.setInt(1, nguoidungID);
				ps.setInt(2, sanphamID);
				ps.executeUpdate();
			} else {
				query = "INSERT donhang(nguoidungID,sanphamID,soluong) VALUES (?,?,1)";
				ps = con.prepareStatement(query);
				ps.setInt(1, nguoidungID);
				ps.setInt(2, sanphamID);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void xoaDonHang(int nguoidungID,int sanphamID) {
		try {
			String query = "DELETE FROM donhang WHERE nguoidungID = ? AND sanphamID = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, nguoidungID);
			ps.setInt(2, sanphamID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void xoaAllDonHang(int nguoidungID) {
		try {
			String query = "DELETE FROM donhang WHERE nguoidungID = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, nguoidungID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
