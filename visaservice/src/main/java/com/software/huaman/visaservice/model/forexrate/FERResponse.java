
package com.software.huaman.visaservice.model.forexrate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FERResponse {

    @SerializedName("cardAcceptor")
    @Expose
    private CardAcceptor cardAcceptor;
    @SerializedName("destinationCurrencyCode")
    @Expose
    private String destinationCurrencyCode;
    @SerializedName("markUpRate")
    @Expose
    private String markUpRate;
    @SerializedName("retrievalReferenceNumber")
    @Expose
    private String retrievalReferenceNumber;
    @SerializedName("sourceAmount")
    @Expose
    private String sourceAmount;
    @SerializedName("sourceCurrencyCode")
    @Expose
    private String sourceCurrencyCode;
    @SerializedName("systemsTraceAuditNumber")
    @Expose
    private String systemsTraceAuditNumber;

    public CardAcceptor getCardAcceptor() {
        return cardAcceptor;
    }

    public void setCardAcceptor(CardAcceptor cardAcceptor) {
        this.cardAcceptor = cardAcceptor;
    }

    public String getDestinationCurrencyCode() {
        return destinationCurrencyCode;
    }

    public void setDestinationCurrencyCode(String destinationCurrencyCode) {
        this.destinationCurrencyCode = destinationCurrencyCode;
    }

    public String getMarkUpRate() {
        return markUpRate;
    }

    public void setMarkUpRate(String markUpRate) {
        this.markUpRate = markUpRate;
    }

    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
        this.retrievalReferenceNumber = retrievalReferenceNumber;
    }

    public String getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(String sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    public void setSourceCurrencyCode(String sourceCurrencyCode) {
        this.sourceCurrencyCode = sourceCurrencyCode;
    }

    public String getSystemsTraceAuditNumber() {
        return systemsTraceAuditNumber;
    }

    public void setSystemsTraceAuditNumber(String systemsTraceAuditNumber) {
        this.systemsTraceAuditNumber = systemsTraceAuditNumber;
    }

}
