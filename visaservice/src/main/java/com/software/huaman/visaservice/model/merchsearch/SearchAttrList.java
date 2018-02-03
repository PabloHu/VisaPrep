
package com.software.huaman.visaservice.model.merchsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchAttrList {

    @SerializedName("merchantName")
    @Expose
    private String merchantName;
    @SerializedName("merchantCity")
    @Expose
    private String merchantCity;
    @SerializedName("merchantState")
    @Expose
    private String merchantState;
    @SerializedName("merchantPostalCode")
    @Expose
    private String merchantPostalCode;
    @SerializedName("merchantCountryCode")
    @Expose
    private String merchantCountryCode;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantCity() {
        return merchantCity;
    }

    public void setMerchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
    }

    public String getMerchantState() {
        return merchantState;
    }

    public void setMerchantState(String merchantState) {
        this.merchantState = merchantState;
    }

    public String getMerchantPostalCode() {
        return merchantPostalCode;
    }

    public void setMerchantPostalCode(String merchantPostalCode) {
        this.merchantPostalCode = merchantPostalCode;
    }

    public String getMerchantCountryCode() {
        return merchantCountryCode;
    }

    public void setMerchantCountryCode(String merchantCountryCode) {
        this.merchantCountryCode = merchantCountryCode;
    }

}
