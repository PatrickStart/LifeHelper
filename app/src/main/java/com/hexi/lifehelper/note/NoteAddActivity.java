package com.hexi.lifehelper.note;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hexi.lifehelper.R;
import com.hexi.lifehelper.base.BaseActivity;
import com.hexi.lifehelper.db.NotesDB;

import java.text.SimpleDateFormat;

/**
 * Created by he.xx on 2016/8/1.
 */
public class NoteAddActivity extends BaseActivity {
    EditText ed_title,ed_content;
    Button btn_add;
    String date;
    SimpleDateFormat sdf;
    NotesDB db;
    Intent intent;
    Bundle bundle;
    NotesEntity intentEntity;

    @Override
    public void setLayout() {
        setContentView(R.layout.note_add);
        intent = this.getIntent();
        if (intent != null){
            bundle = intent.getExtras();
            if (bundle != null){
                intentEntity = (NotesEntity) bundle.getSerializable("entity");
            }

        }
    }

    @Override
    public void loadData() {
        sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        db = new NotesDB(this);
        ed_title = (EditText) findViewById(R.id.note_ed_title);
        ed_content = (EditText) findViewById(R.id.note_ed_content);
        btn_add = (Button) findViewById(R.id.note_btn_add);
        btn_add.setOnClickListener(this);
    }

    @Override
    public void setView() {
        if (intentEntity != null){
            ed_title.setText(intentEntity.getTitle());
            ed_content.setText(intentEntity.getContent());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.note_btn_add:
                String title = ed_title.getText().toString();
                String content = ed_content.getText().toString();
                long time = System.currentTimeMillis();
                date = sdf.format(time);
                NotesEntity entity = new NotesEntity(title,date,content);
                db.addNote(entity);
                startActivity(NotesActivity.class,R.anim.enter_alpha,R.anim.exit_alpha);
                finish();
                break;
        }
    }
}
