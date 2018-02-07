
package com.software.huaman.visaservice.model.checkout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("encUserId")
    @Expose
    private String encUserId;
    @SerializedName("userEmail")
    @Expose
    private String userEmail;
    @SerializedName("userFirstName")
    @Expose
    private String userFirstName;
    @SerializedName("userFullName")
    @Expose
    private String userFullName;
    @SerializedName("userLastName")
    @Expose
    private String userLastName;
    @SerializedName("userName")
    @Expose
    private String userName;

    public String getEncUserId() {
        return encUserId;
    }

    public void setEncUserId(String encUserId) {
        this.encUserId = encUserId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
