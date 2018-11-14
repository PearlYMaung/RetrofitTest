package com.example.mi.currentconcurrency.activities.activities.data.model;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.widget.Toast;

import com.example.mi.currentconcurrency.activities.activities.data.vos.CountryVO;
import com.example.mi.currentconcurrency.activities.activities.data.vos.CurrencyVO;
import com.example.mi.currentconcurrency.activities.activities.delegate.CountryCheckCallBack;
import com.example.mi.currentconcurrency.activities.activities.delegate.DataCheckCallBack;
import com.example.mi.currentconcurrency.activities.activities.network.CurrencyAPI;
import com.example.mi.currentconcurrency.activities.activities.utils.APIConstant;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressLint("CheckResult")
public class AppModel extends AndroidViewModel {
    private CurrencyAPI mCurrencyAPI;
    CountryVO countryVO;
    public AppModel(Application context){
        super(context);
         initAPI();
    }

    private void initAPI() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        mCurrencyAPI = retrofit.create(CurrencyAPI.class);

    }

    public void loadCurrency(Context context, String accessKey, final DataCheckCallBack dataCheckCallBack){
        mCurrencyAPI.loadCurrency(accessKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers
                        .mainThread())
                .subscribe(new Consumer<CurrencyVO>() {
                    @Override
                    public void accept(CurrencyVO currencyVO) throws Exception {
                        if(currencyVO != null){
                            dataCheckCallBack.checkCurrency(true);
                        }
                        else
                            dataCheckCallBack.checkCurrency(false);
                    }
                });

    }
    public void loadCountry(final Context context, String accessKey, final CountryCheckCallBack countryCheckCallBack){
        mCurrencyAPI.loadCountry(accessKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CountryVO>() {
                    @Override
                    public void accept(CountryVO countryVO) throws Exception {
                        if(countryVO != null)
                            countryCheckCallBack.checkCountry(countryVO);
                        else
                            Toast.makeText(context,"No Country VO",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
