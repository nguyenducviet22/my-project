package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Error, can not create SessionFactory");
			return null;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

//	test connection with database
	public static void main(String[] args) {
		try {
			System.out.println(new HibernateUtil().getSessionFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
