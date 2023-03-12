package test;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import daoAPI.ProductDaoAPI;
import model.Product;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		ProductDaoAPI proDao = new ProductDaoAPI();

		List<Product> list = proDao.selectAll();
		for (Product product : list) {
			System.out.println(product);
		}
		
		Object[] obj = proDao.selectMaxMinPriceAllProduct();
		System.out.println("Amount: " + obj[0]);
		System.out.println("The highest price: " + obj[1]);
		System.out.println("The lowest price: " + obj[2]);

		List<Object[]> listObj = proDao.selectMaxMinPriceAllCategory();
		for (Object[] obj2 : listObj) {
			System.out.println("Category: " + obj2[0]);
			System.out.println("Amount: " + obj2[1]);
			System.out.println("The lowest price: " + obj2[2]);
			System.out.println("The highest price: " + obj2[3]);
		}
	}
}
