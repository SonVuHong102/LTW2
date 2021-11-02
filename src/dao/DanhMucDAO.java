package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DanhMuc;
import model.SanPham;

public class DanhMucDAO extends DAO {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
    
    public DanhMucDAO() {
    	this.con = getInstance();
    }
    
    public ArrayList<DanhMuc> getAllDanhMuc() {
    	ArrayList<DanhMuc> list = new ArrayList<DanhMuc>();
    	try {
    		String query = "SELECT * FROM danhmuc";
    		ps = con.prepareStatement(query);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			list.add(new DanhMuc(
    							rs.getInt("id"),
    							rs.getString("ten")));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return list;
    }
    
    public ArrayList<SanPham> getLoai(int id) {
    	ArrayList<SanPham> list = new ArrayList<SanPham>();
    	try {
    		String query = "SELECT * FROM sanpham WHERE danhmucID = ?";
    		ps = con.prepareStatement(query);
    		ps.setInt(1, id);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			list.add(new SanPham(
						rs.getInt("id"),
						rs.getString("ten"),
						rs.getString("tieude"),
						rs.getInt("gia"),
						rs.getString("mota"),
						rs.getString("hinhanh"),
						rs.getInt("danhmucID"),
						rs.getInt("tieuthu")));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return list;
    }

}
