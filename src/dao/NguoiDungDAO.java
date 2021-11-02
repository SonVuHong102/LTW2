package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.NguoiDung;

public class NguoiDungDAO extends DAO {
	public NguoiDungDAO() {
		this.con = getInstance();
	}

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public NguoiDung dangnhap(String user, String pass) {
		NguoiDung nd = null;
		try {
			String query = "SELECT * FROM nguoidung WHERE username = ? AND password = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if (rs.next()) {
				nd = new NguoiDung(rs.getInt("id"),user, pass, rs.getString("name"), rs.getString("email"), rs.getString("sdt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nd;

	}
	
	public boolean checkDangKy(String user,String sdt) {
		try {
			String query = "SELECT * FROM nguoidung WHERE username = ? OR sdt = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, sdt);
			rs = ps.executeQuery();
			if (!rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean dangky(NguoiDung nd) {
		try {
			String query = "INSERT INTO nguoidung(username,password,name,email,sdt) VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, nd.getUsername());
			ps.setString(2, nd.getPassword());
			ps.setString(3, nd.getName());
			ps.setString(4, nd.getEmail());
			ps.setString(5, nd.getSdt());
			int r = ps.executeUpdate();
			if (r != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
