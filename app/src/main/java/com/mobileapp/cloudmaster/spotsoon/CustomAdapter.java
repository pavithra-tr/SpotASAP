package com.mobileapp.cloudmaster.spotsoon;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pavithra on 22-05-2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;
    private static ItemClickListener clickListener;
    Typeface typefaceR, typefaceT, typefaceL;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName, textViewRate, textViewVersion;
        ImageView imageViewIcon, textViewPrice;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textView2);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textView3);
            this.textViewRate = (TextView) itemView.findViewById(R.id.textView4);
            this.textViewPrice = (ImageView) itemView.findViewById(R.id.imageView3);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView2);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
        }
    }


    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);
        typefaceR = Typeface.createFromAsset(parent.getContext().getAssets(), "fonts/Roboto-Bold.ttf");
        typefaceT = Typeface.createFromAsset(parent.getContext().getAssets(), "fonts/Roboto-Medium.ttf");
        typefaceL = Typeface.createFromAsset(parent.getContext().getAssets(), "fonts/Roboto-Light.ttf");
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        TextView textViewRate = holder.textViewRate;
        ImageView textViewPrice = holder.textViewPrice;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewName.setTypeface(typefaceR);
        textViewVersion.setText(dataSet.get(listPosition).getRate());
        textViewVersion.setTypeface(typefaceT);
        textViewRate.setText(dataSet.get(listPosition).getDes());
        textViewRate.setTypeface(typefaceL);
        textViewPrice.setImageResource(dataSet.get(listPosition).getId());
        imageView.setImageResource(dataSet.get(listPosition).getImage());

    }

    public void setClickListener(ItemClickListener itemClickListener) {
        clickListener = itemClickListener;
    }

    public void addItem(DataModel dataObj, int index) {
        dataSet.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        dataSet.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
