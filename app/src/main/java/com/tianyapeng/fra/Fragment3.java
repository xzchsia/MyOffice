package com.tianyapeng.fra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.tianyapeng.act.R;
import com.tianyapeng.act.YuanGongInfoActivity;
import com.tianyapeng.adapter.SortAdapter;
import com.tianyapeng.entity.PhoneModel;
import com.tianyapeng.handle.CharacterParser;
import com.tianyapeng.handle.PinyinComparator;
import com.tianyapeng.view.SideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by TianYapeng on 2017/2/17 0017.
 */

public class Fragment3 extends Fragment {

    private ListView listview;
    private SideBar sideBar;
    private TextView dialog;
    private SortAdapter adapter;
    // 汉语转换成拼音的类
    private CharacterParser characterParser;
    private List<PhoneModel> SourceDateList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra3_layout, container, false);
        sideBar = (SideBar) view.findViewById(R.id.sidebar);
        dialog = (TextView) view.findViewById(R.id.dialog);
        listview = (ListView) view.findViewById(R.id.yuangong_listview);
        initViews();
        return view;
    }

    // 为ListView添加数据
    private List<PhoneModel> filledData(String[] date, String[] imgData) {
        List<PhoneModel> mSortList = new ArrayList<PhoneModel>();

        for (int i = 0; i < date.length; i++) {
            PhoneModel sortModel = new PhoneModel();
            sortModel.setImgSrc(imgData[i]);
            sortModel.setName(date[i]);
            // 汉字转换成拼音
            String pinyin = characterParser.getSelling(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();

            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }
            mSortList.add(sortModel);
        }
        return mSortList;
    }

    private void initViews() {
        // 实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();

        PinyinComparator pinyinComparator = new PinyinComparator();

        sideBar.setTextView(dialog);

        // 设置右侧触摸监听
        sideBar.setOnTouchingLetterChangeListener(new SideBar.OnTouchingLetterChangeListener() {

            @Override
            public void onTouchingLetterChange(String s) {
                // 该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    listview.setSelection(position);
                }
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 这里要利用adapter.getItem(position)来获取当前position所对应的对象
                startActivity(new Intent(getActivity(), YuanGongInfoActivity.class));
                // Toast.makeText(getActivity(), ((PhoneModel)
                // adapter.getItem(position)).getName(),
                // Toast.LENGTH_SHORT).show();
            }
        });

        SourceDateList = filledData(getResources().getStringArray(R.array.date),
                getResources().getStringArray(R.array.img_src_data));

        // 根据a-z进行排序源数据
        Collections.sort(SourceDateList, pinyinComparator);
        adapter = new SortAdapter(getActivity(), SourceDateList);
        listview.setAdapter(adapter);
    }
}
