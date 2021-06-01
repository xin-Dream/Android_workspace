package com.example.infomanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    private TextView tv_back;
    private RelativeLayout rl_modify_psw;
    private RelativeLayout rl_security_setting;
    private TextView tv_main_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        tv_back=(TextView)findViewById(R.id.tv_back);
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);
        rl_modify_psw=(RelativeLayout)findViewById(R.id.rl_modify_psw);
        rl_security_setting=(RelativeLayout)findViewById(R.id.rl_security_setting);

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

    }

    public void jump2ModifyPsw(){
        Intent intent=new Intent(this,ModifyPswActivity.class);
        startActivity(intent);
    }

    public void jump2FindPsw(){
        Intent intent=new Intent(this,FindPswActivity.class);
        intent.putExtra("form",0);
        startActivity(intent);
    }

    public void jump2info(){
        Intent intent=new Intent(this,MyInfoActivity.class);
        startActivity(intent);
    }
}