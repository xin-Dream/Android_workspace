package com.dream.infomanage;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText et_user_name;
    private EditText et_psw;
    private Button btn_login;
    private TextView tv_register;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        Map<String,String> userInfo=SavePWD.getUserInfo(this);

        if (userInfo!=null){
            et_user_name.setText(userInfo.get("username"));
            et_psw.setText(userInfo.get("password"));
        }
    }

    private void initView(){
        et_user_name=(EditText) findViewById(R.id.et_user_name);
        et_psw=(EditText) findViewById(R.id.et_psw);
        btn_login=(Button) findViewById(R.id.btn_login);
        tv_register=(TextView)findViewById(R.id.tv_register);

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2Register();
            }
        });

//        btn_login.setOnClickListener((View.OnClickListener) LoginActivity.this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_user_name.getText().toString().trim();
                String password=et_psw.getText().toString();

                //检查账号密码是否正确
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(LoginActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }

                //登录成功
                Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                jump2UserInfo();
            }
        });
    }

    private void jump2UserInfo(){
        Intent intent=new Intent(this,UserInfoActivity.class);
        startActivity(intent);
    }

    private void jump2Register(){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

}