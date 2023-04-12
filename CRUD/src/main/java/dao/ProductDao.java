package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Product> getAll() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			System.out.println(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6)));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Product getById(String id) {
		String sql = "select * from product where id = ?";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(String name, String image, String price, String amount, String description) {
		String sql = "insert into product (name, image, price, amount, description)" + "value (?, ?, ?, ?, ?)";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, amount);
			ps.setString(5, description);
			ps.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(String name, String image, String price, String amount, String description, String pid) {
		String sql = "update product " + " set " + " name = ?" + ", image = ?" + ", price = ?" + ", amount = ?"
				+ ", description = ?" + " where id = ?";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, amount);
			ps.setString(5, description);
			ps.setString(6, pid);
			ps.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		String sql = "delete from product where id = ?";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Product> search(String name) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where name like ?";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			System.out.println(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6)));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		ProductDao proDao = new ProductDao();
//		List<Product> list = proDao.getAll();
//		for (Product product : list) {
//			System.out.println(product);
//		}

//		Product pro = proDao.getById("1");
//		System.out.println(pro);

//		proDao.insert("Adidas", "https://tse1.mm.bing.net/th?id=OIP.TqRgd0FAlCJEdKQrIgyqtAHaE8&pid=Api&P=0",
//				"500", "100", "Nice");

//		proDao.delete("7");

//		proDao.update("Nike 2021", "https://tse4.mm.bing.net/th?id=OIP.ylicPoufhPEw6w2urnvAqAHaFN&pid=Api&P=0", "550",
//				"100", "Luxury", "5");
		
		List<Product> list = proDao.search("Nike");
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
