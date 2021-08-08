package com.telephone;

import java.util.List;

public class Customer {

    public Customer() {
    }

    public Customer(int customerId, List<PhoneNumber> phoneNumbers) {
        this.customerId = customerId;
        this.phoneNumbers = phoneNumbers;
    }

    private int customerId;

    private List<PhoneNumber> phoneNumbers;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
