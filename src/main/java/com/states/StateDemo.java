package com.states;

import org.example.Certificate;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo
{
    public static void main(String[] args)
    {
        SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        //Creating student object
        Student student=new Student();
        student.setCity("Kolkata");
        student.setId(100);
        student.setName("Sourav");
        student.setCerify(new Certificate("Java","2 months"));
        //Now the student object is in Transient state

        Session s=f.openSession();
        Transaction tx=s.beginTransaction();
        s.save(student);
        //Now the student object is in Persistent state


        tx.commit();
        s.close();
        //Now the student is in detached state.

        f.close();
    }
}
