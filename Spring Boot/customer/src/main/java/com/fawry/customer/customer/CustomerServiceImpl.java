package com.fawry.customer.customer;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Customer not found")
        );
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return saveCustomer(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> filterCustomersWithoutPaging(Long accountNumber, String name, String department) {
        return customerRepository.filterCustomers(accountNumber, name, department);
    }

    @Override
    public Page<Customer> filterCustomers(Long accountNumber, String name, String department, Pageable pageable) {
        return customerRepository.filterCustomers(accountNumber, name, department, pageable);
    }

    @Override
    public Customer searchByAccountNumber(Long accountNumber) {
        return getCustomer(accountNumber);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Page<Customer> searchByName(String name, Pageable pageable) {
        return customerRepository.findByName(name, pageable);
    }

    @Override
    public List<Customer> searchByDepartment(String department) {
        return customerRepository.findByDepartmentContainingIgnoreCase(department);
    }

    @Override
    public Page<Customer> searchByDepartment(String department, Pageable pageable) {
        return customerRepository.findByDepartmentContainingIgnoreCase(department, pageable);
    }

    @Override
    public List<CustomerClosed> getCustomersProjected(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public List<CustomerOpen> getCustomersProjectedOpen(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public List<CustomerOpen> getCustomerByDeptWithQueryProjected(String dept) {
        return customerRepository.getCustomerByDeptProjected(dept);
    }
}
