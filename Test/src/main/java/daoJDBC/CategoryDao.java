package daoJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import util.JDBCUtil;

public class CategoryDao implements InterfaceDao<Category> {
	// #1 create connection with CSDL
	Connection con = null;
	// #2 create SQL command and PreparedStatement
	PreparedStatement pst = null;
	// #3 conduct SQL command
	ResultSet rs = null;

	@Override
	public List<Category> selectAll() {
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

	@Override
	public Category selectById(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category insert(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category delete(Category t) {
		String sql = "delete from category where cid=?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, t.getCid());
			System.out.println(sql);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		CategoryDao cateDao = new CategoryDao();
		
		List<Category> list = cateDao.selectAll();
		for (Category category : list) {
			System.out.println(category);
		}
//		Category cate = new Category(3, "");
//		cateDao.delete(cate);
	}
	
}
