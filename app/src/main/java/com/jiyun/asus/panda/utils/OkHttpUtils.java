package com.jiyun.asus.panda.utils;

import com.jiyun.asus.panda.app.AppService;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ASUS on 2017/9/13.
 */

public class OkHttpUtils {
    private static OkHttpUtils utils;
    private OkHttpClient client;
    private OkHttpUtils(){
        client = new OkHttpClient();
    }
    public static synchronized OkHttpUtils getInstance(){
        if (utils == null){
            utils = new OkHttpUtils();
            return utils;
        }
        return null;
    }
    public void getRequest(Callback callback){
        Request request = new Request.Builder().url(AppService.HOME_UTL).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
