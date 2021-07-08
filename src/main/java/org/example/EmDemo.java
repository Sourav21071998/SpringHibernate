package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo
{
    public static void main(String[] args)
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();


        Student student1=new Student();
        Certificate certificate1=new Certificate();
        student1.setId(1);
        student1.setName("Sourav");
        student1.setCity("Kolkata");

        certificate1.setCourse("Java");
        certificate1.setDuration("1 month");
        student1.setCerify(certificate1);

        Student student2=new Student();
        student2.setId(2);
        student2.setName("Sourav");
        student2.setCity("Kolkata");
        Certificate certificate2=new Certificate();
        certificate2.setDuration("25 days");
        certificate2.setCourse("C");

        student2.setCerify(certificate2);

        Student student3=new Student();
        student3.setId(3);
        student3.setName("Sarkar");
        student3.setCity("ABC");
        Certificate certificate3=new Certificate();
        certificate3.setDuration("45 days");
        certificate3.setCourse("Python");

        student3.setCerify(certificate3);

        Session s= factory.openSession();
        Transaction tx=s.beginTransaction();

        s.save(student1);
        s.save(student2);
        s.save(student3);

        tx.commit();

        s.close();
        factory.close();

    }
}
