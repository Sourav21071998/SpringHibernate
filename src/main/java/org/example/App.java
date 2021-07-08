package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws IOException
    {
        System.out.println( "Project started..." );
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isOpen());
        Student st=new Student();
        st.setId(2);
        st.setName("Sam");
        st.setCity("Kolkata");

        Address ad=new Address();
        ad.setStreet("9,RBC Road");
        ad.setCity("Kolkata");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.12);

        FileInputStream fis=new FileInputStream("src/main/img.jpg");
        byte data[]=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);

        System.out.println(st);
        System.out.println(ad);
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
    }
}
