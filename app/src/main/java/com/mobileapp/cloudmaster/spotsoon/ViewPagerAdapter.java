package com.mobileapp.cloudmaster.spotsoon;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Pavithra on 23-05-2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mResources;
    private int[] mName;
    private String[] mPrice;
    private String[] mReview;
    private static ItemClickListener clickListener;

    public ViewPagerAdapter(Context mContext, int[] mResources, int[] mName, String[] mPrice, String[] mReview) {
        this.mContext = mContext;
        this.mResources = mResources;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mReview = mReview;

    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        ImageView im = (ImageView) itemView.findViewById(R.id.imageView4);
        TextView textView = (TextView) itemView.findViewById(R.id.textView6);
        TextView tv = (TextView) itemView.findViewById(R.id.textView5);
        imageView.setImageResource(mResources[position]);
        im.setImageResource(mName[position]);
        textView.setText(mReview[position]);
        tv.setText(mPrice[position]);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        clickListener = itemClickListener;
    }

}
