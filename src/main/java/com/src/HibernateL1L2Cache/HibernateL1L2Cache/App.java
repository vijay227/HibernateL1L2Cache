package com.src.HibernateL1L2Cache.HibernateL1L2Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.src.HibernateL1L2Cache.HibernateL1L2Cache.Model.Alien;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Alien a = null;

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session1 = sf.openSession();
		session1.beginTransaction();

		a = (Alien) session1.get(Alien.class, 101);
		System.out.println(a);

		session1.getTransaction().commit();
		session1.close();

		Session session2 = sf.openSession();
		session2.beginTransaction();

		a = (Alien) session2.get(Alien.class, 101);
		System.out.println(a);

		session2.getTransaction().commit();
		session2.close();
	}
}
