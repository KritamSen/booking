package com.booking.util;// Import necessary Hibernate packages
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import com.booking.entities.User; // Replace with your package and User class name

public class HibernateExample {
    public static void main(String[] args) {

        // Create a Hibernate configuration object
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        // Create a Hibernate session factory object
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Create a Hibernate session object
        Session session = sessionFactory.openSession();

        // Create a Hibernate query object
        List<User> userList = session.createQuery("from User").list();

        // Iterate over the results and print them
        for (User user : userList) {
            System.out.println("User ID: " + user.getId());
            System.out.println("Email: " + user.getEmail());
            // Add code to print other fields as desired
        }

        // Close the Hibernate session
        session.close();
    }
}
