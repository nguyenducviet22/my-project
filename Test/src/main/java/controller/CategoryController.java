package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
 * Servlet implementation class Category
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cateId = request.getParameter("cid");
		ProductDao productDao = new ProductDao();
//		CategoryDao cateDao = new CategoryDao();
		
		List<Product> list = productDao.selectProductByCId(cateId);
//		request.setAttribute("listP", list);
//		
//		List<Category> listC = cateDao.selectAll();
//		request.setAttribute("listC", listC);
//		
//		Product latest = productDao.selectLatestProduct();
//		request.setAttribute("latest", latest);
//		
//		request.getRequestDispatcher("/home.jsp").forward(request, response);
		
		PrintWriter out = response.getWriter();
		for (Product o : list) {
			out.println("<div class=\"col-lg-4 col-md-6 md-4\">\r\n"
					+ "							<div class=\"card h-100\" style=\"width: 18rem;\">\r\n"
					+ "								<img src=\""+o.getImage()+"\" class=\"card-img-top\" alt=\""+o.getName()+"\">\r\n"
					+ "								<div class=\"card-body\">\r\n"
					+ "									<h5 class=\"card-title\">\r\n"
					+ "										<a href=\"detail?pid="+o.getId()+"\">"+o.getName()+"</a>\r\n"
					+ "									</h5>\r\n"
					+ "									<p class=\"card-text\">"+o.getPrice()+"</p>\r\n"
					+ "									<p class=\"card-text\">"+o.getTitle()+"</p>\r\n"
					+ "									<p class=\"card-text\">"+o.getDescription()+"</p>\r\n"
					+ "									<a href=\"#\" class=\"btn btn-primary\">Buy now</a>\r\n"
					+ "								</div>\r\n"
					+ "							</div>\r\n"
					+ "						</div>");
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
