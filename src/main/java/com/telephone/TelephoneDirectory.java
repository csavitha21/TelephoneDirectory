package com.telephone;

import java.util.List;

public interface TelephoneDirectory {

    public List<String> getAllPhoneNumbers();

    public List<String> getAllPhoneNumbers(int customerId);

    public void activatePhoneNumber(int customerId, String phoneNumber);

}
