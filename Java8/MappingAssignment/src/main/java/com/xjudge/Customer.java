package com.xjudge;

import java.util.List;

public class Customer {
    private int id;
    private String name;
    private int age;
    private List<Order> orders;
    public Customer(int id, String name, int age, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.orders = orders;
    }
    public String getName() {
        return this.name;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public int getOrdersSize() {
        return orders.size();
    }
}
