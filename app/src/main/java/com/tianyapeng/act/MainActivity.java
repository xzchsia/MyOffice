package com.tianyapeng.act;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tianyapeng.adapter.MyFragmentPagerAdapter;

import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.tianyapeng.fra.Fragment1;
import com.tianyapeng.fra.Fragment2;
import com.tianyapeng.fra.Fragment3;
import com.tianyapeng.fra.Fragment4;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    //定义四个Fragment
    private Fragment1 fg1;
    private Fragment2 fg2;
    private Fragment3 fg3;
    private Fragment4 fg4;

    //定义一个ViewPager容器
    ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private MyFragmentPagerAdapter adapter;

    //定义FragmentManager对象
    private FragmentManager fManager;

    //定义OnClick全局对象
    public MyOnClick myclik;
    public MyPageChangeListener myPageChange;

    //获得每一个Layout对象
    RelativeLayout message_layout;
    RelativeLayout yingyong_layout;
    RelativeLayout tongxunlu_layout;
    RelativeLayout me_layout;

    //获得导航栏底部的ImageView和TextView
    ImageView message_img;
    ImageView yingyong_img;
    ImageView tongxunlu_img;
    ImageView me_img;

    TextView message_text;
    TextView yingyong_text;
    TextView tongxunlu_text;
    TextView me_text;

    //颜色值
    private int Gray = 0xFF999999;
    private int Green = 0xFF42c27b;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        //实例化FragmentManager
        fManager = getSupportFragmentManager();
        initViewPager();
        initViews();
        //初始化状态
        initState();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initViewPager() {
        fragmentsList = new ArrayList<Fragment>();
        fg1 = new Fragment1();
        fg2 = new Fragment2();
        fg3 = new Fragment3();
        fg4 = new Fragment4();

        fragmentsList.add(fg1);
        fragmentsList.add(fg2);
        fragmentsList.add(fg3);
        fragmentsList.add(fg4);
        adapter = new MyFragmentPagerAdapter(fManager, fragmentsList);
    }

    private void initViews() {
        mPager = (ViewPager) findViewById(R.id.viewPager);
        message_layout = (RelativeLayout) findViewById(R.id.message_layout);
        yingyong_layout = (RelativeLayout) findViewById(R.id.yingyong_layout);
        tongxunlu_layout = (RelativeLayout) findViewById(R.id.tongxunlu_layout);
        me_layout = (RelativeLayout) findViewById(R.id.me_layout);
        message_img = (ImageView) findViewById(R.id.message_img);
        yingyong_img = (ImageView) findViewById(R.id.yingyong_img);
        tongxunlu_img = (ImageView) findViewById(R.id.tongxunlu_img);
        me_img = (ImageView) findViewById(R.id.me_img);
        message_text = (TextView) findViewById(R.id.message_text);
        yingyong_text = (TextView) findViewById(R.id.yingyong_text);
        tongxunlu_text = (TextView) findViewById(R.id.tongxunlu_text);
        me_text = (TextView) findViewById(R.id.me_text);

        myclik = new MyOnClick();
        myPageChange = new MyPageChangeListener();
        mPager.setAdapter(adapter);
        mPager.setOnPageChangeListener(myPageChange);
        message_layout.setOnClickListener(myclik);
        yingyong_layout.setOnClickListener(myclik);
        tongxunlu_layout.setOnClickListener(myclik);
        me_layout.setOnClickListener(myclik);
    }

    public void initState() {
        message_img.setImageResource(R.mipmap.toolbar_btn_message_focus);
        message_text.setTextColor(Green);
        mPager.setCurrentItem(0);
    }


    public class MyOnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            clearChioce();
            iconChange(v.getId());
        }
    }

    //清空选中状态的方法
    private void clearChioce() {
        message_img.setImageResource(R.mipmap.toolbar_btn_message_normal);
        message_text.setTextColor(Gray);
        yingyong_img.setImageResource(R.mipmap.toolbar_btn_app_normal);
        yingyong_text.setTextColor(Gray);
        tongxunlu_img.setImageResource(R.mipmap.toolbar_btn_address_normal);
        tongxunlu_text.setTextColor(Gray);
        me_img.setImageResource(R.mipmap.toolbar_btn_me_normal);
        me_text.setTextColor(Gray);
    }

    //定义一个底部导航栏图标变化的方法
    public void iconChange(int num) {

        switch (num) {
            case R.id.message_layout:
            case 0:
                message_img.setImageResource(R.mipmap.toolbar_btn_message_focus);
                message_text.setTextColor(Green);
                mPager.setCurrentItem(0);
                break;
            case R.id.yingyong_layout:
            case 1:
                yingyong_img.setImageResource(R.mipmap.toolbar_btn_app_focus);
                yingyong_text.setTextColor(Green);
                mPager.setCurrentItem(1);
                break;
            case R.id.tongxunlu_layout:
            case 2:
                tongxunlu_img.setImageResource(R.mipmap.toolbar_btn_address_focus);
                tongxunlu_text.setTextColor(Green);
                mPager.setCurrentItem(2);
                break;
            case R.id.me_layout:
            case 3:
                me_img.setImageResource(R.mipmap.toolbar_btn_me_focus);
                me_text.setTextColor(Green);
                mPager.setCurrentItem(3);
                break;
        }
    }

    public class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == 2) {
                int i = mPager.getCurrentItem();
                clearChioce();
                iconChange(i);
            }
        }
    }
}
