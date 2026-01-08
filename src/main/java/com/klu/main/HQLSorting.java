package com.klu.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class HQLSorting {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> asc =
            session.createQuery("FROM Product p ORDER BY p.price ASC", Product.class);

        System.out.println("Price Ascending:");
        asc.list().forEach(p ->
            System.out.println(p.getName() + " : " + p.getPrice()));

        Query<Product> desc =
            session.createQuery("FROM Product p ORDER BY p.price DESC", Product.class);

        System.out.println("\nPrice Descending:");
        desc.list().forEach(p ->
            System.out.println(p.getName() + " : " + p.getPrice()));

        session.close();
    }
}
