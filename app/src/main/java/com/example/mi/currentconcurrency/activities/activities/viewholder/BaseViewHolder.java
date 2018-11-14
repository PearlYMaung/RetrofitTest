package com.example.mi.currentconcurrency.activities.activities.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public  abstract class BaseViewHolder<P> extends RecyclerView.ViewHolder implements View.OnClickListener{
    //P for VO
    protected P mData;
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
    }

    public void setmData(P mData) {
        this.mData = mData;
    }

    @Override
    public void onClick(View v) {


    }
    public abstract void bind(Context context);

}
