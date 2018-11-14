
package com.example.mi.currentconcurrency.activities.activities.data.vos;

import com.google.gson.annotations.SerializedName;


public class CurrencyVO {

    @SerializedName("base")
    private String mBase;
    @SerializedName("date")
    private String mDate;
    @SerializedName("rates")
    private Rates mRates;
    @SerializedName("success")
    private Boolean mSuccess;
    @SerializedName("timestamp")
    private Long mTimestamp;

    public String getBase() {
        return mBase;
    }

    public void setBase(String base) {
        mBase = base;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public Rates getRates() {
        return mRates;
    }

    public void setRates(Rates rates) {
        mRates = rates;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

    public Long getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(Long timestamp) {
        mTimestamp = timestamp;
    }

}
