package com.fawry.customer.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/filter")
    public List<Customer> filterCustomersWithoutPaging(
            @RequestParam(defaultValue = "") Long accountNumber,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String department) {
        return customerService.filterCustomersWithoutPaging(accountNumber, name, department);
    }

    @GetMapping("/filter-paging")
    public Page<Customer> filterCustomers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "25") Integer size,
            @RequestParam(defaultValue = "") Long accountNumber,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String department) {
        Pageable paging = PageRequest.of(pageNo, size);
        return customerService.filterCustomers(accountNumber, name, department, paging);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping
    public Customer updateCustomer(@Valid @RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/search/acc-num/{id}")
    public Customer searchByAccountNumber(@PathVariable Long id) {
        return customerService.searchByAccountNumber(id);
    }

    @GetMapping("/search/name/{name}")
    public List<Customer> searchByName(@PathVariable String name) {
        return customerService.searchByName(name);
    }

    @GetMapping("/search/dept/{department}")
    public List<Customer> searchByDepartment(@PathVariable String department) {
        return customerService.searchByDepartment(department);
    }

    @GetMapping("/paging/name/{name}")
    public Page<Customer> searchByNamePaging(@PathVariable String name, Pageable pageable) {
        return customerService.searchByName(name, pageable);
    }

    @GetMapping("/paging/dept/{department}")
    public Page<Customer> searchByDepartmentPaging(@PathVariable String department, Pageable pageable) {
        return customerService.searchByDepartment(department, pageable);
    }

    @GetMapping("/projected/{name}")
    public List<CustomerClosed> getCustomerProjections(@PathVariable String name) {
        return customerService.getCustomersProjected(name);
    }

    @GetMapping("/projected-open/{name}")
    public List<CustomerOpen> getCustomerProjectionsOpen(@PathVariable String name) {
        return customerService.getCustomersProjectedOpen(name);
    }


    @GetMapping("/projected-query/{dept}")
    public List<CustomerOpen> getCustomerByNameProjected(@PathVariable String dept) {
        return customerService.getCustomerByDeptWithQueryProjected(dept);
    }

}
