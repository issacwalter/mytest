package com.example.he.debugapplication;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by He on 2016/3/6.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    private int headerCount = 1;


    private List<String> itemList;
    private Context context;
    private LayoutInflater layoutInflater;

    public RecyclerAdapter(List itemList) {
        this.itemList = itemList;
        for(int i = 0;i<headerCount;i++){
            itemList.add(0,null);
        }
    }

    public RecyclerAdapter(Context context,List itemList){
        this.itemList = itemList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public boolean isHeaderView(int position) {
        return headerCount != 0 && position < headerCount;
    }

    @Override
    public int getItemViewType(int position) {
        //for gridview
//        if (headerCount != 0 && position < headerCount) {
//            return ITEM_TYPE_HEADER;
//        } else {
//            return ITEM_TYPE_CONTENT;
//        }

        return ITEM_TYPE_CONTENT;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE_HEADER) {
            return new HeaderHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_header, parent, false));
        } else {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false));
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderHolder) {
            Log.d("TTEST", "onBindViewHolder" + itemList.get(position));
        } else {
            ((MyViewHolder) holder).tv.setText(itemList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_text);
        }
    }

    static class HeaderHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public HeaderHolder(View headerView) {
            super(headerView);
            tv = (TextView) itemView.findViewById(R.id.header_text);
        }
    }

}
