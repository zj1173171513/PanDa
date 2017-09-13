package com.jiyun.asus.panda.ui.activity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jiyun.asus.panda.R;
import com.jiyun.asus.panda.ui.fragment.BroadcastFragment;
import com.jiyun.asus.panda.ui.fragment.ChinaFragment;
import com.jiyun.asus.panda.ui.fragment.HomeFragment;
import com.jiyun.asus.panda.ui.fragment.LiveFragment;
import com.jiyun.asus.panda.ui.fragment.VideoFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.main_toolbat_img)
    ImageView mainToolbatImg;
    @Bind(R.id.main_toolbar)
    Toolbar mainToolbar;

    @Bind(R.id.main_home)
    RadioButton mainHome;
    @Bind(R.id.main_live)
    RadioButton mainLive;
    @Bind(R.id.main_video)
    RadioButton mainVideo;
    @Bind(R.id.main_broadcast)
    RadioButton mainBroadcast;
    @Bind(R.id.main_china)
    RadioButton mainChina;
    @Bind(R.id.main_tab_bar)
    RadioGroup mainTabBar;
    @Bind(R.id.mFragment)
    FrameLayout mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().add(
                R.id.mFragment, new HomeFragment()).commit();
        initToolbar();
        initRadio();
    }

    private void initRadio() {
        mainHome.setBackgroundColor(Color.parseColor("#a29e9f"));
        mainHome.setOnClickListener(this);
        mainLive.setOnClickListener(this);
        mainVideo.setOnClickListener(this);
        mainChina.setOnClickListener(this);
        mainBroadcast.setOnClickListener(this);
    }

    private void initToolbar() {
        mainToolbar.inflateMenu(R.menu.right);
        mainToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mInteractive:
                        startActivity(new Intent(MainActivity.this,InteractionActivity.class));
                        break;
                    case R.id.mPersonal:
                        startActivity(new Intent(MainActivity.this,PersonalActivity.class));
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        mainHome.setBackgroundColor(Color.parseColor("#ffffff"));
        mainLive.setBackgroundColor(Color.parseColor("#ffffff"));
        mainVideo.setBackgroundColor(Color.parseColor("#ffffff"));
        mainBroadcast.setBackgroundColor(Color.parseColor("#ffffff"));
        mainChina.setBackgroundColor(Color.parseColor("#ffffff"));
        switch (view.getId()) {
            case R.id.main_home:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mFragment, new HomeFragment())
                        .commit();
                mainHome.setBackgroundColor(R.color.main_tab_item_text_color);
                break;
            case R.id.main_live:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mFragment, new LiveFragment())
                        .commit();
                mainLive.setBackgroundColor(R.color.main_tab_item_text_color);
                break;
            case R.id.main_video:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mFragment, new VideoFragment())
                        .commit();
                mainVideo.setBackgroundColor(R.color.main_tab_item_text_color);
                break;
            case R.id.main_broadcast:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mFragment, new BroadcastFragment())
                        .commit();
                mainBroadcast.setBackgroundColor(R.color.main_tab_item_text_color);
                break;
            case R.id.main_china:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mFragment, new ChinaFragment())
                        .commit();
                mainChina.setBackgroundColor(R.color.main_tab_item_text_color);
                break;
        }
    }
}
