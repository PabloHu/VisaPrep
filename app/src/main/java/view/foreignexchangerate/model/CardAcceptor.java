package view.foreignexchangerate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardAcceptor {

    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("idCode")
    @Expose
    private String idCode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("terminalId")
    @Expose
    private String terminalId;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

}
