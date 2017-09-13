package com.jiyun.asus.panda.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asus.panda.ui.view.IGetView;

/**
 * Created by ASUS on 2017/9/13.
 */

public abstract class BaseFragment extends Fragment implements IGetView {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(initLayout(), null);
        initData();
        initClick();
        initAdapter();
        return view;
    }
    public abstract int initLayout();
    public abstract void initData();
    public abstract void initClick();
    public abstract void initAdapter();
}
