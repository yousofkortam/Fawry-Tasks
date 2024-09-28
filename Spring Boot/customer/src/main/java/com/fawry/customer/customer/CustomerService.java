package com.fawry.customer.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Long id);
    List<Customer> getCustomers();
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long id);
    List<Customer> filterCustomersWithoutPaging(Long accountNumber, String name, String department);
    Page<Customer> filterCustomers(Long accountNumber, String name, String department, Pageable pageable);

    Customer searchByAccountNumber(Long accountNumber);
    List<Customer> searchByName(String name);
    Page<Customer> searchByName(String name, Pageable pageable);
    List<Customer> searchByDepartment(String department);
    Page<Customer> searchByDepartment(String department, Pageable pageable);

    List<CustomerClosed> getCustomersProjected(String firstName);
    List<CustomerOpen> getCustomersProjectedOpen(String lastName);
    List<CustomerOpen> getCustomerByDeptWithQueryProjected(String dept);

}
