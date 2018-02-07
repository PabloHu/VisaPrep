
package view.checkout2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentInstrument {

    @SerializedName("billingAddress")
    @Expose
    private BillingAddress billingAddress;
    @SerializedName("binSixDigits")
    @Expose
    private String binSixDigits;
    @SerializedName("cardArts")
    @Expose
    private CardArts cardArts;
    @SerializedName("cardFirstName")
    @Expose
    private String cardFirstName;
    @SerializedName("cardLastName")
    @Expose
    private String cardLastName;
    @SerializedName("expirationDate")
    @Expose
    private ExpirationDate expirationDate;
    @SerializedName("expired")
    @Expose
    private Boolean expired;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("issuerBid")
    @Expose
    private String issuerBid;
    @SerializedName("lastFourDigits")
    @Expose
    private String lastFourDigits;
    @SerializedName("nameOnCard")
    @Expose
    private String nameOnCard;
    @SerializedName("nickName")
    @Expose
    private String nickName;
    @SerializedName("paymentType")
    @Expose
    private PaymentType paymentType;
    @SerializedName("verificationStatus")
    @Expose
    private String verificationStatus;

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBinSixDigits() {
        return binSixDigits;
    }

    public void setBinSixDigits(String binSixDigits) {
        this.binSixDigits = binSixDigits;
    }

    public CardArts getCardArts() {
        return cardArts;
    }

    public void setCardArts(CardArts cardArts) {
        this.cardArts = cardArts;
    }

    public String getCardFirstName() {
        return cardFirstName;
    }

    public void setCardFirstName(String cardFirstName) {
        this.cardFirstName = cardFirstName;
    }

    public String getCardLastName() {
        return cardLastName;
    }

    public void setCardLastName(String cardLastName) {
        this.cardLastName = cardLastName;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssuerBid() {
        return issuerBid;
    }

    public void setIssuerBid(String issuerBid) {
        this.issuerBid = issuerBid;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

}
