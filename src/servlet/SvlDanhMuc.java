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
 * Servlet implementation class SvlDanhMuc
 */
@WebServlet("/SvlDanhMuc")
public class SvlDanhMuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvlDanhMuc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("tag", id);
		HomePageController hc = new HomePageController();
		ArrayList<SanPham> listSP = hc.getLoai(id);
		request.setAttribute("listSanPham", listSP);
		ArrayList<DanhMuc> listDM = hc.getAllDanhMuc();
		request.setAttribute("listDanhMuc", listDM);
		ServletContext sc = request.getSession().getServletContext();
		String url = "/index.jsp";
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
