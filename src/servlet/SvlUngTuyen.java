package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UngTuyenDAO;
import model.UngTuyen;

/**
 * Servlet implementation class SvlUngTuyen
 */
@WebServlet("/SvlUngTuyen")
public class SvlUngTuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvlUngTuyen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String) request.getParameter("name");
		String email = (String) request.getParameter("email");
		String sdt = (String) request.getParameter("sdt");
		UngTuyen ut = new UngTuyen(name,email,sdt);
		UngTuyenDAO utd = new UngTuyenDAO();
		utd.them(ut);
		response.sendRedirect("SvlHomePage");
	}

}
