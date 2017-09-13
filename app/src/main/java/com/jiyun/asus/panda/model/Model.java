package com.jiyun.asus.panda.model;

import android.util.Log;

import com.google.gson.Gson;
import com.jiyun.asus.panda.bean.InfoBean;
import com.jiyun.asus.panda.utils.OkHttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ASUS on 2017/9/13.
 */

public class Model implements IGetUser{

    @Override
    public void getRequset(final IModelUser iModelUser) {
        OkHttpUtils.getInstance().getRequest(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG","1111111"+e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                InfoBean infoBean = gson.fromJson(string, InfoBean.class);
                List<InfoBean> list = new ArrayList<InfoBean>();
                list.add(infoBean);
                iModelUser.sueeccd(list);
            }
        });
    }
}
