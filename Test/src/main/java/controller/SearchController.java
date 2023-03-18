package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class SearchControl
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtSearch = request.getParameter("txt"); //name="txt"
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		
		List<Product> list = productDao.searchProductByName(txtSearch);
		request.setAttribute("listP", list);
		request.setAttribute("searchValue", txtSearch);
		
		List<Category> listC = cateDao.selectAll();
		request.setAttribute("listC", listC);
		
		Product latest = productDao.selectLatestProduct();
		request.setAttribute("latest", latest);
		
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
