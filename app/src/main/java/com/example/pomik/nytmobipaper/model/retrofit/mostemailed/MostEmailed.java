package com.example.pomik.nytmobipaper.model.retrofit.mostemailed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MostEmailed {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("results")
    @Expose
    private MostEmailedResult[] results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public MostEmailedResult[] getResults() {
        return results;
    }

    public void setResults(MostEmailedResult[] results) {
        this.results = results;
    }
}
