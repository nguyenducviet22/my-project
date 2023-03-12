package dao_db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import util.HibernateUtil;
import util.JDBCUtil;

public class CustomerDao implements InterfaceDao<Customer> {

	@Override
	public List<Customer> selectAll() {
		List<Customer> list = new ArrayList<Customer>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from customer";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String customerCode = rs.getString("customer_code");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String receivedAddress = rs.getString("receivedAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");

				Customer customer = new Customer(customerCode, username, password, fullName, gender, address,
						receivedAddress, dateOfBirth, phoneNumber, email);
				list.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer selectById(Customer t) {
		List<Customer> list = new ArrayList<Customer>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from customer where customer_code = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getCustomerCode());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String customerCode = rs.getString("customer_code");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String receivedAddress = rs.getString("receivedAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");

				Customer customer = new Customer(customerCode, username, password, fullName, gender, address,
						receivedAddress, dateOfBirth, phoneNumber, email);
				list.add(customer);
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean insert(Customer t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "insert into customer (customer_code, username, password, fullName, gender, address, receivedAddress, dateOfBirth, phoneNumber, email)"
					+ "value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getCustomerCode());
			pst.setString(2, t.getUsername());
			pst.setString(3, t.getPassword());
			pst.setString(4, t.getFullName());
			pst.setString(5, t.getGender());
			pst.setString(6, t.getAddress());
			pst.setString(7, t.getReceivedAddress());
			pst.setDate(8, t.getDateOfBirth());
			pst.setString(9, t.getPhoneNumber());
			pst.setString(10, t.getEmail());
			System.out.println(sql);
			result = pst.executeUpdate();
			System.out.println("sql was conducted:" + sql);
			System.out.println(result + " line(s) changed");
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Customer t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "update customer " + " set " + " username = ?" + ", password = ?" + ", fullName = ?"
					+ ", gender = ?" + ", address = ?" + ", receivedAddress = ?" + ", dateOfBirth = ?"
					+ ", phoneNumber = ?" + ", email = ?" + " where customer_code = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getCustomerCode());
			pst.setString(2, t.getUsername());
			pst.setString(3, t.getPassword());
			pst.setString(4, t.getFullName());
			pst.setString(5, t.getGender());
			pst.setString(6, t.getAddress());
			pst.setString(7, t.getReceivedAddress());
			pst.setDate(8, t.getDateOfBirth());
			pst.setString(9, t.getPhoneNumber());
			pst.setString(10, t.getEmail());
			System.out.println(sql);
			result = pst.executeUpdate();
			System.out.println("sql was conducted:" + sql);
			System.out.println(result + " line(s) changed");
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Customer t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "delete from product where product_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getCustomerCode());

			// #3 conduct SQL command
			System.out.println(sql);
			result = pst.executeUpdate();

			// #4
			System.out.println("sql was conducted:" + sql);
			System.out.println(result + " line(s) changed");

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkUsername(String username) {
		boolean result = false;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from customer where username=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				result = true;
			}

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
