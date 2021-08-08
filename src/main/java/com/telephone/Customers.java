package com.telephone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Customers {
    public static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(1,
                Arrays.asList(new PhoneNumber(Optional.ofNullable("0426789908"), false),
                        new PhoneNumber(Optional.ofNullable("0426789901"), false),
                        new PhoneNumber(Optional.ofNullable("0426789902"), false),
                        new PhoneNumber(Optional.ofNullable("0426789934"), false))));

        customers.add(new Customer(2,
                Arrays.asList(new PhoneNumber(Optional.ofNullable("0426789923"), false),
                        new PhoneNumber(Optional.ofNullable("0426789989"), false),
                        new PhoneNumber(Optional.ofNullable("0426789990"), false),
                        new PhoneNumber(Optional.ofNullable("0426789910"), false))));
        return customers;
    }
}
