package com.fawry.customer.customer;

import org.springframework.beans.factory.annotation.Value;

public interface CustomerOpen {
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
