package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoJDBC.AccountDao;
import model.Account;
import util.Encoding;

/**
 * Servlet implementation class CusControl
 */
@WebServlet("/account-controller")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		switch (act) {
		case "sign-in":
			signIn(request, response);
			break;
		case "sign-out":
			signOut(request, response);
			break;
		case "register":
			register(request, response);
			break;
		case "change-password":
			changePassword(request, response);
			break;
		case "change-info":
			changeInfo(request, response);
			break;
		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void signIn(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("user");
			String password = request.getParameter("pass");

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

				cUser.setMaxAge(100);
				cPass.setMaxAge(100);

				response.addCookie(cUser);
				response.addCookie(cPass);

				

				response.sendRedirect("home");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void signOut(HttpServletRequest request, HttpServletResponse response) {
		try {
//			HttpSession session = request.getSession();
//			//stop connecting with website
//			session.invalidate();
//			session.removeAttribute("account");
			request.getSession().invalidate();
			response.sendRedirect("home");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			String rePassword = request.getParameter("repass");
			String fullName = request.getParameter("fullName");
			String gender = request.getParameter("gender");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String address = request.getParameter("address");
			String receivedAddress = request.getParameter("receivedAddress");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");

			request.setAttribute("username", username);
			request.setAttribute("fullName", fullName);
			request.setAttribute("gender", gender);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("address", address);
			request.setAttribute("receivedAddress", receivedAddress);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("email", email);

			String error = "";
			AccountDao accDao = new AccountDao();
			if (accDao.checkUsername(username)) {
				error += "The username was in existence.<br/>";
			}
			if (!password.equals(rePassword)) {
				error += "The passwords you entered do not match.<br/>";
			}
			request.setAttribute("error", error);
			if (error.length() > 0) {
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else {
				int id = (int) System.currentTimeMillis() * -1;
				Account newAccount = new Account(id, username, password, fullName, gender, address, receivedAddress,
						Date.valueOf(dateOfBirth), phoneNumber, email, 0, 0);
				accDao.insert(newAccount);
				response.sendRedirect("home");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			String oldPassword = request.getParameter("oldPass");
			String newPassword = request.getParameter("newPass");
			String newRepassword = request.getParameter("newRepass");

			HttpSession session = request.getSession();
			Account account = (Account) session.getAttribute("account");

			AccountDao accDao = new AccountDao();
			// check old and new password
			if (account == null) {
				request.setAttribute("error", "You need to sign in the system first.");
				request.getRequestDispatcher("signIn.jsp").forward(request, response);
			} else {
				// When cus successfully signed in
				if (!oldPassword.equals(account.getPassword())) {
					request.setAttribute("error", "Your old password is inaccurate");
					request.getRequestDispatcher("changePassword.jsp").forward(request, response);
				} else {
					if (!newPassword.equals(newRepassword)) {
						request.setAttribute("error", "The new password and new re-passowrd you entered do not match.");
						request.getRequestDispatcher("changePassword.jsp").forward(request, response);
					} else {
						account.setPassword(newPassword);
						if (accDao.changePassword(account)) {
							request.setAttribute("error", "You have changed your password");
							request.getRequestDispatcher("home").forward(request, response);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void changeInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			String fullName = request.getParameter("fullName");
			String gender = request.getParameter("gender");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String address = request.getParameter("address");
			String receivedAddress = request.getParameter("receivedAddress");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");

			request.setAttribute("fullName", fullName);
			request.setAttribute("gender", gender);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("address", address);
			request.setAttribute("receivedAddress", receivedAddress);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("email", email);

			String url = "";
			String error = "";
			AccountDao accDao = new AccountDao();
			request.setAttribute("error", error);
			// other errors
			if (error.length() > 0) {
				url = "/register.jsp";
			} else {
				Object obj = request.getSession().getAttribute("account");
				Account account = null;
				if (obj != null)
					account = (Account) obj;
				if (account != null) {
					String customerCode = account.getCustomerCode();
					Account oldCustomer = new Account(customerCode, "", "", fullName, gender, address, receivedAddress,
							Date.valueOf(dateOfBirth), phoneNumber, email);
					accDao.updateInfo(oldCustomer);
					Account updateCustomer = accDao.selectById(oldCustomer);
					request.getSession().setAttribute("account", updateCustomer);
					url = "/html.jsp";
				}
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
