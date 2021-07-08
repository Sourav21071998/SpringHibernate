package com.sqlquery;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class SQLExample
{
    public static void main(String[] args)
    {
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session s=factory.openSession();

        String q="Select * from student";
        NativeQuery nq=s.createSQLQuery(q);

        List<Object[]> list=nq.list();

        for(Object[] student:list)
        {
            System.out.println(student[4]+" : "+student[0]);
        }



        s.close();
        factory.close();

    }
}
