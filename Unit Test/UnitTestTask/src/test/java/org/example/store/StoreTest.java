package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {

    @Test
    public void givenProductWithPositiveQuantityAndCustomerWithBalance_whenBuy_thenSuccess() {
        Product product = new Product();
        product.setQuantity(10);
        product.setPrice(550);

        Customer customer = new Customer();
        customer.setBalance(700);

        Store store = new StoreImpl(new MockSuccessAccountManager());
        store.buy(product, customer);

        Assertions.assertEquals(9, product.getQuantity());
    }

    @Test
    public void givenProductWithZeroQuantityAndCustomerWithBalance_whenBuy_thenFailure() {
        Product product = new Product();
        product.setQuantity(0);
        product.setPrice(550);
        Customer customer = new Customer();
        customer.setBalance(700);
        Store store = new StoreImpl(new MockSuccessAccountManager());
        try {
            store.buy(product, customer);
        } catch (Exception e) {
            Assertions.assertEquals("Product out of stock", e.getMessage());
        }
    }

    @Test
    public void givenProductAndAccountManagerStatusNotSuccess_whenBuy_thenFailure() {
        Product product = new Product();
        product.setQuantity(10);
        product.setPrice(550);
        Customer customer = new Customer();
        customer.setBalance(700);
        Store store = new StoreImpl(new MockFailureAccountManager());
        try {
            store.buy(product, customer);
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().contains("Payment failure: "));
        }
    }

    static class MockSuccessAccountManager implements AccountManager {

        @Override
        public void deposit(Customer customer, int amount) {

        }

        @Override
        public String withdraw(Customer customer, int amount) {
            return "success";
        }
    }

    static class MockFailureAccountManager implements AccountManager {
        @Override
        public void deposit(Customer customer, int amount) {

        }

        @Override
        public String withdraw(Customer customer, int amount) {
            return "insufficient account balance";
        }
    }

}
