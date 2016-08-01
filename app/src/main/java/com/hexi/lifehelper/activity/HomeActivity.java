package com.hexi.lifehelper.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hexi.lifehelper.R;
import com.hexi.lifehelper.base.BaseActivity;

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

    }

    @Override
    public void onClick(View v) {

    }
}
