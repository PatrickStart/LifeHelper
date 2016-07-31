package com.hexi.lifehelper.lead;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by he.xx on 2016/7/31.
 */
public class LeadPagerAdapter extends PagerAdapter {
    List<View> list;
    Context mC;

    public LeadPagerAdapter(Context mC) {
        this.mC = mC;
        list = new ArrayList<View>();
    }

    public List<View> getList() {
        return list;
    }

    public void setList(List<View> list) {
        this.list = list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
