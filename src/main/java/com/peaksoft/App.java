package com.peaksoft;

import com.peaksoft.entity.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setForstName("Albert");
        employee1.setLastName("Akiev");
        employee1.setAge(18);
        create(employee1);

        Employee employee2 = new Employee();
        employee2.setForstName("Syimyk");
        employee2.setLastName("Avasov");
        employee2.setAge(20);
        create(employee2);

        Employee employee3 = new Employee();
        employee3.setForstName("Kurmanbek");
        employee3.setLastName("Mambetomoruv");
        employee3.setAge(32);
        create(employee3);

        Employee employee4 = new Employee();
        employee4.setForstName("Aza");
        employee4.setLastName("Shorpokulov");
        employee4.setAge(21);
        create(employee4);

        Employee employee5 = new Employee();
        employee5.setForstName("Kanat");
        employee5.setLastName("Kurmanovich");
        employee5.setAge(16);
        create(employee5);

        Employee employee6 = new Employee();
        employee6.setForstName("Azamat");
        employee6.setLastName("Syimonkulov");
        employee6.setAge(19);
        create(employee6);

        Employee employee7 = new Employee();
        employee7.setForstName("Marat");
        employee7.setLastName("Bekjanov");
        employee7.setAge(15);
        create(employee7);

        Employee employee8 = new Employee();
        employee8.setForstName("Rahmanali");
        employee8.setLastName("Begaliev");
        employee8.setAge(24);
        create(employee8);

        Employee employee9 = new Employee();
        employee9.setForstName("Baiel");
        employee9.setLastName("Jekshenov");
        employee9.setAge(12);
        create(employee9);

        Employee employee10 = new Employee();
        employee10.setForstName("Shabdan");
        employee10.setLastName("Ulanov");
        employee10.setAge(18);
        create(employee10);


        ochuryy();
    }

    public static Long create(Employee e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        return e.getId();
    }
    public static void aluu() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Employee WHERE forstName LIKE 'Aza' AND age<20");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully d");
    }
    public static void ochuryy() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Employee WHERE forstName LIKE 'Aza'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Employee");
    }

    public static void update(String name, int age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class,name);
        employee.setAge(18);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");
    }
}
