package com.klu.main;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class HQLWhereDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> q =
            session.createQuery(
                "FROM Product p WHERE p.price BETWEEN :min AND :max",
                Product.class);

        q.setParameter("min", 1000.0);
        q.setParameter("max", 10000.0);

        q.list().forEach(p ->
            System.out.println(p.getName() + " : " + p.getPrice()));

        session.close();
    }
}
