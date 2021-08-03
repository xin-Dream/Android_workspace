package com.dream.infomanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    private TextView tv_back;
    private RelativeLayout rl_modify_psw;
    private RelativeLayout rl_security_setting;
    private RelativeLayout rl_exit_login;
    private TextView tv_main_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        tv_back=(TextView)findViewById(R.id.tv_back);
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);
        rl_modify_psw=(RelativeLayout)findViewById(R.id.rl_modify_psw);
        rl_security_setting=(RelativeLayout)findViewById(R.id.rl_security_setting);
        rl_exit_login=(RelativeLayout)findViewById(R.id.rl_exit_login);

        tv_main_title.setText("设置");
        tv_back.setVisibility(View.VISIBLE);

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2info();
            }
        });

        rl_modify_psw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2ModifyPsw();
            }
        });

        rl_security_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2FindPsw();
            }
        });

        rl_exit_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitLogin();
            }
        });

    }

    private void exitLogin(){
        Intent resultintent= new Intent();
        boolean exitSuccess= UserInfo.clearUserState(this);
        if (exitSuccess){
            Toast.makeText(SettingActivity.this,"退出成功",Toast.LENGTH_SHORT).show();
            resultintent.putExtra("state","exit success");
//            jump2main();
        }
        else {
            Toast.makeText(SettingActivity.this,"退出失败",Toast.LENGTH_SHORT).show();
            resultintent.putExtra("state","exit failed");
        }
        setResult(MyInfoActivity.RESULT_OK,resultintent);
        finish();
    }

    private void jump2main(){
        Intent intent=new Intent(this, com.dream.infomanage.MainActivity.class);
        startActivity(intent);
    }

    private void jump2ModifyPsw(){
        Intent intent=new Intent(this, com.dream.infomanage.ModifyPswActivity.class);
        startActivity(intent);
    }

    private void jump2FindPsw(){
        Intent intent=new Intent(this, com.dream.infomanage.FindPswActivity.class);
        intent.putExtra("form",0);
        startActivity(intent);
    }

    private void jump2info(){
        Intent intent=new Intent(this, com.dream.infomanage.MyInfoActivity.class);
        startActivity(intent);
    }
}