package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.NguoiDung;
import model.UngTuyen;

public class UngTuyenDAO extends DAO {
	
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public UngTuyenDAO() {
		this.con = getInstance();
	}

	public void them(UngTuyen ut) {
		try {
			String query = "INSERT INTO ungtuyen(ten,email,sdt) VALUES (?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, ut.getTen());
			ps.setString(2, ut.getEmail());
			ps.setString(3, ut.getSdt());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
