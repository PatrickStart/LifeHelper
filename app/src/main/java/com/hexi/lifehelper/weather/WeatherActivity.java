package com.hexi.lifehelper.weather;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
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
    TextView drawerEd;
    TextView weatherTvSk;
    TextView weatherTvToday;
    TextView weatherTvFuture;
    GridView drawergridview;
    GirdViewAdapter adapter;
    List<String> list;
    android.support.v7.widget.Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    LinearLayout ll;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    WeatherEntity entity = (WeatherEntity) msg.obj;
                    showInfo(entity);
//                    Log.i("msg",entity.toString());
                    break;
            }
        }
    };

    public void showInfo(WeatherEntity entity){
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
        weatherTvSk.setText(city+"\n"+"当前温度："+temp
                            +"\t\t"+wind+"\n"+"更新时间："+time);
        weatherTvToday.setText(today+"\t"+week+"\n"+weather+
                            "\t"+temper+"\n"+advice);
        StringBuffer sbf = new StringBuffer();
        for (int i = 0;i < listF.size();i++){
            WeatherEntity.Result.Future future = listF.get(i);
            sbf.append(future.toString());
        }
        weatherTvFuture.setText(sbf.toString());
    }
    @Override
    public void setLayout() {
        setContentView(R.layout.weather);
        getData("成都");
        list = new ArrayList<String>();

    }

    @Override
    public void loadData() {
        drawerEd = (TextView) findViewById(R.id.drawer_ed);
        weatherTvSk = (TextView) findViewById(R.id.weather_tv_sk);
        weatherTvToday = (TextView) findViewById(R.id.weather_tv_today);
        weatherTvFuture = (TextView) findViewById(R.id.weather_tv_future);
        drawergridview = (GridView) findViewById(R.id.drawer_gridview);
        ll = (LinearLayout) findViewById(R.id.drawer_ll);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.weather_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.weather_drawer);
        toolbar.setTitle("天气预报");
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
        list.add("成都");
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("遵义");
        list.add("贵阳");
        list.add("安顺");
        list.add("深圳");
        list.add("都江堰");
        list.add("云南");
        list.add("重庆");
        list.add("绵阳");
    }

    @Override
    public void setView() {
        adapter = new GirdViewAdapter(this);
        adapter.setList(list);
        drawergridview.setAdapter(adapter);
        drawergridview.setOnItemClickListener(listener);
        ll.setOnClickListener(this);
    }

    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           String city = list.get(position);
            getData(city);
        }
    };

    public void getData(String cityname) {
        String cityn = cityname;
        String url = JuheAPI.WEATHER_API + cityn + "&key=" + JuheAPI.WEATHER_KEY;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
//                Log.i("msg",s);
            WeatherEntity entity = new Gson().fromJson(s,WeatherEntity.class);
//                Log.i("msg",entity.toString());
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
        switch (v.getId()){
            case R.id.drawer_ll:

                break;
        }
    }

}
