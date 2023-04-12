package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoJDBC.CategoryDao;
import daoJDBC.ProductDao;
import model.Account;
import model.Category;
import model.Product;

/**
 * Servlet implementation class Seller
 */
@WebServlet("/sell")
public class SellController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Account acc = (Account) session.getAttribute("account");
			int id = acc.getId();

			CategoryDao cateDao = new CategoryDao();
			List<Category> listC = cateDao.selectAll();
			request.setAttribute("listC", listC);

			ProductDao proDao = new ProductDao();
			List<Product> list = proDao.selectProductBySell(id);
			request.setAttribute("list", list);

			request.getRequestDispatcher("/sellProduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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

}
