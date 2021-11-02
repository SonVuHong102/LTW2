package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;
import model.NguoiDung;

/**
 * Servlet implementation class SvlDangKy
 */
@WebServlet("/SvlDangKy")
public class SvlDangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvlDangKy() {
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
		String repass = request.getParameter("repass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		String url = "/SvlHomePage";
		if(!pass.equals(repass)) {
			request.setAttribute("mess", "Mật khẩu không khớp");
			url = "/Login.jsp";
		} else {
			LoginController lc = new LoginController();
			if(!lc.checkDangKy(user, sdt)) {
				request.setAttribute("mess", "Tên đăng nhập hoặc sdt đã tồn tại");
				url = "/Login.jsp";
			} else {
				NguoiDung nd = new NguoiDung(user,pass,name,email,sdt);
				if(!lc.dangky(nd)) {
					request.setAttribute("mess", "Không thể đăng ký tại thời điểm hiện tại");
					url = "/Login.jsp";
				} else {
					request.setAttribute("nguoidung", nd);
				}
			}
		}
		ServletContext sc = request.getSession().getServletContext();
		sc.getRequestDispatcher(url).forward(request, response);
	}

}
