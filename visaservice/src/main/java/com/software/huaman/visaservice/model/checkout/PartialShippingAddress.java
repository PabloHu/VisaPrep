
package com.software.huaman.visaservice.model.checkout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartialShippingAddress {

    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}
