package com.hexi.lifehelper.note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hexi.lifehelper.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by he.xx on 2016/8/1.
 */
public class NotesAdapter extends BaseAdapter{
    List<NotesEntity> list;
    Context mC;

    public NotesAdapter(Context mC) {
        this.mC = mC;
        list = new ArrayList<NotesEntity>();
    }

    public List<NotesEntity> getList() {
        return list;
    }

    public void setList(List<NotesEntity> list) {
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
            convertView = LayoutInflater.from(mC).inflate(R.layout.note_item,null);
            holder.tv_title = (TextView) convertView.findViewById(R.id.note_item_tv_title);
            holder.tv_content = (TextView) convertView.findViewById(R.id.note_item_tv_content);
            holder.tv_date = (TextView) convertView.findViewById(R.id.note_item_tv_date);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_content.setText(list.get(position).getContent());
        holder.tv_date.setText(list.get(position).getDate());
        return convertView;
    }

    class ViewHolder{
        TextView tv_title,tv_content,tv_date;
    }
}
