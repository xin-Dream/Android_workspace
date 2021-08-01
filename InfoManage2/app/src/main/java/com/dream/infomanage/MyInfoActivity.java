package com.dream.infomanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MyInfoActivity extends AppCompatActivity {

    private ImageView iv_infoback;
    private RelativeLayout rl_setting;
    private TextView tv_user_name;
    private boolean login_flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        iv_infoback=(ImageView)findViewById(R.id.iv_infoback);
        rl_setting=(RelativeLayout)findViewById(R.id.rl_setting);
        tv_user_name=(TextView)findViewById(R.id.tv_user_name);

        Map<String,String>userInfo=SavePWD.getUserInfo(this);

        if (userInfo.get("username")==null){
            login_flag = false;
            tv_user_name.setText("点击登录");
        }
        else {
            tv_user_name.setText(userInfo.get("username"));
        }

        rl_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login_flag){
                    jump2Setting();
                }else {
                    Toast.makeText(MyInfoActivity.this, "您还未登录，请先登录", Toast.LENGTH_SHORT).show();
                }
            }
        });

        iv_infoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2Main();
            }
        });


        tv_user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login_flag){
                    jump2UserInfo();
                }
                else {
                    jump2Login();
                }
            }
        });
    }

    public void jump2Main(){
        Intent intent=new Intent(this, com.dream.infomanage.MainActivity.class);
        startActivity(intent);
    }
    public void jump2UserInfo(){
        Intent intent=new Intent(this,UserInfoActivity.class);
        startActivity(intent);
    }
    public void jump2Setting(){
        Intent intent=new Intent(this,SettingActivity.class);
        startActivity(intent);
    }
    public void jump2Login(){
        Intent intent=new Intent(this, com.dream.infomanage.LoginActivity.class);
        startActivity(intent);
    }
}