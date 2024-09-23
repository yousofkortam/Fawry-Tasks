package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class StoreMockitoTest {

    @Mock
    AccountManager accountManager;
    private StoreImpl store;

    @BeforeEach
    public void beforeEachTestFunction() {
        accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(Matchers.any(), Matchers.anyInt()))
                .thenReturn("success");
        store = new StoreImpl(accountManager);
    }

    @Test
    public void givenProductWithPositiveQuantityAndCustomerWithBalance_whenBuy_thenSuccess() {
        Product product = new Product();
        product.setQuantity(10);
        product.setPrice(550);

        Customer customer = new Customer();
        customer.setBalance(700);

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

        try {
            store.buy(product, customer);
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().contains("Payment failure: "));
        }
    }

}
