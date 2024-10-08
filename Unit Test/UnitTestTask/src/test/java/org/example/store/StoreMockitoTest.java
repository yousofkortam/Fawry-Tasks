package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class StoreMockitoTest {

    @Mock
    AccountManager accountManager;
    private StoreImpl store;

    @Test
    public void givenProductWithPositiveQuantityAndCustomerWithBalance_whenBuy_thenSuccess() {
        accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(Matchers.any(), Matchers.anyInt()))
                .thenReturn("success");
        store = new StoreImpl(accountManager);

        Product product = new Product();
        product.setQuantity(10);
        product.setPrice(550);

        Customer customer = new Customer();
        customer.setBalance(700);

        store.buy(product, customer);

        assertThat(product.getQuantity()).isEqualTo(9);
    }

    @Test
    public void givenProductWithZeroQuantityAndCustomerWithBalance_whenBuy_thenFailure() {
        accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(Matchers.any(), Matchers.anyInt()))
                .thenReturn("success");
        store = new StoreImpl(accountManager);

        Product product = new Product();
        product.setQuantity(0);
        product.setPrice(550);

        Customer customer = new Customer();
        customer.setBalance(700);

//        try {
//            store.buy(product, customer);
//        } catch (Exception e) {
//            Assertions.assertEquals("Product out of stock", e.getMessage());
//        }

        // Use assertJ instead
        assertThatThrownBy(() -> store.buy(product, customer))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Product out of stock");
    }

    @Test
    public void givenProductAndAccountManagerStatusNotSuccess_whenBuy_thenFailure() {
        // Handle failure status account manager.
        accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(Matchers.any(), Matchers.anyInt()))
                .thenReturn("failure");
        store = new StoreImpl(accountManager);

        Product product = new Product();
        product.setQuantity(10);
        product.setPrice(550);

        Customer customer = new Customer();
        customer.setBalance(700);

//        try {
//            store.buy(product, customer);
//        } catch (Exception e) {
//            Assertions.assertTrue(e.getMessage().contains("Payment failure: "));
//        }

        // Use assertJ instead
        assertThatThrownBy(() -> store.buy(product, customer))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Payment failure:");
    }

}
