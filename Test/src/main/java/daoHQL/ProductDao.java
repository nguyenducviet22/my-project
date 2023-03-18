package daoHQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Product;
import util.HibernateUtil;

public class ProductDao implements InterfaceDao<Product> {

	@Override
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				// execute HQL
				String hql = "from Product";
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
	public Product selectById(Product t) {
		List<Product> list = new ArrayList<Product>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				// execute HQL
				String hql = "from Product p where p.id =: id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
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

	public Product selectLatestProduct() {
		List<Product> list = new ArrayList<Product>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				// execute HQL
				String hql = "from Product p order by p.id desc";
				Query query = session.createQuery(hql);
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

	public List<Product> selectProductByCid(String cid) {
		List<Product> list = new ArrayList<Product>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				// execute HQL
				String hql = "from Product p where p.cid =: cid";
				Query query = session.createQuery(hql);
				query.setParameter("cid", cid);
				list = query.getResultList();
				trans.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	public boolean saveOrUpdate(Product t) {
		boolean result = false;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				// execute HQL
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
	public boolean insert(Product t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Product t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Product t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				// execute HQL
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
