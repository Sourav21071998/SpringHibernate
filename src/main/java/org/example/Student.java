package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student
{
    @Id
    private int id;

    private String name;

    private String city;

    public Student(int id, String name, String city, Certificate cerify) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.cerify = cerify;
    }

    public Certificate getCerify() {
        return cerify;
    }

    public void setCerify(Certificate cerify) {
        this.cerify = cerify;
    }

    private Certificate cerify;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student() {
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", cerify=" + cerify +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
