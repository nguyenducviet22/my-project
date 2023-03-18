package test;

import java.util.List;

import daoHQL.ProductDao;
import model.Product;

public class TestHQL {
	public static void main(String[] args) {
		ProductDao proDao = new ProductDao();
		List<Product> list = proDao.selectAll();
		System.out.println("All products: ");
		for (Product product : list) {
			System.out.println(product);
		}

		Product product = proDao.selectLatestProduct();
		System.out.println("The latest product: ");
		System.out.println(product);

		List<Product> list2 = proDao.selectProductByCid("1");
		System.out.println("All products have cate id is 1: ");
		for (Product product2 : list2) {
			System.out.println(product2);
		}

//		Product pro = new Product(0, null, null, 0, null, null, "1");
//		System.out.println(pro);
	}
}
