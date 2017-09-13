package com.jiyun.asus.panda.ui.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.asus.panda.R;
import com.jiyun.asus.panda.adapter.InteractionAdapter;
import com.jiyun.asus.panda.base.BaseActivity;
import com.jiyun.asus.panda.bean.InfoBean;
import com.jiyun.asus.panda.presenter.MPresenter;
import com.jiyun.asus.panda.ui.view.IGetView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InteractionActivity extends BaseActivity implements IGetView {
    private List<InfoBean.InteractiveBean> mList = new ArrayList<>();

    @Bind(R.id.interaction_Listview)
    ListView interactionListview;
    private MPresenter mPresenter;

    @Bind(R.id.interaction_finish)
    TextView interactionFinish;
    @Bind(R.id.inter_toolbar)
    Toolbar interToolbar;
    private InteractionAdapter interactionAdapter;


    @Override
    protected void initAdapter() {
        interactionAdapter = new InteractionAdapter(mList, this);
        interactionListview.setAdapter(interactionAdapter);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_interaction;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

    }

    @Override
    public void initData() {
        mPresenter = new MPresenter(this);
        mPresenter.getData();
    }

    @Override
    public void initClick() {
        interactionFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismisLoading() {

    }

    @Override
    public void toMainSucceed(final List<InfoBean> info) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mList.addAll(info.get(0).getInteractive());
                Toast.makeText(InteractionActivity.this, ""+info.get(0).getInteractive().get(2).getTitle(), Toast.LENGTH_SHORT).show();
                interactionAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void toMainFail(final String e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(InteractionActivity.this, ""+e, Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
//    }
}
