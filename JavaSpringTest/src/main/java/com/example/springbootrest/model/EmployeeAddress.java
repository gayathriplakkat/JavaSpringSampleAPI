package com.example.springbootrest.model;

import javax.persistence.*;

@Entity
@Table(name = "EmployeeAddress")
public class EmployeeAddress {

    private long id;
    private String address;
    private Employee employee;
    private String addressType;

    public EmployeeAddress() {
    }

    public EmployeeAddress(long id, String address, Employee employee, String addressType) {
        this.id = id;
        this.address = address;
        this.employee = employee;
        this.addressType = addressType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = "address",nullable = false)
    public String getAddress() {
        return address;
    }

    @Column(name = "employee",nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    @Column(name = "addressType")
    public String getAddressType() {
        return addressType;
    }

    @ManyToMany
    @JoinTable(name="Employee")
    public Address address_employee = new Address();

    public void setId(long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", employee=" + employee +
                ", addressType='" + addressType + '\'' +
                '}';
    }
}
