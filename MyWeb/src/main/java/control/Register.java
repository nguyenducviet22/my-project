package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao_db.CustomerDao;
import model.Customer;

/**
 * Servlet implementation class Register
 */
@WebServlet("/do-register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String reenteredPassword = request.getParameter("reenteredPassword");
		String fullName = request.getParameter("fullName");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String address = request.getParameter("address");
		String receivedAddress = request.getParameter("receivedAddress");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		
		//keep values have entered in register form
		request.setAttribute("username", username);
		request.setAttribute("fullName", fullName);
		request.setAttribute("gender", gender);
		request.setAttribute("dateOfBirth", dateOfBirth);
		request.setAttribute("address", address);
		request.setAttribute("receivedAddress", receivedAddress);
		request.setAttribute("phoneNumber", phoneNumber);
		request.setAttribute("email", email);
		
		String url = "";
		String error = "";
		CustomerDao cusDao = new CustomerDao();
		if(cusDao.checkUsername(username)) {
			error += "The username was in existence.<br/>";
		}
		
		if(!password.equals(reenteredPassword)) {
			error += "The passwords you have entered do not match.<br/>";
		}
		
		if(error.length() > 0) {
			url = "/register.jsp";
		} else {
			String customerCode = System.currentTimeMillis() + "";
			Customer cus = new Customer(customerCode, username, password, fullName, gender, address, receivedAddress, Date.valueOf(dateOfBirth), phoneNumber, email);
			cusDao.insert(cus);
			url = "/index.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
