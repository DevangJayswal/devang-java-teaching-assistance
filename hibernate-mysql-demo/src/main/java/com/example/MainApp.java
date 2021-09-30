package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.entity.Book;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory;
		
		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		// creating SessionFactory
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		// code to save a book
		Book book = new Book();
		book.setTitle("Python");
		book.setAuthor("France Melion");
		book.setPrice(42.59f);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();
		session.close();

		sessionFactory.close();

	}

}
