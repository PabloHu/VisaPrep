
package view.checkout2.viewmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import view.checkout2.model.PartialShippingAddress;
import view.checkout2.model.PaymentInstrument;
import view.checkout2.model.PaymentRequest;
import view.checkout2.model.RiskData;
import view.checkout2.model.ShippingAddress;
import view.checkout2.model.UserData;

public class CheckoutResponse {

    @SerializedName("creationTimeStamp")
    @Expose
    private Integer creationTimeStamp;
    @SerializedName("partialShippingAddress")
    @Expose
    private view.checkout2.model.PartialShippingAddress partialShippingAddress;
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

    public CheckoutResponse(view.checkout2.model.CheckoutResponse checkoutResponse){

        this.partialShippingAddress = checkoutResponse.getPartialShippingAddress();
    }



}
