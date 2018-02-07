
package view.checkout2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckoutResponse {

    @SerializedName("creationTimeStamp")
    @Expose
    private Integer creationTimeStamp;
    @SerializedName("partialShippingAddress")
    @Expose
    private PartialShippingAddress partialShippingAddress;
    @SerializedName("paymentInstrument")
    @Expose
    private PaymentInstrument paymentInstrument;
    @SerializedName("paymentRequest")
    @Expose
    private PaymentRequest paymentRequest;
    @SerializedName("riskData")
    @Expose
    private RiskData riskData;
    @SerializedName("shippingAddress")
    @Expose
    private ShippingAddress shippingAddress;
    @SerializedName("userData")
    @Expose
    private UserData userData;

    public Integer getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Integer creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public PartialShippingAddress getPartialShippingAddress() {
        return partialShippingAddress;
    }

    public void setPartialShippingAddress(PartialShippingAddress partialShippingAddress) {
        this.partialShippingAddress = partialShippingAddress;
    }

    public PaymentInstrument getPaymentInstrument() {
        return paymentInstrument;
    }

    public void setPaymentInstrument(PaymentInstrument paymentInstrument) {
        this.paymentInstrument = paymentInstrument;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }

    public RiskData getRiskData() {
        return riskData;
    }

    public void setRiskData(RiskData riskData) {
        this.riskData = riskData;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

}
