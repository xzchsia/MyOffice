package com.tianyapeng.act;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tianyapeng.entity.UserInfo;
import com.tianyapeng.util.SharedPreferencesHelp;

import java.lang.reflect.Type;

/**
 * Created by TianYapeng on 2017/2/17 0017.
 */

public class LoginActivity extends Activity {

    private EditText username_et, password_et;
    private Button btn;
    private Handler handler;
    private int LOGIN_SUCCESS = 1;
    private int LOGIN_FAIL = 0;
    private SharedPreferencesHelp sharedHelper;
    private String username, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        btn= (Button) findViewById(R.id.login_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });


    }
}





































