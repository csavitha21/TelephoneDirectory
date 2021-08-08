package com.telephone;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.stream.Collectors;

public class TelephoneDirectoryImpl implements TelephoneDirectory {

    private static final Logger logger = Logger.getLogger(TelephoneDirectoryImpl.class);

    List<Customer> customers;

    public TelephoneDirectoryImpl(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public List<String> getAllPhoneNumbers() {
        logger.debug("Inside getAllPhoneNumbers");
        return customers.stream().
                flatMap(a -> a.getPhoneNumbers().stream().
                        map(x -> x.getPhoneNumber())).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllPhoneNumbers(int customerId) {
        logger.debug("Inside getAllPhoneNumbers for CustomerID");
        logger.debug("CustomerID " + customerId);
        return customers.stream().filter(a -> a.getCustomerId() == customerId).
                flatMap(a -> a.getPhoneNumbers().stream().
                        map(x -> x.getPhoneNumber())).collect(Collectors.toList());
    }

    @Override
    public void activatePhoneNumber(int customerId, String phoneNumber) {
        logger.debug("Inside activatePhoneNumber");
        logger.debug("CustomerID " + customerId);
        logger.debug("Phone number " + phoneNumber);

        //Print updated customer's phone numbers list
        customers.stream().filter(a -> a.getCustomerId() == customerId).
                forEach(a -> a.getPhoneNumbers().stream().filter(x -> x.getPhoneNumber().equals(phoneNumber)).
                        forEach(x -> logger.debug("PhoneNumber status before activation: " + x.isActive())));

        customers.stream().
                filter(a -> a.getCustomerId() == customerId).
                forEach(a -> a.getPhoneNumbers().stream().
                        filter(x -> x.getPhoneNumber().equals(phoneNumber)).
                        forEach(x -> x.setActive(true)));

        //Print updated customer's phone numbers list
        customers.stream().filter(a -> a.getCustomerId() == customerId).
                forEach(a -> a.getPhoneNumbers().stream().filter(x -> x.getPhoneNumber().equals(phoneNumber)).
                        forEach(x -> logger.debug("PhoneNumber status after activation: " + x.isActive())));

    }
}
