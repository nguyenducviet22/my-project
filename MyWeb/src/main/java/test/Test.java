package test;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import dao_db.CategoryDao;
import dao_db.CustomerDao;
import dao_db.DetailedOrderDao;
import dao_db.ProductDao;
import dao_db.ShopDao;
import model.Category;
import model.Customer;
import model.DetailedOrder;
import model.Product;
import model.Shop;

public class Test {
	public static void main(String[] args) {
//		Random rd = new Random();
//		int value = rd.nextInt(1, 1000);
//		String randomCode = System.currentTimeMillis() + value + "";

		CategoryDao cateDao = new CategoryDao();
		Category cate1 = new Category("1", "Runner");
		Category cate2 = new Category("2", "Clothes");
		Category cate3 = new Category("3", "Hat");
		cateDao.insert(cate1);
		cateDao.insert(cate2);
		cateDao.insert(cate3);
		List<Category> listCate = cateDao.selectAll();
		for (Category category : listCate) {
			System.out.println(category);
		}

//		CustomerDao cusDao = new CustomerDao();
//		Customer customer1 = new Customer(randomCode, "hihi", "123", "hihi", "Male", "Binh Duong",
//				new Date(System.currentTimeMillis()), "01234", "abc@gmail.com");
//		Customer customer2 = new Customer(randomCode, "haha", "123", "haha", "Male", "Binh Duong",
//				new Date(System.currentTimeMillis()), "01234", "abc@gmail.com");
//		Customer customer3 = new Customer(randomCode, "hoho", "123", "hoho", "Male", "Binh Duong",
//				new Date(System.currentTimeMillis()), "01234", "abc@gmail.com");
//		cusDao.insert(customer1);
//		cusDao.insert(customer2);
//		cusDao.insert(customer3);
//		List<Customer> listCus = cusDao.selectAll();
//		for (Customer customer : listCus) {
//			System.out.println(customer);
//		}
//
//		ShopDao shopDao = new ShopDao();
//		Shop shop1 = new Shop(randomCode, "Shop haha", "TP HCM");
//		Shop shop2 = new Shop(randomCode, "Shop hihi", "TP HCM");
//		Shop shop3 = new Shop(randomCode, "Shop hehe", "TP HCM");
//		shopDao.insert(shop1);
//		shopDao.insert(shop2);
//		shopDao.insert(shop3);
//		List<Shop> listShop = shopDao.selectAll();
//		for (Shop shop : listShop) {
//			System.out.println(shop);
//		}
//
//		ProductDao proDao = new ProductDao();
//		Product pro1 = new Product(randomCode, "Nike", 2022, 400.0, 100, "Durable", cate1);
//		Product pro2 = new Product(randomCode, "Adidas", 2022, 400.0, 100, "Durable", cate1);
//		Product pro3 = new Product(randomCode, "Converse", 2022, 400.0, 100, "Durable", cate1);
//		proDao.insert(pro1);
//		proDao.insert(pro2);
//		proDao.insert(pro3);
//		
//		Product pro4 = new Product(randomCode, "Shirt", 2022, 400.0, 100, "Durable", cate2);
//		Product pro5 = new Product(randomCode, "T-Shirt", 2022, 400.0, 100, "Durable", cate2);
//		Product pro6 = new Product(randomCode, "Dress", 2022, 400.0, 100, "Durable", cate2);
//		proDao.insert(pro4);
//		proDao.insert(pro5);
//		proDao.insert(pro6);
//		
//		Product pro7 = new Product(randomCode, "Hat1", 2022, 400.0, 100, "Durable", cate3);
//		Product pro8 = new Product(randomCode, "Hat2", 2022, 400.0, 100, "Durable", cate3);
//		Product pro9 = new Product(randomCode, "Hat3", 2022, 400.0, 100, "Durable", cate3);
//		proDao.insert(pro7);
//		proDao.insert(pro8);
//		proDao.insert(pro9);
	}
}