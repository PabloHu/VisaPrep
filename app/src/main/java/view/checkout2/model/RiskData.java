
package view.checkout2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RiskData {

    @SerializedName("advice")
    @Expose
    private String advice;
    @SerializedName("avsResponseCode")
    @Expose
    private String avsResponseCode;
    @SerializedName("cvvResponseCode")
    @Expose
    private String cvvResponseCode;
    @SerializedName("score")
    @Expose
    private Integer score;

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getAvsResponseCode() {
        return avsResponseCode;
    }

    public void setAvsResponseCode(String avsResponseCode) {
        this.avsResponseCode = avsResponseCode;
    }

    public String getCvvResponseCode() {
        return cvvResponseCode;
    }

    public void setCvvResponseCode(String cvvResponseCode) {
        this.cvvResponseCode = cvvResponseCode;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
