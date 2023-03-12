package test;

import java.sql.Date;
import java.util.List;

import dao_db.CustomerDao;
import dao_db.ShopDao;
import model.Customer;
import model.Shop;

public class Test {
	public static void main(String[] args) {
//		ShopDao shopDao = new ShopDao();
//		List<Shop> list = shopDao.selectAll();
//		for (Shop shop : list) {
//			System.out.println(shop);
//		}
		
//		
		
//		Shop shop = shopDao.selectById(new Shop("S002", "", ""));
//		System.out.println(shop);

//		Shop shop = new Shop("S001", "", "");
//		shopDao.delete(shop);

//		Shop shop = new Shop("S001", "Shop haha", "TP HCM");
//		shopDao.update(shop);

		CustomerDao cusDao = new CustomerDao();		
//		List<Customer> list = cusDao.selectAll();
//		for (Customer customer : list) {
//			System.out.println(customer);
//		}
//
//		Customer cus = cusDao.selectById(new Customer("1677045756192", "", "", "", "", "", "", null, "", ""));
//		System.out.println(cus);
		
		String customerCode = System.currentTimeMillis() + "";
		Customer customer = new Customer(customerCode, "haha", "123", "haha", "Male", "Binh Duong", "Tp HCM",
				new Date(System.currentTimeMillis()), "01234", "abc@gmail.com");
		cusDao.insert(customer);
		
		
	}
}