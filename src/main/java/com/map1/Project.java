package com.map1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project
{
    @Id
    private int pid;
    @Column(name = "Project_name")
    private String pname;

    @ManyToMany
    private List<Emp> emps;

    public Project() {
    }

    public Project(int pid, String pname, List<Emp> emps) {
        this.pid = pid;
        this.pname = pname;
        this.emps = emps;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }




}
