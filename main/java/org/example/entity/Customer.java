package org.example.entity;

import java.util.List;
import java.util.Objects;

public class Customer {
    private int id;
    private String fistName;
    private String lastName;
    private int age;
    private String address;
    private Passport passport;

    public Customer(int id, String fistName, String lastName, int age, String address, long passportId) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public Customer(String fistName, String lastName, int age, String address) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public Customer(int id) {
        this.id = id;
    }


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && age == customer.age && Objects.equals(fistName, customer.fistName) && Objects.equals(lastName, customer.lastName) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fistName, lastName, age, address);
    }

    public void addPassport(Passport passport){
       passport.add(passport);
    }
}
