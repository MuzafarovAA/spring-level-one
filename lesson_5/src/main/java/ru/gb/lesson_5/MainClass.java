package ru.gb.lesson_5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(ShopCart.class)
                .buildSessionFactory();
        Session session;
        session = factory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, 1);
        System.out.println(user);
        Product product = session.get(Product.class, Long.valueOf(2));
        System.out.println(product);
        ShopCart shopCart = session.get(ShopCart.class, 3);
        System.out.println(shopCart);
    }
}
