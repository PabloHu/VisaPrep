
package com.software.huaman.visaservice.model.merchsearch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchOptions {

    @SerializedName("wildCard")
    @Expose
    private List<String> wildCard = null;
    @SerializedName("maxRecords")
    @Expose
    private String maxRecords;
    @SerializedName("matchIndicators")
    @Expose
    private String matchIndicators;
    @SerializedName("matchScore")
    @Expose
    private String matchScore;
    @SerializedName("proximity")
    @Expose
    private List<String> proximity = null;

    public List<String> getWildCard() {
        return wildCard;
    }

    public void setWildCard(List<String> wildCard) {
        this.wildCard = wildCard;
    }

    public String getMaxRecords() {
        return maxRecords;
    }

    public void setMaxRecords(String maxRecords) {
        this.maxRecords = maxRecords;
    }

    public String getMatchIndicators() {
        return matchIndicators;
    }

    public void setMatchIndicators(String matchIndicators) {
        this.matchIndicators = matchIndicators;
    }

    public String getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(String matchScore) {
        this.matchScore = matchScore;
    }

    public List<String> getProximity() {
        return proximity;
    }

    public void setProximity(List<String> proximity) {
        this.proximity = proximity;
    }

}
