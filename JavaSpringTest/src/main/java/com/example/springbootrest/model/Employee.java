package com.example.springbootrest.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    private long id;
    private String name;
    private String dateOfBirth;

    public Employee(){

    }

    public Employee(long id, String name, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = "name",nullable = false, length = 3)
    public String getName() {
        return name;
    }

    @Column(name = "dateOfBirth",nullable = false)
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
