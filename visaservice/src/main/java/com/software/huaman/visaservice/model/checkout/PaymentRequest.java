
package com.software.huaman.visaservice.model.checkout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentRequest {

    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("customData")
    @Expose
    private CustomData customData;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("giftWrap")
    @Expose
    private String giftWrap;
    @SerializedName("merchantRequestId")
    @Expose
    private String merchantRequestId;
    @SerializedName("misc")
    @Expose
    private String misc;
    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("promoCode")
    @Expose
    private String promoCode;
    @SerializedName("shippingHandling")
    @Expose
    private String shippingHandling;
    @SerializedName("subtotal")
    @Expose
    private String subtotal;
    @SerializedName("tax")
    @Expose
    private String tax;
    @SerializedName("total")
    @Expose
    private String total;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public CustomData getCustomData() {
        return customData;
    }

    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getGiftWrap() {
        return giftWrap;
    }

    public void setGiftWrap(String giftWrap) {
        this.giftWrap = giftWrap;
    }

    public String getMerchantRequestId() {
        return merchantRequestId;
    }

    public void setMerchantRequestId(String merchantRequestId) {
        this.merchantRequestId = merchantRequestId;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getShippingHandling() {
        return shippingHandling;
    }

    public void setShippingHandling(String shippingHandling) {
        this.shippingHandling = shippingHandling;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
