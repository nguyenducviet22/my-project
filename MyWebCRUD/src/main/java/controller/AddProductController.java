package controller;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/add")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String image = request.getParameter("image");
			String price = request.getParameter("price");
			String amount = request.getParameter("amount");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String category = request.getParameter("category");
			HttpSession session = request.getSession();
			Account acc = (Account) session.getAttribute("account");
			int sid = acc.getId();
			
			ProductDao proDao = new ProductDao();
			proDao.insert(name, image, price, amount, title, description, category, sid);
			
			CategoryDao cateDao = new CategoryDao();
			List<Category> listC = cateDao.selectAll();
			request.setAttribute("listC", listC);
			
			response.sendRedirect("sell");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
