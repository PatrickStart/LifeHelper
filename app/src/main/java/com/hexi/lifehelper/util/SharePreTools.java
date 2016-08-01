package com.hexi.lifehelper.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by he.xx on 2016/7/30.
 */
public class SharePreTools {
    Context mC;
    public static SharePreTools sharePreTools = null;

    private SharePreTools(Context mC){
        this.mC = mC;
    }

    public static SharePreTools getInstance(Context mC){
        if (sharePreTools == null){
            sharePreTools = new SharePreTools(mC);
        }
        return sharePreTools;
    }

    //判断是否是第一次使用
    public void isFirstUse(){
        SharedPreferences preferences = mC.getSharedPreferences("isFirst",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isfirst",false);
        editor.commit();
    }

    public boolean getIsFirstUse(){
        SharedPreferences preferences = mC.getSharedPreferences("isFirst",Context.MODE_PRIVATE);
        return preferences.getBoolean("isfirst",true);
    }
}
