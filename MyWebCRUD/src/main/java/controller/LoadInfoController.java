package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoJDBC.CategoryDao;
import daoJDBC.ProductDao;
import model.Category;
import model.Product;

/**
 * Servlet implementation class LoadInfoController
 */
@WebServlet("/loadInfo")
public class LoadInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadInfoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("pid");

		ProductDao productDao = new ProductDao();
		Product pro = productDao.selectById(id);
		request.setAttribute("detail", pro);
		
		CategoryDao cateDao = new CategoryDao();
		List<Category> listC = cateDao.selectAll();
		request.setAttribute("listC", listC);

		request.getRequestDispatcher("/editProduct.jsp").forward(request, response);
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
