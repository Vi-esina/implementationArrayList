package org.example.entity;

import java.util.Objects;

public class Passport {
    public long getId;
    private long id;
    private String serialNumber;
    private String identification;

    private Customer customer;
    public Passport(long id, String serialNumber, String identification) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.identification = identification;
    }

    public Passport() {
    }

    public Passport(long id, String serialNumber, String identification, int customer_id) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.identification = identification;
        this.customer=new Customer(customer_id);
    }

    public Passport(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return id == passport.id && Objects.equals(serialNumber, passport.serialNumber) && Objects.equals(identification, passport.identification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, identification);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", identification='" + identification + '\'' +
                '}';
    }

    public Passport(String serialNumber, String identification) {
        this.serialNumber = serialNumber;
        this.identification = identification;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public void add(Passport passport) {
    }
}
