
package com.software.huaman.visaservice.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MSResponse {

    @SerializedName("searchAttrList")
    @Expose
    private SearchAttrList searchAttrList;
    @SerializedName("responseAttrList")
    @Expose
    private List<String> responseAttrList = null;
    @SerializedName("searchOptions")
    @Expose
    private SearchOptions searchOptions;
    @SerializedName("header")
    @Expose
    private Header header;

    public SearchAttrList getSearchAttrList() {
        return searchAttrList;
    }

    public void setSearchAttrList(SearchAttrList searchAttrList) {
        this.searchAttrList = searchAttrList;
    }

    public List<String> getResponseAttrList() {
        return responseAttrList;
    }

    public void setResponseAttrList(List<String> responseAttrList) {
        this.responseAttrList = responseAttrList;
    }

    public SearchOptions getSearchOptions() {
        return searchOptions;
    }

    public void setSearchOptions(SearchOptions searchOptions) {
        this.searchOptions = searchOptions;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

}
