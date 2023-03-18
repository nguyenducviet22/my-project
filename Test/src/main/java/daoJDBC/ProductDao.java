package daoJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import util.JDBCUtil;

public class ProductDao implements InterfaceDao<Product> {
	// #1 create connection with CSDL
	Connection con = null;
	// #2 create SQL command and PreparedStatement
	PreparedStatement pst = null;
	// #3 conduct SQL command
	ResultSet rs = null;

	@Override
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6),
						rs.getString(7)));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Product selectLatestProduct() {
		String sql = "select * from product\r\n" + "order by id desc limit 1";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6),
						rs.getString(7));
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
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6),
						rs.getString(7)));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Product> selectProductBySell(int isSell) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product\r\n" + "where accId = ?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, isSell);
			System.out.println(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6),
						rs.getString(7)));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public Product selectById(String id) {
		String sql = "select * from product\r\n" + "where id = ?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			System.out.println(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6),
						rs.getString(7));
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
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6),
						rs.getString(7)));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
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
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6),
						rs.getString(7)));
			}
			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product insert(Product t) {
		String sql = "insert into product (id, name, image, price, title, description)" + "value (?, ?, ?, ?, ?, ?)";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			pst.setInt(1, t.getId());
			pst.setString(2, t.getName());
			pst.setString(3, t.getImage());
			pst.setDouble(4, t.getPrice());
			pst.setString(5, t.getTitle());
			pst.setString(6, t.getDescription());
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product selectById(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product delete(Product t) {
		String sql = "delete from product where id=?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, t.getId());
			System.out.println(sql);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();

//		List<Product> list = productDao.selectAll();
//		System.out.println("GET ALL PRODUCTS:");
//		for (Product product : list) {
//			System.out.println(product);
//		}
//
//		Product product = productDao.selectLatestProduct();
//		System.out.println("GET THE LATEST PRODUCTS:");
//		System.out.println(product);
//
//		List<Product> list2 = productDao.selectProductByCId("2");
//		System.out.println("GET PRODUCTS BY CID:");
//		for (Product product2 : list2) {
//			System.out.println(product2);
//		}

		Product product2 = productDao.selectById("3");
		System.out.println("GET PRODUCTS BY ID:");
		System.out.println(product2);

//		List<Product> list3 = productDao.searchProductByName("Nike");
//		System.out.println("SEARCH PRODUCTS:");
//		for (Product product3 : list3) {
//			System.out.println(product3);
//		}
//		
//		List<Product> list4 = productDao.selectTop3();
//		System.out.println("GET TOP 3:");
//		for (Product product4 : list4) {
//			System.out.println(product4);
//		}

//		Product product = new Product(13, "Shirt Zara 2000",
//				"https://tse4.mm.bing.net/th?id=OIP.7nsFU3j1UvBsS5avXNcl_AHaJe&pid=Api&P=0", 300.0, "Shirt",
//				"Beautiful");
//		productDao.insert(product);
//		
//		Product pro = new Product(13, "", "", null, "", "");
//		productDao.delete(pro);
	}
}
