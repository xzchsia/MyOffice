package com.tianyapeng.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by TianYapeng on 2017/2/17 0017.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentsList;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentsList) {
        super(fm);
        this.fragmentsList = fragmentsList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
