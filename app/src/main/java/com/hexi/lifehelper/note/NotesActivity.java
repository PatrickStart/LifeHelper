package com.hexi.lifehelper.note;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.hexi.lifehelper.R;
import com.hexi.lifehelper.base.BaseActivity;
import com.hexi.lifehelper.db.NotesDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by he.xx on 2016/8/1.
 */
public class NotesActivity extends BaseActivity {
    ImageView img_add;
    List<NotesEntity> list;
    ListView listView;
    NotesDB db;
    NotesAdapter adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void setLayout() {
        setContentView(R.layout.notes);
    }

    @Override
    public void loadData() {
        img_add = (ImageView) findViewById(R.id.note_main_img_add);
        list = new ArrayList<NotesEntity>();
        listView = (ListView) findViewById(R.id.note_main_listview);
        db = new NotesDB(this);
    }

    @Override
    public void setView() {
        list = db.getAllTag();
        adapter = new NotesAdapter(this);
        adapter.setList(list);
        listView.setAdapter(adapter);
        img_add.setOnClickListener(this);
        listView.setOnItemClickListener(listener);
        listView.setOnItemLongClickListener(longClickListener);
    }

    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView tv_title = (TextView) view.findViewById(R.id.note_item_tv_title);
            TextView tv_content = (TextView) view.findViewById(R.id.note_item_tv_content);
            TextView tv_date = (TextView) view.findViewById(R.id.note_item_tv_date);
            String title = tv_title.getText().toString();
            String content = tv_content.getText().toString();
            String date = tv_date.getText().toString();
            NotesEntity entity = new NotesEntity(title, date, content);
            Bundle bundle = new Bundle();
            bundle.putSerializable("entity",entity);
            startActivity(NoteAddActivity.class,R.anim.enter_alpha,R.anim.exit_alpha,bundle);
            finish();
        }
    };

    private AdapterView.OnItemLongClickListener longClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            TextView tv = (TextView) view.findViewById(R.id.note_item_tv_date);
            final String date = tv.getText().toString();
            AlertDialog.Builder builder = new AlertDialog.Builder(NotesActivity.this);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle("确定删除这条便签嘛！");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.delete(date);
                    list = db.getAllTag();
                    adapter.setList(list);
                    listView.setAdapter(adapter);
                }
            });
            builder.setNegativeButton("取消", null);
            builder.create();
            builder.show();
            return true;
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.note_main_img_add:
                startActivity(NoteAddActivity.class, R.anim.enter_alpha, R.anim.exit_alpha);
                finish();
                break;
        }
    }

}
