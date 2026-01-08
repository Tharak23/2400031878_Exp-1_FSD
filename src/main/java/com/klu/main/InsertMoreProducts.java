package com.klu.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class InsertMoreProducts {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(new Product("Mouse", "Electronics", 500, 50));
        session.persist(new Product("Keyboard", "Electronics", 1200, 30));
        session.persist(new Product("Monitor", "Electronics", 15000, 15));
        session.persist(new Product("Chair", "Furniture", 4500, 20));
        session.persist(new Product("Table", "Furniture", 8000, 10));
        session.persist(new Product("Pen", "Stationery", 20, 100));
        session.persist(new Product("Notebook", "Stationery", 80, 0));

        tx.commit();
        session.close();

        System.out.println("Additional products inserted successfully");
    }
}
