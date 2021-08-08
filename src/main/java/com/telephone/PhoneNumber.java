package com.telephone;

import java.util.Optional;

public class PhoneNumber {

    private Optional<String> phoneNumber;

    private boolean isActive = false;

    public PhoneNumber(Optional<String> phoneNumber, boolean isActive) {
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(Optional<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
