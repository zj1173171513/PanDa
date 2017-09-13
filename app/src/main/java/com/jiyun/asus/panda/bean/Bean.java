package com.jiyun.asus.panda.bean;

/**
 * Created by ASUS on 2017/9/12.
 */

public class Bean {
    private String title;
    private Class fragment;

    public Bean(String title, Class fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
