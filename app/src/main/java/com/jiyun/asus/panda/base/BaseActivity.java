package com.jiyun.asus.panda.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by ASUS on 2017/9/13.
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initClick();
        initData();
        initAdapter();
    }

    protected abstract void initAdapter();
    public abstract int initLayout();
    public abstract void initView();
    public abstract void initData();
    public abstract void initClick();

    public void showToast(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
