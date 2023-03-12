package dao_db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Product;
import model.Shop;
import util.HibernateUtil;

public class ShopDao implements InterfaceDao<Shop> {

	@Override
	public List<Shop> selectAll() {
		List<Shop> list = new ArrayList<Shop>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//execute HQL
				String hql = "from Shop";
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
	public Shop selectById(Shop t) {
		List<Shop> list = new ArrayList<Shop>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//execute HQL
				String hql = "from Shop s where s.shopCode =: shopCode";
				Query query = session.createQuery(hql);
				query.setParameter("shopCode", t.getShopCode());
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

	public boolean saveOrUpdate(Shop t) {
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
	public boolean insert(Shop t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Shop t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Shop t) {
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
	
	public static void main(String[] args) {
		ShopDao shopDao = new ShopDao();
		List<Shop> list = shopDao.selectAll();
		System.out.println(list);
	}

}
