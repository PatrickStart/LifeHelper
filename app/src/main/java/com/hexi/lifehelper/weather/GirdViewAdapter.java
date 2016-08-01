package com.hexi.lifehelper.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hexi.lifehelper.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by he.xx on 2016/8/1.
 */
public class GirdViewAdapter extends BaseAdapter {
    List<String> list;
    Context mC;

    public GirdViewAdapter(Context mC) {
        this.mC = mC;
        list = new ArrayList<String>();
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mC).inflate(R.layout.weather_item,null);
            holder.tv = (TextView) convertView.findViewById(R.id.weather_item_tv);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position));

        return convertView;
    }

    class ViewHolder{
        TextView tv;
    }
}
