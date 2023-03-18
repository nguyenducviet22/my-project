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
@WebServlet("/seller")
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("account");
		
		int id = acc.getId();
		
		ProductDao proDao = new ProductDao();
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		
		List<Category> listC = cateDao.selectAll();
		request.setAttribute("listC", listC);
		
		Product latest = productDao.selectLatestProduct();
		request.setAttribute("latest", latest);
		
		List<Product> list = proDao.selectProductBySell(id);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/manageProduct.jsp");
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
