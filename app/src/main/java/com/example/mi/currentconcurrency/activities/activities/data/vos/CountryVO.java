
package com.example.mi.currentconcurrency.activities.activities.data.vos;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CountryVO {

    public CountryVO(Boolean mSuccess, Symbols mSymbols) {
        this.mSuccess = mSuccess;
        this.mSymbols = mSymbols;
    }

    @SerializedName("success")

    private Boolean mSuccess;
    @SerializedName("symbols")
    private Symbols mSymbols;

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

    public Symbols getSymbols() {
        return mSymbols;
    }

    public void setSymbols(Symbols symbols) {
        mSymbols = symbols;
    }

}
