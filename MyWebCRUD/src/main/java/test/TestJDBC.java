package test;

import java.sql.Date;

import javax.servlet.http.Cookie;

import daoJDBC.AccountDao;
import daoJDBC.ProductDao;
import model.Account;
import model.Product;

public class TestJDBC {

	public static void main(String[] args) {
		AccountDao accDao = new AccountDao();

//		Account acc = new Account(4, "user3", "123", "user3", "Male", "Binh Duong", "Binh Duong",
//				new Date(System.currentTimeMillis()), "0123", "abc@gmail.com", 0, 0);
//		accDao.insert(acc);

//		List<Account> list = accDao.selectAll();
//		System.out.println("GET ALL ACCOUNTS:");
//		for (Account account : list) {
//			System.out.println(account);
//		}

//		Account acc = accDao.selectById(new Account(1, "", "", "", "", "", "", null, "", "", 0, 0));
//		System.out.println(acc);
//
//		Account acc2 = accDao.selectById("1");
//		System.out.println(acc2);

		ProductDao productDao = new ProductDao();

		productDao.insert("Bitis 2000", "https://tse1.mm.bing.net/th?id=OIP.3fGeJN48g7_GhZSx-GOmmQHaEp&pid=Api&P=0",
				"400.0", "120", "Shoes", "Beautiful", "3", 457248757);
		
//		List<Product> list = productDao.selectAll();
//		System.out.println("GET ALL PRODUCTS:");
//		for (Product product : list) {
//			System.out.println(product);
//		}
//
//		Product product = productDao.selectLatestProduct();
//		System.out.println("GET THE LATEST PRODUCTS:");
//		System.out.println(product);
//
//		List<Product> list2 = productDao.selectProductByCId("2");
//		System.out.println("GET PRODUCTS BY CID:");
//		for (Product product2 : list2) {
//			System.out.println(product2);
//		}

//		Product product2 = productDao.selectById("3");
//		System.out.println("GET PRODUCTS BY ID:");
//		System.out.println(product2);

//		List<Product> list3 = productDao.searchProductByName("Nike");
//		System.out.println("SEARCH PRODUCTS:");
//		for (Product product3 : list3) {
//			System.out.println(product3);
//		}
//		
//		List<Product> list4 = productDao.selectTop3();
//		System.out.println("GET TOP 3:");
//		for (Product product4 : list4) {
//			System.out.println(product4);
//		}

//		Product pro = new Product(13, "", "", null, "", "");
//		productDao.delete(pro);
	}
}
