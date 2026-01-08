package com.klu.main;

import org.hibernate.Session;
import com.klu.util.HibernateUtil;

public class HQLLikeDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("Names starting with M:");
        session.createQuery(
            "FROM Product p WHERE p.name LIKE 'M%'")
            .list().forEach(System.out::println);

        System.out.println("\nNames ending with r:");
        session.createQuery(
            "FROM Product p WHERE p.name LIKE '%r'")
            .list().forEach(System.out::println);

        System.out.println("\nNames containing oo:");
        session.createQuery(
            "FROM Product p WHERE p.name LIKE '%oo%'")
            .list().forEach(System.out::println);

        System.out.println("\nNames with length 5:");
        session.createQuery(
            "FROM Product p WHERE LENGTH(p.name) = 5")
            .list().forEach(System.out::println);

        session.close();
    }
}
