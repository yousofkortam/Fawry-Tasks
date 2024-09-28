package com.fawry.customer.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c " +
            "WHERE (:id IS NULL OR c.id = :id) " +
            "AND (:name IS NULL OR :name = '' OR " +
            "UPPER(CONCAT(c.firstName, ' ', c.lastName)) LIKE UPPER(CONCAT('%', :name, '%'))) " +
            "AND (:department IS NULL OR :department = '' OR UPPER(c.department) LIKE UPPER(CONCAT('%', :department, '%')))")
    Page<Customer> filterCustomers(Long id, String name, String department, Pageable pageable);

    @Query("SELECT c FROM Customer c " +
            "WHERE (:id IS NULL OR c.id = :id) " +
            "AND (:name IS NULL OR :name = '' OR " +
            "UPPER(CONCAT(c.firstName, ' ', c.lastName)) LIKE UPPER(CONCAT('%', :name, '%'))) " +
            "AND (:department IS NULL OR :department = '' OR UPPER(c.department) LIKE UPPER(CONCAT('%', :department, '%')))")
    List<Customer> filterCustomers(Long id, String name, String department);

    @Query("SELECT c FROM Customer c " +
    "WHERE UPPER(CONCAT(c.firstName, '', c.lastName)) LIKE UPPER(CONCAT('%', :name, '%'))")
    List<Customer> findByName(String name);

    @Query("SELECT c FROM Customer c " +
            "WHERE UPPER(CONCAT(c.firstName, '', c.lastName)) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Customer> findByName(String name, Pageable pageable);

    List<Customer> findByDepartmentContainingIgnoreCase(String department);
    Page<Customer> findByDepartmentContainingIgnoreCase(String department, Pageable pageable);

    List<CustomerClosed> findByFirstName(String firstName);
    List<CustomerOpen> findByLastName(String lastName);

    @Query("SELECT c FROM Customer c " +
            "WHERE UPPER(c.department) LIKE UPPER(:dept)")
    List<CustomerOpen> getCustomerByDeptProjected(String dept);

}
