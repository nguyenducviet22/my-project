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
import model.Order;
import util.HibernateUtil;
import util.JDBCUtil;

public class OrderDao implements InterfaceDao<Order> {

	@Override
	public List<Order> selectAll() {
		List<Order> list = new ArrayList<Order>();
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from orders";
			PreparedStatement pst = con.prepareStatement(sql);

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String orderCode = rs.getString("order_code");
				String customerCode = rs.getString("customer_FK");
				String receivedAddress = rs.getString("receivedAddress");
				String state = rs.getString("state");
				String formOfPayment = rs.getString("formOfPayment");
				Double paidMoney = rs.getDouble("paidMoney");
				Double unpaidMoney = rs.getDouble("unpaidMoney");
				Date orderedDay = rs.getDate("orderedDay");
				Date deliveredDay = rs.getDate("deliveredDay");

				Customer customer = new CustomerDao()
						.selectById(new Customer(customerCode, "", "", "", "", "", "", null, "", ""));

				Order order = new Order(orderCode, customer, receivedAddress, state, formOfPayment, paidMoney,
						unpaidMoney, orderedDay, deliveredDay);
				list.add(order);
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
	public Order selectById(Order t) {
		List<Order> list = new ArrayList<Order>();
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from order where order_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getOrderCode());

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String orderCode = rs.getString("order_code");
				String customerCode = rs.getString("customer_code");
				String receivedAddress = rs.getString("received_address");
				String state = rs.getString("state");
				String formOfPayment = rs.getString("form_of_payment");
				Double paidMoney = rs.getDouble("pay_money");
				Double unpaidMoney = rs.getDouble("unpaid_money");
				Date orderedDay = rs.getDate("ordered_date");
				Date orddeliveredDayeredDay = rs.getDate("delivered_date");

				Order order = new Order(orderCode, null, receivedAddress, state, formOfPayment, paidMoney, unpaidMoney,
						orderedDay, orddeliveredDayeredDay);
			}
			// #5 stop connection with CSDL
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
	
	public boolean saveOrUpdate(Order t) {
		boolean result = false;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//execute HQL
				session.saveOrUpdate(t);
				trans.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Order t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Order t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Order t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//execute HQL
				session.delete(t);
				trans.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
