package com.dream.infomanage;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText et_user_name;
    private EditText et_psw;
    private Button btn_login;
    private TextView tv_register;
    private TextView tv_find_psw;
    private TextView tv_main_title;
    private TextView tv_back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        Map<String,String> userInfo= UserInfo.getUserInfo(this);

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
        tv_find_psw=(TextView)findViewById(R.id.tv_find_psw);
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);
        tv_back=(TextView)findViewById(R.id.tv_back);

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2Register();
            }
        });

        tv_main_title.setText("登录");
        tv_back.setVisibility(View.VISIBLE);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2MyInfo();
            }
        });

        tv_find_psw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2FindPWD();
            }
        });

//        btn_login.setOnClickListener((View.OnClickListener) LoginActivity.this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_user_name.getText().toString().trim();
                String password=et_psw.getText().toString();

                // 添加用户在注册界面保存的数据
                Map<String,String>userInfo= UserInfo.getUserInfo(LoginActivity.this);

                if (TextUtils.isEmpty(name)){
                    Toast.makeText(LoginActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!name.equals(userInfo.get("username"))){
                    Toast.makeText(LoginActivity.this,"该账号未被注册，请先注册账号",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(userInfo.get("password"))){
                    Toast.makeText(LoginActivity.this,"密码输入错误，请重新输入",Toast.LENGTH_SHORT).show();
                    return;
                }

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
                boolean isSaveSuccess= UserInfo.saveUserState(LoginActivity.this,"logged");
                if (isSaveSuccess){
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    jump2UserInfo();
                }
            }
        });
    }

    private void jump2UserInfo(){
        Intent intent=new Intent(this,UserInfoActivity.class);
        startActivity(intent);
    }

    private void jump2FindPWD(){
        Intent intent=new Intent(this,FindPswActivity.class);
        startActivity(intent);
    }

    private void jump2MyInfo(){
        Intent intent=new Intent(this,MyInfoActivity.class);
        startActivity(intent);
    }

    private void jump2Register(){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }


}