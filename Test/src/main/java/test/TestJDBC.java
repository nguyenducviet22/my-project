package test;

import java.sql.Date;

import javax.servlet.http.Cookie;

import daoJDBC.AccountDao;
import model.Account;

public class TestJDBC {

	public static void main(String[] args) {
		AccountDao accDao = new AccountDao();

//		Account acc = new Account(2, "hihi", "123", "hihi", "Male", "Binh Duong", "Binh Duong",
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

	}
}
