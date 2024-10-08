package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

    @Test
    public void givenCustomerWithPositiveBalanceAndPositiveAmount_whenWithdraw_thenSuccess() {
        Customer customer = new Customer();
        customer.setBalance(100);
        AccountManager accountManager = new AccountManagerImpl();
        String result = accountManager.withdraw(customer, 50);
        Assertions.assertEquals("success", result);
    }

    @Test
    public void givenCustomerWithZeroBalance_whenWithdraw_thenFailure() {
        Customer customer = new Customer();
        customer.setBalance(0);
        AccountManager accountManager = new AccountManagerImpl();
        String result = accountManager.withdraw(customer, 50);
        Assertions.assertEquals("insufficient account balance", result);
    }

    @Test
    public void givenCustomerWithPositiveBalanceAndLargeAmount_whenWithdraw_thenFailure() {
        Customer customer = new Customer();
        customer.setBalance(100);
        AccountManager accountManager = new AccountManagerImpl();
        String result = accountManager.withdraw(customer, 150);
        Assertions.assertEquals("insufficient account balance", result);
    }

    @Test
    public void givenCustomerWithCreditAllowedAndLowAmount_whenWithdraw_thenSuccess() {
        Customer customer = new Customer();
        customer.setCreditAllowed(true);
        customer.setBalance(50);
        AccountManager accountManager = new AccountManagerImpl();
        String result = accountManager.withdraw(customer, 100);
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(-50, customer.getBalance());
    }

    @Test
    public void givenCustomerWithCreditAllowedAndExpectedBalanceMoreThanMAXCREDIT_whenWithdraw_thenFailure() {
        Customer customer = new Customer();
        customer.setBalance(50);
        customer.setCreditAllowed(true);
        AccountManager accountManager = new AccountManagerImpl();
        String result = accountManager.withdraw(customer, 3000);
        Assertions.assertEquals("maximum credit exceeded", result);
    }

    @Test
    public void givenVIPCustomerWithCreditAllowedAndExpectedBalanceMoreThanMAXCREDIT_whenWithdraw_thenSuccess() {
        Customer customer = new Customer();
        customer.setCreditAllowed(true);
        customer.setBalance(50);
        customer.setVip(true);
        AccountManager accountManager = new AccountManagerImpl();
        String result = accountManager.withdraw(customer, 1100);
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(-1050, customer.getBalance());
    }

    @Test
    public void givenCustomerAndNegativeAmount_whenWithdraw_thenFailure() {
        Customer customer = new Customer();
        customer.setBalance(50);
        AccountManager accountManager = new AccountManagerImpl();
        String result = accountManager.withdraw(customer, -500);
        Assertions.assertEquals("Amount must be greater than 0", result);
    }


}
