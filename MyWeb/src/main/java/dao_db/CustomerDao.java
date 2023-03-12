package dao_db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.Shop;
import util.HibernateUtil;

public class CustomerDao implements InterfaceDao<Customer> {

	@Override
	public List<Customer> selectAll() {
		List<Customer> list = new ArrayList<Customer>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//execute HQL
				String hql = "from Customer";
				Query query = session.createQuery(hql);
				list = query.getResultList();
				trans.commit();
				session.close();
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
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//execute HQL
				String hql = "from Customer c where c.customerCode =: customerCode";
				Query query = session.createQuery(hql);
				query.setParameter("customerCode", t.getCustomerCode());
				list = query.getResultList();
				trans.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	public boolean saveOrUpdate(Customer t) {
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
	public boolean insert(Customer t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Customer t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Customer t) {
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

	public boolean checkUsername(String username) {
		List<Customer> list = new ArrayList<Customer>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//execute HQL
				String hql = "from mywebsite u where u.username =: username";
				Query query = session.createQuery(hql);
				query.setParameter("username", username);
				list = query.getResultList();
				trans.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.size() > 0) {
			return false;
		} else {
			return true;
		}
	}
}
