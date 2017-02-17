package com.tianyapeng.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by TianYapeng on 2017/2/17 0017.
 */

//当前类注释:文件存储工具类
public class SharedPreferencesHelp {

    private SharedPreferences shared;
    private SharedPreferences.Editor editor;
    private Context context;

    public SharedPreferencesHelp(Context context, String name) {
        this.context = context;
        shared = context.getSharedPreferences(name, 0);
        this.editor = shared.edit();
    }

    public String getString(String key) {
        return shared.getString(key, "");
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String putDefaultString(String key, String value) {
        return shared.getString(key, value);
    }

    public int getInt(String key) {
        return shared.getInt(key, 0);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public long getLong(String key) {
        return shared.getLong(key, 0);
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key) {
        return shared.getBoolean(key, false);
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }


}
