package com.telephone;

import org.apache.log4j.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Test class to test TelephoneDirectoryImpl methods
 */
public class TelephoneDirectoryTest {

    private static final Logger logger = Logger.getLogger(TelephoneDirectoryTest.class);

    private static Stream<Arguments> getCustomerPhoneNumbersData() {
        return Stream.of(
                Arguments.of(getCustomersList1(),
                        Arrays.asList("0489029382", "0489029231", "0489029122", "0489029114", "0489029115", "0489029118", "0489029190", "0489029108")),
                Arguments.of(getCustomersList2(),
                        Arrays.asList("0489029100", "0489029120", "0489029388", "0489029194"))
        );
    }

    private static Stream<Arguments> getCustomerPhoneNumbersDataFail() {
        return Stream.of(
                Arguments.of(getCustomersList3(), null),
                Arguments.of(Arrays.asList(new Customer()), null)
        );
    }

    private static Stream<Arguments> getAllPhoneNumbersForCusomterIdData() {
        return Stream.of(
                Arguments.of(getCustomersList1(), 400100,
                        Arrays.asList("0489029382", "0489029231", "0489029122", "0489029114")),
                Arguments.of(getCustomersList2(), 400102,
                        Arrays.asList("0489029100", "0489029120", "0489029388", "0489029194")),
                Arguments.of(getCustomersList2(), 0,
                        Arrays.asList())
        );
    }

    private static Stream<Arguments> getActivatePhoneNumberData() {
        return Stream.of(
                Arguments.of(getCustomersList1(), 400100, "0489029382", true),
                Arguments.of(getCustomersList1(), 400101, "0489029108", true),
                Arguments.of(getCustomersList2(), 400102, "0489029194", true),
                Arguments.of(getCustomersList2(), 400102, "", false),
                Arguments.of(getCustomersList2(), 0, "0489029194", false),
                Arguments.of(getCustomersList2(), 0, "", false)
        );
    }


    @ParameterizedTest
    @MethodSource(value = "getCustomerPhoneNumbersData")
    void testGetAllPhoneNumbers(List<Customer> customersData, List expectedPhoneNums) {
        TelephoneDirectory telephoneDirectory = new TelephoneDirectoryImpl(customersData);
        assertEquals(expectedPhoneNums, telephoneDirectory.getAllPhoneNumbers());
    }

    @ParameterizedTest
    @MethodSource(value = "getCustomerPhoneNumbersDataFail")
    void testGetAllPhoneNumbersFail(List<Customer> customersData, String expectedMessage) {
        TelephoneDirectory telephoneDirectory = new TelephoneDirectoryImpl(customersData);
        Throwable exception = assertThrows(NullPointerException.class, () -> telephoneDirectory.getAllPhoneNumbers());
        System.out.println("Exception cause " + exception.getCause());
        assertEquals(expectedMessage, exception.getCause());
    }

    @ParameterizedTest
    @MethodSource(value = "getAllPhoneNumbersForCusomterIdData")
    void testGetAllPhoneNumbersForCusomterId(List<Customer> customersData, int customerId, List expectedPhoneNums) {
        TelephoneDirectory telephoneDirectory = new TelephoneDirectoryImpl(customersData);
        assertEquals(expectedPhoneNums, telephoneDirectory.getAllPhoneNumbers(customerId));

    }

    @ParameterizedTest
    @MethodSource(value = "getActivatePhoneNumberData")
    void testActivatePhoneNumber(List<Customer> customersData, int customerId, String phoneNumber, boolean expectedMessage) {
        TelephoneDirectory telephoneDirectory = new TelephoneDirectoryImpl(customersData);
        telephoneDirectory.activatePhoneNumber(customerId, phoneNumber);
        List result = customersData.stream().
                filter(a -> a.getCustomerId() == customerId).
                flatMap(a -> a.getPhoneNumbers().stream().filter(x -> x.getPhoneNumber().equals(phoneNumber)))
                .map(x -> x.isActive()).collect(Collectors.toList());

        if (result.size() > 0)
            assertTrue((boolean) result.get(0));
        else
            assertEquals(expectedMessage, false);
    }

    public static List<Customer> getCustomersList1() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(400100, Arrays.asList(new PhoneNumber(Optional.ofNullable("0489029382"), false),
                new PhoneNumber(Optional.ofNullable("0489029231"), false),
                new PhoneNumber(Optional.ofNullable("0489029122"), false),
                new PhoneNumber(Optional.ofNullable("0489029114"), true))));
        customers.add(new Customer(400101, Arrays.asList(new PhoneNumber(Optional.ofNullable("0489029115"), false),
                new PhoneNumber(Optional.ofNullable("0489029118"), false),
                new PhoneNumber(Optional.ofNullable("0489029190"), false),
                new PhoneNumber(Optional.ofNullable("0489029108"), true))));
        return customers;
    }

    public static List<Customer> getCustomersList2() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(400102, Arrays.asList(new PhoneNumber(Optional.ofNullable("0489029100"), false),
                new PhoneNumber(Optional.ofNullable("0489029120"), false),
                new PhoneNumber(Optional.ofNullable("0489029388"), false),
                new PhoneNumber(Optional.ofNullable("0489029194"), false))));
        return customers;
    }

    public static List<Customer> getCustomersList3() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(400102, null));
        return customers;
    }


}
