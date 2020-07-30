package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String managerName;

    private boolean flag;

    private Double salary;

    @ManyToOne
    @JoinColumn(name="managerName",referencedColumnName = "name",insertable = false,updatable = false)
    //insertable and updateble false as the Employee class has the managerName field
    private Employee manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Employee() {

    }
    public Employee(Long id, String name, String managerName, boolean flag, Double salary) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
        this.flag = flag;
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", flag=" + flag +
                ", salary=" + salary +
                '}';
    }
}
