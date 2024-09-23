package com.xjudge;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("--------------------------------");
        Assignment assignment = new Assignment();
        List<Customer> customers = assignment.getCustomerList();

        Map<String, Integer> map = customers.stream()
                .collect(
                        Collectors.toMap(
                                Customer::getName,
                                Customer::getOrdersSize
                        )
                );
        System.out.println(map);

    }
}