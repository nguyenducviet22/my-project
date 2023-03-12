package dao_db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.DetailedOrder;
import model.Shop;
import util.HibernateUtil;

public class DetailedOrderDao implements InterfaceDao<DetailedOrder> {

	@Override
	public List<DetailedOrder> selectAll() {
		List<DetailedOrder> list = new ArrayList<DetailedOrder>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//execute HQL
				String hql = "from DetailedOrder";
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
	public DetailedOrder selectById(DetailedOrder t) {
		List<DetailedOrder> list = new ArrayList<DetailedOrder>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//execute HQL
				String hql = "from DetailedOrder d where d.detailedOrderCode =: detailedOrderCode";
				Query query = session.createQuery(hql);
				query.setParameter("detailedOrderCode", t.getDetailedOrderCode());
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
	
	public boolean saveOrUpdate(DetailedOrder t) {
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
	public boolean insert(DetailedOrder t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(DetailedOrder t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(DetailedOrder t) {
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
