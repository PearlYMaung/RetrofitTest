package com.example.mi.currentconcurrency.activities.activities.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.example.mi.currentconcurrency.R;
import com.example.mi.currentconcurrency.activities.activities.data.vos.CountryNamesVO;
import com.example.mi.currentconcurrency.activities.activities.data.vos.CountryVO;
import com.example.mi.currentconcurrency.activities.activities.delegate.CountryCheckCallBack;
import com.example.mi.currentconcurrency.activities.activities.viewholder.CountryViewHolder;
public class CountryRecyclerAdapter extends BaseRecyclerAdapter<CountryViewHolder,CountryNamesVO> {

    public CountryRecyclerAdapter(Context context) {
        super(context);

    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CountryViewHolder(mLayoutInflater.inflate(R.layout.item_view_country, viewGroup, false));
    }



}