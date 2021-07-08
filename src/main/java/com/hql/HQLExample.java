package com.hql;

import org.example.Student;
import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class HQLExample
{
    public static void main(String[] args)
    {
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();

        Session s=factory.openSession();
        //HQL
        //Symtax
        String query="from Student where city='Kolkata'";

        Query q=s.createQuery(query);
        List<Student> list=q.list();

        for(Student student:list)
        {
            System.out.println(student.getName()+":"+student.getCerify().getCourse());
        }


        String qr="from Student as s where s.name=:x and s.id=:n";
        Query q1=s.createQuery(qr);
        q1.setParameter("x","Sourav");
        q1.setParameter("n",1);
        List<Student> list1=q1.list();

        for(Student student:list1)
        {
            System.out.println(student.getName()+":"+student.getCerify().getCourse()+":"+student.getCerify().getDuration());
        }


//        Transaction tx=s.beginTransaction();
//        //Query to delete
//        Query q3=s.createQuery("delete from Student as s where s.id=:c");
//        q3.setParameter("c",3);
//        int r=q3.executeUpdate();
//        System.out.println("Deleted : "+r);
//        tx.commit();

//        //UPDATE
//        Transaction tx=s.beginTransaction();
//        Query q3=s.createQuery("update Student set name=:n where id=:i");
//        q3.setParameter("n","Subho");
//        q3.setParameter("i",2);
//        int r=q3.executeUpdate();
//        tx.commit();

        Query q3=s.createQuery("select q.question,q.questionId,a.answer from Question as q inner join q.answers as a");

        List<Object []> list2=q3.getResultList();

        for(Object[] arr:list2)
        {
            System.out.println(Arrays.toString(arr));
        }


        s.close();
        factory.close();
    }

}
