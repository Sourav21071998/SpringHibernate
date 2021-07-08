package com.pagination;


import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination
{
    public static void main(String[] args)
    {
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();

        Session s=factory.openSession();

        Query query=s.createQuery("from Student");

        //implementing pagination using hibernate

        query.setFirstResult(0);
        query.setMaxResults(5);

        List<Student> list=query.list();

        for(Student st:list)
        {
            System.out.println(st);
        }



        s.close();
        factory.close();
    }
}
