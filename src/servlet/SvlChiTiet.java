package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.HomePageController;
import model.DanhMuc;
import model.SanPham;

/**
 * Servlet implementation class SvlChiTiet
 */
@WebServlet("/SvlChiTiet")
public class SvlChiTiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvlChiTiet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HomePageController hc = new HomePageController();
		SanPham sp = hc.getSanPham(id);	
		request.setAttribute("sp", sp);
		ArrayList<DanhMuc> listDM = hc.getAllDanhMuc();
		request.setAttribute("listDanhMuc", listDM);
		ServletContext sc = request.getSession().getServletContext();
		String url = "/Detail.jsp";
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
