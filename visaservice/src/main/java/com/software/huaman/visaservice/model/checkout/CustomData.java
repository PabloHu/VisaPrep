
package com.software.huaman.visaservice.model.checkout;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomData {

    @SerializedName("nvPair")
    @Expose
    private List<NvPair> nvPair = null;

    public List<NvPair> getNvPair() {
        return nvPair;
    }

    public void setNvPair(List<NvPair> nvPair) {
        this.nvPair = nvPair;
    }

}
