package controller;

import dao.NguoiDungDAO;
import model.NguoiDung;

public class LoginController {
	public NguoiDung dangnhap(String user,String pass) {
		NguoiDungDAO nd = new NguoiDungDAO();
		return nd.dangnhap(user, pass);
	}
	public boolean checkDangKy(String user,String sdt) {
		NguoiDungDAO nd = new NguoiDungDAO();
		return nd.checkDangKy(user,sdt);
	}
	public boolean dangky(NguoiDung nd) {
		NguoiDungDAO ndd = new NguoiDungDAO();
		return ndd.dangky(nd);
	}
}
