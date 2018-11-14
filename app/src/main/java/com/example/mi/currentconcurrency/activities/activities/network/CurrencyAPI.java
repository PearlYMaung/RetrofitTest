package com.example.mi.currentconcurrency.activities.activities.network;
import com.example.mi.currentconcurrency.activities.activities.data.vos.CountryVO;
import com.example.mi.currentconcurrency.activities.activities.data.vos.CurrencyVO;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyAPI {

    @GET("latest")
    Single<CurrencyVO> loadCurrency(
            @Query("access_key") String accessKey
     );

    @GET("symbols")
    Single<CountryVO> loadCountry(
            @Query("access_key") String accessKey
    );
}
