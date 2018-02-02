package com.software.huaman.visaservice.contentprovider;

/**
 * Created by kiwic on 2/1/2018.
 */

public class ContactObj {
    String name;
    String phone;

    public ContactObj(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}