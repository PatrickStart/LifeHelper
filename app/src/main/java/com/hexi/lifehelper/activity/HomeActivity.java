package com.hexi.lifehelper.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hexi.lifehelper.R;
import com.hexi.lifehelper.base.BaseActivity;
import com.hexi.lifehelper.cook.CookActivity;
import com.hexi.lifehelper.news.NewsActivity;
import com.hexi.lifehelper.note.NotesActivity;
import com.hexi.lifehelper.weather.WeatherActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by he.xx on 2016/7/31.
 */
public class HomeActivity extends BaseActivity {

    @Bind(R.id.home_weather)
    Button homeWeather;
    @Bind(R.id.home_cook)
    Button homeCook;
    @Bind(R.id.home_news)
    Button homeNews;
    @Bind(R.id.home_note)
    Button homeNote;

    @Override
    public void setLayout() {
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setView() {
        homeCook.setOnClickListener(this);
        homeWeather.setOnClickListener(this);
        homeNews.setOnClickListener(this);
        homeNote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_weather:
                startActivity(WeatherActivity.class,R.anim.enter_alpha,R.anim.exit_alpha);
                break;

            case R.id.home_cook:
                startActivity(CookActivity.class,R.anim.enter_alpha,R.anim.exit_alpha);
                break;

            case R.id.home_news:
                startActivity(NewsActivity.class,R.anim.enter_alpha,R.anim.exit_alpha);
                break;

            case R.id.home_note:
                startActivity(NotesActivity.class,R.anim.enter_alpha,R.anim.exit_alpha);
                break;
        }
    }
}
