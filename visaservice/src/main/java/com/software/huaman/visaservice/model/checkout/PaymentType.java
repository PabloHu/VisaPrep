
package com.software.huaman.visaservice.model.checkout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentType {

    @SerializedName("cardBrand")
    @Expose
    private String cardBrand;
    @SerializedName("cardType")
    @Expose
    private String cardType;

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

}
