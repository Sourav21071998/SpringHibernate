package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class FetchDEMO
{
    public static void main(String args[])throws IOException
    {
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session session= factory.openSession();
        Student student1=(Student)session.get(Student.class,1);
        Address address1=(Address)session.get(Address.class,1);
        System.out.println(student1);
        System.out.println(address1);
        System.out.println();
        Student student2=(Student)session.load(Student.class,2);
        Address address2=(Address)session.load(Address.class,2);
        System.out.println(student2);
        System.out.println(address2);
        session.close();
        factory.close();
    }
}
