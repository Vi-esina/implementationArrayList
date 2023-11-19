package org.example.entity;

import java.util.Objects;

public class Product {
    private long id;
    private String name;
    private double totalAmount;
    private Customer customer;

    public Product(long id, String name, double totalAmount, int customer_id) {
        this.id = id;
        this.name = name;
        this.totalAmount = totalAmount;
        this.customer=new Customer(customer_id);
    }

    public Product(String name, double totalAmount, Customer customer) {
        this.name = name;
        this.totalAmount = totalAmount;
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(totalAmount, product.totalAmount) == 0 && Objects.equals(name, product.name) && Objects.equals(customer, product.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, totalAmount, customer);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
