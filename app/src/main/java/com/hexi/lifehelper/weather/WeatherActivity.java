package com.hexi.lifehelper.weather;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hexi.lifehelper.R;
import com.hexi.lifehelper.base.BaseActivity;
import com.hexi.lifehelper.http.JuheAPI;
import com.hexi.lifehelper.http.VolleySingleton;
import com.nostra13.universalimageloader.utils.L;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by he.xx on 2016/8/1.
 */
public class WeatherActivity extends BaseActivity {
    TextView weatherTvSk;
    TextView weatherTvToday;
    TextView weatherTvFuture;
    NavigationView navigationView;
    android.support.v7.widget.Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    WeatherEntity entity = (WeatherEntity) msg.obj;
                    showInfo(entity);
                    break;
            }
        }
    };


    @Override
    public void setLayout() {
        setContentView(R.layout.weather);
        getData("成都");//进来首先显示成都天气预报
    }

    @Override
    public void loadData() {
        weatherTvSk = (TextView) findViewById(R.id.weather_tv_sk);
        weatherTvToday = (TextView) findViewById(R.id.weather_tv_today);
        weatherTvFuture = (TextView) findViewById(R.id.weather_tv_future);
        navigationView = (NavigationView) findViewById(R.id.drawer_navigation);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.weather_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.weather_drawer);
        toolbar.setTitle("天气预报");
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        toggle.syncState();//toolbar和drawerlayout关联同步
        drawerLayout.addDrawerListener(toggle);
    }

    @Override
    public void setView() {
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    private NavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_cq:
                    getData("重庆");
                    break;
                case R.id.menu_cd:
                    getData("成都");
                    break;
                case R.id.menu_as:
                    getData("安顺");
                    break;
                case R.id.menu_gy:
                    getData("贵阳");
                    break;
                case R.id.menu_zy:
                    getData("遵义");
                    break;
                case R.id.menu_yn:
                    getData("云南");
                    break;
                case R.id.menu_djy:
                    getData("都江堰");
                    break;
                case R.id.menu_bj:
                    getData("北京");
                    break;
                case R.id.menu_sh:
                    getData("上海");
                    break;
                case R.id.menu_gz:
                    getData("广州");
                    break;

            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

    };


    public void getData(String cityname) {
        String cityn = cityname;
        String url = JuheAPI.WEATHER_API + cityn + "&key=" + JuheAPI.WEATHER_KEY;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.i("msg", s);
                WeatherEntity entity = new Gson().fromJson(s, WeatherEntity.class);
                Log.i("msg", entity.toString());
                Message msg = new Message();
                msg.what = 0;
                msg.obj = entity;
                handler.sendMessage(msg);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        VolleySingleton.getVolleySingleton(this).addToRequestQueue(request);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }


    public void showInfo(WeatherEntity entity) {
        if (entity != null && entity.getResultcode().equals("200")) {
            String city = entity.getResult().getToday().getCity();
            String temp = entity.getResult().getSk().getTemp();
            String time = entity.getResult().getSk().getTime();
            String wind = entity.getResult().getSk().getWind_direction();
            String today = entity.getResult().getToday().getDate_y();
            String week = entity.getResult().getToday().getWeek();
            String weather = entity.getResult().getToday().getWeather();
            String advice = entity.getResult().getToday().getDressing_advice();
            String temper = entity.getResult().getToday().getTemperature();
            List<WeatherEntity.Result.Future> listF = entity.getResult().getFuture();
            weatherTvSk.setText(city + "\n" + "当前温度：" + temp
                    + "\t\t" + wind + "\n" + "更新时间：" + time);
            weatherTvToday.setText(today + "\t" + week + "\n" + weather +
                    "\t" + temper + "\n" + advice);
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < listF.size(); i++) {
                WeatherEntity.Result.Future future = listF.get(i);
                sbf.append(future.toString());
            }
            weatherTvFuture.setText(sbf.toString());
        } else if (entity != null && entity.getResultcode().equals("202")) {
            weatherTvToday.setText(entity.getReason());
        } else {
            getData("成都");
        }
    }
}
