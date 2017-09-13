package com.jiyun.asus.panda.ui.view;

import com.jiyun.asus.panda.bean.InfoBean;

import java.util.List;

/**
 * Created by ASUS on 2017/9/13.
 */

public interface IGetView {
    void showLoading();
    void dismisLoading();

    void toMainSucceed(List<InfoBean> s);
    void toMainFail(String e);
}
