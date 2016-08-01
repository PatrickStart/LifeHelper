package com.hexi.lifehelper.base;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by he.xx on 2016/7/30.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout();
        loadData();
        setView();
    }

    //设置布局
    public abstract void setLayout();


    //加载数据
    public abstract void loadData();

    //设置View
    public abstract void setView();




    /**
     * 启动跳转
     * @param c 目标Activity
     * @param inId  页面载入动画
     * @param outId 页面退出动画
     */
    public void startActivity(Class c, int inId, int outId){
        Intent intent=new Intent(this,c);
        startActivity(intent);
        overridePendingTransition(inId,outId);
    }

    /**
     * 带参数传递的跳转方法
     * @param c 目标Activity
     * @param inId  页面载入动画
     * @param outId 页面退出动画
     * @param bundle 参数传递体
     */
    public void startActivity(Class c, int inId, int outId,Bundle bundle){
        Intent intent=new Intent(this,c);
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(inId,outId);
    }

}
