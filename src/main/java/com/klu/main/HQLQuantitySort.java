package com.klu.main;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class HQLQuantitySort {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> q =
            session.createQuery("FROM Product p ORDER BY p.quantity DESC", Product.class);

        q.list().forEach(p ->
            System.out.println(p.getName() + " : " + p.getQuantity()));

        session.close();
    }
}
