package com.example.mi.currentconcurrency.activities.activities.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.mi.currentconcurrency.R;
import com.example.mi.currentconcurrency.activities.activities.data.vos.CountryNamesVO;
import com.example.mi.currentconcurrency.activities.activities.data.vos.CountryVO;
import com.example.mi.currentconcurrency.activities.activities.delegate.CountryCheckCallBack;

import butterknife.BindView;

public class CountryViewHolder extends BaseViewHolder<CountryNamesVO>{

    @BindView(R.id.tv_country)
    TextView tvCountry;



    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);

    }

    @Override
    public void bind(Context context) {
        tvCountry.setText(mData.getCountryName());
    }



}
