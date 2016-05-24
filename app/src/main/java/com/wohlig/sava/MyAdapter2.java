package com.wohlig.sava;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {


    List<String> data;
    Context mContext;

    public MyAdapter2(List<String> data,Context mContext){
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public MyAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CardView cardView = (CardView) inflater.inflate(R.layout.list_item,null);
        ViewHolder viewHolder = new ViewHolder(cardView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView2.setText(data.get(position));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            textView2 = (TextView) itemView.findViewById(R.id.info_text2);
        }
    }

}
