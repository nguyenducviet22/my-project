package daoHQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Category;
import model.Product;
import util.JDBCUtil;

public class Dao {

	// #1 create connection with CSDL
	Connection con = null;
	// #2 create SQL command and PreparedStatement
	PreparedStatement pst = null;
	// #3 conduct SQL command
	ResultSet rs = null;

	public List<Product> selectAllProduct() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<Category> selectAllCategory() {
		List<Category> list = new ArrayList<Category>();
		String sql = "select * from category";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public Product selectLatestProduct() {
		String sql = "select * from product\r\n"
				+ "order by id desc limit 1";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> selectProductByCId(String cid) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product\r\n" + "where cateId = ?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, cid);
			System.out.println(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public Product selectProductById(String id) {
		String sql = "select * from product\r\n" + "where id = ?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			System.out.println(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> searchProductByName(String txtSearch) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product\r\n" + "where name like ?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + txtSearch + "%");
			System.out.println(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public Account Login(String user, String pass) {
		String sql = "select * from account where username=? and password=?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, pass);
			System.out.println(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public ArrayList<Product> selectTop3() {
		ArrayList<Product> list = new ArrayList<Product>();
		String sql = "select * from product\r\n" + "order by id desc limit 3";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		Dao proDao = new Dao();
//		List<Product> list = proDao.selectAllProduct();
//		for (Product product : list) {
//			System.out.println(product);
//		}
		
//		List<Category> list = proDao.selectAllCategory();
//		for (Category category : list) {
//			System.out.println(category);
//		}
		
		Product product = proDao.selectLatestProduct();
		System.out.println(product);
	}
}
