package com.telephone;

import org.apache.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        TelephoneDirectory telephoneDirectory = new TelephoneDirectoryImpl(Customers.getAllCustomers());

        List<String> phoneNumbers = telephoneDirectory.getAllPhoneNumbers();
        logger.debug("Below is the list of all Phone Numbers \n"+phoneNumbers);

        List<String> phoneNumbers1 = telephoneDirectory.getAllPhoneNumbers(2);
        logger.debug("Below is the list of Phone Numbers for given customer \n"+phoneNumbers1);

        logger.debug("Activated phone number for the given customer");
        telephoneDirectory.activatePhoneNumber(2,"0426789923");

    }

}
