package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.GioHangController;
import model.NguoiDung;

/**
 * Servlet implementation class SvlTang
 */
@WebServlet("/SvlTang")
public class SvlTang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvlTang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sanphamID = Integer.parseInt((String)request.getParameter("sanphamID"));
		HttpSession session = request.getSession();
		int nguoidungID = ((NguoiDung) session.getAttribute("nguoidung")).getId();
		GioHangController ghc = new GioHangController();
		ghc.tangDonHang(nguoidungID, sanphamID);
		ServletContext sc = session.getServletContext();
		String url = "/SvlGioHang";
		sc.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
