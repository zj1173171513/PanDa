package com.jiyun.asus.panda.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jiyun.asus.panda.bean.Bean;
import com.jiyun.asus.panda.ui.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/9/12.
 */

public class FragPaAdater extends FragmentStatePagerAdapter {
    private List<Bean> list;

    public FragPaAdater(FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();
        list.add(new Bean("首页",HomeFragment.class));
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) list.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }
}
