
package view.checkout2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillingAddress {

    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("line1")
    @Expose
    private String line1;
    @SerializedName("personName")
    @Expose
    private String personName;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("stateProvinceCode")
    @Expose
    private String stateProvinceCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStateProvinceCode() {
        return stateProvinceCode;
    }

    public void setStateProvinceCode(String stateProvinceCode) {
        this.stateProvinceCode = stateProvinceCode;
    }

}
