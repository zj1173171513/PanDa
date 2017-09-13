package com.jiyun.asus.panda.ui.fragment;


import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.jiyun.asus.panda.R;
import com.jiyun.asus.panda.base.BaseFragment;
import com.jiyun.asus.panda.bean.InfoBean;
import com.jiyun.asus.panda.presenter.MPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment{
    private MPresenter mPresenter;
    private ProgressDialog progressDialog;
    @Override
    public void showLoading() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.show();
    }

    @Override
    public void dismisLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void toMainSucceed(List<InfoBean> s) {

    }


    @Override
    public void toMainFail(final String e) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), ""+e, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initData() {
        mPresenter = new MPresenter(this);
//        mPresenter.getData();
    }

    @Override
    public void initClick() {

    }

    @Override
    public void initAdapter() {

    }


//    private ProgressDialog pd;
//
//    public HomeFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        pd = new ProgressDialog(getActivity());
//        MPresenter mPresenter = new MPresenter(this);
//        mPresenter.getData();
//        return view;
//    }
//
//    @Override
//    public void showLoading() {
//        pd.show();
//    }
//
//    @Override
//    public void dismisLoading() {
//        pd.dismiss();
//    }
//
//    @Override
//    public void toMainSucceed(final String s) {
//
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(getActivity(), ""+s, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    @Override
//    public void toMainFail(final String e) {
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(getActivity(), ""+e, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
