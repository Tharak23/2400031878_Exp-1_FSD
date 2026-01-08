package com.klu.main;

import org.hibernate.Session;
import com.klu.util.HibernateUtil;

public class HQLAggregates {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Long total =
            session.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
                   .uniqueResult();

        Long available =
            session.createQuery(
                "SELECT COUNT(p) FROM Product p WHERE p.quantity > 0",
                Long.class).uniqueResult();

        System.out.println("Total products: " + total);
        System.out.println("Available products: " + available);

        session.createQuery(
            "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description")
            .list().forEach(System.out::println);

        Object[] minMax =
            (Object[]) session.createQuery(
                "SELECT MIN(p.price), MAX(p.price) FROM Product p")
                .uniqueResult();

        System.out.println("Min price: " + minMax[0]);
        System.out.println("Max price: " + minMax[1]);

        session.close();
    }
}
