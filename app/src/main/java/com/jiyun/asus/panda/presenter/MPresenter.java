package com.jiyun.asus.panda.presenter;

import com.jiyun.asus.panda.model.IGetUser;
import com.jiyun.asus.panda.model.IModelUser;
import com.jiyun.asus.panda.model.Model;
import com.jiyun.asus.panda.ui.view.IGetView;

import java.util.List;

/**
 * Created by ASUS on 2017/9/13.
 */

public class MPresenter {
    private IGetView iGetView;
    private IGetUser modelUser;

    public MPresenter(IGetView iGetView) {
        this.iGetView = iGetView;
        modelUser = new Model();
    }
    public void getData(){
//        iGetView.showLoading();
        modelUser.getRequset(new IModelUser() {
            @Override
            public void sueeccd(List info) {
                iGetView.toMainSucceed(info);
            }

            @Override
            public void fail(String e) {
                iGetView.toMainFail(e);
            }
        });
    }
}
