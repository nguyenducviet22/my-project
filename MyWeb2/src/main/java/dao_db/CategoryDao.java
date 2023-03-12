package dao_db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Category;
import model.Product;
import util.HibernateUtil;

public class CategoryDao implements InterfaceDao<Category> {

	@Override
	public List<Category> selectAll() {
		List<Category> list = new ArrayList<Category>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				// execute HQL
				String hql = "from category";
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
	public Category selectById(Category t) {
		List<Category> list = new ArrayList<Category>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				// execute HQL
				String hql = "from category c where c.categoryCode =: categoryCode";
				Query query = session.createQuery(hql);
				list = query.getResultList();
				trans.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.get(0);
	}

	@Override
	public boolean insert(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

}
