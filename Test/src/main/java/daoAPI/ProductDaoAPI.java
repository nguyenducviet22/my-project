package daoAPI;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.Category;
import model.Product;
import util.HibernateUtil;

public class ProductDaoAPI implements InterfaceDao<Product> {

	@Override
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<Product> cquery = builder.createQuery(Product.class);
				Root<Product> root = cquery.from(Product.class);
				cquery = cquery.select(root);

				Predicate p1 = builder.like(root.get("name").as(String.class), "%Nike%");
				Predicate p2 = builder.like(root.get("description").as(String.class), "%Durable%");
				Predicate p3 = builder.between(root.get("price").as(Double.class), new Double(450), new Double(500));

//				cquery.where(p3);
				cquery.where(builder.and(p3, builder.and(p1, p2)));
//				cquery.where(builder.and(p1, p2));

				Query<Product> query = session.createQuery(cquery);
				list = query.getResultList();
				session.close();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return list;
	}

	public Object[] selectMaxMinPriceAllProduct() {
		Object[] obj = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<Object[]> cquery = builder.createQuery(Object[].class);
				Root<Product> root = cquery.from(Product.class);
				cquery = cquery.multiselect(builder.count(root.get("id")),
						builder.max(root.get("price").as(Double.class)),
						builder.min(root.get("price").as(Double.class)));

				Query<Object[]> query = session.createQuery(cquery);
				obj = query.getSingleResult();
				
				session.close();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return obj;
	}
	
	public List<Object[]> selectMaxMinPriceAllCategory(){
		List<Object[]> listObj = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<Object[]> cquery = builder.createQuery(Object[].class);
				Root<Product> proRoot = cquery.from(Product.class);
				Root<Category> cateRoot = cquery.from(Category.class);
				cquery = cquery.where(builder.equal(proRoot.get("category"), cateRoot.get("cid")));
				
				cquery.multiselect(cateRoot.get("cname").as(String.class), 
						builder.count(proRoot.get("id")),
						builder.min(proRoot.get("price").as(Double.class)),
						builder.max(proRoot.get("price").as(Double.class)));
				cquery.groupBy(cateRoot.get("cname").as(String.class));
				cquery.orderBy(builder.asc(cateRoot.get("cname").as(String.class)));
				
				Query<Object[]> query = session.createQuery(cquery);
				listObj = query.getResultList();
				
				session.close();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return listObj;
	}

	@Override
	public Product selectById(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Product t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product t) {
		// TODO Auto-generated method stub
		return false;
	}

}
