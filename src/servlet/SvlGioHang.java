package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.GioHangController;
import model.GioHang;
import model.NguoiDung;
import model.SanPhamDaChon;

/**
 * Servlet implementation class SvlGioHang
 */
@WebServlet("/SvlGioHang")
public class SvlGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvlGioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NguoiDung nd = (NguoiDung) session.getAttribute("nguoidung");
		if(nd == null) {
			response.sendRedirect("Login.jsp");
		} else {
			GioHangController ghc = new GioHangController();
			ArrayList<GioHang> listGH = ghc.getGioHang(nd.getId());
			ArrayList<SanPhamDaChon> listDC = ghc.getDaChon(listGH);
			session.setAttribute("listDC", listDC);
			int tongtien = ghc.tongtien(listDC);
			session.setAttribute("tongtien", tongtien);
			ServletContext sc = session.getServletContext();
			String url = "/Cart.jsp";
			sc.getRequestDispatcher(url).forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
