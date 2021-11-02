package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LoginController;
import model.NguoiDung;

/**
 * Servlet implementation class SvlDangNhap
 */
@WebServlet("/SvlDangNhap")
public class SvlDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvlDangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		LoginController lc = new LoginController();
		NguoiDung nd = lc.dangnhap(user, pass);
		if(nd == null) {
			request.setAttribute("mess", "Sai tài khoản hoặc mật khẩu");
			ServletContext sc = request.getSession().getServletContext();
			sc.getRequestDispatcher("/Login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("nguoidung", nd);
			response.sendRedirect("SvlHomePage");
		}
		
	}

}
