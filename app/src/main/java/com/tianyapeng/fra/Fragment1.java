package com.tianyapeng.fra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tianyapeng.act.R;

/**
 * Created by TianYapeng on 2017/2/17 0017.
 */

public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fra1_layout, container, false);
        return view;
    }
}
