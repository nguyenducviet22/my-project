package daoJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import util.JDBCUtil;

public class AccountDao implements InterfaceDao<Account> {
	// #1 create connection with CSDL
	Connection con = null;
	// #2 create SQL command and PreparedStatement
	PreparedStatement pst = null;
	// #3 conduct SQL command
	ResultSet rs = null;

	@Override
	public List<Account> selectAll() {
		List<Account> list = new ArrayList<Account>();
		String sql = "select * from account";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			System.out.println(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), rs.getInt(12)));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Account selectById(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account selectById(String id) {
		String sql = "select * from account\r\n" + "where id = ?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			System.out.println(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), rs.getInt(12));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account insert(Account t) {//register
		String sql = "insert into account (id, username, password, fullName, gender, address, receivedAddress, dateOfBirth, phoneNumber, email, isSell, isAdmin)"
				+ "value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, t.getId());
			pst.setString(2, t.getUsername());
			pst.setString(3, t.getPassword());
			pst.setString(4, t.getFullName());
			pst.setString(5, t.getGender());
			pst.setString(6, t.getAddress());
			pst.setString(7, t.getReceivedAddress());
			pst.setDate(8, t.getDateOfBirth());
			pst.setString(9, t.getPhoneNumber());
			pst.setString(10, t.getEmail());
			pst.setInt(11, t.getIsSell());
			pst.setInt(12, t.getIsAdmin());
			System.out.println(sql);
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account update(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account delete(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account signIn(String user, String pass) {
		String sql = "select * from account where username=? and password=?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, pass);
			System.out.println(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), rs.getInt(12));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkUsername(String user) {
		boolean result = false;
		String sql = "select * from account where username=?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, user);
			System.out.println(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = true;
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean changePassword(Account t) {
		int result = 0;
		String sql = "update customer " + " set " + " password = ?" + " where customer_code = ?";
		try {
			con = JDBCUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, t.getPassword());
			System.out.println(sql);
			result = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result > 0;
	}

}
