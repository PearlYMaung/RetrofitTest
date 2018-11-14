package com.example.mi.currentconcurrency.activities.activities.activities;

import android.app.AlertDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.mi.currentconcurrency.R;
import com.example.mi.currentconcurrency.activities.activities.adapter.CountryRecyclerAdapter;
import com.example.mi.currentconcurrency.activities.activities.data.model.AppModel;
import com.example.mi.currentconcurrency.activities.activities.data.vos.CountryNamesVO;
import com.example.mi.currentconcurrency.activities.activities.data.vos.CountryVO;
import com.example.mi.currentconcurrency.activities.activities.data.vos.Symbols;
import com.example.mi.currentconcurrency.activities.activities.delegate.CountryCheckCallBack;
import com.example.mi.currentconcurrency.activities.activities.delegate.DataCheckCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.rv_country_names)
    RecyclerView recyclerView;
    AppModel mAppModel;
    List<CountryNamesVO> mCountryVOList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean network_state=isNetworkAvailable();
        mAppModel = ViewModelProviders.of(this).get(AppModel.class);
//        if(network_state) {
//            mAppModel.loadCurrency(this, "3e485d20bffbf2c1757bfc21e13df564", new DataCheckCallBack() {
//                @Override
//                public void checkCurrency(boolean test) {
//                    if (test)
//                        Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
//                    else
//                        Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        }
//        else {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("No INTERNET")
//                    .setMessage("Internet Connection is required.")
//                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                            finish();
//                        }
//                    });
//            AlertDialog alertDialog = builder.create();
//            alertDialog.show();
//
//        }
        if(network_state){
            mAppModel.loadCountry(this, "3e485d20bffbf2c1757bfc21e13df564", new CountryCheckCallBack() {
                @Override
                public void checkCountry(CountryVO countryVO) {
                    if(countryVO != null) {
                        Log.e("Error",(countryVO.getSuccess()  )+" Found");

                        CountryNamesVO countryNamesVO = new CountryNamesVO(countryVO.getSymbols().getAED());
                        mCountryVOList.add(countryNamesVO);
                        countryNamesVO = new CountryNamesVO(countryVO.getSymbols().getAFN());
                        mCountryVOList.add(countryNamesVO);
                        countryNamesVO = new CountryNamesVO(countryVO.getSymbols().getALL());
                        mCountryVOList.add(countryNamesVO);
                        countryNamesVO = new CountryNamesVO(countryVO.getSymbols().getAMD());
                        mCountryVOList.add(countryNamesVO);
                        countryNamesVO = new CountryNamesVO(countryVO.getSymbols().getAOA());
                        mCountryVOList.add(countryNamesVO);
                        setUpRecyclerView();




                    }

                    else
                        Toast.makeText(MainActivity.this,"No VO is"+countryVO.getSymbols(),Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
               builder.setTitle("No INTERNET")
                      .setMessage("Internet Connection is required.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    private void setUpRecyclerView() {
        final CountryRecyclerAdapter mCountryRecyclerAdapter = new CountryRecyclerAdapter(this);
        recyclerView.setAdapter(mCountryRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCountryRecyclerAdapter.setData(mCountryVOList);

    }



    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

    @Override
    protected boolean getDisplayBackButton() {
        return false;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }
}
