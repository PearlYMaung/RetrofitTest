package com.example.mi.currentconcurrency.activities.activities.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.example.mi.currentconcurrency.activities.activities.data.model.AppModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private AppModel mAppModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        mAppModel = ViewModelProviders.of(this).get(AppModel.class);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(getDisplayBackButton());
        }
        ButterKnife.bind(this,this);

    }

    protected abstract boolean getDisplayBackButton();

    public abstract int getLayout() ;

    public AppModel getmAppModel() {
        return mAppModel;
    }




}
