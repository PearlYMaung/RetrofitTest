package com.example.mi.currentconcurrency.activities.activities.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;


import com.example.mi.currentconcurrency.activities.activities.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter <P extends BaseViewHolder,M> extends RecyclerView.Adapter<P> {
    //P for ViewHolder that exteds base ViewHolder
    protected List<M> mList;
    protected LayoutInflater mLayoutInflater;

    public BaseRecyclerAdapter(Context context){
        mList = new ArrayList<>();
        mLayoutInflater = LayoutInflater.from(context);

    }
    @Override
    public void onBindViewHolder(@NonNull P holder, int i) {
        if(mList.size() > 0) {
            holder.setmData(mList.get(i));
            holder.bind(mLayoutInflater.getContext());
        }
    }
    @Override
    public int getItemCount() {
        if(mList != null)
            return mList.size();
        else return 0;
    }
    public void setData(List<M> data){
        mList = data;
        notifyDataSetChanged();
    }
}