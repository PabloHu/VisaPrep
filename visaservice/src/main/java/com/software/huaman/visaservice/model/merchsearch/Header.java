
package com.software.huaman.visaservice.model.merchsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header {

    @SerializedName("requestMessageId")
    @Expose
    private String requestMessageId;
    @SerializedName("startIndex")
    @Expose
    private String startIndex;
    @SerializedName("messageDateTime")
    @Expose
    private String messageDateTime;

    public String getRequestMessageId() {
        return requestMessageId;
    }

    public void setRequestMessageId(String requestMessageId) {
        this.requestMessageId = requestMessageId;
    }

    public String getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

    public String getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(String messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

}
