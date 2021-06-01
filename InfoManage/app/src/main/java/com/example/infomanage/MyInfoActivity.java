package com.example.infomanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MyInfoActivity extends AppCompatActivity {

    private ImageView iv_infoback;
    private RelativeLayout rl_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        iv_infoback=(ImageView)findViewById(R.id.iv_infoback);
        rl_setting=(RelativeLayout)findViewById(R.id.rl_setting);

        rl_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2Setting();
            }
        });

        iv_infoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2Main();
            }
        });
    }

    public void jump2Main(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void jump2Setting(){
        Intent intent=new Intent(this,SettingActivity.class);
        startActivity(intent);
    }
}