package daoJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import util.JDBCUtil;

public class ProductDao {
	// #1 create connection with CSDL
	Connection con = null;
	// #2 create SQL command and PreparedStatement
	PreparedStatement pst = null;
	// #3 conduct SQL command
	ResultSet rs = null;

	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7)));
			}
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
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
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
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7)));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
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
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7)));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
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
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
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
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7)));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
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
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7)));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insert(String name, String image, String price, String amount, String title, String description,
			String category, int sid) {
		String sql = "insert into product (name, image, price, amount, title, description, cateId, accId)"
				+ "value (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			pst.setString(1, name);
			pst.setString(2, image);
			pst.setString(3, price);
			pst.setString(4, amount);
			pst.setString(5, title);
			pst.setString(6, description);
			pst.setString(7, category);
			pst.setInt(8, sid);
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(String name, String image, String price, String amount, String title, String description,
			String category, String pid) {
		String sql = "update product " + " set " + " name = ?" + ", image = ?" + ", price = ?" + ", amount = ?"
				+ ", title = ?" + ", description = ?" + ", cateId = ?" + " where id = ?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			pst.setString(1, name);
			pst.setString(2, image);
			pst.setString(3, price);
			pst.setString(4, amount);
			pst.setString(5, title);
			pst.setString(6, description);
			pst.setString(7, category);
			pst.setString(8, pid);
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String pid) {
		String sql = "delete from product where id=?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, pid);
			System.out.println(sql);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
