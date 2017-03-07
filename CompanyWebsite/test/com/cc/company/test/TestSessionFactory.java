package com.cc.company.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

public class TestSessionFactory extends BaseSpring {

	@Test
	public void testSessionFactory() {
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("sessionFactory");

	}
}
