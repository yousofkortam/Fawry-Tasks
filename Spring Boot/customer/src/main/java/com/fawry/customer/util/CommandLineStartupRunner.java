package com.fawry.customer.util;

import com.fawry.customer.customer.Customer;
import com.fawry.customer.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class CommandLineStartupRunner implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
//        fillSalaryAttr();
    }

    private void fillSalaryAttr() {
        List<Customer> customerList = customerRepository.findAll();
        for (Customer customer : customerList) {
            customer.setSalary((new Random().nextDouble(10000)) + 1500);
        }
        customerRepository.saveAll(customerList);
    }
}
