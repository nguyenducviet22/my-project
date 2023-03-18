package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoJDBC.AccountDao;
import model.Account;

/**
 * Servlet implementation class SignInController
 */
@WebServlet("/sign-in")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignInController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get username and password from cookie on the browser
		Cookie arr[] = request.getCookies();
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("cUsername")) {
					request.setAttribute("username", o.getValue());
				}
				if (o.getName().equals("cPassword")) {
					request.setAttribute("password", o.getValue());
				}
			}
		}
		// set username and password in sign in form
		request.getRequestDispatcher("signIn.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			String rememberMe = request.getParameter("remember");

			AccountDao accDao = new AccountDao();
			Account acc = accDao.signIn(username, password);
			if (acc == null) {
				request.setAttribute("error", "The username or password you entered is incorrect!");
				request.getRequestDispatcher("signIn.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("account", acc);
//				session.setMaxInactiveInterval(60);

				// save account on cookie
				Cookie cUser = new Cookie("cUsername", username);
				Cookie cPass = new Cookie("cPassword", password);
				cUser.setMaxAge(60*60);
				if (rememberMe != null) {
					cPass.setMaxAge(60);
				} else {
					cPass.setMaxAge(0);
				}
				
				response.addCookie(cUser);
				response.addCookie(cPass);

				response.sendRedirect("home");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
