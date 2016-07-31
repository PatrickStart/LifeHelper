package com.hexi.lifehelper.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by he.xx on 2016/7/30.
 */
public class JuheAPI {

    public static final String NEWS_URL = "http://v.juhe.cn/toutiao/index";

    public static final String NEWS_KEY = "74a91900551faf66efcbf982de9a96b0";

    public static final String WEATHER_API = "http://v.juhe.cn/weather/index?format=2&cityname=";

    public static final String WEATHER_KEY = "2a847e65a9fee974394ad479646ab61a";

    public static final String COOK_API = "http://apis.juhe.cn/cook/query.php";

    public static final String COOK_KEY = "b81523dc4b2fcb47d1c0ee069430726c";

    public static final String NEWS_HOT_URL = null;


    //拼接地址
    public static String getNewsUrl(String type){
        String path=NEWS_URL+"?type="+ChangeEncode(type);
        return path;
    }


    //修改编码
    public static String ChangeEncode(String type){
        try {
            type= URLEncoder.encode(type,"utf-8");
        } catch (UnsupportedEncodingException e) {
            type="null";
        }
        return type;

    }
}
