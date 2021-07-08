package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo
{
    public static void main(String[] args)
    {
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();

        System.out.println("Hello!!");

        //creating question
        Question question1=new Question();
        question1.setQuestionId(1212);
        question1.setQuestion("What is Java?");

        //creating answer
        Answer answer1=new Answer();
        answer1.setAnswer("Java is a programming language.");
        answer1.setAnswerId(343);
        //question1.setAnswer(answer1);
        answer1.setQuestion(question1);

        Answer answer2=new Answer();
        answer2.setAnswer("With the help of Java, we can create softwares.");
        answer2.setAnswerId(344);
        answer2.setQuestion(question1);
//
        Answer answer3=new Answer();
        answer3.setAnswer("It is useful for implementing object oriented programming concepts.");
        answer3.setAnswerId(345);
        answer3.setQuestion(question1);
//
        List<Answer> list=new ArrayList<Answer>();
        list.add(answer1);
        list.add(answer2);
        list.add(answer3);
//
        question1.setAnswers(list);

        //creating question
//        Question question2=new Question();
//        question2.setQuestionId(242);
//        question2.setQuestion("What is Collection Framework?");

        //creating answer
//        Answer answer2=new Answer();
//        answer2.setAnswer("API to work with group of objects.");
//        answer2.setAnswerId(344);
//        question2.setAnswer(answer2);
//        answer2.setQuestion(question2);

        //session
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        s.save(question1);
        s.save(answer1);
//        s.save(question2);
        s.save(answer2);
        s.save(answer3);
        tx.commit();

        Question q=(Question) s.get(Question.class,1212);
        System.out.println(q.getQuestion());
        System.out.println(q.getQuestionId());
        System.out.println(q.getAnswers().size());
        //System.out.println(newQ.getAnswer().getAnswer());

        for(Answer a:q.getAnswers())
        {
            System.out.println(a.getAnswer());
        }

        //Answer newA=(Answer) s.get(Answer.class,344);
        //System.out.println(newA.getQuestion().getQuestion());
        //System.out.println(newQ.getAnswer());
        //System.out.println(newA.getAnswer());

        s.close();
        factory.close();
    }
}
